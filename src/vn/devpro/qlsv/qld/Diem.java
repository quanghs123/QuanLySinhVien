package vn.devpro.qlsv.qld;

public class Diem {
	
	private int maSV;
	private int maM;
	private double diem;
	public Diem() {
		super();
	}
	public Diem(int maSV, int maM, double diem) {
		super();
		this.maSV = maSV;
		this.maM = maM;
		this.diem = diem;
	}
	public int getMaSV() {
		return maSV;
	}
	public void setMaSV(int maSV) {
		this.maSV = maSV;
	}
	public int getMaM() {
		return maM;
	}
	public void setMaM(int maM) {
		this.maM = maM;
	}
	public double getDiem() {
		return diem;
	}
	public void setDiem(double diem) {
		this.diem = diem;
	}
	
}
