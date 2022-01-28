package vn.devpro.qlsv.qlmh;


public class MonHoc {
	private int maMon;
	private String tenMon;
	private double heSo;
	
	public void hienThi() {
		System.out.printf("%6d %-23s %5.1f %n",maMon,tenMon,heSo);
	}
	public MonHoc() {
		super();
	}
	public MonHoc(int maMon, String tenMon, double heSo) {
		super();
		this.maMon = maMon;
		this.tenMon = tenMon;
		this.heSo = heSo;
	}
	public int getMaMon() {
		return maMon;
	}
	public void setMaMon(int maMon) {
		this.maMon = maMon;
	}
	public String getTenMon() {
		return tenMon;
	}
	public void setTenMon(String tenMon) {
		this.tenMon = tenMon;
	}
	public double getHeSo() {
		return heSo;
	}
	public void setHeSo(double heSo) {
		this.heSo = heSo;
	}
	
}
