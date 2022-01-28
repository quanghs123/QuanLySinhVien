package vn.devpro.qusv.qlsv;

public class SinhVien {
	private int maSV;
	private String hoDem;
	private String ten;
	private int namSinh;
	private String gioiTinh;
	
	public void hienThi() {
		System.out.printf("%-12d %13s %-10s %8d %9s %n",maSV,hoDem,ten,namSinh,gioiTinh);
	}
	
	public SinhVien() {
		super();
	}
	public SinhVien(int maSV, String hoDem, String ten, int namSinh, String gioiTinh) {
		super();
		this.maSV = maSV;
		this.hoDem = hoDem;
		this.ten = ten;
		this.namSinh = namSinh;
		this.gioiTinh = gioiTinh;
	}
	public int getMaSV() {
		return maSV;
	}
	public void setMaSV(int maSV) {
		this.maSV = maSV;
	}
	public String getHoDem() {
		return hoDem;
	}
	public void setHoDem(String hoDem) {
		this.hoDem = hoDem;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public int getNamSinh() {
		return namSinh;
	}
	public void setNamSinh(int namSinh) {
		this.namSinh = namSinh;
	}
	public String getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	
}
