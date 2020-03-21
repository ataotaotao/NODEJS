


    <?php
        //防止有乱码出现
        header('Content-Type:text/HTML;charset=utf-8');
        $username = $_POST['username'];
        $password = $_POST['password'];

        echo $username.$password;
    ?>
