package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import connectDB.ConnectDB;
import entity.NhanVienKyThuat;

public class NhanVienKyThuat_Dao {
	public ArrayList<NhanVienKyThuat> getAllNhanVienkyThuat(){
		ArrayList<NhanVienKyThuat> dsnvkt = new ArrayList<NhanVienKyThuat>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			
			String sql = "select * from NhanVienKyThuat";
			Statement state = con.createStatement();
			ResultSet rs = state.executeQuery(sql);
			
			while (rs.next()) {
				String manv = rs.getString(1);
				String tennv = rs.getString(2);
				String bactho = rs.getString(3);
				String chucvu = rs.getString(4);
				String gioitinh = rs.getString(5);
				String ngaysinh = rs.getString(6);
				String sonamkinhnghiem = rs.getString(7);
				String sdt = rs.getString(8);
				NhanVienKyThuat nvkt = new NhanVienKyThuat(manv, tennv, bactho, chucvu, gioitinh, ngaysinh, sonamkinhnghiem, sdt);
				dsnvkt.add(nvkt);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsnvkt;
	}
	public String getTenNhanVienKT(String maNVKT){
		
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement state = null;
		String sql = "select tenNhanVien from NhanVienKyThuat where maNhanVien like ?";
		String ten = null;
		try {
			
			state = con.prepareStatement(sql);
			state.setString(1, maNVKT);
			
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
	public boolean ThemNVKT(NhanVienKyThuat n) throws Exception{
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement state = null;
		try {
			state = con.prepareStatement("insert into NhanVienKyThuat values (?,?,?,?,?,?,?,?)");
			state.setString(1, n.getMaNhanVien());
			state.setString(2, n.getTenNhanVien());
			state.setString(3, n.getBacTho());
			state.setString(4, n.getChucVu());
			state.setString(5, n.getGioiTinh());		
			state.setString(6, n.getNgaySinh());		
			state.setString(7, n.getSoNamKinhNghiem());		
			state.setString(8, n.getSoDienThoai());
			state.executeUpdate();
			return true;
			
		} catch (SQLException e) {
			//e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Mã nhân viên kỹ thuật đã tồn tại");
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
	public void xoaNVKT(String ma){
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement state = null;
		try {
			state = con.prepareStatement("delete from NhanVienKyThuat where maNhanVien like ?");
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
	public boolean capNhatNVHC(NhanVienKyThuat n) throws Exception{
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement state = null;
		try {
			state = con.prepareStatement("UPDATE NhanVienKyThuat set tenNhanVien=?,bacTho=?,chucvu=?,gioiTinh=?,ngaySinh=?,SoNamKN=?,soDienThoai=? WHERE maNhanVien =?");
			state.setString(8, n.getMaNhanVien());
			state.setString(1, n.getTenNhanVien());
			state.setString(2, n.getBacTho());
			state.setString(3, n.getChucVu());
			state.setString(4, n.getGioiTinh());
			state.setString(5, n.getNgaySinh());
			state.setString(6, n.getSoNamKinhNghiem());
			state.setString(7, n.getSoDienThoai());
			
			state.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
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
