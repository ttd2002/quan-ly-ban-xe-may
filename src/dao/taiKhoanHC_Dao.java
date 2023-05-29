package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import connectDB.ConnectDB;
import entity.TaiKhoanHC;


public class taiKhoanHC_Dao {
	public String getMatKhauHC(String tendangnhap){
		
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement state = null;
		String sql = "select matKhau from TaiKhoanHC where tenTaiKhoanHC like ?";
		String mk = null;
		try {
			
			state = con.prepareStatement(sql);
			state.setString(1, tendangnhap);
			
			ResultSet rs = state.executeQuery();
			while (rs.next() ){
				mk = rs.getString(1);
				
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
		return mk;
	}
	public String getMaNV(String tendangnhap){
			
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement state = null;
		String sql = "select maNhanVienHC from TaiKhoanHC where tenTaiKhoanHC like ?";
		String ma = null;
		try {
				
			state = con.prepareStatement(sql);
			state.setString(1, tendangnhap);
			
			ResultSet rs = state.executeQuery();
			while (rs.next() ){
				ma = rs.getString(1);
					
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
		return ma;
	}
	public boolean taoTaiKhoanNVHC(TaiKhoanHC tkhc) throws Exception{
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement state = null;
		try {
			state = con.prepareStatement("insert into TaiKhoanHC values (?,?,?)");
			state.setString(1, tkhc.getTenTaiKhoanHC());
			state.setString(2, tkhc.getMatKhau());
			state.setString(3, tkhc.getMaHC().getMaNhanVien());
			state.executeUpdate();
			return true;
			
		} catch (SQLException e) {
			//e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Tài khoản đã tồn tại");
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
	
	public void xoaTaiKhoanNVHC(String maKT){
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			PreparedStatement state = null;
			try {
				state = con.prepareStatement("delete from TaiKhoanHC where maNhanVienHC like ?");
				state.setString(1, maKT);
				state.executeUpdate();
			}
			catch (SQLException e){
				e.printStackTrace();
			}
			finally{
				try {
					state.close();
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
			}
			
			
			
		}

}




