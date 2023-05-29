package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import java.sql.Statement;

import javax.swing.JOptionPane;

import connectDB.ConnectDB;
import entity.xeMay;


public class XeMayDuPhong_Dao {
	public void ThemTuXM(String ma){
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement state = null;
		try {
			state = con.prepareStatement("INSERT INTO XeMayDuPhong SELECT * FROM XeMay WHERE maXe like ?");
			state.setString(1, ma);
			
			state.executeUpdate();
			
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
	}
	public void ThemDSXe(String ma){
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement state = null;
		try {
			state = con.prepareStatement("INSERT INTO DanhSachXeMay SELECT * FROM XeMay WHERE maXe like ?");
			state.setString(1, ma);
			
			state.executeUpdate();
			
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
	}
	public void xoaXeDP(String ma){
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement state = null;
		try {
			state = con.prepareStatement("delete from XeMayDuPhong where maXe like ?");
			state.setString(1, ma);
			
			state.executeUpdate();
			
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
	}
	public void xoaXeDSXe(String ma){
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement state = null;
		try {
			state = con.prepareStatement("delete from DanhSachXeMay where maXe like ?");
			state.setString(1, ma);
			
			state.executeUpdate();
			
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
	}
	public String getMaTuDS(String ma){	
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement state = null;
		String sql = "select maXe from DanhSachXeMay where maXe like ?";
		String maxe = null;
		try {
			
			state = con.prepareStatement(sql);
			state.setString(1, ma);
			
			ResultSet rs = state.executeQuery();
			while (rs.next() ){
				maxe = rs.getString(1);
				
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
		return maxe;
					
	}
	public int getSLXe(){
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		Statement state = null;
		
		int sl = 0 ;
		try {
			String sql = "select COUNT(*) from DanhSachXeMay";
			state = con.createStatement();
			ResultSet rs = state.executeQuery(sql);
			while (rs.next()) {
				sl = rs.getInt(1);
				
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
		return sl;
	}
	public void capNhatdsXM(xeMay n) throws Exception{
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement state = null;
		try {
			state = con.prepareStatement("UPDATE DanhSachXeMay SET nuocSX=?,dongia=?,mauXe=?,tenXe=?,hangSX=?,soPhanKhoi=?,loaiXe=?   WHERE maXe =?");
			state.setString(8, n.getMaXe());
			state.setString(1, n.getNuocSX());
			state.setDouble(2, n.getDonGia());
			state.setString(3, n.getMauXe());
			state.setString(4, n.getTenXe());
			state.setString(5, n.getHsx().getMaHSX());
			state.setString(6, n.getSoPhanKhoi());
			state.setString(7, n.getLoai().getMaLoai());
			state.executeUpdate();
		} catch (SQLException e) {
			//e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Dữ liệu không hợp lệ");
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
