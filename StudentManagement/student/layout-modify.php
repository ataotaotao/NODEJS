<?php
    header("content-type:text/html;charset=UTF-8");
    $id = isset($_REQUEST['id'])?$_REQUEST['id']:"";
    echo $id;
?>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width,initial-scale=1">
	<title>index</title>
	<link rel="stylesheet" href="static/css/bootstrap.min.css">
	<script text="text/javascript" src="static/js/jquery-3.1.0.min.js"></script>
	<style type="text/css">
		body{ font-family: 'Microsoft YaHei';}
		/*.panel-body{ padding: 0; }*/
		span{
			 color: blue;
		}
	</style>
</head>
<body>
<div class="jumbotron">
	<div class="container">
		<h1>51学生管理系统 V1.0</h1>


	</div>
</div>
<div class="container">
	<div class="main">
		<div class="row">
			<!-- 左侧内容 -->
			<div class="col-md-3">
				<div class="list-group">
					<a class="list-group-item text-center active">查看学生</a>
					<a href="layout-form.php" class="list-group-item text-center">新增学生</a>

				</div>
			</div>
			<!-- 右侧内容 -->
			<div class="col-md-9">
				<!-- 自定义内容 -->
				<div class="panel panel-default">
					<div class="panel-heading">学生信息修改</div>
					<div class="panel-body">
						<form action="doAction.php?act=modify&id=<?php echo $id; ?>" method="post" class="form-horizontal" role="form">				
							
							<div class="form-group">
								<label class="col-sm-2 control-label">姓名</label>
								<div class="col-sm-5">
									<input type="text" name="username" class="form-control" placeholder="姓名">
								</div>
								<div class="col-sm-5">
									<p class="form-control-static text-danger">姓名不能为空</p>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">年龄</label>
								<div class="col-sm-5">
									<input type="text" name="age" class="form-control" placeholder="年龄">
								</div>
								<div class="col-sm-5">
									<p class="form-control-static text-danger">年龄只能为整数</p>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">性别</label>
								<div class="col-sm-5">
									<label class="radio-inline">
										<input type="radio" name="sex" value="未知">未知
									</label>
									<label class="radio-inline">
										<input type="radio" name="sex" value="男">男
									</label>
									<label class="radio-inline">
										<input type="radio" name="sex" value="女">女
									</label>
								</div>
								<div class="col-sm-5">
									<p class="form-control-static text-danger">请选择性别</p>
								</div>
							</div>
							<div class="form-group">
								<div class="col-sm-offset-2 col-sm-10">
									<button type="submit" class="btn btn-primary">提交</button>
								</div>
							</div>
						</form>

					</div>
				</div>

				<nav>
					<ul class="pagination pull-right">
					<!-- 页数处理 -->
					</ul>
				</nav>
			</div>
		</div>
  	</div>
</div>
<!-- 尾部 -->
<div class="jumbotron" style=" margin-bottom:0;margin-top:105px;">
	<div class="container">
	<span>&copy; 2016 Saitmob</span>
	</div>
</div>


	<script src="static/js/jquery-3.1.0.min.js"></script>
	<script src="static/js/bootstrap.min.js"></script>
</body>
</html>