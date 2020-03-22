<?php
    header("content-type:text/html;charset=UTF-8");

    //引入文件
    require_once 'functions/mysql.php';

    //表
    $table = "user";

    //接受参数
    $username = isset($_REQUEST['username'])?$_REQUEST['username']:"";

    $password = isset($_REQUEST['password'])?$_REQUEST['password']:"";

    $email = isset($_REQUEST['email'])?$_REQUEST['email']:"";

    $act = isset($_REQUEST['act'])?$_REQUEST['act']:"";
    $num = isset($_REQUEST['num'])?$_REQUEST['num']:"";

    //mysql 类的实例
    $mysql = new MysqlConnect('Wt1779791796','demo_zxw');

    
   

    //判断传入的参数是什么类型 login     reg    checkUser
    if($act === "checkUser"){
        //判断输入过来的用户名是否被注册
        $result = $mysql->search($table , "*"," where username ='$username'");
        
         //判断是否有数据
        echo $result ? 1: 0;
    }else if($act === "reg"){
        //直接往数据库中塞入数据
        //对密码进行加密
        $password = md5($password);
        $result = $mysql->insert(array(
            "username" => $username,
            "password" => $password,
            "email" => $email,
            "regtime" => date("Y-m-d h:i:s")
        ) , $table);
        if($result == false){
            echo "注册失败，即将返回登录页面<script> setTimeout(function(){window.location.href='index.php'} ,345000);  </script>";
        }else{
            echo "注册成功，即将返回登录页面<script> setTimeout(function(){window.location.href='index.php'} ,3000);  </script>";
        }
        
    }else if($act === "login"){

        //对比数据库中的账号密码和输入的是否一致

        //先查询账号密码
        $arr = $mysql->search($table , array("username" , "password")," where username ='$username'");

        //和输入的进行对比
        if($username == $arr[0]['username'] && md5($password) == $arr[0]['password'] ){
            echo "登录成功，即将跳转到选座页面<script> setTimeout(function(){ window.location.href='choose.php' },3000 );</script>";
        }else{
            echo "登录失败，回到登录页面页面<script> setTimeout(function(){ window.location.href='index.php' },3000 );</script>";
        }
        
    }else if($act === "request_seat"){
        $arr = $mysql->search("choose","num");
        
        if($arr){
            $array = array();
            foreach($arr as $key => $val){
                array_push($array , $val['num']);
            }
            echo json_encode($array);
        }else{
            echo 0;
        }
    }else if($act === "buy"){
        // echo json_encode($num);
        //处理成健名是num的。
        $array = array();
        foreach ($num as $key => $value) {
            $array[] = array(
                "num"=>$value
            );
        }
        
        $res = $mysql->insert($array , "choose");

        if($res){
            echo 1;
        }else{
            echo 0;
        }
    }



