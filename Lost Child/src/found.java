import java.sql.*;

import javax.swing.JFrame;


public class found extends JFrame{
	Connection con;
	Statement stmt;
	public found(String str1, String str2,String str3) {
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		    this.con = DriverManager.getConnection("jdbc:odbc:abc", "", "");
		    this.stmt = this.con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from found where fname='"+str1+"' or lname='"+str2+"' or aname='"+str3+"'");
	        while(rs.next()){
			int index=rs.getInt("cid");
	        Show1 s= new Show1();
			s.c2.setSelectedIndex(index);
			s.show(true);
	        }
		} catch (Exception e) {
			e.printStackTrace();
		}
        
        }
	}


