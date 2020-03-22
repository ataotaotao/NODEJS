<?php
	
	//查询出数据库所有的数据
	require_once "../function_class/mysqli.func.php";
	require_once "../function_class/common.func.php";

	//查询数据
	$mysql = new MysqlConnect("123456789","51zxw");

	//查询所有的数据
	$result = $mysql->search("student","*");
	// echo "<pre>";
	// print_r($result);

	// echo "</pre>";

	//页数也得处理

	//默认显示第一页
	$page = isset($_REQUEST['page'])?$_REQUEST['page']:1;
	// echo $page;
	//一共多少页
	$num = 5;
	echo count($result);
	$nums = (int)(count($result) / $num) +1;
	if(count($result) % $num ===0 && count($result) !==0){
		echo "走到了这儿";
		$nums--;
	}
	echo $nums;
	// echo $nums;
	$resultTotal = showData($result , $page , $num);
	// echo "<pre>";
	// print_r($resultTotal);
	// echo "</pre>";



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
				<!-- 成功提示框 -->
				<div class="alert alert-success alert-dismissible" role="alert">
					<button type="button" class="close" data-dismiss="alert"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
					<strong>成功！</strong> 操作成功提示
				</div>
				<!-- 失败提示框 -->
				<div class="alert alert-danger alert-dismissible" role="alert">
					<button type="button" class="close" data-dismiss="alert"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
					<strong>失败！</strong> 操作失败提示
				</div>
				<!-- 自定义内容 -->
				<div class="panel panel-default">
					<div class="panel-heading">学生列表</div>
					<div class="panel-body">
						<table class="table table-striped table-responsive table-hover">
							
								<tr>
									<th>id</th>
									<th>姓名</th>
									<th>年龄</th>
									<th>性别</th>
									<th width="120">操作</th>
								</tr>
							<?php 
								if($resultTotal){
									foreach($resultTotal as $key => $val){
							?>
								<tr>
									<td><?php echo $val['id'] ?></td>
									<td><?php echo $val['username'] ?></td>
									<td><?php echo $val['age'] ?></td>
									<td><?php echo $val['sex'] ?></td>
									<td>
										<a href="layout-detail.php?id=<?php echo $val['id']; ?>" style='cursor:pointer; color:blue;' class='detail'>详情</a>
										<a  href="layout-modify.php?id=<?php echo $val['id']; ?>" style='cursor:pointer; color:blue;' class='modify'>修改</a>
										<a data-index = <?php echo $val['id']; ?>  style='cursor:pointer; color:blue;' class='delete'>删除</a>
									</td>
								</tr>

							<?php
								}
							}
							?>
							
						</table>
					</div>
				</div>

				<nav>
					<ul class="pagination pull-right">
					<!-- 页数处理 -->
					<?php
						for($i = 1;$i<=$nums;$i++){
					?>
						<li>
							<a href="layout-index.php?page=<?php echo $i;?>"><?php echo $i; ?></a>
						</li>
					<?php
						}
					?>
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
	<script>
		{
			//delete发送ajax请求
			let $delete = $(".delete");

			$delete.click(function(){
				let $this = $(this);
				let index = $this.data("index");
				console.log($this[0].parentNode);
				$.post({
					url:"doAction.php",
					data:{
						id:index,
						act:"delete"
					},
					success(res){
						// console.log(res);
						if(res){
							alert("删除成功");
							//删除自己
							window.location.reload();
							// $($this[0].parentNode).remove(".delete");
							// console.log(.removeChild($this[0].parentNode.children('.delete')))
						}else{
							alert("删除失败");
						}
						
					}
				});
			});
		}
	</script>
</body>
</html>