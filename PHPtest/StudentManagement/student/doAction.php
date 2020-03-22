<?php
    header("content-type:text/html;charset=UTF-8");

    //引入文件
    include_once '../function_class/mysqli.func.php';
    include_once "../function_class/common.func.php";

    //接受参数
    $username = isset($_REQUEST['username'])?trim($_REQUEST['username']):"";
    $age = isset($_REQUEST['age'])?trim($_REQUEST['age']):"";
    $sex = isset($_REQUEST['sex'])?trim($_REQUEST['sex']):"";
    $act = isset($_REQUEST['act'])?trim($_REQUEST['act']):"";
    

    //得到mysql对象
    $mysql = new MysqlConnect("Wt1779791796","51zxw");

    //判断参数
    switch($act){
        case "add":
        //  判断是不是add的代码
            // echo "添加用户";

            //获取到用户然后插入用户
            $array = array(
                "username"=>"'".$username."'",
                "age"=>"'".$age."'",
                "sex"=>"'".$sex."'"
            );
            $result = $mysql->insert($array , "student");

            if($result){
                alertMes("插入成功，跳转到详情页面","layout-index.php");
            }else{
                alertMes("插入失败，跳转到新增页面","layout-form.php");
            }



            break;
        case "modify":
            $id = isset($_REQUEST['id'])?trim($_REQUEST['id']):"";

            $data = judges($username,$age,$sex);
            $res = $mysql->update($data,"student","where id= $id");

            if($res){
                alertMes("修改成功","layout-index.php");
            }else{
                alertMes("修改失败","layout-index.php");
            }
            

            break;
        case "delete":
            // echo "删除";
            $id = isset($_REQUEST['id'])?trim($_REQUEST['id']):"";

            $res = $mysql->delete("student","where id=$id");
            if($res){
                echo 1;
            }else{
                echo 0;
            }

            break;
    }

    


