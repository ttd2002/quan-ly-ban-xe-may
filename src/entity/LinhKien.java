package entity;

public class LinhKien {
	private String maLinhkien;
	private String tenLinhKien;
	public String getMaLinhkien() {
		return maLinhkien;
	}
	public void setMaLinhkien(String maLinhkien) {
		this.maLinhkien = maLinhkien;
	}
	public String getTenLinhKien() {
		return tenLinhKien;
	}
	public void setTenLinhKien(String tenLinhKien) {
		this.tenLinhKien = tenLinhKien;
	}
	public LinhKien(String maLinhkien, String tenLinhKien) {
		super();
		this.maLinhkien = maLinhkien;
		this.tenLinhKien = tenLinhKien;
	}
	public LinhKien(String maLinhkien) {
		super();
		this.maLinhkien = maLinhkien;
	}
	
}
