


    <?php
        //防止有乱码出现
        header('Content-Type:text/HTML;charset=utf-8');
        $username = $_GET['username'];
        $password = $_GET['password'];
        echo '用户名：'.$username.'密码:'.$password;
    ?>
