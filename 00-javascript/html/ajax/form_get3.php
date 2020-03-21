


    <?php
        //防止有乱码出现
        header('Content-Type:text/HTML;charset=utf-8');
        $username = $_GET['username'];
        $password = $_GET['password'];

        if($username == 'helloworld' && $password == '8888'){
            $result = 1;
        } else{
            $result = 2;
        }

        header('location:./form_get3.html?'.$result);
    ?>
