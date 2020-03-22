<?php
/**
 * 弹出提示信息并且跳转
 * @param string $mes
 * @param string $url
 */
function alertMes($mes,$url){
	echo "<script>
			alert('{$mes}');
			setTimeout(function(){
				location.href='{$url}';
			},1000);
			
	</script>";
	die;
}

/**
 * 
 * 判断修改的值有哪几个
 */

 function judges($username , $age , $sex){
	$arr1 = array();
	if($username){
		$arr1['username'] = "'".$username."'";
	}
	if($age){
		$arr1['age'] = "'".$age."'";
	}
	if($sex){
		$arr1['sex'] = "'".$sex."'";
	}

	return $arr1;
 }



/**
 * $all 数组
 * $page 第几页
 * $num 每页多少个
 * 
 * 获取显示的数据
 */

 function showData($data,$page , $num){
	$array = array();
	$all = count($data);
	// echo $all."nums".$page.$num;
	//判断有多少页
	$pageAll = (int)($all/$num) +1;
	if( $pageAll< $page){
		return;
	}else if($page < $pageAll){	//小于pageAll
		for($i = 0;$i<$num;$i++){
			$array[] = $data[($page-1)*$num + $i];
		}

	}else{//等于pageAll
		// echo "走这边";
		
		for ($i=0; $i <$all - ($page-1) * $num  ; $i++) { 
			$array[] = $data[($page-1)*$num + $i];
		}
	}

	return $array;

	




 }