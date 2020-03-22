<?php
    header("content-type:text/html;charset=UTF-8");
    //操作数据库六部：



    //1.连接数据库
    //建立连接并且返回对象
    /*
        $user 数据库的用户名，
        $password， 数据库的密码；
    */
    $host = "localhost";
    $user = "root";
    $password = "123456789";
    $link = mysqli_connect($host , $user,$password , $database , $port,$socket) or die("连接失败".mysqli_connect_errno()."具体信息".mysqli_connect_error());
    // echo "<pre>";
    // var_dump($link);
    // echo "</pre>";
    //2.设置字符集
    //防止乱码
    mysqli_set_charset($link , 'utf8');


    //3.打开指定数据库 防止出错还是要写or，防止报错。
    mysqli_select_db($link , "book") or die("打开指定数据库出错:".mysqli_errno($link).":".mysqli_error($link));

    //4.执行sql查询
    // 增删改，基本相同 ， 返回的结果是是否成功，
    $query = "insert into bookcategory (category , parent_id) values ('建筑学1',2)";
    // $query = "delete from bookcategory where category_id = 6";
    // $query = "update bookcategory set parent_id = (select category_id from bookcategory where category = '计算机') where category = '建筑学'";
    $result = mysqli_query($link , $query);

    var_dump($result);

    //判断是否操作成功
    if($result){
        echo "操作成功";
    }else{
        echo "操作失败";
    }


    // 查询比较特殊，得到的结果是数据，要进行处理。



    //5.释放结果集
    //6.关闭连接
