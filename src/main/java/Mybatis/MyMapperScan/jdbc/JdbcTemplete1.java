package Mybatis.MyMapperScan.jdbc;

import java.sql.*;

public class JdbcTemplete1 {

    Connection connection=null;
    Statement statement=null;
    ResultSet resultSet=null;

    public void load(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void getConnection(){
        String url="jdbc:mysql://127.0.0.1:3307/xa1";
        try {
            connection=DriverManager.getConnection(url,"root","");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void getStatment(){
        try {
            statement=connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    public void closeSource(){

        if(resultSet!=null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(statement!=null){
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(connection!=null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    //SQL语句的执行以及结果的处理
    //这个是泛型方法
    public final  <T,R> R execute(String sql,Hanlder<T,R> hanlder){

        this.load();
        this.getConnection();
        this.getStatment();

        //接下来是对结果的处理：但是我们还是需要通过分类讨论才能实现不同的功能
        if(sql.trim().startsWith("select")||sql.trim().startsWith("SELECT")){
            try {
                resultSet=statement.executeQuery(sql);

                //得到结果以后就直接返回结果:通过传进来的参数调用处理结果的方法
                return hanlder.hanlder((T) resultSet);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else {
            try {
                Integer effect=statement.executeUpdate(sql);
                return hanlder.hanlder((T) effect);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        //如果都不满足说明这个语句有问题直接返回null
        return null;

    }


}
interface Hanlder<T,R>{
    R hanlder(T t);
}