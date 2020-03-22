
{
    //ajax请求获取数据
    $.post({
        url:"./doAction.php",
        data:{
            act:"getData"
        },
        success(res){
            // console.log(res);
            let data = JSON.parse(res);
            console.log(data);
            data.forEach((val,index) =>{
                let str = `<li>
                    <img src="${val['imgUrl']}" width="100%" height='100%' alt="${val['description']}">
                    <p class='explanation'>${val['description']}</p>
                    <p class='price'>￥${ parseFloat(val['price']).toFixed(2) }</p>
                </li>`;
                $(".content").html($(".content").html() + str);

                $(".content li").click(function(){
                    let index = $(this).index();
                    console.log(index);
                    window.location.href='./shopDetail.php?act=detail&index='+index;
                });
            });
            

        }
    });
}