package co.za.gordonmzizi;
import java.sql.*;

public class DbAccess {
    public static void main(String[] args) {
        //password and username created just for this learning session.
        String url = "jdbc:postgresql://192.168.1.5:5432/postgres";
        String userName = "postgres";
        String passwd = "mzizi45";
        String sql = "SELECT * FROM users";

        try {
            Connection connection = DriverManager.getConnection(url, userName, passwd);
            Statement statement1 = connection.createStatement();
            ResultSet result = statement1.executeQuery(sql);
            ResultSetMetaData meta = result.getMetaData();
            int row = meta.getColumnCount();
            while(result.next()){
            for(int i = 1; i <= row; i++) {
                System.out.println(meta.getColumnTypeName(i));
                if (meta.getColumnTypeName(i).equals("serial")) {
                    System.out.println(result.getInt(meta.getColumnName(i)));
                } else if (meta.getColumnTypeName(i).equals("varchar")) {
                    System.out.print(result.getString(meta.getColumnName(i)));
                }
              }
            }


            result.close();
            statement1.close();
            connection.close();

        }catch (SQLException e){
            System.out.println(e.fillInStackTrace());
        }
    }
}
