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
import entity.HopDongTraHet;


public class HopDongTraHet_Dao {
	
	public ArrayList<HopDongTraHet> getAllHopDongTraHet(){
		ArrayList<HopDongTraHet> ds = new ArrayList<HopDongTraHet>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		
		try {	
			String sql = "select * from HopDongMotLan";
			Statement state = con.createStatement();
			ResultSet rs = state.executeQuery(sql);
			
			while (rs.next()) {
				HopDong mahd = new HopDong(rs.getString(1));
				String maxe = rs.getString(2);
				String nvl = rs.getString(3);
				double gia = rs.getDouble(4);
				String tenxe = rs.getString(5);
				
				HopDongTraHet n = new HopDongTraHet(mahd, maxe, nvl, gia, tenxe);
				ds.add(n);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ds;
	}
	public ArrayList<HopDongTraHet> getAllHopDongTraHetTheoMa(String mahopdong){
		ArrayList<HopDongTraHet> ds = new ArrayList<HopDongTraHet>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		
		String sql = "select * from HopDongMotLan where maHopDong like ?";
		PreparedStatement state = null;
		try {
			state = con.prepareStatement(sql);
			state.setString(1, mahopdong);
			ResultSet rs = state.executeQuery();
			
			while (rs.next()) {
				HopDong mahd = new HopDong(rs.getString(1));
				String maxe = rs.getString(2);
				String nvl = rs.getString(3);
				double gia = rs.getDouble(4);
				String tenxe = rs.getString(5);
				
				HopDongTraHet n = new HopDongTraHet(mahd, maxe, nvl, gia, tenxe);
				ds.add(n);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ds;
	}
	/*public ArrayList<HopDongTraHet> getAllHopDongTraHetTheoMaXe(String maxm){
		ArrayList<HopDongTraHet> ds = new ArrayList<HopDongTraHet>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		
		String sql = "select * from HopDongMotLan where maHopDong like ?";
		PreparedStatement state = null;
		try {
			state = con.prepareStatement(sql);
			state.setString(1, maxm);
			ResultSet rs = state.executeQuery();
			
			while (rs.next()) {
				HopDong mahd = new HopDong(rs.getString(1));
				String maxe = rs.getString(2);
				String nvl = rs.getString(3);
				double gia = rs.getDouble(4);
				String tenxe = rs.getString(5);
				
				HopDongTraHet n = new HopDongTraHet(mahd, maxe, nvl, gia, tenxe);
				ds.add(n);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ds;
	}*/
	public boolean ThemHD(HopDongTraHet n) throws Exception{
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement state = null;
		try {
			state = con.prepareStatement("insert into HopDongMotLan values (?,?,?, ?, ?)");
			state.setString(1, n.getMaHopDong().getMaHopDong());
			state.setString(2, n.getMaXe());
			state.setString(3, n.getNhanVienLap());
			state.setDouble(4, n.getGiaXe());
			state.setString(5, n.getTenXe());

			state.executeUpdate();
			return true;
			
		} catch (SQLException e) {
			//e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Mã hợp đồng trả hết đã tồn tại");
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
	public double getTongThanhToan(String mahd){
		
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement state = null;
		String sql = "select sum(giaXe) from HopDongMotLan where maHopDong like ?";
		double tong =0;
		try {
			
			state = con.prepareStatement(sql);
			state.setString(1, mahd);
			
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
	public void xoaHDTH(String mahd, String maxe){
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement state = null;
		try {
			state = con.prepareStatement("delete from HopDongMotLan where MaHopDong like ? and maXe like ?");
			state.setString(1, mahd);
			state.setString(2, maxe);
			
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
	public String getMaHDTH(String ma){
		
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement state = null;
		String sql = "select maHopDong from HopDongMotLan where maXe like ?";
		String str = "";
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
}
