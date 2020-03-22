<?php
    /**
     * 连接1，传入所有的参数
     * @return 连接对象
     * 
     */
    function connect1($host , $username , $password , $charset , $database){
        //还是需要连接失败函数
        $link = mysqli_connect($host , $username , $password) or die("连接失败".mysqli_connect_errno().":".mysqli_connect_error());
        mysqli_set_character($link , $charset);
        mysqli_select_db($link ,  $database) or die("选择数据库失败:".mysqli_errno($link).":".mysqli_error($link));
        
        return $link;
    }

    /**
     * 连接2，传入关联数组
     * @return 连接对象
     * 
     */

     function connect2($arr){
        $link = mysqli_connect( $arr['host'] , $arr['user'] , $arr['password']) or die("连接失败".mysqli_connect_errno().":".mysqli_connect_error());
        mysqli_set_character($link , $arr['charset']);
        mysqli_select_db($link , $arr['dbName']) or die("选择数据库失败:".mysqli_errno($link).":".mysqli_error($link));

        return $link;
     }
     
     /**
      * 连接3 使用常量
      * @return 连接对象
      */
      function connect3(){
        $link = mysqli_connect( $arr['host'] , $arr['user'] , $arr['password']) or die("连接失败".mysqli_connect_errno().":".mysqli_connect_error());
        mysqli_set_character($link , $arr['charset']);
        mysqli_select_db($link , $arr['dbName']) or die("选择数据库失败:".mysqli_errno($link).":".mysqli_error($link));
        echo "连接成功";
        return $link;
      }

      /**
       * 插入函数
       * 
       * $data 数组
       * @return 是否成功
       * 
       * 
       */

      function insert( $data , $table){
            $link = connect3();

            //处理query函数
            /*
                insert into xx () values ();
                array_keys() 获取键名 得到的是一个键名索引数组
                array_values() 获取键值
            */
            $keys = join(",",array_keys($data));
            $vals = join(",",array_values($data));
            $query = "insert into $table ($key) values ($vals)";

            $res = mysqli_query($link , $query);
                
            if($res){
                return true;
            }else{
                return false;
            }
      }

      /**
       * 
       * 删除数据
       * @return 是否删除成功 true/false
       * 
       * 
       */
      function delete($table , $where = null){
          $where = $where ? $where :"";
          $query = "delete from". $table.$where;
          $res = mysli_query($link , $query);
          if($res ){
              return true;
          }else{
              return false;
          }
      }

      /**
       * 
       * 更新数据
       * $date 一个数组，设置的属性值
       * @return true/false
       * 
       */
        function update($data , $table , $where = null){
            $link = connect3();
            $where = $where ? $where : "";
            $set = "set ";
            /*
                update table set id = 1 , name = 2 where 
            */
            foreach($data as  $key => $val){
                $set.= "$key = $val,";
            }
            //删除最后多的那个，
            $set = substr($set , 0 , -1);

            //开始更新
            $query = "update $table $set".$where;
            $res = mysqli_query($link , $query);

        }


        /**
         * 查询数据
         * 判断target是否是一个，还是数组
         * @return 数组
         * 
         * 
         */

         function search($table, $target , $where = null , $result_type = MYSQLI_ASSOC){
            //判断$target是不是数组
            $set = null;
            if(is_array($target)){
                foreach($target as $key=>$val){
                    $set.="$key,";
                }
                $set = substr($set , 0 , -1);
            }else{
                $set = $target;
            }
            $query = "select $set from $table".$where;
            $res = mysqli_query($link , $query);
            if($res && mysqli_num_rows($res) >0){
                $rows = mysqli_fetch_all($rows , $result_type);
                return $rows;
            }else{
                return false;
            }
         }

        /**
         * 得到记录数
         * @return 行数
         * 
         * 
         */

         function getTotalNums($table ){
             $link = connect3();
            $query = "select count(*) from $table";
            $res = mysqli_query($link , $query);
            if($res && mysqli_num_rows($res) >0){
                $rows = mysqli_fetch_assoc($res);
            }
         }






        




