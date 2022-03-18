import com.mysql.jdbc.Driver;

import java.sql.*;
import java.util.Properties;

public class JDBCDemo {
    public static void main(String[] args) throws Exception {
        Properties prop = new Properties();

        //1 注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        //2 获取连接
        String url = "jdbc:mysql://127.0.0.1:3306/mydb";//可以开启预编译功能useServerPrepStmts = true
        String username = "root";
        String password = "123456789";
        Connection connection = DriverManager.getConnection(url, username, password);

        // 防止sql注入
//        String sql1 = "select * from tb_user where username = ? and password = ?";
//        PreparedStatement preparedStatement = connection.prepareStatement(sql);
//        preparedStatement.executeUpdate();
//

        //3 定义sql
        String sql = "update myapp_users set age = 18 where id = 1";

        //4 执行sql对象 statment
        Statement statement = connection.createStatement();
        //5 执行sql
        int i = statement.executeUpdate(sql);
        if (i>0) {
            System.out.println("修改成功");
        }else{
            System.out.println("修改失败");
        }
//        ResultSet resultSet = statement.executeQuery(sql);
//        while (resultSet.next()) {
//            int id = resultSet.getInt("id");
//            String name = resultSet.getString("name");
//            System.out.println(id+"-"+name);
//        }
        System.out.println(i);
        //6 关闭连接
        statement.close();
        connection.close();
    }
}
