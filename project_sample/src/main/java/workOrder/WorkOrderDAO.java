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
					+ " w_seq, w_title, w_detail";
			query += " FROM"
					+ " workTable";
			
			PreparedStatement ps = con.prepareStatement(query);
			
			ResultSet rs = ps.executeQuery();
			
			while( rs.next() ) {
				
				int seq = rs.getInt(1);
				String title = rs.getString(2);
				String detail = rs.getString(3);
				
				WorkOrderDTO dto = new WorkOrderDTO();
				dto.setSeq(seq);
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
					+ " workTable(w_seq, w_title, w_detail)";
			query += " VALUES"
					+ " ("
					+ " w_sequence.NEXTVAL, '"
					+ title
					+ "','"
					+ detail
					+ "')";
			
			PreparedStatement ps = con.prepareStatement(query);
			ps.executeQuery();

			ps.close();
			con.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deleteColumn(WorkOrderDTO dto) {
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@112.148.46.134:51521:xe";		
		String user = "scott4_4";
		String password = "tiger";
		
		try {
			
			Class.forName(driver);
			
			Connection con = DriverManager.getConnection(url, user, password);
			
			int seq = dto.getSeq();
			
			String query = "";
			query += " DELETE FROM"
					+ " workTable";
			query += " WHERE"
					+ " w_seq =";
			query += seq;
			
			PreparedStatement ps = con.prepareStatement(query);
			ps.executeQuery();

			ps.close();
			con.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void retouchColumn(WorkOrderDTO dto) {
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@112.148.46.134:51521:xe";		
		String user = "scott4_4";
		String password = "tiger";
		
		try {
			
			Class.forName(driver);
			
			Connection con = DriverManager.getConnection(url, user, password);
			
			int seq = dto.getSeq();
			String title = dto.getTitle();
			String detail = dto.getDetail();
			
			String query = "";
			query += " UPDATE"
					+ " workTable";
			query += " SET"
					+ " w_title = '"
					+ title
					+ "',"
					+ " w_detail = '"
					+ detail
					+ "'";
			query += " WHERE"
					+ " w_seq = "
					+ seq;
			
			PreparedStatement ps = con.prepareStatement(query);
			ps.executeQuery();

			ps.close();
			con.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
