import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;  

public class UpdateMySQLData {

    private static String[] names = {"Bob", "Jenn", "Susan", "Joe", "Henry"};
    private static String[] days = {"Sat", "Sat", "Sat", "Sun", "Sun"};
    private static int[] amount = {3, 2, 7, 5, 1};

    public static void main(String[] args) {
    	String URL = "jdbc:mysql://frodo.bentley.edu:3306/test";
        String username = "harry";
        String password = "harry";

        try { //load driver into VM memory
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Failed to load MySQL driver.");
            return;
        }

      
        //make connection, create statement, execute SQL
        try (
            Connection con = DriverManager.getConnection (
                URL,
                username,
                password))
           
            {
        	 System.out.println("Connection made");
           Statement stmt = con.createStatement();
            stmt.executeUpdate("drop table if exists CS280data;");
            stmt.executeUpdate("create table CS280data (Names varchar(32), Days varchar(10), Amount integer);");
            System.out.println("table created");        

            // execute SQL command to insert data using a PreparedStatement     
        	PreparedStatement pstmt = con.prepareStatement("insert into CS280data values (?, ?, ?);");
        	int howmany=0;
            for (int i=0; i<names.length; i++) {
                pstmt.setString(1, names[i]);
                pstmt.setString(2, days[i]);
                pstmt.setInt(3, amount[i]);
                howmany = howmany + pstmt.executeUpdate(); //count effected records
                
            }
            System.out.println(howmany + " records inserted");
           
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
