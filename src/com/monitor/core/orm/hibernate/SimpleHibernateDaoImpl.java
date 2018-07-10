package com.monitor.core.orm.hibernate;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.metadata.ClassMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.monitor.core.utils.ReflectionUtils;


//该事务可以被继承
@Transactional
@SuppressWarnings("unchecked")
public abstract class SimpleHibernateDaoImpl<T> implements SimpleHibernateDao<T> {

	protected Logger logger = LoggerFactory.getLogger(getClass());

	private SessionFactory sessionFactory;
	private Class<T> entityClass = null;

	/**
	 * 用于Dao层子类使用的构造函数. <br>
	 * 通过子类的泛型定义取得对象类型Class. <br>
	 * eg. <br>
	 * public class UserDao extends SimpleHibernateDaoImpl<User>{ }
	 */
	public SimpleHibernateDaoImpl() {
		this.entityClass = ReflectionUtils.getSuperClassGenricType(getClass());
		logger.info("----->装载bean对象:" + entityClass + "<-----");
	}

	/**
	 * 用于用于省略Dao层, 在Service层直接使用通用SimpleHibernateDao的构造函数. <br>
	 * 
	 * 在构造函数中定义对象类型Class. <br>
	 * eg. <br>
	 * SimpleHibernateDao<User> userDao = new
	 * SimpleHibernateDaoImpl<User>(sessionFactory, User.class);
	 */
	public SimpleHibernateDaoImpl(final SessionFactory sessionFactory, final Class<T> entityClass) {
		this.sessionFactory = sessionFactory;
		this.entityClass = entityClass;
	}

	/**
	 * 采用@Autowired按类型注入SessionFactory, 当有多个SesionFactory的时候Override本函数.
	 */
	@Autowired
	public void setSessionFactory(final SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * 获取当前可用的session对象.
	 * 
	 * @return
	 */
	protected Session getSession() {
		//return sessionFactory.openSession();
		return sessionFactory.getCurrentSession();
	}

	/**
	 * 取得sessionFactory.
	 */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Override
	public Object save(Object entity) {
		Assert.notNull(entity, "entity不能为空");
		logger.debug("save entity: {}", entity);
		return getSession().save(entity);
	}

	@Override
	public void saveOrUpdate(Object entity) {
		Assert.notNull(entity, "entity不能为空");
		getSession().saveOrUpdate(entity);
		logger.debug("save entity: {}", entity);
	}

	@Override
	public void update(Object entity) {
		Assert.notNull(entity, "entity不能为空");
		getSession().update(entity);
		logger.debug("save entity: {}", entity);
	}

	@Override
	public void delete(Object entity) {
		Assert.notNull(entity, "entity不能为空");
		getSession().delete(entity);
		logger.debug("delete entity: {}", entity);
	}

	@Override
	public void deleteById(Object id) {
		Assert.notNull(id, "id不能为空");
		delete(get(id));
		logger.debug("delete entity {},id is {}", entityClass.getSimpleName(), id);
	}

	@Override
	public T get(Object id) {
		Assert.notNull(id, "id不能为空");
		return (T) getSession().load(entityClass, (Serializable) id);
	}

	@Override
	public T get(Object id, Boolean isUsedGet) {
		Assert.notNull(id, "id不能为空");
		if (isUsedGet) {
			return (T) getSession().get(entityClass, (Serializable) id);
		}
		return (T) getSession().load(entityClass, (Serializable) id);
	}

	@Override
	public List<T> getAll() {
		return find();
	}

	@Override
	public List<T> getAll(String orderBy, boolean isAsc) {
		Criteria c = createCriteria();
		if (isAsc) {
			c.addOrder(Order.asc(orderBy));
		} else {
			c.addOrder(Order.desc(orderBy));
		}
		return c.list();
	}

	@Override
	public List<T> findBy(String propertyName, Object value) {
		Assert.hasText(propertyName, "propertyName不能为空");
		Criterion criterion = Restrictions.eq(propertyName, value);
		return find(criterion);
	}

	@Override
	public List<T> findBy(String propertyName, Object value, String propertyName1, Object value1) {
		Assert.hasText(propertyName, "propertyName不能为空");
		Criterion criterion = Restrictions.eq(propertyName, value);
		Criterion criterion1 = Restrictions.eq(propertyName1, value1);
		return find(new Criterion[] { criterion, criterion1 });
	}

	@Override
	public List<T> findByAndOrder(String propertyName, Object value, String orderBy, boolean isAsc) {
		Assert.hasText(propertyName, "propertyName不能为空");
		Criteria criteria = getSession().createCriteria(entityClass);
		criteria.add(Restrictions.eq(propertyName, value));
		// 设置排序
		if (StringUtils.isNotBlank(orderBy)) {
			if (isAsc) {
				criteria.addOrder(Order.asc(orderBy));
			} else {
				criteria.addOrder(Order.desc(orderBy));
			}
		}
		return criteria.list();
	}

	@Override
	public List<T> findByAndOrder(String propertyName, Object value, String propertyName1, Object value1, String orderBy, boolean isAsc) {
		Assert.hasText(propertyName, "propertyName不能为空");
		Criteria criteria = getSession().createCriteria(entityClass);
		criteria.add(Restrictions.eq(propertyName, value));
		criteria.add(Restrictions.eq(propertyName1, value1));
		// 设置排序
		if (StringUtils.isNotBlank(orderBy)) {
			if (isAsc) {
				criteria.addOrder(Order.asc(orderBy));
			} else {
				criteria.addOrder(Order.desc(orderBy));
			}
		}
		return criteria.list();
	}

	@Override
	public T findUniqueBy(String propertyName, Object value) {
		Assert.hasText(propertyName, "propertyName不能为空");
		Criterion criterion = Restrictions.eq(propertyName, value);
		return (T) createCriteria(criterion).uniqueResult();
	}

	@Override
	public T findUniqueBy(String propertyName, Object value, String propertyName1, Object value1) {
		Assert.hasText(propertyName, "propertyName不能为空");
		Assert.hasText(propertyName1, "propertyName1不能为空");
		Criterion criterion = Restrictions.eq(propertyName, value);
		Criterion criterion1 = Restrictions.eq(propertyName1, value1);
		return (T) createCriteria(criterion, criterion1).uniqueResult();
	}

	@Override
	public List<T> findByIds(List<Object> ids) {
		return find(Restrictions.in(getIdName(), ids));
	}

	@Override
	public List<T> find(String hql, Object... values) {
		return createQuery(hql, values).list();
	}

	@Override
	public <X> List<X> find(final String hql, final Map<String, ?> values) {
		return createQuery(hql, values).list();
	}

	@Override
	public <X> X findUnique(String hql, Object... values) {
		return (X) createQuery(hql, values).uniqueResult();
	}

	@Override
	public <X> X findUnique(final String hql, final Map<String, ?> values) {
		return (X) createQuery(hql, values).uniqueResult();
	}
	
	@Override
	public <X> X findSqlUnique(String sql, Object... values) {
		return (X) createSQLQuery(sql, values).uniqueResult();
	}

	@Override
	public <X> X findSqlUnique(final String sql, final Map<String, ?> values) {
		return (X) createSQLQuery(sql, values).uniqueResult();
	}
	@Override
	public int batchExecute(final String hql, final Object... values) {
		return createQuery(hql, values).executeUpdate();
	}

	@Override
	public int batchExecute(final String hql, final Map<String, ?> values) {
		return createQuery(hql, values).executeUpdate();
	}

	@Override
	public Query createQuery(final String queryString, final Object... values) {
		Assert.hasText(queryString, "queryString不能为空");
		Query query = getSession().createQuery(queryString);
		if (values != null) {
			for (int i = 0; i < values.length; i++) {
				query.setParameter(i, values[i]);
			}
		}
		return query;
	}
	
	public SQLQuery createSQLQuery(final String queryString, final Object... values) {
		Assert.hasText(queryString, "queryString不能为空");
		SQLQuery query = getSession().createSQLQuery(queryString);
		if (values != null) {
			for (int i = 0; i < values.length; i++) {
				query.setParameter(i, values[i]);
			}
		}
		return query;
	}
	
	@Override
	public Query createQuery(final String queryString, final Map<String, ?> values) {
		Assert.hasText(queryString, "queryString不能为空");
		Query query = getSession().createQuery(queryString);
		if (values != null) {
			query.setProperties(values);
		}
		return query;
	}
	public SQLQuery createSQLQuery(final String queryString, final Map<String, ?> values) {
		Assert.hasText(queryString, "queryString不能为空");
		SQLQuery query = getSession().createSQLQuery(queryString);
		if (values != null) {
			query.setProperties(values);
		}
		return query;
	}
	/**
	 * 按Criteria查询对象列表.
	 * 
	 * @param criterions
	 *            数量可变的Criterion.
	 */
	public List<T> find(final Criterion... criterions) {
		return createCriteria(criterions).list();
	}

	@Override
	public List<T> find(final Set<String> refNames, final Map<String, String> orderMap, final Criterion... criterions) {
		return createCriteria(refNames, orderMap, criterions).list();
	}

	@Override
	public T findUnique(final Criterion... criterions) {
		return (T) createCriteria(criterions).uniqueResult();
	}

	@Override
	public Criteria createCriteria(final Set<String> refNames, Map<String, String> orderMap, final Criterion... criterions) {
		Criteria criteria = getSession().createCriteria(entityClass);
		// 设置引用类

		for (String refClassName : refNames) {
			criteria.createAlias(refClassName, refClassName);
		}
		for (Criterion c : criterions) {
			criteria.add(c);
		}
		if (orderMap != null) {
			for (String key : orderMap.keySet()) {
				if ("ASC".equals(orderMap.get(key).toUpperCase())) {
					criteria.addOrder(Order.asc(key));
				} else {
					criteria.addOrder(Order.desc(key));
				}
			}
		}
		return criteria;
	}

	@Override
	public Criteria createCriteria(final Criterion... criterions) {
		Criteria criteria = getSession().createCriteria(entityClass);
		for (Criterion c : criterions) {
			criteria.add(c);
		}
		return criteria;
	}

	@Override
	public void initEntity(T entity) {
		Hibernate.initialize(entity);
	}

	@Override
	public void initEntity(List<T> entityList) {
		for (T entity : entityList) {
			Hibernate.initialize(entity);
		}
	}

	@Override
	public void flush() {
		getSession().flush();
	}

	@Override
	public Query distinct(Query query) {
		query.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
		return query;
	}

	@Override
	public Criteria distinct(Criteria criteria) {
		criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
		return criteria;
	}

	@Override
	public String getIdName() {
		ClassMetadata meta = getSessionFactory().getClassMetadata(entityClass);
		return meta.getIdentifierPropertyName();
	}

}
