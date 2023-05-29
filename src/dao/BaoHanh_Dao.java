package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import connectDB.ConnectDB;
import entity.BaoHanh;
import entity.LinhKien;
import entity.dsXeMay;




public class BaoHanh_Dao {
	public ArrayList<BaoHanh> getAllBaoHanhTheoMa(String maxe){
		ArrayList<BaoHanh> ds = new ArrayList<BaoHanh>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		
		String sql = "select * from BaoHanh where maXe like ?";
		PreparedStatement state = null;
		try {
			state = con.prepareStatement(sql);
			state.setString(1, maxe);
			ResultSet rs = state.executeQuery();
			
			while (rs.next()) {
				String maxemay = rs.getString(1);
				String tenxe= rs.getString(2);
				String hangsx= rs.getString(3);
				String loai= rs.getString(4);
							
				String mahd= rs.getString(5);
				String loaiHD = rs.getString(6);
				String nhanvienlap = rs.getString(7);
				String thoiGianBH= rs.getString(8);
				String ngayLapHD= rs.getString(9);
				
				String nvpt = rs.getString(10);
				String lidoBH = rs.getString(11);
				String loiDo = rs.getString(12);
				LinhKien LK = new LinhKien(rs.getString(13));
				String ngayBH = rs.getString(14);
				String maPhieu = rs.getString(15);
				BaoHanh n = new BaoHanh(maPhieu,maxemay, tenxe, hangsx, loai, mahd, loaiHD, nhanvienlap, thoiGianBH, ngayLapHD, nvpt, lidoBH, loiDo, LK, ngayBH);
				ds.add(n);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ds;
	}
/*	public ArrayList<BaoHanh> getAllBaoHanh(){
		ArrayList<BaoHanh> ds = new ArrayList<BaoHanh>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			
			String sql = "select * from BaoHanh";
			Statement state = con.createStatement();
			ResultSet rs = state.executeQuery(sql);
			
			while (rs.next()) {
				String maxemay = rs.getString(1);
				String tenxe= rs.getString(2);
				String hangsx= rs.getString(3);
				String loai= rs.getString(4);
							
				String mahd= rs.getString(5);
				String loaiHD = rs.getString(6);
				String nhanvienlap = rs.getString(7);
				String thoiGianBH= rs.getString(8);
				String ngayLapHD= rs.getString(9);
				
				String nvpt = rs.getString(10);
				String lidoBH = rs.getString(11);
				String loiDo = rs.getString(12);
				LinhKien LK = new LinhKien(rs.getString(13));
				String ngayBH = rs.getString(14);
				BaoHanh n = new BaoHanh(maxemay, tenxe, hangsx, loai, mahd, loaiHD, nhanvienlap, thoiGianBH, ngayLapHD, nvpt, lidoBH, loiDo, LK, ngayBH);
				ds.add(n);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ds;
	}*/
	public boolean ThemBH(BaoHanh n) throws Exception{
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement state = null;
		try {
			state = con.prepareStatement("insert into BaoHanh values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			state.setString(1, n.getMaxe());
			state.setString(2, n.getTenxe());
			state.setString(3, n.getHangsx());
			state.setString(4, n.getLoai());
			
			state.setString(5, n.getMahd());
			state.setString(6, n.getLoaiHD());
			state.setString(7, n.getNhanvienlap());
			state.setString(8, n.getThoiGianBH());
			state.setString(9, n.getNgayLapHD());
			
			
			state.setString(10, n.getNvpt());
			state.setString(11, n.getLidoBH());
			state.setString(12, n.getLoiDo());
			state.setString(13, n.getLK().getMaLinhkien());
			state.setString(14, n.getNgayBH());
			state.setString(15, n.getMaphieu());
			
			state.executeUpdate();
			return true;
			
		} catch (SQLException e) {
			//e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Mã Bảo hành đã tồn tại");
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
	/*public ArrayList<dsXeMay> getAllxeMayNgoaitheoMa(String maxe){
		ArrayList<dsXeMay> ds = new ArrayList<dsXeMay>();
		
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		
		String sql = "select * from DanhSachXeMay where maXe like ?";
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
				
				
				dsXeMay n = new dsXeMay(ma, ten, nuocsx, hsx, gia, soPK, mau, loai);
				ds.add(n);
				
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ds;
	}*/
	public ArrayList<dsXeMay> getAllxeMay(){
		ArrayList<dsXeMay> ds = new ArrayList<dsXeMay>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			
			String sql = "select * from DanhSachXeMay";
			Statement state = con.createStatement();
			ResultSet rs = state.executeQuery(sql);
			
			while (rs.next()) {
				String ma = rs.getString(1);
				String nuocsx = rs.getString(2);
				double gia = rs.getDouble(3);
				String mau = rs.getString(4);
				String ten = rs.getString(5);
				String hsx = rs.getString(6);
				String soPK = rs.getString(7);
				String loai = rs.getString(8);
				
				
				dsXeMay n = new dsXeMay(ma, ten, nuocsx, hsx, gia, soPK, mau, loai);
				ds.add(n);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ds;
	}
	public String getTenXe(String maxe){
		
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement state = null;
		String sql = "select tenXe from DanhSachXeMay where maXe like ?";
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
	public String getMaHSX(String maxe){
		
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement state = null;
		String sql = "select hangSX from DanhSachXeMay where maXe like ?";
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
	public String getMaLoai(String maxe){
		
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement state = null;
		String sql = "select loaiXe from DanhSachXeMay where maXe like ?";
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
	public void xoaBH(String ma){
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement state = null;
		try {
			state = con.prepareStatement("delete from BaoHanh where maPhieu like ? ");
			state.setString(1, ma);
			
			state.executeUpdate();
			
		} catch (SQLException e) {
			//e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Không thể xóa vì ràng buộc dữ liệu");
		}
		finally{
			try {
				state.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
	}
	public boolean capNhatBH(BaoHanh n) throws Exception{
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement state = null;
		try {
			state = con.prepareStatement("UPDATE BaoHanh SET lidoBaoHanh =? , loiDo=?,tenlinhKien=?,ngayBaoHanh=? WHERE maPhieu =?");
			state.setString(5, n.getMaphieu());
			state.setString(1, n.getLidoBH());
			state.setString(2, n.getLoiDo());
			state.setString(3, n.getLK().getMaLinhkien());
			state.setString(4, n.getNgayBH());
			
			
			state.executeUpdate();
			return true;
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
		return false;
	}
	public int getSLBH(){
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		Statement state = null;
		
		int sl = 0 ;
		try {
			String sql = "select COUNT(*) from BaoHanh";
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
}
