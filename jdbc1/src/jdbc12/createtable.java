package jdbc12;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class createtable {
	private static final String Driver = "com.mysql.cj.jdbc.Driver";
	private static final String Username = "root";
	private static final String Password = "root";

	private static Connection conn;
	private static PreparedStatement pmst;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			Class.forName(Driver);
			System.out.println("enter database name");
			String Url = "jdbc:mysql://localhost:3306/"+sc.next();
			conn = DriverManager.getConnection(Url, Username, Password);
			System.out.println("enter table name");
			String sql = "create table "+ sc.next() + "(id int,name varchar(90),email varchar(90))";
			pmst = conn.prepareStatement(sql);
			int i = pmst.executeUpdate();
			if(i==0) {
				System.out.println("created");
			}
			else {
				System.out.println("error");
			}
			sc.close();
			conn.close();
			pmst.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		}
}
