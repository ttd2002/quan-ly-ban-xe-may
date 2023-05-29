package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import connectDB.ConnectDB;
import entity.TaiKhoanKT;

public class TaiKhoanKT_Dao {
	
	public String getMatKhauKT(String tendangnhap){
		
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement state = null;
		String sql = "select matKhau from TaiKhoanKT where tenTaiKhoanKT like ?";
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
		String sql = "select maNhanVienKT from TaiKhoanKT where tenTaiKhoanKT like ?";
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
	public boolean taoTaiKhoanNVKT(TaiKhoanKT tkKT) throws Exception{
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement state = null;
		try {
			state = con.prepareStatement("insert into TaiKhoanKT values (?,?,?)");
			
			state.setString(1, tkKT.getTenTaiKhoanKT());
			state.setString(2, tkKT.getMatKhau());
			state.setString(3, tkKT.getMaKT().getMaNhanVien());
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
	public void xoaTaiKhoanNVKT(String maKT){
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement state = null;
		try {
			state = con.prepareStatement("delete from TaiKhoanKT where maNhanVienKT like ?");
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
