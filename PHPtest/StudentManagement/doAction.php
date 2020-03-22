<?php
    // 设置字符编码集
    header("content-type:text/html;charset=UTF-8");

    require 'function_class/mysqli.func.php';
    require_once "swiftmailer-master/lib/swift_required.php";
    require_once "function_class/common.func.php";

    //接受参数
    $username = isset($_REQUEST['username'])?trim($_REQUEST['username']):"";
    $password = isset($_REQUEST['password'])?md5(trim($_REQUEST['password'])):"";
    $act = isset($_REQUEST['act'])?trim($_REQUEST['act']):"";
	
    $mysql = new MysqlConnect("Wt1779791796","51zxw");
    
    $link = $mysql->getConnect();

   

    switch($act){
        case "reg":
            //关闭自动提交
            mysqli_autocommit($link , false);
            // echo "注册";
            $email = $_REQUEST['email'];
            $regTime = time();
            // echo $regTime;

            $token = md5($username.$password.$regTime);
            

            $token_exptime = $regTime + 24 * 3600;

            // $arr = compact("username","password","regTime","email","token","token_exptime");
            $arr = array(
                "username" => "'".$username."'",
                "password" => "'".$password."'",
                "email" => "'".$email."'",
                "token" => "'".$token."'",
                "token_exptime" => $token_exptime,
                "regTime" => $regTime
            );
            $res = $mysql->insert($arr , "51zxw_user");

            //发送邮件的对象
            //初始化邮件服务器对象
            $transport = Swift_SmtpTransport::newInstance("smtp.sina.com",25);

            //设置用户名和密码
            $transport->setUsername("wt1779791796@sina.com");
            $transport->setPassword("wt1779791796");

            //获取发送邮件对象
            $mailer = Swift_Mailer::newInstance($transport);
            //邮件信息发送对象
            $message = Swift_Message::newInstance();
            //谁发送的
            $message->setFrom(array("wt1779791796@sina.com"));
            //发送给谁
            $message->setTo($email);
            //设置邮件的标题，也就是主题
            $message->setSubject('注册邮箱激活邮件');
            
            /*
                url中间不能有空格。
            */

            $searches = "?username={$username}&act=active&token={$token}";
            $url = "http://".$_SERVER['HTTP_HOST'].$_SERVER['PHP_SELF'].$searches;
            echo $url;
            $urlenchode = urlencode($url);
            $emailBody = <<< EOF
            欢迎使用账号激活功能,请点击链接激活账号：
	   <a href="$url" target="_blank">$urlenchode</a>
    	(该链接在24小时内有效)
        如果上面不是链接形式，请将地址复制到您的浏览器(例如IE)的地址栏再访问。     
EOF;

            $message->setBody($emailBody,"text/html","utf-8");
            try{
                $res1 = $mailer->send($message);
                if($res && $res1){
                    mysqli_commit($link);
                    mysqli_autocommit($link,true);
                    alertMes('注册成功，立即激活使用','index.php');
                }else{
                    mysqli_rollback($link);
                    alertMes("注册失败，重新注册",'index.php');
                }
            }catch(Swift_ConnectionException $e){
                die('邮件服务器错误:').$e->getMessage();
            };
            
            break;
        case "active":
            $token = $_REQUEST['token'];
            $username = mysqli_real_escape_string($link , $username);
            $query = $mysql->search("51zxw_user",array("id","token_exptime"),"where username ='{$username}'");

            
            if($query){
                $now = time();
                $exp_time = $query[0]['token_exptime'];
                if($now - $exp_time > 24 * 3600){
                    $mysql->delete("51zxw_user","where username = ' $username '");
                    alertMes("激活码过期，请重新注册","index.php");
                }else{
                    $result = $mysql->update(array(
                        "status"=>1
                    ),"51zxw_user");
                    alertMes("激活成功",'index.php');
                }

            }else{
                alertMes("激活失败,没找到激活的用户",'index.php');
            }



            break;
        case "login":
            //登录
            $res = $mysql->search("51zxw_user",array("username","password"),"where username='{$username}'");
            
            if($res[0]['username'] === $username && $res[0]['password'] === $password){
                alertMes("登录成功,进入学生管理页面","student/layout-index.php");
            }else{
                alertMes("登录失败,进入登录页面","index.php");
            }
            break;
        case "checkUser":
            $res = $mysql->search("51zxw_user","*","where username='{$username}'");
            
            if($res){
                echo 1;
            }else{
                echo 0;
            }
            break;
    }

    


