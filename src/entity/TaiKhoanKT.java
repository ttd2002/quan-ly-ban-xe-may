package entity;

public class TaiKhoanKT {
	private String tenTaiKhoanKT;
	private String matKhau;
	NhanVienKyThuat maKT;
	public String getTenTaiKhoanKT() {
		return tenTaiKhoanKT;
	}
	public void setTenTaiKhoanKT(String tenTaiKhoanKT) {
		this.tenTaiKhoanKT = tenTaiKhoanKT;
	}
	public String getMatKhau() {
		return matKhau;
	}
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	public NhanVienKyThuat getMaKT() {
		return maKT;
	}
	public void setMaKT(NhanVienKyThuat maKT) {
		this.maKT = maKT;
	}
	public TaiKhoanKT(String tenTaiKhoanKT, String matKhau, NhanVienKyThuat maKT) {
		super();
		this.tenTaiKhoanKT = tenTaiKhoanKT;
		this.matKhau = matKhau;
		this.maKT = maKT;
	}
	
}
