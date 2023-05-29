package entity;

public class TaiKhoanHC {
	private String tenTaiKhoanHC;
	private String matKhau;
	NhanVienHanhChanh MaHC;
	public String getTenTaiKhoanHC() {
		return tenTaiKhoanHC;
	}
	public void setTenTaiKhoanHC(String tenTaiKhoanHC) {
		this.tenTaiKhoanHC = tenTaiKhoanHC;
	}
	public String getMatKhau() {
		return matKhau;
	}
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	public NhanVienHanhChanh getMaHC() {
		return MaHC;
	}
	public void setMaHC(NhanVienHanhChanh maHC) {
		MaHC = maHC;
	}
	public TaiKhoanHC(String tenTaiKhoanHC, String matKhau,
			NhanVienHanhChanh maHC) {
		super();
		this.tenTaiKhoanHC = tenTaiKhoanHC;
		this.matKhau = matKhau;
		MaHC = maHC;
	}
	
}
