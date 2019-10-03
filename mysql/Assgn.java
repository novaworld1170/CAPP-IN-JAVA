import java.sql.*;
import java.util.Scanner;
 
public class Assgn {

  static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
  static final String DB_URL = "jdbc:mysql://localhost:3306/assgn?autoReconnect=true&useSSL=false";
  static final String USER = "root";
  static final String PASS = "";
  static ResultSet rs = null;
  static Connection conn = null;
  Statement stmt = null;
  static PreparedStatement statement = null;
  static String sql;

  @SuppressWarnings("resource")
  
public static void main(String[] args) {
 
  try{
     Class.forName("com.mysql.jdbc.Driver");
     System.out.println("Connecting to database...");
     conn = DriverManager.getConnection(DB_URL,USER,PASS);
 
     sql = "INSERT INTO USERDETAILS(ID, NAME, EMAIL, PHNO,CITY,USER_STATUS) VALUES (?, ?, ?, ?, ?, ?)";
     
     statement = conn.prepareStatement(sql);
     statement.setString(1, null);
     statement.setString(2, "RAHUL");
     statement.setString(3, "rahul123@gmail.com");
     statement.setInt(4, 1313142861);
     statement.setString(5, "Bangalore");
     statement.setBoolean(6, true);
     
     try {
     int rowsInserted = statement.executeUpdate();
     if (rowsInserted > 0) {
       System.out.println("A new user inserted successfully!");
     }
     }catch(SQLIntegrityConstraintViolationException si) {
     System.out.println("Failed to Insert user,Duplicate Found!");
     }
     display();
  
     updateUser();
     deleteUser();
     rs.close();
     statement.close();
     conn.close();
  }catch(SQLException se){
    
     se.printStackTrace();
  }catch(Exception e){
     
     e.printStackTrace();
  }finally{
    
     try{
        if(statement!=null)
           statement.close();
     }catch(SQLException se2){
     }
     try{
        if(conn!=null)
           conn.close();
     }catch(SQLException se){
        se.printStackTrace();
     }
  }
  System.out.println("Thank you!");
}

private static void deleteUser() {
sql = "DELETE FROM USERDETAILS WHERE ID=? OR USER_STATUS = false";

System.out.println("Enter Id to delete:");
Scanner in = new Scanner(System.in);
int id = in.nextInt();
     
     try {
     statement = conn.prepareStatement(sql);
     statement.setInt(1, id);
     
     int rowsDeleted = statement.executeUpdate();
     if (rowsDeleted > 0) {
         System.out.println("A user deleted successfully!");
     }
     } catch (SQLException e) {

e.printStackTrace();
 }
     display();
}


private static void updateUser() {
sql = "UPDATE USERDETAILS SET CITY = ? WHERE ID=?";
System.out.println("Enter Id to update:");
Scanner in1 = new Scanner(System.in);
int id = in1.nextInt();

System.out.println("Enter CityName:");
Scanner in = new Scanner(System.in);
String cityName = in.nextLine();

    try {
     statement = conn.prepareStatement(sql);
     statement.setString(1, cityName);
     statement.setInt(2, id);
     int rowsUpdated = statement.executeUpdate();
     if (rowsUpdated > 0) {
         System.out.println("An existing user was updated successfully!");
     }
     }catch(SQLException se) {
     System.out.println("Failed to Update Data!");
     se.printStackTrace();
     }
     display();

}

private static void display() {
 sql = "SELECT * FROM USERDETAILS";
     try {
rs = statement.executeQuery(sql);


     while(rs.next()){
      
        int id  = rs.getInt("ID");
        String name = rs.getString("NAME");
        String email = rs.getString("EMAIL");
        int phno = rs.getInt("PHNO");
        String city = rs.getString("CITY");
        Boolean user_status = rs.getBoolean("USER_STATUS");
       
        System.out.print("ID: " + id + ", ");
        System.out.print("NAME: " + name + ", ");
        System.out.print("EMAIL: " + email + ", ");
        System.out.print("PHNO: " + phno + ", ");
        System.out.print("CITY: " + city + ", ");
        System.out.println("USER_STATUS: " + user_status);

     }
     } catch (SQLException e) {

e.printStackTrace();
}

}

}
