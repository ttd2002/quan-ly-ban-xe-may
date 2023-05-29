package entity;

public class xeMay {
	private String maXe;
	private String tenXe;
	private String nuocSX;
	private HangSanXuat hsx;
	private double donGia;
	private String soPhanKhoi;
	private String mauXe;
	private LoaiXe loai;
	public String getMaXe() {
		return maXe;
	}
	public void setMaXe(String maXe) {
		this.maXe = maXe;
	}
	public String getNuocSX() {
		return nuocSX;
	}
	public void setNuocSX(String nuocSX) {
		this.nuocSX = nuocSX;
	}
	public double getDonGia() {
		return donGia;
	}
	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}
	public String getMauXe() {
		return mauXe;
	}
	public void setMauXe(String mauXe) {
		this.mauXe = mauXe;
	}
	public String getTenXe() {
		return tenXe;
	}
	public void setTenXe(String tenXe) {
		this.tenXe = tenXe;
	}
	public HangSanXuat getHsx() {
		return hsx;
	}
	public void setHsx(HangSanXuat hsx) {
		this.hsx = hsx;
	}
	public String getSoPhanKhoi() {
		return soPhanKhoi;
	}
	public void setSoPhanKhoi(String soPhanKhoi) {
		this.soPhanKhoi = soPhanKhoi;
	}
	public LoaiXe getLoai() {
		return loai;
	}
	public void setLoai(LoaiXe loai) {
		this.loai = loai;
	}
	
	public xeMay(String maXe, String tenXe, String nuocSX, HangSanXuat hsx,
			double donGia, String soPhanKhoi, String mauXe, LoaiXe loai) {
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
	public xeMay(String maXe) {
		super();
		this.maXe = maXe;
	}
	
	
	
}

