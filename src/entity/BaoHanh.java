package entity;

public class BaoHanh {
	private String maphieu;
	private String maxe;
	private String tenxe;
	private String hangsx;
	private String loai;
				
	private String mahd;
	private String loaiHD ;
	private String nhanvienlap;
	private String thoiGianBH;
	private String ngayLapHD;
	
	private String nvpt ;
	private String lidoBH ;
	private String loiDo;
	private LinhKien LK;
	private String ngayBH ;
	
	public String getMaphieu() {
		return maphieu;
	}
	public void setMaphieu(String maphieu) {
		this.maphieu = maphieu;
	}
	public String getMaxe() {
		return maxe;
	}
	public void setMaxe(String maxe) {
		this.maxe = maxe;
	}
	public String getTenxe() {
		return tenxe;
	}
	public void setTenxe(String tenxe) {
		this.tenxe = tenxe;
	}
	public String getHangsx() {
		return hangsx;
	}
	public void setHangsx(String hangsx) {
		this.hangsx = hangsx;
	}
	public String getLoai() {
		return loai;
	}
	public void setLoai(String loai) {
		this.loai = loai;
	}
	public String getMahd() {
		return mahd;
	}
	public void setMahd(String mahd) {
		this.mahd = mahd;
	}
	public String getLoaiHD() {
		return loaiHD;
	}
	public void setLoaiHD(String loaiHD) {
		this.loaiHD = loaiHD;
	}
	public String getNhanvienlap() {
		return nhanvienlap;
	}
	public void setNhanvienlap(String nhanvienlap) {
		this.nhanvienlap = nhanvienlap;
	}
	public String getThoiGianBH() {
		return thoiGianBH;
	}
	public void setThoiGianBH(String thoiGianBH) {
		this.thoiGianBH = thoiGianBH;
	}
	public String getNgayLapHD() {
		return ngayLapHD;
	}
	public void setNgayLapHD(String ngayLapHD) {
		this.ngayLapHD = ngayLapHD;
	}
	public String getNvpt() {
		return nvpt;
	}
	public void setNvpt(String nvpt) {
		this.nvpt = nvpt;
	}
	public String getLidoBH() {
		return lidoBH;
	}
	public void setLidoBH(String lidoBH) {
		this.lidoBH = lidoBH;
	}
	public String getLoiDo() {
		return loiDo;
	}
	public void setLoiDo(String loiDo) {
		this.loiDo = loiDo;
	}
	public LinhKien getLK() {
		return LK;
	}
	public void setLK(LinhKien lK) {
		LK = lK;
	}
	public String getNgayBH() {
		return ngayBH;
	}
	public void setNgayBH(String ngayBH) {
		this.ngayBH = ngayBH;
	}
	public BaoHanh(String maphieu, String maxe, String tenxe, String hangsx,
			String loai, String mahd, String loaiHD, String nhanvienlap,
			String thoiGianBH, String ngayLapHD, String nvpt, String lidoBH,
			String loiDo, LinhKien lK, String ngayBH) {
		super();
		this.maphieu = maphieu;
		this.maxe = maxe;
		this.tenxe = tenxe;
		this.hangsx = hangsx;
		this.loai = loai;
		this.mahd = mahd;
		this.loaiHD = loaiHD;
		this.nhanvienlap = nhanvienlap;
		this.thoiGianBH = thoiGianBH;
		this.ngayLapHD = ngayLapHD;
		this.nvpt = nvpt;
		this.lidoBH = lidoBH;
		this.loiDo = loiDo;
		LK = lK;
		this.ngayBH = ngayBH;
	}
	public BaoHanh(String maphieu, String lidoBH, String loiDo, LinhKien lK,
			String ngayBH) {
		super();
		this.maphieu = maphieu;
		this.lidoBH = lidoBH;
		this.loiDo = loiDo;
		LK = lK;
		this.ngayBH = ngayBH;
	}
	
	
}
