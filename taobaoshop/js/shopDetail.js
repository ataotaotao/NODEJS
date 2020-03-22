{
    let $back = $(".back");

    $back.click(function(){
        window.history.go(-1);
    });


    //控制数量的变化
    let $less = $("#box .count .less"),
        $more = $("#box .count .add"),
        $count = $("#box .count i"),
        $price = $("#box .price ").html().substring(1),
        $total = $("#box .pay .total");
    let count = 0;
    // console.log(Number($price));
    $less.click(function(){
        
        if(count == 0){
            return;
        }
        count--;
        $count.html(count);
        $total.html( "￥" +  parseFloat($price ) * count );
    });

    $more.click(function(){
        if(count == 10){
            return;
        }
        count++;
        $count.html(count);
        $total.html( "￥" + parseFloat($price ) * count );
    });

    //点击确定按钮提交
    let $btn = $("#box .pay .total");
    $btn.click(function(){

        //发送请求，然后将购买信息存在数据库中。

        /*
            存储的数据：价格，数量，总价，时间，物品id
        */
       let value = $("#shopid").html();
       console.log(value);
        if(count){
            $.post({
                url:"./doAction.php",
                data:{
                    act:"save",
                    price:$price,
                    count,
                    total:$total.html().substring(1),
                    id:value
                },
                success(res){
                    if(res){
                        alert("购买成功");
                        window.location.reload();
                    }
                }
            });
        }else{
            return;
        }

    });
}




