package com.monitor.core.orm.hibernate;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.internal.CriteriaImpl;
import org.hibernate.transform.ResultTransformer;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import com.google.common.collect.Sets;
import com.monitor.core.orm.Page;
import com.monitor.core.orm.PropertyFilter;
import com.monitor.core.orm.PropertyFilter.MatchType;
import com.monitor.core.utils.ReflectionUtils;

/**
 * 封装SpringSide扩展功能的Hibernate DAO泛型基类.<br>
 * 扩展功能包括分页查询,按属性过滤条件列表查询. 可在Service层直接使用,也可以扩展泛型DAO子类使用,见两个构造函数的注释.
 * 
 * @param <T>
 *            DAO操作的对象类型
 */
@Transactional //此注解可以被继承
@SuppressWarnings({ "rawtypes", "unchecked" })
public class HibernateDao<T> extends SimpleHibernateDaoImpl<T> {
	/**
	 * 用于Dao层子类使用的构造函数. 通过子类的泛型定义取得对象类型Class. eg. public class UserDao extends
	 * HibernateDao<User>{ }
	 */
	public HibernateDao() {
		super();
	}

	/**
	 * 用于省略Dao层, Service层直接使用通用HibernateDao的构造函数. 在构造函数中定义对象类型Class. eg.
	 * HibernateDao<User> userDao = new HibernateDao<User, Long>(sessionFactory,User.class);
	 */
	public HibernateDao(final SessionFactory sessionFactory, final Class<T> entityClass) {
		super(sessionFactory, entityClass);
	}

	/****************** 分页查询函数 ******************/
	/**
	 * 分页获取全部对象.
	 */
	public Page<T> getAll(final Page<T> page) {
		return findPage(page, null);
	}

	/**
	 * 按HQL分页查询.
	 * 
	 * @param page
	 *            分页参数.不支持其中的orderBy参数.
	 * @param hql
	 *            hql语句.
	 * @param values
	 *            数量可变的查询参数,按顺序绑定.
	 * 
	 * @return 分页查询结果, 附带结果列表及所有查询时的参数.
	 */
	public Page<T> findPage(final Page<T> page, final String hql, final Object... values) {
		Assert.notNull(page, "page不能为空");

		Query q = createQuery(hql, values);

		if (page.isAutoCount()) {
			long totalCount = countHqlResult(hql, values);
			page.setTotalCount(totalCount);
		}

		setPageParameter(q, page);
		List result = q.list();
		page.setResult(result);
		return page;
	}
	public Page<T> findPageBySql(final Page<T> page, final String sql, final Object... values) {
		Assert.notNull(page, "page不能为空");
		SQLQuery q = createSQLQuery(sql, values);

		if (page.isAutoCount()) {
			long totalCount = countSqlResult(sql, values);
			page.setTotalCount(totalCount);
		}

		setPageParameter(q, page);
		List result = q.list();
		page.setResult(result);
		return page;
	}
	/**
	 * 按HQL分页查询.
	 * 
	 * @param page
	 *            分页参数.
	 * @param hql
	 *            hql语句.
	 * @param values
	 *            命名参数,按名称绑定.
	 * 
	 * @return 分页查询结果, 附带结果列表及所有查询时的参数.
	 */
	public Page<T> findPage(final Page<T> page, final String hql, final Map<String, ?> values) {
		Assert.notNull(page, "page不能为空");

		Query q = createQuery(hql, values);

		if (page.isAutoCount()) {
			long totalCount = countHqlResult(hql, values);
			page.setTotalCount(totalCount);
		}

		setPageParameter(q, page);

		List result = q.list();
		page.setResult(result);
		return page;
	}
	/**
	 * 按HQL分页查询.
	 * 
	 * @param page
	 *            分页参数.
	 * @param sql
	 *            hql语句.
	 * @param values
	 *            命名参数,按名称绑定.
	 * 
	 * @return 分页查询结果, 附带结果列表及所有查询时的参数.
	 */
	public Page<T> findPageBySql(final Page<T> page, final String sql, final Map<String, ?> values) {
		Assert.notNull(page, "page不能为空");

		SQLQuery q = createSQLQuery(sql, values);

		if (page.isAutoCount()) {
			long totalCount = countSqlResult(sql, values);
			page.setTotalCount(totalCount);
		}

		setPageParameter(q, page);

		List result = q.list();
		page.setResult(result);
		return page;
	}
	/**
	 * 按Criteria分页查询.
	 * 
	 * @param page
	 *            分页参数.
	 * @param criterions
	 *            数量可变的Criterion.
	 * 
	 * @return 分页查询结果.附带结果列表及所有查询时的参数.
	 */
	public Page<T> findPage(final Page<T> page, final Set refNames, Map<String, String> orderMap, final Criterion... criterions) {
		Assert.notNull(page, "page不能为空");
		Criteria c = createCriteria(refNames, orderMap, criterions);

		if (page.isAutoCount()) {
			int totalCount = countCriteriaResult(c);
			page.setTotalCount(totalCount);
		}

		setPageParameter(c, page);
		List result = c.list();
		page.setResult(result);
		return page;
	}

	/**
	 * 设置分页参数到Query对象,辅助函数.
	 */
	protected Query setPageParameter(final Query q, final Page<T> page) {
		// hibernate的firstResult的序号从0开始

		q.setFirstResult(page.getFirst() - 1);
		q.setMaxResults(page.getPageSize());
		return q;
	}

	/**
	 * 设置分页参数到Criteria对象,辅助函数.
	 */
	protected Criteria setPageParameter(final Criteria c, final Page<T> page) {
		// hibernate的firstResult的序号从0开始

		c.setFirstResult(page.getFirst() - 1);
		c.setMaxResults(page.getPageSize());

		if (page.isOrderBySetted()) {
			String[] orderByArray = StringUtils.split(page.getOrderBy(), ',');
			String[] orderArray = StringUtils.split(page.getOrder(), ',');

			Assert.isTrue(orderByArray.length == orderArray.length, "分页多重排序参数中,排序字段与排序方向的个数不相等");

			for (int i = 0; i < orderByArray.length; i++) {
				if (Page.ASC.equals(orderArray[i])) {
					c.addOrder(Order.asc(orderByArray[i]));
				} else {
					c.addOrder(Order.desc(orderByArray[i]));
				}
			}
		}
		return c;
	}

	/**
	 * 执行count查询获得本次Hql查询所能获得的对象总数.
	 * 
	 * 本函数只能自动处理简单的hql语句,复杂的hql查询请另行编写count语句查询.
	 */
	protected long countHqlResult(final String hql, final Object... values) {
		String fromHql = hql;
		// select子句与order by子句会影响count查询,进行简单的排除.
		fromHql = "from " + StringUtils.substringAfter(fromHql, "from");
		fromHql = StringUtils.substringBefore(fromHql, "order by");

		String countHql = "select count(*) " + fromHql;

		try {
			Long count = findUnique(countHql, values);
			return count;
		} catch (Exception e) {
			throw new RuntimeException("hql can't be auto count, hql is:" + countHql, e);
		}
	}
	protected long countSqlResult(final String sql, final Object... values) {
		String fromSql = sql;
		// select子句与order by子句会影响count查询,进行简单的排除.
		fromSql = "from " + StringUtils.substringAfter(fromSql, "from");
		fromSql = StringUtils.substringBefore(fromSql, "order by");

		String countSql = "select count(*) " + fromSql;

		try {
			BigInteger count = findSqlUnique(countSql, values);
			return count.longValue();
		} catch (Exception e) {
			throw new RuntimeException("sql can't be auto count, sql is:" + countSql, e);
		}
	}
	
	/**
	 * 执行count查询获得本次Hql查询所能获得的对象总数.
	 * 
	 * 本函数只能自动处理简单的hql语句,复杂的hql查询请另行编写count语句查询.
	 */
	protected long countHqlResult(final String hql, final Map<String, ?> values) {
		String fromHql = hql;
		// select子句与order by子句会影响count查询,进行简单的排除.
		fromHql = "from " + StringUtils.substringAfter(fromHql, "from");
		fromHql = StringUtils.substringBefore(fromHql, "order by");

		String countHql = "select count(*) " + fromHql;

		try {
			Long count = findUnique(countHql, values);
			return count;
		} catch (Exception e) {
			throw new RuntimeException("sql can't be auto count, hql is:" + countHql, e);
		}
	}
	protected long countSqlResult(final String sql, final Map<String, ?> values) {
		String fromSql = sql;
		// select子句与order by子句会影响count查询,进行简单的排除.
		fromSql = "from " + StringUtils.substringAfter(fromSql, "from");
		fromSql = StringUtils.substringBefore(fromSql, "order by");

		String countSql = "select count(*) " + fromSql;

		try {
			BigInteger count = findUnique(countSql, values);
			return count.longValue();
		} catch (Exception e) {
			throw new RuntimeException("sql can't be auto count, sql is:" + countSql, e);
		}
	}
	/**
	 * 执行count查询获得本次Criteria查询所能获得的对象总数.
	 */
	protected int countCriteriaResult(final Criteria c) {
		CriteriaImpl impl = (CriteriaImpl) c;

		// 先把Projection、ResultTransformer、OrderBy取出来,清空三者后再执行Count操作
		Projection projection = impl.getProjection();
		ResultTransformer transformer = impl.getResultTransformer();

		List<CriteriaImpl.OrderEntry> orderEntries = null;
		try {
			orderEntries = (List) ReflectionUtils.getFieldValue(impl, "orderEntries");
			ReflectionUtils.setFieldValue(impl, "orderEntries", new ArrayList());
		} catch (Exception e) {
			logger.error("不可能抛出的异常:{}", e.getMessage());
		}

		// 执行Count查询
		int totalCount = (Integer) c.setProjection(Projections.rowCount()).uniqueResult();

		// 将之前的Projection,ResultTransformer和OrderBy条件重新设回去

		c.setProjection(projection);

		if (projection == null) {
			c.setResultTransformer(CriteriaSpecification.ROOT_ENTITY);
		}
		if (transformer != null) {
			c.setResultTransformer(transformer);
		}
		try {
			ReflectionUtils.setFieldValue(impl, "orderEntries", orderEntries);
		} catch (Exception e) {
			logger.error("不可能抛出的异常:{}", e.getMessage());
		}

		return totalCount;
	}

	// -- 属性过滤条件(PropertyFilter)查询函数 --//

	/**
	 * 按属性查找对象列表,支持多种匹配方式.
	 * 
	 * @param matchType
	 *            匹配方式,目前支持的取值见PropertyFilter的MatcheType enum.
	 */
	public List<T> findBy(final String propertyName, final Object value, final MatchType matchType) {
		Criterion criterion = buildPropertyFilterCriterion(propertyName, value, null, matchType);
		return find(criterion);
	}

	/**
	 * 按属性过滤条件列表查找对象列表.
	 */
	public List<T> find(List<PropertyFilter> filters) {
		Criterion[] criterions = buildPropertyFilterCriterions(filters);
		Set<String> refNameSet = buildPropertyFilterRefNames(null, filters, null);
		return find(refNameSet, null, criterions);
	}

	/**
	 * 按属性过滤条件列表查找对象列表.
	 */
	public List<T> find(List<PropertyFilter> filters, Map<String, String> orderMap) {
		Criterion[] criterions = buildPropertyFilterCriterions(filters);
		Set<String> refNameSet = buildPropertyFilterRefNames(null, filters, orderMap);
		return find(refNameSet, orderMap, criterions);
	}

	/**
	 * 按属性过滤条件列表分页查找对象.
	 */
	public Page<T> findPage(final Page<T> page, final List<PropertyFilter> filters) {
		Criterion[] criterions = buildPropertyFilterCriterions(filters);
		Set<String> refNameSet = buildPropertyFilterRefNames(page, filters, null);
		return findPage(page, refNameSet, null, criterions);
	}

	/**
	 * 按属性过滤条件列表分页查找对象.
	 */
	public Page<T> findPage(final Page<T> page, final List<PropertyFilter> filters, Map<String, String> orderMap) {
		Criterion[] criterions = buildPropertyFilterCriterions(filters);
		Set<String> refNameSet = buildPropertyFilterRefNames(page, filters, orderMap);
		return findPage(page, refNameSet, orderMap, criterions);
	}

	/**
	 * 按属性条件列表创建Criterion数组,辅助函数.
	 */
	protected Set<String> buildPropertyFilterRefNames(final Page<T> page, final List<PropertyFilter> filters, Map<String, String> orderMap) {
		Set<String> refNameSet = Sets.newLinkedHashSet();
		// 查询字段filter
		for (PropertyFilter filter : filters) {
			if (filter.getPropertyRefName() != null) {
				refNameSet.addAll(filter.getPropertyRefName());
			}
		}
		// page排序字段
		if (page != null && page.isOrderBySetted()) {
			String[] orderByArray = StringUtils.split(page.getOrderBy(), ',');
			for (String refName : orderByArray) {
				if (refName.indexOf(".") != -1) {
					refNameSet.add(refName.substring(0, refName.lastIndexOf(".")));
				}
			}
		}
		// 排序MAP
		if (orderMap != null) {
			for (String key : orderMap.keySet()) {
				if (key.indexOf(".") != -1) {
					refNameSet.add(key.substring(0, key.lastIndexOf(".")));
				}
			}
		}
		return refNameSet;

	}

	/**
	 * 按属性条件列表创建Criterion数组,辅助函数.
	 */
	protected Criterion[] buildPropertyFilterCriterions(final List<PropertyFilter> filters) {
		List<Criterion> criterionList = new ArrayList<Criterion>();
		for (PropertyFilter filter : filters) {
			if (!filter.isMultiProperty()) { // 只有一个属性需要比较的情况.
				Criterion criterion = buildPropertyFilterCriterion(filter.getPropertyName(), filter.getPropertyValue(), filter.getPropertyArray(), filter.getMatchType());
				criterionList.add(criterion);
			} else {// 包含多个属性需要比较的情况,进行or处理.
				Disjunction disjunction = Restrictions.disjunction();
				for (String param : filter.getPropertyNames()) {
					Criterion criterion = buildPropertyFilterCriterion(param, filter.getPropertyValue(), null, filter.getMatchType());
					disjunction.add(criterion);
				}
				criterionList.add(disjunction);
			}
		}
		return criterionList.toArray(new Criterion[criterionList.size()]);
	}

	/**
	 * 按属性条件参数创建Criterion,辅助函数.
	 */
	protected Criterion buildPropertyFilterCriterion(final String propertyName, final Object propertyValue, final Object[] propertyArray, final MatchType matchType) {
		Assert.hasText(propertyName, "propertyName不能为空");
		Criterion criterion = null;
		try {

			// 根据MatchType构造criterion
			if (MatchType.EQ.equals(matchType)) {
				criterion = Restrictions.eq(propertyName, propertyValue);
			} else if (MatchType.LIKE.equals(matchType)) {
				criterion = Restrictions.like(propertyName, (String) propertyValue, MatchMode.ANYWHERE);
			} else if (MatchType.LE.equals(matchType)) {
				criterion = Restrictions.le(propertyName, propertyValue);
			} else if (MatchType.LT.equals(matchType)) {
				criterion = Restrictions.lt(propertyName, propertyValue);
			} else if (MatchType.GE.equals(matchType)) {
				criterion = Restrictions.ge(propertyName, propertyValue);
			} else if (MatchType.GT.equals(matchType)) {
				criterion = Restrictions.gt(propertyName, propertyValue);
			} else if (MatchType.IN.equals(matchType)) {
				criterion = Restrictions.in(propertyName, propertyArray);
			} else if (MatchType.ISNULL.equals(matchType)) {
				criterion = Restrictions.isNull(propertyName);
			} else if (MatchType.ISNOTNULL.equals(matchType)) {
				criterion = Restrictions.isNotNull(propertyName);
			} else if (MatchType.NEQ.equals(matchType)) {
				criterion = Restrictions.ne(propertyName, propertyValue);
			} else if (MatchType.ILIKE.equals(matchType)) {
				criterion = Restrictions.ilike(propertyName, propertyArray);
			}
		} catch (Exception e) {
			throw ReflectionUtils.convertReflectionExceptionToUnchecked(e);
		}
		return criterion;
	}

	/**
	 * 判断对象的属性值在数据库内是否唯一.
	 * 
	 * 在修改对象的情景下,如果属性新修改的值(value)等于属性原来的值(orgValue)则不作比较.
	 */
	public boolean isPropertyUnique(final String propertyName, final Object newValue, final Object oldValue) {
		if (newValue == null || newValue.equals(oldValue)) {
			return true;
		}
		Object object = findUniqueBy(propertyName, newValue);
		return (object == null);
	}

}
