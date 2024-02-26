package workOrder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class WorkOrderDAO {

	public List selectTable() {
		List list = new ArrayList();
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@112.148.46.134:51521:xe";		
		String user = "scott4_4";
		String password = "tiger";
		
		try {
			Class.forName(driver);
			
			Connection con = DriverManager.getConnection(url, user, password);
			
			String query = "";
			query += " SELECT"
					+ " *";
			query += " FROM"
					+ " workTable";
			
			PreparedStatement ps = con.prepareStatement(query);
			
			ResultSet rs = ps.executeQuery();
			
			while( rs.next() ) {
				
				String title = rs.getString(1);
				String detail = rs.getString(2);
				System.out.println(title);
				
				WorkOrderDTO dto = new WorkOrderDTO();
				dto.setTitle(title);
				dto.setDetail(detail);
				
				list.add(dto);
			}
			
			rs.close();
			ps.close();
			con.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public void insertInfo(WorkOrderDTO dto) {
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@112.148.46.134:51521:xe";		
		String user = "scott4_4";
		String password = "tiger";
		
		try {
			Class.forName(driver);
			
			Connection con = DriverManager.getConnection(url, user, password);
			
			String title = dto.getTitle();
			String detail = dto.getDetail();
			
			String query = "";
			query += " INSERT INTO"
					+ " workTable(w_title, w_detail)";
			query += " VALUES"
					+ " ('"
					+ title
					+ "','"
					+ detail
					+ "')";
			
			PreparedStatement ps = con.prepareStatement(query);
			System.out.println(query);
			ps.executeQuery();
//			rs.close();
//			ps.close();
//			con.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
