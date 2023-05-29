package entity;

public class NhanVienHanhChanh {
	private String maNhanVien;
	private String tenNhanVien;
	private String phongBan;
	private String chucVu;
	private String gioiTinh;
	private String ngaySinh;
	private String hocVan;
	private String soDienThoai;
	public String getMaNhanVien() {
		return maNhanVien;
	}
	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
	}
	public String getTenNhanVien() {
		return tenNhanVien;
	}
	public void setTenNhanVien(String tenNhanVien) {
		this.tenNhanVien = tenNhanVien;
	}
	public String getPhongBan() {
		return phongBan;
	}
	public void setPhongBan(String phongBan) {
		this.phongBan = phongBan;
	}
	public String getChucVu() {
		return chucVu;
	}
	public void setChucVu(String chucVu) {
		this.chucVu = chucVu;
	}
	public String getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public String getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(String ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public String getHocVan() {
		return hocVan;
	}
	public void setHocVan(String hocVan) {
		this.hocVan = hocVan;
	}
	public String getSoDienThoai() {
		return soDienThoai;
	}
	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}
	public NhanVienHanhChanh(String maNhanVien, String tenNhanVien,
			String phongBan, String chucVu, String gioiTinh, String ngaySinh,
			String hocVan, String soDienThoai) {
		super();
		this.maNhanVien = maNhanVien;
		this.tenNhanVien = tenNhanVien;
		this.phongBan = phongBan;
		this.chucVu = chucVu;
		this.gioiTinh = gioiTinh;
		this.ngaySinh = ngaySinh;
		this.hocVan = hocVan;
		this.soDienThoai = soDienThoai;
	}
	public NhanVienHanhChanh(String maNhanVien) {
		super();
		this.maNhanVien = maNhanVien;
	}
	
	
}
