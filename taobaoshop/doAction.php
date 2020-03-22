<?php
    header("content-type:text/html;charset=UTF-8");

    require_once 'functions/mysql.php';

    //获取数据
    $act = isset($_REQUEST['act'])?trim($_REQUEST['act']):"";
    $mysql = new MysqlConnect("123456789","taobaoshop");

    if ($act === "getData"){
        $res = $mysql->search("shopinfo","*");
        // print_r($res);
        echo json_encode($res);
    }else if($act === "save"){
        $act = isset($_REQUEST['act'])?trim($_REQUEST['act']):"";
        $price = isset($_REQUEST['price'])?trim($_REQUEST['price']):"";
        $count = isset($_REQUEST['count'])?trim($_REQUEST['count']):"";
        $total = isset($_REQUEST['total'])?trim($_REQUEST['total']):"";
        $id = isset($_REQUEST['id'])?trim($_REQUEST['id']):"";

        $data = array(
            "price" => $price,
            "count" => $count,
            "total" => $total,
            "time" =>date("Y-m-d h:i:s"),
            "shopId" => $id
        );

        $res = $mysql->insert($data , "purchaseInfo");
        echo $res."res";
        if($res){
            echo 1;
        }else{
            echo 0;
        }
    }