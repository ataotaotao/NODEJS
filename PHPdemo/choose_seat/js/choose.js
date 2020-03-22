

//es6
{

    function addZero(num){
        if(num <10){
            num  = "0"+ num;
        }else{
            num = "" + num;
        }
        return num;
    }


    //刚开始显示今天的时间
    let d = new Date();
    let month = d.getMonth() +1 ;
    let day = d.getDate();
    let h = d.getHours();
    let m = d.getMinutes();

    let $title = $("#box .title");
    $title.html("今天"+addZero(month)+"月"+addZero(day)+"日 "+addZero(h)+":"+addZero(m));
}

{
    //生成座位
    let $seat = $("#box .seat");
    let arr = [];
    let numArr = [];
    async function requests(){
        await $.post({
            url:"./doAction.php",
            data:{
                "act":"request_seat"
            },
            success:function(res){
                if(res !== "0"){
                    arr = JSON.parse(res);
                }else{
                    arr = [];
                }
                for(let i = 0;i<92;i++){
                    let span = document.createElement("span");
                    if(i % 10 === 0 && i !== 90 ){
                        $(span).addClass("first");
                    }else if( i %10 === 4 && i !== 84){
                        $(span).addClass("four");
                    }
                    $seat[0].appendChild(span);
                    if(arr.length !== 0){
                        arr.forEach((val)=>{
                            if(i == val){
                                $(span).addClass("chose");
                            }
                        });
                    }
            
                    
                }
                
            }
        });

        

        

    }
    requests()
        .then(res=>{
            //选座
            {
                let $span = $("#box .seat span");
                let $show = $("#box .chose-seat .chose");
                let $total = $("#total");
                let $num = $("#num");
                let count = 0;
                $span.each((index, val) =>{
                    
                    val.onoff = true; // 表示没有被选择。

                    val.addEventListener("click",function(e){
                        if(count >= 5){
                            alert("最多选择5人的座位");
                            return;
                        }
                        if($(val).hasClass("chose")){
                            alert("此座位已被选择，请选择其他座位");
                            return;
                        }
                        //选择
                        

                        if(!this.onoff){
                            alert("不可重复选座");
                            return;
                        }
                        $(this).addClass("selected");

                        

                        let row = Math.floor(index/10) +1;
                        let position = index -  (row -1 )*10 +1 ;
                        let $span =`<span>${row}排${position}座</span>` ;
                        $show.html($show.html() + $span);
                        count++;
                        numArr.push(index);
                        $num.html(count);
                        $total.html(count * 99);
                        this.onoff = false;

                    } , false);
                    
                });
            }
        })
        .then(res=>{
            //点击确定
            {
                let $btn = $("#box .total .sure");
                $btn.click(function(){
                    $.post({
                        url:"./doAction.php",
                        data:{
                            num:numArr,
                            act:"buy"
                        },
                        success:function(res){
                            if(res == 1){
                                alert("购买成功");
                            }else{
                                alert("购买失败");
                            }

                            //将选择的那几个变色
                            for(let i=0;i<numArr.length;i++){
                                $("#box .seat span").eq(numArr[i]).addClass("chose");
                            }
                            
                        }
                    })
                });
            }
        })
    

}



