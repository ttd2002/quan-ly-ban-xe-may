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



public class HangSanXuat_Dao {
	public ArrayList<HangSanXuat> getAllHangSanXuat(){
		ArrayList<HangSanXuat> ds = new ArrayList<HangSanXuat>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			
			String sql = "select * from HangSanXuat";
			Statement state = con.createStatement();
			ResultSet rs = state.executeQuery(sql);
			
			while (rs.next()) {
				String mahsx = rs.getString(1);
				String tenhsx = rs.getString(2);
				int slTon = rs.getInt(3);
				
				HangSanXuat n = new HangSanXuat(mahsx, tenhsx, slTon);
				ds.add(n);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ds;
	}
	public boolean ThemHSX(HangSanXuat n) throws Exception{
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement state = null;
		try {
			state = con.prepareStatement("insert into HangSanXuat values (?,?,?)");
			state.setString(1, n.getMaHSX());
			state.setString(2, n.getTenHSX());
			state.setInt(3, n.getSoLuongTon());
			state.executeUpdate();
			return true;
			
		} catch (SQLException e) {
			//e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Mã hãng sản xuất đã tồn tại");
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
	public String getTenHSX(String mahsx){
		
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement state = null;
		String sql = "select tenHSX from HangSanXuat where maHSX like ?";
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
	public int getSoLuongTon(String mahsx){
		
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement state = null;
		String sql = "select soLuongTon from HangSanXuat where maHSX like ?";
		int sl = 0;
		try {
			
			state = con.prepareStatement(sql);
			state.setString(1, mahsx);
			
			ResultSet rs = state.executeQuery();
			while (rs.next() ){
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
	public boolean xoaHSX(String ma) throws Exception{
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement state = null;
		try {
			state = con.prepareStatement("delete from HangSanXuat where maHSX like ?");
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
				JOptionPane.showMessageDialog(null, "Không thể xóa vì ràng buộc dữ liệu");
			}
		}
		return false;
	}
	public boolean capNhatNVHC(HangSanXuat n) throws Exception{
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement state = null;
		try {
			state = con.prepareStatement("UPDATE HangSanXuat SET tenHSX =? , soLuongTon=? WHERE maHSX =?");
			state.setString(3, n.getMaHSX());
			state.setString(1, n.getTenHSX());
			state.setInt(2, n.getSoLuongTon());
			
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
	public void capNhatSL(String mahsx) throws Exception{
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement state = null;
		try {
			state = con.prepareStatement("UPDATE HangSanXuat SET soLuongTon=soLuongTon-1 WHERE maHSX =?");
			state.setString(1, mahsx);
			
			
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
	public void capNhatSLLen(String mahsx) throws Exception{
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement state = null;
		try {
			state = con.prepareStatement("UPDATE HangSanXuat SET soLuongTon=soLuongTon+1 WHERE maHSX =?");
			state.setString(1, mahsx);
			
			
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
}
