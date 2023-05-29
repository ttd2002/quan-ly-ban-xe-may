package entity;

public class HangSanXuat {
	private String maHSX;
	private String tenHSX;
	private int soLuongTon;
	public String getMaHSX() {
		return maHSX;
	}
	public void setMaHSX(String maHSX) {
		this.maHSX = maHSX;
	}
	public String getTenHSX() {
		return tenHSX;
	}
	public void setTenHSX(String tenHSX) {
		this.tenHSX = tenHSX;
	}
	public int getSoLuongTon() {
		return soLuongTon;
	}
	public void setSoLuongTon(int soLuongTon) {
		this.soLuongTon = soLuongTon;
	}
	public HangSanXuat(String maHSX, String tenHSX, int soLuongTon) {
		super();
		this.maHSX = maHSX;
		this.tenHSX = tenHSX;
		this.soLuongTon = soLuongTon;
	}
	public HangSanXuat(String maHSX) {
		super();
		this.maHSX = maHSX;
	}
	
}
