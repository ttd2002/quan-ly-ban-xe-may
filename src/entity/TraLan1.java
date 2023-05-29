package entity;

public class TraLan1 {
	private String  maHopDong;
	private String ngayTralan1;
	private double soTienTraLan1;
	public String getMaHopDong() {
		return maHopDong;
	}
	public void setMaHopDong(String maHopDong) {
		this.maHopDong = maHopDong;
	}
	public String getNgayTralan1() {
		return ngayTralan1;
	}
	public void setNgayTralan1(String ngayTralan1) {
		this.ngayTralan1 = ngayTralan1;
	}
	public double getSoTienTraLan1() {
		return soTienTraLan1;
	}
	public void setSoTienTraLan1(double soTienTraLan1) {
		this.soTienTraLan1 = soTienTraLan1;
	}
	public TraLan1(String maHopDong, String ngayTralan1, double soTienTraLan1) {
		super();
		this.maHopDong = maHopDong;
		this.ngayTralan1 = ngayTralan1;
		this.soTienTraLan1 = soTienTraLan1;
	}
	
}
