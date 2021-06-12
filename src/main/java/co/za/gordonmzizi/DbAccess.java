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
            Statement statement1 = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ResultSet result = statement1.executeQuery(sql);
            while(result.next()){
                if(result.getString("gender").equals("Male")){
                   result.updateString("gender","FUCK");
                   result.updateRow();
                }
            }
            
            result.close();
            statement1.close();
            connection.close();

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
