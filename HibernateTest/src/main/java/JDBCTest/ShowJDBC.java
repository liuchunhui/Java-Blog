package JDBCTest;

import java.sql.*;

/**
 * Created by huihui on 14-11-7.
 */
public class ShowJDBC {
    public static void main(String[] args) throws SQLException{
        String driver = "com.mysql.jdbc.Driver";
        String dbName = "hibernate";
        String username = "root";
        String password = "0000";
        String url = "jdbc:mysql://localhost:3306/" + dbName +"?useUnicode=true&amp;characterEncoding=utf8";
        String sql = "select * from news_inf";



        // 装载驱动程序
        try {
            System.out.println(Class.forName(driver));
            throw new ClassNotFoundException("发生ClassNotFoundException");
        }catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        // 建立连接
        Connection conn = DriverManager.getConnection(url,username,password);

        // 创建SQL语句对象
        Statement ps = conn.createStatement();

        // 返回一个ResultSet的对象，此对象由统一形式的列组织的数据行组成，一次只能看到一个数据行，
        // 所以要使用rs.next()来遍历
        ResultSet rs = ps.executeQuery(sql);

        while (rs.next()) {
            System.out.println(rs.getString("new_title"));
        }


        DatabaseMetaData metaData = conn.getMetaData();
        ResultSet resultSet = metaData.getColumns(null,null,"school_inf",null);
        while (resultSet.next()) {
            System.out.println(resultSet);
        }

        // 关闭记录集
        if (rs !=  null ) {
            try {
                rs.close();
            }catch (SQLException e) {
                e.printStackTrace();
            }
        }

        // 关闭声明
        if (ps != null ) {
            try{
                ps.close();
            }catch (SQLException e) {
                e.printStackTrace();
            }

        }

        // 关闭链接对象
        if (conn != null ) {
            try{
                conn.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

}
