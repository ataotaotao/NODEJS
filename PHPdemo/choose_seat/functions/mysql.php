<?php
    header("content-type:text/html;charset=UTF-8");
    //定义类来连接数据库
    class MysqlConnect{
        private $host = "localhost";
        private $user = "root";
        private $charset = "utf8";
        private $link;

        function __construct($password , $dbName){
            
            $this->link = mysqli_connect($this->host , $this->user , $password) or die("连接数据库失败".mysqli_connect_errno().":".mysqli_connect_error());
            mysqli_set_charset($this->link , $this->charset);
            mysqli_select_db($this->link , $dbName) or die("选择打开数据库失败".mysqli_errno().":".mysqli_error());
            // echo "连接成功";
        }

       /**
       * 插入函数
       * 
       * $data 数组
       * @return 是否成功
       * 
       * 
       */

       public function insert( $data , $table ){

            
            $vals = "";
            $attr = "";
            
            if(is_array(array_values($data)[0])){
                foreach ($data as $key => $val) {
                    $attr = join(",",array_keys($val));
                    $vals.="(";
                    foreach ($val as $keys => $values) {
                        $vals .="'".$values."',";
                    }
                    $vals = substr($vals , 0 , -1);
                    $vals.="),";
                }
                $vals = substr($vals , 0 , -1);
            }else{
                $vals = "(";
                foreach ($data as $key => $value) {
                    $attr .= $key.",";
                    $vals .= "'".$value."',";
                }
                $attr  = substr($attr , 0 , -1);
                $vals = substr($vals , 0 , -1);
                $vals.=")";
                
            }


            
            
            
            // echo $attr;
            $query = "insert into $table ($attr) values $vals";
            // echo $query;
            $res = mysqli_query($this->link , $query);
            
            if($res){
                return 1;
            }else{
                return 0;
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
            $query = "delete from ". $table.' '.$where;
            
            $res = mysqli_query($this->link , $query);
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
            $query = "update $table $set ".$where;
            
            $res = mysqli_query($this->link , $query);
            
            if($res ){
                return true;
            }else{
                return false;
            }
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
                    $set.="$val,";
                }
                $set = substr($set , 0 , -1);
            }else{
                $set = $target;
            }
            $query = "select $set from $table ".$where;
            $res = mysqli_query($this->link , $query);
            if($res && mysqli_num_rows($res) >0){
                $rows = mysqli_fetch_all($res , $result_type);
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

        function getTotalNums($table){
           $query = "select count(*) from $table";
           $res = mysqli_query($this->link , $query);
           if($res && mysqli_num_rows($res) >0){
               $rows = mysqli_fetch_assoc($res);
               return $rows['count(*)'];
           }else{
               return false;
           }
        }



    }


    // $mysql = new MysqlConnect("123456789","book");

    // $mysql->insert(array(
    //     // array(
    //     //     "category"=>"计算机2",
    //     //     "parend_id" => 0
    //     // ),
    //     // array(
    //     //     "category"=>"计算机2",
    //     //     "parend_id" => 0
    //     // ),

    //     "category"=>"计算机2",
    //         "parend_id" => 0
            
       
    // ),"bookcategory");


    