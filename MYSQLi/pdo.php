<?php
    header("content-type:text/html;charset=UTF-8");
    $servername = "localhost";
    $username = "root";
    $password = "123456789";
     
    try {
        $conn = new PDO("mysql:host=$servername;", $username, $password);
        echo "连接成功"; 
    }
    catch(PDOException $e)
    {
        echo $e->getMessage();
    }

    $array = array(
        "username"=>"123",
        "password"=>"123"
    );
    $p =  json_encode($array);
    echo $p;
    var_dump($p);
    echo "<br>";
    var_dump(json_decode($p));
    print_r(json_decode($p , true));
    echo "<pre>";
    print_r($_SERVER);
    echo "</pre>";
    