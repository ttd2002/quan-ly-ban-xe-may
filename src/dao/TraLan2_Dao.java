package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connectDB.ConnectDB;
import entity.TraLan2;


public class TraLan2_Dao {
	public boolean ThemTraLan2(TraLan2 n) throws Exception{
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement state = null;
		try {
			state = con.prepareStatement("insert into Tralan2 values (?,?,?)");
			state.setString(1, n.getMaHopDong());
			state.setString(2, n.getNgayTralan2());
			state.setDouble(3, n.getSoTienTraLan2());
			
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
		String sql = "select soTienTra from Tralan2 where maHopDong like ?";
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
		String sql = "select ngayTra from Tralan2 where maHopDong like ?";
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
