<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta charset="UTF-8">
<title>P2P网站后台管理系统</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/semantic.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/main.css" />

<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-2.1.4.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/semantic.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/home.js"></script>
</head>

<body>
	<!--header-->
	<div class="ui clearing segment">
		<h3 class="ui left floated header">P2P网站后台管理系统</h3>
		<div class="ui right floated header">
			<div class="ui horizontal list">
				<div class="item">
					<a href="javascript:;">${user.username}</a> <a href="javascript:;"
						onclick="shutdown()"><i class="power icon"></i></a>
				</div>

			</div>
		</div>
	</div>

	<!--main-->

	<div class="ui grid">
		<!--left-->
		<div class="two wide column">
			<div class="ui inverted segment">
				<div class="ui inverted accordion">
					<div class="title">
						<i class="dropdown icon"></i> <i class="code icon"></i>用户及交易管理
					</div>
					<div class="content item vertical tabular menu">
						<div class="transition hidden header item" data-tab="one">用户信息管理</div>
						<div class="transition hidden header item" data-tab="two">资金流水记录
						</div>

					</div>
					<div class="title">
						<i class="dropdown icon"></i> <i class="sitemap icon"></i>投资管理
					</div>
					<div class="content item vertical tabular menu">
						<div class="transition hidden header item" data-tab="three">投资记录查询</div>
						<div class="transition hidden header item" data-tab="four">每月投资统计</div>
						<div class="transition hidden header item" data-tab="five">月存及月取计划管理</div>
					</div>
					<div class="title active">
						<i class="dropdown icon"></i> <i class="at icon"></i>产品管理

					</div>
					<div class="content active item vertical tabular menu">
						<div class="transition visible header item" data-tab="six">产品列表</div>
					</div>
					<div class="title">
						<i class="dropdown icon"></i> <i class="industry icon"></i>债权管理

					</div>
					<div class="content item vertical tabular menu">
						<div class="transition hidden header item" data-tab="seven">债权查询</div>
						<div class="transition hidden header item" data-tab="eight">录入债权</div>
						<div class="transition hidden header item" data-tab="nine">批量导入</div>
						<div class="transition hidden header item" data-tab="ten">债权还款计划查询</div>

					</div>
					<div class="title">
						<i class="dropdown icon"></i> <i class="tag icon"></i>撮合管理

					</div>
					<div class="content item vertical tabular menu">
						<div class="transition hidden header item" data-tab="aa">待匹配资金队列</div>
						<div class="transition hidden header item" data-tab="bb">待匹配债权队列</div>
						<div class="transition hidden header item" data-tab="cc">已匹配投资查询</div>
						<div class="transition hidden header item" data-tab="dd">已匹配债权查询</div>
						<div class="transition hidden header item" data-tab="ee">匹配结果确认</div>
						<div class="transition hidden header item" data-tab="ff">匹配结果查询</div>

					</div>
					<div class="title">
						<i class="dropdown icon"></i> <i class="dashboard icon"></i>资金流水管理
					</div>
					<div class="content item vertical tabular menu">
						<div class="transition hidden header item" data-tab="gg">用户提现审批</div>
						<div class="transition hidden header item" data-tab="hh">总账户资金流水记录</div>

					</div>
					<div class="title">
						<i class="dropdown icon"></i> <i class="creative commons icon"></i>借款申请管理
					</div>
					<div class="content item vertical tabular menu">
						<div class="transition hidden header item" data-tab="ii">借款申请列表</div>

					</div>
					<div class="title">
						<i class="dropdown icon"></i> <i class="shopping bag icon"></i>其他管理
					</div>
					<div class="content item vertical tabular menu">
						<div class="transition hidden header item" data-tab="jj">站内信管理</div>

					</div>
					<div class="title">
						<i class="dropdown icon"></i> <i class="protect icon"></i>修改密码
					</div>
					<div class="content item vertical tabular menu">
						<div class="transition hidden header item" data-tab="kk">修改密码</div>
					</div>

				</div>
			</div>

		</div>

		<div class="fourteen wide white column">

			<!--one-->
			<div class="ui tab segment" data-tab="one">用户信息管理</div>
			<!--two-->
			<div class="ui tab segment" data-tab="two">资金流水记录</div>
			<!--three-->
			<div class="ui tab segment" data-tab="three">投资记录查询</div>
			<!--four-->
			<div class="ui tab segment" data-tab="four">每月投资统计</div>
			<!--five-->
			<div class="ui tab segment" data-tab="five">月存及月取计划管理</div>

			<!--six-->
			<div class="ui active tab segment" data-tab="six">

				<div class="ui grid">
					<div class="wide  column">
						<div class="ui tab segment active" data-tab="first">
							<div class="ui breadcrumb">
								<i class="home icon"></i> <a class="section">产品管理</a> <i
									class="right angle icon divider"></i> <a class="section">产品列表</a>

							</div>

							<div class="btns">
								<div class="settings">
									<div class="ui green fade button" tabindex="0">
										<div class="visible content" onclick="addProduct()">新增产品</div>
									</div>


								</div>
								<div class="search">
									<div class="ui icon input">
										<input type="text" placeholder="搜索你想要的" /> <i
											class="search icon"></i>
									</div>
								</div>
							</div>
							<div style="clear: both;"></div>

							<div class="items">
								<table class="ui sortable celled table">
									<thead>
										<tr>
											<th><i class="write square icon"></i></th>
											<th colspan="9">产品列表信息</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td>序号</td>
											<td>产品编号</td>
											<td>产品名称</td>
											<td>期限</td>
											<td>年化利率</td>
											<td>操作</td>
										</tr>
									</tbody>
									<tbody id="pbody">

									</tbody>

									<tfoot>
										<tr>

											<th colspan="2"><span>共有<strong>10</strong>条数据，当前是第<strong>1</strong>页
											</span></th>

											<th colspan="9">
												<div class="ui right floated pagination menu">
													<a class="icon item"> <i class="left chevron icon"></i>
													</a> <a class="item">1</a> <a class="item">2</a> <a
														class="item">3</a> <a class="item">4</a> <a
														class="icon item"> <i class="right chevron icon"></i>
													</a>
												</div>
											</th>
										</tr>
									</tfoot>
								</table>
							</div>

						</div>
						<div class="ui tab segment" data-tab="second">大纲</div>
						<div class="ui tab segment" data-tab="thrid">课件</div>
						<div class="ui tab segment" data-tab="forth">习题</div>
					</div>

				</div>

			</div>
			<!--seven-->
			<div class="ui tab segment" data-tab="seven">债权查询</div>
			<!--eight-->
			<div class="ui tab segment" data-tab="eight">录入债权</div>
			<!--nine-->
			<div class="ui tab segment" data-tab="nine">批量导入</div>
			<!--ten-->
			<div class="ui tab segment" data-tab="ten">债权还款计划查询</div>
			<!--aa-->
			<div class="ui tab segment" data-tab="aa">个人中心</div>
			<!--bb-->
			<div class="ui tab segment" data-tab="bb">第八个</div>
			<!--cc-->
			<div class="ui tab segment" data-tab="cc">第八个</div>
			<!--dd-->
			<div class="ui tab segment" data-tab="dd">第八个</div>
			<!--ee-->
			<div class="ui tab segment" data-tab="ee">第八个</div>
			<!--ff-->
			<div class="ui tab segment" data-tab="ff">第八个</div>
			<!--gg-->
			<div class="ui tab segment" data-tab="gg">第八个</div>
			<!--hh-->
			<div class="ui tab segment" data-tab="hh">第八个</div>
			<!--ii-->
			<div class="ui tab segment" data-tab="ii">第八个</div>
			<!--jj-->
			<div class="ui tab segment" data-tab="jj">第八个</div>
			<!--kk-->
			<div class="ui tab segment" data-tab="kk">第八个</div>
		</div>

		<!-- 弹出层--添加产品 -->
		<div class="ui modal" id="addModal">
			<i class="close icon"></i>
			<div class="header">产品添加</div>
			<div class="image content">
				<!-- 添加一个表单 -->
				<form class="ui form" id="addProductForm">
					<div class="field">
						<label>产品编号</label> <input type="text" name="proNum"
							placeholder="请录入产品编号"> <label>产品名称</label> <input
							type="text" name="proName" placeholder="请录入 产品名称">
					</div>
					<div class="field">
						<label>产品期限</label> <input type="text" name="proLimit"
							placeholder="请录入 产品期限"> <label>产品年化利率</label> <input
							type="text" name="annualized" placeholder="请录入 产品年化利率">
					</div>
					<input class="ui button" type="button" value="添加" id="addBtn">
				</form>
			</div>
		</div>
		
		<!-- 弹出层--修改产品 -->
		<div class="ui modal" id="editModal">
			<i class="close icon"></i>
			<div class="header">产品修改</div>
			<div class="image content">
				<!-- 添加一个表单 -->
				<form class="ui form" id="editProductForm">
					<div class="field">
						<label>产品编号</label> <input type="text" name="proNum"
							placeholder="请录入产品编号" id="proNum"> 
							
							<label>产品名称</label> <input
							type="text" name="proName" placeholder="请录入 产品名称" id="proName">
					</div>
					<div class="field">
						<label>产品期限</label> <input type="text" name="proLimit"
							placeholder="请录入 产品期限" id="proLimit"> 
							
							<label>产品年化利率</label> <input
							type="text" name="annualized" placeholder="请录入 产品年化利率" id="annualized">
					</div>
					<input class="ui button" type="button" value="修改" id="editBtn">
				</form>
			</div>
		</div>

	</div>
</body>
<script type="text/javascript">
	$(function() {
		$('.ui.dropdown').dropdown({
			allowAdditions : true
		});
		$(".tabular.menu .item").tab();
		$('.ui.accordion').accordion({
			selector : {
				trigger : '.title'
			}
		});
	})
</script>

</html>