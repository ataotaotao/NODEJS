/**
 * removeEvent函数
 * @authors Your Name (you@example.org)
 * @date    2018-03-08 19:32:43
 * @version $Id$
 */
    function removeEvent(obj,type,fn,bool){
        bool = bool || false;//将bool值默认设为false
        if(obj.removeEventListener){//标准浏览器
            obj.removeEventListener(type,handle,bool);
            if(type == 'mousewheel'){//firefox
                obj.removeEventListener('DOMMouseScroll',handle,bool);
            }
        }else{//ie
            obj.detachEvent('on'+type,handle);
        }
        function handle(e){
            e = e || window.event;
            e.wheel = e.wheelDelta || e.detail*-40;//滚动方向
            fn.call(obj,e);
            e.preventDefault?e.preventDefault():e.returnValue = false;//阻止浏览器默认事件
        }
    }
