package entity;

public class TraLan3 {
	private String maHopDong;
	private String ngayTralan3;
	private double soTienTraLan3;
	public String getMaHopDong() {
		return maHopDong;
	}
	public void setMaHopDong(String maHopDong) {
		this.maHopDong = maHopDong;
	}
	public String getNgayTralan3() {
		return ngayTralan3;
	}
	public void setNgayTralan3(String ngayTralan3) {
		this.ngayTralan3 = ngayTralan3;
	}
	public double getSoTienTraLan3() {
		return soTienTraLan3;
	}
	public void setSoTienTraLan3(double soTienTraLan3) {
		this.soTienTraLan3 = soTienTraLan3;
	}
	public TraLan3(String maHopDong, String ngayTralan3, double soTienTraLan3) {
		super();
		this.maHopDong = maHopDong;
		this.ngayTralan3 = ngayTralan3;
		this.soTienTraLan3 = soTienTraLan3;
	}
	
}
