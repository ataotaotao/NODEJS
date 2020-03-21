/**
 * addEvent
 * @authors Your Name (you@example.org)
 * @date    2018-03-14 21:14:22
 * @version $Id$
 */


    function addEvent(obj,type,fn,bool){
        bool  = bool || false;//默认为冒泡
        obj[type+fn.name+bool] = handle;
        if(obj.addEventListener){
            obj.addEventListener(type,obj[type+fn.name+bool],bool);
            if(type == 'mousewheel'){
                obj.addEventListener('DOMMouseScroll',obj[type+fn.name+bool],bool);
            }
        }else{
            obj.attachEvent('on'+type,obj[type+fn.name+bool]);
        }

        function handle(e){
            e = e || window.event;//兼容e
            e.wheel = e.wheelDelta || e.detail*-40;//兼容滚轮滚动的方向
            fn.call(obj,e);
            e.preventDefault?e.preventDefault():e.returnValue = false;
        }
    }

    function removeEvent(obj,type,fn,bool){
        bool = bool || false;//将bool值默认设为false
        if(obj.removeEventListener){//标准浏览器
            obj.removeEventListener(type,obj[type+fn.name+bool],bool);
            if(type == 'mousewheel'){//firefox
                obj.removeEventListener('DOMMouseScroll',obj[type+fn.name+bool],bool);
            }
        }else{//ie
            obj.detachEvent('on'+type,obj[type+fn.name+bool]);
        }
    }

