package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



import connectDB.ConnectDB;
import entity.TraLan1;

public class TraLan1_Dao {
	public boolean ThemTraLan1(TraLan1 n) throws Exception{
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement state = null;
		try {
			state = con.prepareStatement("insert into Tralan1 values (?,?,?)");
			state.setString(1, n.getMaHopDong());
			state.setString(2, n.getNgayTralan1());
			state.setDouble(3, n.getSoTienTraLan1());
			
			state.executeUpdate();
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
			//JOptionPane.showMessageDialog(null, "Mã xe máy đã tồn tại");
		}
		finally{
			try {
				state.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return false;
	}
	public double getTien(String maHD){
		
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement state = null;
		String sql = "select soTienTra from Tralan1 where maHopDong like ?";
		double tong =0;
		try {
			
			state = con.prepareStatement(sql);
			state.setString(1, maHD);
			
			ResultSet rs = state.executeQuery();
			while (rs.next() ){
				tong = rs.getDouble(1);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			try {
				state.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return tong;
	}
	public String getNgay(String maHD){
		
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement state = null;
		String sql = "select ngayTra from Tralan1 where maHopDong like ?";
		String str = "";
		try {
			
			state = con.prepareStatement(sql);
			state.setString(1, maHD);
			
			ResultSet rs = state.executeQuery();
			while (rs.next() ){
				str = rs.getString(1);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			try {
				state.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return str;
	}
}
