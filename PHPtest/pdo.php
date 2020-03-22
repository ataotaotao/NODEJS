<?php
    header("content-type:text/html;charset=UTF-8");
    $servername = "localhost";
    $username = "root";
    $password = "Wt1779791796";
     
    try {
        $conn = new PDO("mysql:host=$servername;", $username, $password);
        echo "连接成功"; 
    }
    catch(PDOException $e)
    {
        echo $e->getMessage();
    }
    
    