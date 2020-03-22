<?php
    header("content-type:text/html;charset=UTF-8");
    $host = "localhost";
    $user = "root";
    $password = "123456789";
    $link = mysqli_connect($host , $user,$password) or die("连接失败".mysqli_connect_errno()."具体信息".mysqli_connect_error());
    mysqli_set_charset($link , 'utf8');
    mysqli_select_db($link , "book") or die("打开指定数据库出错:".mysqli_errno($link).":".mysqli_error($link));
    $query = "select * from bookcategory";
    $result = mysqli_query($link , $query);
    if($result && mysqli_num_rows($result) >0 ){
        // $rows = mysqli_fetch_all($result,MYSQLI_ASSOC);
        // $rows = mysqli_fetch_array($result,MYSQLI_ASSOC);
        $rows = mysqli_fetch_assoc($result);
        echo "<pre>";
        print_r($rows);
        echo "</pre>";
    }