<?php
    
    //mysql
    require_once "functions/mysql.php";


    //获取参数 
    $act = isset($_REQUEST['act'])?$_REQUEST['act']:"";
    // echo $act."这就是act";
    
    if($act === "detail"){
        $index = isset($_REQUEST['index'])?$_REQUEST['index']:"";
        // var_dump(is_string($index));
        $mysql = new MysqlConnect("123456789","taobaoshop");
        $index ++;
        //查询数据
        $res = $mysql->search("shopinfo","*","where id = {$index}");

        // print_r($res);

    }
    
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <script>
        let html = document.querySelector('html');
        let width = html.getBoundingClientRect().width;
        html.style.fontSize = width / 10 + 'px';
    </script>
    <link rel="stylesheet" href="css/buy.css">
</head>
<body>
    <div id="box">
        <div class="back"><</div>
        <?php
            foreach ($res as $key => $value) {
        ?>
            <div class="img">
            <img src="<?php echo $value['imgUrl'] ?>" width="100%" height="100%" alt="<?php echo $value['description'] ?>">
        </div>
        <p class="description"><?php echo $value['description'] ?></p>
        <p class="price">￥<?php echo (float)$value['price']; ?></p>
        <div class="count">
            数量
            <span class="less">-</span>
            <i>0</i>
            <span class='add'>+</span>
        </div>
        <div class="pay">
            <h3>总计</h3>
            <p class='total'>￥0</p>
        </div>
        <div id='shopid' style="display:none;"><?php echo $index;?></div>
        <?php
            }
        ?>


    </div>
    <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
    <script src="js/shopDetail.js"></script>
</body>
</html>