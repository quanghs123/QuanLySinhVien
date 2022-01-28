package vn.devpro.qlsv.qld;

import java.util.ArrayList;
import java.util.Scanner;


import vn.devpro.qlsv.qlmh.QLMH;
import vn.devpro.qusv.qlsv.QLSV;

public class QLD {
	static Scanner sc = new Scanner(System.in);
	public static ArrayList<Diem>list = new ArrayList<>();
	
	public static void capNhat() {
		do {
			System.out.println("\n================CHUONG TRINH QUAN LY DIEM=================");
			System.out.println("Hay chon mot chuc nang");
			System.out.println("\t1.Them diem");
			System.out.println("\t2.Sua diem");
			System.out.println("\t3.Xoa diem");
			System.out.println("\t0.Quay lai");
			System.out.print("Nhap lua chon cua ban: ");
			int chon = Integer.parseInt(sc.nextLine());
			switch(chon) {
			case 1:themDiem();break;
			case 2:suaDiem();break;
			case 3:xoaDiem();break;
			case 0:
				return;
			default:
				System.out.println("Lua chon khong hop le!");
			}
		}while(true);
	}

	private static void themDiem() {
		System.out.println("\n==================CHUC NANG THEM DIEM===============");
		double diem;
		System.out.print("\tNhap ma sinh vien: ");
		int maSV = Integer.parseInt(sc.nextLine());
		int index1 = QLSV.indexOf(maSV);
		if(index1==-1) {
			System.out.println("Sinh vien khong co trong danh sach!");
			return;
		}
		System.out.print("\tNhap ma mon hoc: ");
		int maM = Integer.parseInt(sc.nextLine());
		int index2 = QLMH.indexOf(maM);
		if(index2==-1) {
			System.out.println("Mon hoc khong co trong danh sach!");
			return;
		}
		for(int i=0;i<list.size();i++) {
			if(list.get(i).getMaSV()==maSV&&list.get(i).getMaM()==maM) {
				System.out.println("Sinh vien voi mon hoc da co diem!");
				return;
			}
		}
		do {
			System.out.print("\tNhap diem (0<=diem<=10): ");
			diem = Double.parseDouble(sc.nextLine());
		}while(diem<0||diem>10);
		Diem d = new Diem(maSV,maM,diem);
		list.add(d);
		System.out.println("Them diem thanh cong!");
	}

	private static void suaDiem() {
		System.out.println("\n=======================CHUC NANG SUA DIEM========================");
		double diem;
		System.out.print("\tNhap ma sinh vien: ");
		int maSV = Integer.parseInt(sc.nextLine());
		int index1 = QLSV.indexOf(maSV);
		if(index1==-1) {
			System.out.println("Sinh vien khong co trong danh sach!");
			return;
		}
		System.out.print("\tNhap ma mon hoc: ");
		int maM = Integer.parseInt(sc.nextLine());
		int index2 = QLMH.indexOf(maM);
		if(index2==-1) {
			System.out.println("Mon hoc khong co trong danh sach!");
			return;
		};
		int index = indexOf(maSV, maM);
		if(index==-1) {
			System.out.println("Khong co diem cua sinh vien voi mon hoc!");
			return;
		}
		do {
			System.out.print("\tNhap diem moi (0<=diem<=10): ");
			diem = Double.parseDouble(sc.nextLine());
		}while(diem<0||diem>10);
		list.get(index).setDiem(diem);
		System.out.println("Sua diem thanh cong!");
	}

	private static void xoaDiem() {
		System.out.println("\n=======================CHUC NANG XOA DIEM========================");
		System.out.print("\tNhap ma sinh vien: ");
		int maSV = Integer.parseInt(sc.nextLine());
		int index1 = QLSV.indexOf(maSV);
		if(index1==-1) {
			System.out.println("Sinh vien khong co trong danh sach!");
			return;
		}
		System.out.print("\tNhap ma mon hoc: ");
		int maM = Integer.parseInt(sc.nextLine());
		int index2 = QLMH.indexOf(maM);
		if(index2==-1) {
			System.out.println("Mon hoc khong co trong danh sach!");
			return;
		};
		int index = indexOf(maSV, maM);
		if(index==-1) {
			System.out.println("Khong co diem cua sinh vien voi mon hoc!");
			return;
		}
		list.remove(index);
		System.out.println("Xoa thanh cong!");
	}
	public static int indexOf(int maSV, int maM) {
		for(int index=0;index<list.size();index++) {
			if(list.get(index).getMaSV()==maSV&&list.get(index).getMaM()==maM) {
				return index;
			}
		}
		return -1;
	}
}
