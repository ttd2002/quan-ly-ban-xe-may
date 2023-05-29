package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import connectDB.ConnectDB;
import entity.NhanVienHanhChanh;

public class NhanVienHanhChanh_Dao {
	public ArrayList<NhanVienHanhChanh> getAllNhanVienHanhChanh(){
		ArrayList<NhanVienHanhChanh> dsnvhc = new ArrayList<NhanVienHanhChanh>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			
			String sql = "select * from NhanVienHanhChanh";
			Statement state = con.createStatement();
			ResultSet rs = state.executeQuery(sql);
			
			while (rs.next()) {
				String manv = rs.getString(1);
				String tennv = rs.getString(2);
				String pb = rs.getString(3);
				String chucvu = rs.getString(4);
				String gioitinh = rs.getString(5);
				String ngaysinh = rs.getString(6);
				String hocvan = rs.getString(7);
				String sdt = rs.getString(8);
				NhanVienHanhChanh nvhc = new NhanVienHanhChanh(manv, tennv, pb, chucvu, gioitinh, ngaysinh, hocvan, sdt);
				dsnvhc.add(nvhc);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsnvhc;
	}
	public String getTenNhanVienHC(String maNVHC){
		
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement state = null;
		String sql = "select tenNhanVien from NhanVienHanhChanh where maNhanVien like ?";
		String ten = null;
		try {
			
			state = con.prepareStatement(sql);
			state.setString(1, maNVHC);
			
			ResultSet rs = state.executeQuery();
			while (rs.next() ){
				ten = rs.getString(1);
				
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
		return ten;
	}
	public boolean ThemNVHC(NhanVienHanhChanh n) throws Exception{
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement state = null;
		try {
			state = con.prepareStatement("insert into NhanVienHanhChanh values (?,?,?,?,?,?,?,?)");
			state.setString(1, n.getMaNhanVien());
			state.setString(2, n.getTenNhanVien());
			state.setString(3, n.getPhongBan());
			state.setString(4, n.getChucVu());
			state.setString(5, n.getGioiTinh());		
			state.setString(6, n.getNgaySinh());		
			state.setString(7, n.getHocVan());		
			state.setString(8, n.getSoDienThoai());
			state.executeUpdate();
			return true;
			
		} catch (SQLException e) {
			//e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Mã nhân viên hành chánh đã tồn tại");
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
	public void xoaNVHC(String ma){
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement state = null;
		try {
			state = con.prepareStatement("delete from NhanVienHanhChanh where maNhanVien like ?");
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
	public boolean capNhatNVHC(NhanVienHanhChanh n) throws Exception{
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement state = null;
		try {
			state = con.prepareStatement("UPDATE NhanVienHanhChanh SET "
					+ "tenNhanVien=?,phongBan=?,chucvu=?,gioiTinh=?,ngaySinh=?,hocVan=?,soDienThoai=? WHERE maNhanVien =?");
			state.setString(8, n.getMaNhanVien());
			state.setString(1, n.getTenNhanVien());
			state.setString(2, n.getPhongBan());
			state.setString(3, n.getChucVu());
			state.setString(4, n.getGioiTinh());
			state.setString(5, n.getNgaySinh());
			state.setString(6, n.getHocVan());
			state.setString(7, n.getSoDienThoai());
			
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
