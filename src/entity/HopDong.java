package entity;

public class HopDong {
	private String maHopDong;
	private String TenKhachHang;
	private String NhanVienLap;
	private String diaChiKhachHang;
	private String loaiHopDong;
	private String soDienThoaiKH;
	private String thoiGianBaoHanh;
	private String ngayLapHD;
	public String getMaHopDong() {
		return maHopDong;
	}
	public void setMaHopDong(String maHopDong) {
		this.maHopDong = maHopDong;
	}
	public String getTenKhachHang() {
		return TenKhachHang;
	}
	public void setTenKhachHang(String tenKhachHang) {
		TenKhachHang = tenKhachHang;
	}
	public String getNhanVienLap() {
		return NhanVienLap;
	}
	public void setNhanVienLap(String nhanVienLap) {
		NhanVienLap = nhanVienLap;
	}
	public String getDiaChiKhachHang() {
		return diaChiKhachHang;
	}
	public void setDiaChiKhachHang(String diaChiKhachHang) {
		this.diaChiKhachHang = diaChiKhachHang;
	}
	public String getLoaiHopDong() {
		return loaiHopDong;
	}
	public void setLoaiHopDong(String loaiHopDong) {
		this.loaiHopDong = loaiHopDong;
	}
	public String getSoDienThoaiKH() {
		return soDienThoaiKH;
	}
	public void setSoDienThoaiKH(String soDienThoaiKH) {
		this.soDienThoaiKH = soDienThoaiKH;
	}
	public String getThoiGianBaoHanh() {
		return thoiGianBaoHanh;
	}
	public void setThoiGianBaoHanh(String thoiGianBaoHanh) {
		this.thoiGianBaoHanh = thoiGianBaoHanh;
	}
	public String getNgayLapHD() {
		return ngayLapHD;
	}
	public void setNgayLapHD(String ngayLapHD) {
		this.ngayLapHD = ngayLapHD;
	}
	public HopDong(String maHopDong, String tenKhachHang, String nhanVienLap,
			String diaChiKhachHang, String loaiHopDong, String soDienThoaiKH,
			String thoiGianBaoHanh, String ngayLapHD) {
		super();
		this.maHopDong = maHopDong;
		TenKhachHang = tenKhachHang;
		NhanVienLap = nhanVienLap;
		this.diaChiKhachHang = diaChiKhachHang;
		this.loaiHopDong = loaiHopDong;
		this.soDienThoaiKH = soDienThoaiKH;
		this.thoiGianBaoHanh = thoiGianBaoHanh;
		this.ngayLapHD = ngayLapHD;
	}
	public HopDong(String maHopDong) {
		super();
		this.maHopDong = maHopDong;
	}
	public HopDong(String maHopDong, String tenKhachHang,
			String diaChiKhachHang, String loaiHopDong, String soDienThoaiKH,
			String thoiGianBaoHanh, String ngayLapHD) {
		super();
		this.maHopDong = maHopDong;
		TenKhachHang = tenKhachHang;
		this.diaChiKhachHang = diaChiKhachHang;
		this.loaiHopDong = loaiHopDong;
		this.soDienThoaiKH = soDienThoaiKH;
		this.thoiGianBaoHanh = thoiGianBaoHanh;
		this.ngayLapHD = ngayLapHD;
	}
	
	
	
}
