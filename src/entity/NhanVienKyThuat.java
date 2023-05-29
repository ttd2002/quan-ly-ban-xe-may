package entity;

public class NhanVienKyThuat {
	private String maNhanVien;
	private String tenNhanVien;
	private String bacTho;
	private String chucVu;
	private String gioiTinh;
	private String ngaySinh;
	private String soNamKinhNghiem;
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
	public String getBacTho() {
		return bacTho;
	}
	public void setBacTho(String bacTho) {
		this.bacTho = bacTho;
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
	public String getSoNamKinhNghiem() {
		return soNamKinhNghiem;
	}
	public void setSoNamKinhNghiem(String soNamKinhNghiem) {
		this.soNamKinhNghiem = soNamKinhNghiem;
	}
	public String getSoDienThoai() {
		return soDienThoai;
	}
	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}
	public NhanVienKyThuat(String maNhanVien, String tenNhanVien,
			String bacTho, String chucVu, String gioiTinh, String ngaySinh,
			String soNamKinhNghiem, String soDienThoai) {
		super();
		this.maNhanVien = maNhanVien;
		this.tenNhanVien = tenNhanVien;
		this.bacTho = bacTho;
		this.chucVu = chucVu;
		this.gioiTinh = gioiTinh;
		this.ngaySinh = ngaySinh;
		this.soNamKinhNghiem = soNamKinhNghiem;
		this.soDienThoai = soDienThoai;
	}
	public NhanVienKyThuat(String maNhanVien) {
		super();
		this.maNhanVien = maNhanVien;
	}
	
	
}
