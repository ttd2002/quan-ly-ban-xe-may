package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import connectDB.ConnectDB;

import entity.HopDong;


public class HopDong_Dao {
	public ArrayList<HopDong> getAllHopDong(){
		ArrayList<HopDong> ds = new ArrayList<HopDong>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			
			String sql = "select * from HopDong";
			Statement state = con.createStatement();
			ResultSet rs = state.executeQuery(sql);
			
			while (rs.next()) {
				String mahd = rs.getString(1);
				String tenkh = rs.getString(2);
				String nvl = rs.getString(3);
				String dc = rs.getString(4);
				String loaihd = rs.getString(5);
				String sdt = rs.getString(6);
				String tgbh = rs.getString(7);
				String ngaylap = rs.getString(8);
				
				HopDong n = new HopDong(mahd, tenkh, nvl, dc, loaihd, sdt, tgbh, ngaylap);
				ds.add(n);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ds;
	}
	public boolean ThemHD(HopDong n) throws Exception{
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement state = null;
		try {
			state = con.prepareStatement("insert into HopDong values (?,?,?, ?,?,?,?,?)");
			state.setString(1, n.getMaHopDong());
			state.setString(2, n.getTenKhachHang());
			state.setString(3, n.getNhanVienLap());
			state.setString(4, n.getDiaChiKhachHang());
			state.setString(5, n.getLoaiHopDong());
			state.setString(6, n.getSoDienThoaiKH());
			state.setString(7, n.getThoiGianBaoHanh());
			state.setString(8, n.getNgayLapHD());
			state.executeUpdate();
			return true;
			
		} catch (SQLException e) {
			//e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Mã hợp đồng đã tồn tại");
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
	public String getTenNhanVien(String manv){
		
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement state = null;
		String sql = "select NhanVienLap from HopDong where maHopDong like ?";
		String str = null;
		try {
			
			state = con.prepareStatement(sql);
			state.setString(1, manv);
			
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
	public String getLoaiHD(String manv){
		
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement state = null;
		String sql = "select loaiHopDong from HopDong where maHopDong like ?";
		String str = null;
		try {
			
			state = con.prepareStatement(sql);
			state.setString(1, manv);
			
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
	public String getMaHDTH(String ma){
		
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement state = null;
		String sql = "select loaiHopDong from HopDong where maHopDong like ?";
		String str = null;
		try {
			
			state = con.prepareStatement(sql);
			state.setString(1, ma);
			
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
	public String getNhanVienLap(String ma){
		
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement state = null;
		String sql = "select nhanVienLap from HopDong where maHopDong like ?";
		String str = null;
		try {
			
			state = con.prepareStatement(sql);
			state.setString(1, ma);
			
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
	public String getNgayLapHD(String ma){
		
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement state = null;
		String sql = "select ngaylapHopDong from HopDong where maHopDong like ?";
		String str = null;
		try {
			
			state = con.prepareStatement(sql);
			state.setString(1, ma);
			
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
	public String getThoiGianBH(String ma){
		
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement state = null;
		String sql = "select ThoiGianBaoHanh from HopDong where maHopDong like ?";
		String str = null;
		try {
			
			state = con.prepareStatement(sql);
			state.setString(1, ma);
			
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
	public boolean xoaHD(String ma) throws Exception{
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement state = null;
		try {
			state = con.prepareStatement("delete from HopDong where maHopDong like ?");
			state.setString(1, ma);
			
			state.executeUpdate();
			return true;
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Xóa thất bại vì có dữ liệu bên hợp đồng trả hết hoặc hợp đồng trả góp");
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
	public boolean capNhatHD(HopDong n) throws Exception{
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement state = null;
		try {
			state = con.prepareStatement("UPDATE HopDong SET tenKhachHang =? , diaChiKhachHang=?,loaiHopDong=?,soDienThoaiKH=?,ThoiGianBaoHanh=?,NgayLapHopDong = ? WHERE maHopDong =?");
			state.setString(7, n.getMaHopDong());
			state.setString(1, n.getTenKhachHang());
			state.setString(2, n.getDiaChiKhachHang());
			state.setString(3, n.getLoaiHopDong());
			state.setString(4, n.getSoDienThoaiKH());
			state.setString(5, n.getThoiGianBaoHanh());
			state.setString(6, n.getNgayLapHD());
			state.executeUpdate();
			return true;
		} catch (SQLException e) {
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
