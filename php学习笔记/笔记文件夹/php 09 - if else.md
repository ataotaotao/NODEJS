# if  else 语句

在编写代码的时候常常要用到条件判断来做事情，比如，满足这个条件之后做什么，不满足做什么，尝尝用到条件判断

## 1、if语句

在满足条件之后做什么，不满足什么都不做

# 注意，在PHP里面有一部分值在进行条件判断的时候，会转化为false，例如："" ,0,false,null,空数组



## 2、if else语句

如果满足if里面的条件，就做if里面的事，如果不满足，就做else里面的事





## 3、if   else if   else

如果满足if的条件，就做if里面的事，如果满足else  if里面的条件，就做else if里面的事，如果都不满足，就做else里面的事

这个里面的else  if还可以直接连接在一起，就是`elseif` 这个是专门为PHP else if做的容错版





## 4、switch语句

作用，和if  else  if  ... else 相同

写法：

```php
<?
    switch(names){
        case 1:
            code1;
            break;
        case 2:
            code2;
            break;
        default:
            //如果前面的都没有执行，就执行这一步，可有可无
            code3;
            break;
    }
```

注意：break必须写，否则会导致后面的代码都执行