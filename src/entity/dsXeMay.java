package entity;

public class dsXeMay {
	private String maXe;
	private String tenXe;
	private String nuocSX;
	private String hsx;
	private double donGia;
	private String soPhanKhoi;
	private String mauXe;
	private String loai;
	public String getMaXe() {
		return maXe;
	}
	public void setMaXe(String maXe) {
		this.maXe = maXe;
	}
	
	public String getTenXe() {
		return tenXe;
	}
	public void setTenXe(String tenXe) {
		this.tenXe = tenXe;
	}
	public String getNuocSX() {
		return nuocSX;
	}
	public void setNuocSX(String nuocSX) {
		this.nuocSX = nuocSX;
	}
	public String getHsx() {
		return hsx;
	}
	public void setHsx(String hsx) {
		this.hsx = hsx;
	}
	public double getDonGia() {
		return donGia;
	}
	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}
	public String getSoPhanKhoi() {
		return soPhanKhoi;
	}
	public void setSoPhanKhoi(String soPhanKhoi) {
		this.soPhanKhoi = soPhanKhoi;
	}
	public String getMauXe() {
		return mauXe;
	}
	public void setMauXe(String mauXe) {
		this.mauXe = mauXe;
	}
	public String getLoai() {
		return loai;
	}
	public void setLoai(String loai) {
		this.loai = loai;
	}
	public dsXeMay(String maXe) {
		super();
		this.maXe = maXe;
	}
	public dsXeMay(String maXe, String tenXe, String nuocSX, String hsx,
			double donGia, String soPhanKhoi, String mauXe, String loai) {
		super();
		this.maXe = maXe;
		this.tenXe = tenXe;
		this.nuocSX = nuocSX;
		this.hsx = hsx;
		this.donGia = donGia;
		this.soPhanKhoi = soPhanKhoi;
		this.mauXe = mauXe;
		this.loai = loai;
	}
}
