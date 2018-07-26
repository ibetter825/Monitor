//初始化控制面板
function initControlPanel() {
	$('#controlPanel').show();
	$('#controlPanel').window({
		title : '控制面板',
		collapsible : true,
		width : 100,
		height : 400,
		top : winHeight / 2 - 200,
		left : winWidth - 150,
		resizable : false,
		closable : false,
		minimizable : false,
		maximizable : false
	});
}
// 打开操作框 0:新增, 1:编辑, -1:删除
function initDialog(_this, flg) {
	optFlg = flg;
	if (flg == -1) {// 删除模块
		$.messager.confirm('确认', '您确认想要删除改模块吗？', function(r) {
			if (r) {
				var $phs = $('.c-p-edit,.c-p-del');
				$('.part-selected').slideUp('fast');
				$phs.slideUp('fast');
				// 删除其他东西
				// ...
			}
		});
	} else {
		if(flg == 1){//编辑
			var $part = $('.part-selected');
			var no = $part.attr('no');
			var part = globalParts[no];
			$('#form').form('load', part);
		}
		if (!$dialog) {
			$('#dialog').show();
			$dialog = $('#dialog').dialog({
				title : flg == 1 ? '修改' : '添加',
				modal : true,
				resizable : true,
				onClose : function() {
					$('#form').form('reset');
				},
				buttons : [ {
					text : '确定',
					iconCls : 'icon-save',
					handler : function() {
						if (!$('#form').form('validate'))
							return;
						var part = app.serializeForm('#form', false);
						var no = new Date().getTime();//有点问题
						part['no'] = no;//
						initPart(part, optFlg);
						$dialog.dialog('close');
					}
				}, {
					text : '取消',
					iconCls : 'icon-cancel',
					handler : function() {
						$dialog.dialog('close');
					}
				} ]
			});
		} else {
			$dialog.dialog({
				title : flg == 1 ? '修改' : '新增'
			});
			$dialog.dialog('open');
		}
	}
}
// 初始化组件框
function initCompDialog(_this, flg) {
	if (!$compDialog) {
		$('#compDialog').show();
		$compDialog = $('#compDialog').dialog({
			title : flg ? '修改' : '添加',
			modal : true,
			resizable : true,
			onClose : function() {
				$('#form').form('reset');
			},
			buttons : [ {
				text : '确定',
				iconCls : 'icon-save',
				handler : function() {
					$compDialog.dialog('close');
				}
			}, {
				text : '取消',
				iconCls : 'icon-cancel',
				handler : function() {
					$compDialog.dialog('close');
				}
			} ]
		});
	} else {
		$compDialog.dialog({
			title : flg ? '修改' : '新增'
		});
		$compDialog.dialog('open');
	}
}
// 查询参数
function initParamDialog() {
	if (!$paramDialog) {
		$('#paramDialog').show();
		$paramDialog = $('#paramDialog').dialog({
			title : '查询参数',
			modal : true,
			resizable : true,
			onClose : function() {

			},
			buttons : [ {
				text : '保存',
				iconCls : 'icon-save',
				handler : function() {

				}
			}, {
				text : '取消',
				iconCls : 'icon-cancel',
				handler : function() {
					$paramDialog.dialog('close');
				}
			} ]
		});
	} else {
		$paramDialog.dialog('open');
	}
	initGrid();
}
// 初始化查询参数列表
function initGrid() {
	if (!$grid) {
		$grid = $('#grid').datagrid({
			url : jui.uri + '/u/user/list',
			striped : true,
			autoRowHeight : false,
			border : false,
			fitColumns : true,
			rownumbers : true,
			width : 'auto',
			height : '100%',
			columns : [ [ {
				field : '',
				title : '',
				checkbox : true
			}, {
				field : 'userId',
				title : '用户编号',
				width : 100
			}, {
				field : 'userName',
				title : '用户登录名',
				width : 100
			}, {
				field : 'nickName',
				title : '用户昵称',
				width : 100
			}, {
				field : 'orgNames',
				title : '所属机构',
				width : 100
			} ] ],
			pagination : true,
			pageSize : 50,
			pageList : [ 50, 100, 200, 500 ],
			onDblClickRow : function(index, row) {
				openFormDialog(1, row);
			},
			onLoadError : function() {
				$.messager.alert('警告', '加载数据出错', 'warning');
			}
		});
	}
}

// 生成模块
function initPart(part, flg) {
	if(flg == 0){//添加
		var html = [];
		html.push('<div no="' + part.no + '" class="part" onclick="choosePart(this);">');
		html.push('<ul class="part-title" title="' + part.partDesc + '">');
		html.push('<li class="part-title-cont">');
		html.push('<span class="p-t-c-left"><i></i></span>');
		html.push('<span class="p-t-c-center">' + part.partTitle + '</span>');
		html.push('<span class="p-t-c-right"></span>');
		html.push('</li>');
		html.push('<li class="part-title-tip">' + part.partTip + '</li>');
		html.push('</ul>');
		html.push('<ul class="part-cont">');
		html.push('<li class="col col-4">');
		html.push('<div class="col-cont">');
		html.push('<div class="p-l-c-self" id="gauge"></div>');
		html.push('</div>');
		html.push('</li>');
		html.push('<li class="col col-8">');
		html.push('<div class="col-cont">');
		html.push('<div class="p-l-c-self" id="table"></div>');
		html.push('</div>');
		html.push('</li>');
		html.push('</ul>');
		html.push('<span class="deco">');
		html.push('<i class="deco-l"></i>');
		html.push('<i class="deco-r"></i>');
		html.push('</span>');
		html.push('</div>');
	
		globalParts[part.no] = part;
		$('#container').append(html.join(''));
	}else{//编辑
		
	}
}
// 选中模块
function choosePart(_this) {
	var $this = $(_this);
	var clz = 'part-selected';
	var $phs = $('.c-p-edit,.c-p-del');
	if ($this.hasClass(clz)) {
		$this.removeClass(clz);
		$phs.slideUp('fast');
	} else {
		$('.' + clz).removeClass(clz);
		$this.addClass(clz);
		$phs.slideDown('fast');
	}
}