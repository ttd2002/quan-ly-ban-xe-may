package entity;

public class TraLan2 {
	private String maHopDong;
	private String ngayTralan2;
	private double soTienTraLan2;
	public String getMaHopDong() {
		return maHopDong;
	}
	public void setMaHopDong(String maHopDong) {
		this.maHopDong = maHopDong;
	}
	public String getNgayTralan2() {
		return ngayTralan2;
	}
	public void setNgayTralan2(String ngayTralan2) {
		this.ngayTralan2 = ngayTralan2;
	}
	public double getSoTienTraLan2() {
		return soTienTraLan2;
	}
	public void setSoTienTraLan2(double soTienTraLan2) {
		this.soTienTraLan2 = soTienTraLan2;
	}
	public TraLan2(String maHopDong, String ngayTralan2, double soTienTraLan2) {
		super();
		this.maHopDong = maHopDong;
		this.ngayTralan2 = ngayTralan2;
		this.soTienTraLan2 = soTienTraLan2;
	}
	
}
