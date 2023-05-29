package entity;

public class HopDongTraGop {
	private HopDong maHopDong;
	private String maXe;
	private String nhanVienLap;
	private double giaXe;
	private String tenXe;
	public HopDong getMaHopDong() {
		return maHopDong;
	}
	public void setMaHopDong(HopDong maHopDong) {
		this.maHopDong = maHopDong;
	}
	public String getMaXe() {
		return maXe;
	}
	public void setMaXe(String maXe) {
		this.maXe = maXe;
	}
	public String getNhanVienLap() {
		return nhanVienLap;
	}
	public void setNhanVienLap(String nhanVienLap) {
		this.nhanVienLap = nhanVienLap;
	}
	public double getGiaXe() {
		return giaXe;
	}
	public void setGiaXe(double giaXe) {
		this.giaXe = giaXe;
	}
	public String getTenXe() {
		return tenXe;
	}
	public void setTenXe(String tenXe) {
		this.tenXe = tenXe;
	}
	public HopDongTraGop(HopDong maHopDong, String maXe, String nhanVienLap,
			double giaXe, String tenXe) {
		super();
		this.maHopDong = maHopDong;
		this.maXe = maXe;
		this.nhanVienLap = nhanVienLap;
		this.giaXe = giaXe;
		this.tenXe = tenXe;
	}
	
}
