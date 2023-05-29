package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import connectDB.ConnectDB;
import entity.HangSanXuat;

import entity.LoaiXe;
import entity.xeMay;


public class XeMay_Dao {
	public ArrayList<xeMay> getAllxeMay(){
		ArrayList<xeMay> ds = new ArrayList<xeMay>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			
			String sql = "select * from xeMay";
			Statement state = con.createStatement();
			ResultSet rs = state.executeQuery(sql);
			
			while (rs.next()) {
				String ma = rs.getString(1);
				String nuocsx = rs.getString(2);
				double gia = rs.getDouble(3);
				String mau = rs.getString(4);
				String ten = rs.getString(5);
				HangSanXuat hsx = new HangSanXuat(rs.getString(6));
				String soPK = rs.getString(7);
				LoaiXe loai = new LoaiXe(rs.getString(8));
				
				
				xeMay n = new xeMay(ma, ten, nuocsx, hsx, gia, soPK, mau, loai);
				ds.add(n);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ds;
	}
	public ArrayList<xeMay> getAllxeMayNgoaiTruMa(String maxe){
		ArrayList<xeMay> ds = new ArrayList<xeMay>();
		
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		
		String sql = "select * from XeMay where maXe not in (?)";
		PreparedStatement state = null;
		try {
			state = con.prepareStatement(sql);
			state.setString(1, maxe);
			ResultSet rs = state.executeQuery();
			
			while (rs.next()) {
				String ma = rs.getString(1);
				String nuocsx = rs.getString(2);
				double gia = rs.getDouble(3);
				String mau = rs.getString(4);
				String ten = rs.getString(5);
				HangSanXuat hsx = new HangSanXuat(rs.getString(6));
				String soPK = rs.getString(7);
				LoaiXe loai = new LoaiXe(rs.getString(8));
				
				
				xeMay n = new xeMay(ma, ten, nuocsx, hsx, gia, soPK, mau, loai);
				ds.add(n);
				
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ds;
	}
	public boolean ThemXe(xeMay n) throws Exception{
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement state = null;
		try {
			state = con.prepareStatement("insert into XeMay values (?,?,?, ?, ?,?,?,?)");
			state.setString(1, n.getMaXe());
			state.setString(2, n.getNuocSX());
			state.setDouble(3, n.getDonGia());
			state.setString(4, n.getMauXe());
			state.setString(5, n.getTenXe());		
			state.setString(6, n.getHsx().getMaHSX());		
			state.setString(7, n.getSoPhanKhoi());		
			state.setString(8, n.getLoai().getMaLoai());
			state.executeUpdate();
			return true;
			
		} catch (SQLException e) {
			//e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Mã xe máy đã tồn tại");
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
	public double getTienXe(String maxe){
		
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement state = null;
		String sql = "select dongia from XeMay where maXe like ?";
		double tong =0;
		try {
			
			state = con.prepareStatement(sql);
			state.setString(1, maxe);
			
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
	public String getTenXe(String maxe){
		
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement state = null;
		String sql = "select tenXe from XeMay where maXe like ?";
		String str = null;
		try {
			
			state = con.prepareStatement(sql);
			state.setString(1, maxe);
			
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
	public void xoaXe(String ma){
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement state = null;
		try {
			state = con.prepareStatement("delete from XeMay where maXe like ?");
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
	public void themTuXMDP(String ma){
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement state = null;
		try {
			state = con.prepareStatement("INSERT INTO XeMay SELECT * FROM XeMayDuPhong WHERE maXe like ?;");
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
	public boolean capNhatXM(xeMay n) throws Exception{
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement state = null;
		try {
			state = con.prepareStatement("UPDATE XeMay SET nuocSX=?,dongia=?,mauXe=?,tenXe=?,hangSX=?,soPhanKhoi=?,loaiXe=?   WHERE maXe =?");
			state.setString(8, n.getMaXe());
			state.setString(1, n.getNuocSX());
			state.setDouble(2, n.getDonGia());
			state.setString(3, n.getMauXe());
			state.setString(4, n.getTenXe());
			state.setString(5, n.getHsx().getMaHSX());
			state.setString(6, n.getSoPhanKhoi());
			state.setString(7, n.getLoai().getMaLoai());
			state.executeUpdate();
			return true;
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
		return false;
	}
}
