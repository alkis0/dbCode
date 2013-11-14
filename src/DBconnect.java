import java.sql.*;

public class DBconnect {
	private Connection con;
	private Statement st;
	private ResultSet rs;

	public DBconnect(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost/database_name","user","password");
			st=con.createStatement();
			getData();
		}catch(Exception e){
			System.err.println(e);
		}

	}
	
	public void getData() throws Exception{
		String query="select * from table_name";
		rs=st.executeQuery(query);
		System.out.println("records from db:");
		while(rs.next()){
			String id=rs.getString("id");
			String num=rs.getString("num");
			System.out.println(id+" "+num);

		}
	}


}
