package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import connectDB.ConnectDB;
import entity.LoaiXe;


public class LoaiXe_Dao {
	public ArrayList<LoaiXe> getAllLoaiXe(){
		ArrayList<LoaiXe> ds = new ArrayList<LoaiXe>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			
			String sql = "select * from LoaiXe";
			Statement state = con.createStatement();
			ResultSet rs = state.executeQuery(sql);
			
			while (rs.next()) {
				String maLoai = rs.getString(1);
				String tenLoai = rs.getString(2);
				
				
				LoaiXe n = new LoaiXe(maLoai, tenLoai);
				ds.add(n);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ds;
	}
	public boolean ThemLoai(LoaiXe n) throws Exception{
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement state = null;
		try {
			state = con.prepareStatement("insert into LoaiXe values (?,?)");
			state.setString(1, n.getMaLoai());
			state.setString(2, n.getTenLoai());
			state.executeUpdate();
			return true;
			
		} catch (SQLException e) {
			//e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Mã loại xe đã tồn tại");
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
	public String getTenLoai(String mahsx){
		
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement state = null;
		String sql = "select tenLoai from loaiXe where maLoai like ?";
		String str = null;
		try {
			
			state = con.prepareStatement(sql);
			state.setString(1, mahsx);
			
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
	public boolean xoaLoaiXe(String ma) throws Exception{
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement state = null;
		try {
			state = con.prepareStatement("delete from LoaiXe where maLoai like ?");
			state.setString(1, ma);
			
			state.executeUpdate();
			return true;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Xóa thất bại vì có dữ liệu bên bàng xe máy");
		}
		finally{
			try {
				state.close();
			} catch (SQLException e2) {
				
			}
		}
		return false;
	}
	public boolean capNhatLK(LoaiXe n) throws Exception{
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement state = null;
		try {
			state = con.prepareStatement("UPDATE LoaiXe SET tenLoai=?  WHERE maLoai =?");
			state.setString(2, n.getMaLoai());
			state.setString(1, n.getTenLoai());
			
			
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
