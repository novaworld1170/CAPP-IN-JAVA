import java.util.*;
//STEP 1. Import required packages
import java.sql.*;


abstract class SqlDemo
{
	
	Connection conn = null;
	 Statement stmt = null;
	String sql;
	ResultSet resultSet;
	int result;
		void connect(String JDBC_DRIVER , String DB_URL,String USER,String PASS) {}
	void createTable(){}
	
	void insertData(String name,String email,int phone , String city,int user_status) 
	{
	  
	}
	void updateData(int id,int status) {}
	void deleteData(int id) {}
	
}




class Brew extends  SqlDemo
{
	
	
	Brew()
	{
		
		
	}
	
	
	@Override
	 void connect(String JDBC_DRIVER , String DB_URL,String USER,String PASS) {
		try {
			   Class.forName(JDBC_DRIVER);

			  
			    System.out.println("Connecting to database...");
			    conn = DriverManager.getConnection(DB_URL,USER,PASS);
			    stmt = conn.createStatement();
			
			
			
		}catch(Exception e) {e.printStackTrace();}
		
		
		System.out.println("successfully connected to database");
		
	
	
	}
	
	
	@Override
	void createTable()
	{
		
		ResultSet rs1;
		try
		{
		   DatabaseMetaData meta = (DatabaseMetaData) conn.getMetaData();
		     rs1 = meta.getTables(null, null, null, new String[] {
		         "TABLE"
		      });
		     
		     
		     
		     
		     
		     
		     while (rs1.next()) {
		         String tblName = rs1.getString("TABLE_NAME");
		         //System.out.println(tblName);
		         if(tblName.compareTo("userdetails")==0)
		         {
		        	String  sql="drop table userdetails";
		        	 stmt.executeUpdate(sql);
		        	 System.out.println("\"user details\" table found and deleted ");
		         }
		         
		      }
		     
		     String  sql = "create table userdetails(id int not null auto_increment,name varchar(20),email varchar(30) unique,phone int(10) unique ,city varchar(20),user_status int,primary key(id))";
			    //sql="show tables";
			    result = stmt.executeUpdate(sql);
			    System.out.println("new userdetails table created");
		     
		     
		     
		}catch(SQLException e) {
			
			
			//e.printStackTrace();
		System.out.println("========= table creation failed =========");	
		
		}
		
		
		
		  
		
		
		
		
	}
	
	
	@Override
	void insertData(String name,String email,int phone , String city,int user_status) 
	{
	    sql="insert into userdetails(name,email,phone,city,user_status) values('"+name+"','"+email+"',"+phone+",'"+city+"',"+user_status+") ";
	    
	    try {
	    
	    result=stmt.executeUpdate(sql);

		System.out.println("inserted successfully ");
		
	    }catch(SQLException e) {
	    	//e.printStackTrace();
	    System.out.println("data insertion failed");
	    
	    }
	}
	
	
	
	@Override
	void updateData(int id,int status) 
	{
		try {
			sql="update userdetails set user_status="+status+" where id= "+id;
		result=stmt.executeUpdate(sql);
		System.out.println("updated successfully");
		}catch(SQLException e) {
			
			//e.printStackTrace();
			System.out.println("======= data updation failed ======== ");
		
		}
	}
	
	
	
	@Override
	void deleteData(int id)
	{
		sql="select * from userdetails where id="+id;
		try
		{
		stmt=conn.createStatement();
		resultSet=stmt.executeQuery(sql);
		resultSet.next();
		if(resultSet.getInt("user_status")==0) {
			sql="delete from userdetails where id="+id;
			result=stmt.executeUpdate(sql);
			System.out.println("deleted successfully");
		}
		else
			System.out.println("unable to delete as it is active");
		//System.out.println(resultSet.getInt("user_status"));
		
		}catch(SQLException e) {
			
			//e.printStackTrace();
			
		
		System.out.println("...........deletion failed .........");
		
		}
		
	}
	
	
	
	
}




public class Assgn  {
	 
	 
	public static void main(String[] args) {
		
		 String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
		 String DB_URL = "jdbc:mysql://localhost:3306/rahul?autoReconnect=true&useSSL=false";

		 String USER = "root";
		 String PASS = "";
		 String name,email,city;
		 int status,phone;
		 int choice,id;
		Brew b=new Brew();
		Scanner in = new Scanner(System.in);
		b.connect(JDBC_DRIVER, DB_URL, USER, PASS);
		b.createTable();
		
		do
		{
			
			System.out.print("\n\n\n1:insert\n2:update\n3:delete\n4:exit\nenter your choice : ");
			choice=Integer.parseInt(in.nextLine());
			System.out.print("\n\n\n");
			switch(choice)
			{
			case 1:
				System.out.println("enter name");
				name=in.nextLine();
				
				System.out.println("enter email");
				email=in.nextLine();
		
				System.out.println("enter city");
				city=in.nextLine();
		
				System.out.println("enter phone (9 digits )");
				phone=Integer.parseInt(in.nextLine());
		
				System.out.println("enter status ( 0/1 )");
				status=Integer.parseInt(in.nextLine());
				
				b.insertData(name, email, phone, city, status);
			
			break;
			
			
			
			case 2:
				System.out.println("enter the id to update");
				id=Integer.parseInt(in.nextLine());
				System.out.println("enter the status (0/1)");
				status=Integer.parseInt(in.nextLine());
				b.updateData(id,status);break;
			case 3:
				System.out.println("enter the id to be deleted ");
				id=Integer.parseInt(in.nextLine());
				b.deleteData(id);break;
			}	
		}while(choice!=4);
		
		
		


		}

	}