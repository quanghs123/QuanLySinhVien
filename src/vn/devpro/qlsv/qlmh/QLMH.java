package vn.devpro.qlsv.qlmh;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import vn.devpro.qlsv.qld.QLD;


public class QLMH {
	
	static int autoId=1;
	
	static Scanner sc = new Scanner(System.in);
	
	public static ArrayList<MonHoc>list = new ArrayList<>();
	
	public static void capNhat() {
		do {
			System.out.println("\n=================CHUC NANG CAP NHAT MON HOC=======================");
			System.out.println("Hay chon mot chuc nang");
			System.out.println("\t1.Them mon hoc");
			System.out.println("\t2.Sua mon hoc");
			System.out.println("\t3.Xoa mon hoc");
			System.out.println("\t4.Hien thi danh sach mon hoc");
			System.out.println("\t0.Quay lai");
			System.out.print("Nhap lua chon cua ban: ");
			int chon = Integer.parseInt(sc.nextLine());
			switch(chon) {
			case 1:themMonHoc();break;
			case 2:suaMonHoc();break;
			case 3:xoaMonHoc();break;
			case 4:hienThi();break;
			case 0:
				return;
			default:
				System.out.println("Lua chon khong hop le!");
			}
		}while(true);
	}

	private static void themMonHoc() {
		System.out.println("\n===========CHUC NANG THEM MON HOC===============");
		System.out.print("\tNhap ten mon: ");
		String tenMon = sc.nextLine();
		if(tenMon.trim().length()==0) {
			System.out.println("Ten mon hoc khong duoc de trong!");
			return;
		}
		int i=0;
		while (i<list.size()&&list.get(i).getTenMon().trim().compareToIgnoreCase(tenMon)!=0) {
			i++;
		}
		if(i<list.size()) {
			System.out.println("Mon hoc da ton tai trong danh sach!");
			return;
		}
		System.out.print("\tNhap he so mon: ");
		double heSo = Double.parseDouble(sc.nextLine());
		MonHoc mh = new MonHoc(autoId,tenMon,heSo);
		autoId++;
		list.add(mh);
		System.out.println("Them mon hoc thanh cong!");
	}

	private static void suaMonHoc() {
		System.out.println("\n==================CHUC NANG SUA THONG TIN MON HOC================");
		System.out.print("\tNhap ma mon hoc can sua: ");
		int ma = Integer.parseInt(sc.nextLine());
		int index = indexOf(ma);
		if(index==-1) {
			System.out.println("Ma mon hoc khong ton tai");
			return;
		}
		System.out.println("Hay chon mot chuc nang");
		System.out.println("\t1.Sua ten mon");
		System.out.println("\t2.Sua he so");
		System.out.println("\t0.Quay lai");
		System.out.print("Nhap lua chon cua ban: ");
		int chon = Integer.parseInt(sc.nextLine());
		switch(chon) {
		case 1:
			System.out.print("Nhap ten moi: ");
			list.get(index).setTenMon(sc.nextLine());
			System.out.println("Sua ten thanh cong!");
			break;
		case 2:
			System.out.print("Nhap he so: ");
			list.get(index).setHeSo(Double.parseDouble(sc.nextLine()));
			System.out.println("Sua he so thanh cong!");
			break;
		case 3:
			return;
		default:
			System.err.println("Lua chon khong hop le!");
		}
	}

	private static void xoaMonHoc() {
		System.out.println("\n==============CHUC NANG XOA MON HOC=================");
		System.out.print("Nhap ma mon can xoa: ");
		int ma = Integer.parseInt(sc.nextLine());
		int index = indexOf(ma);
		if(index==-1) {
			System.out.println("Ma mon khong ton tai");
			return;
		}
		for(int i=0;i<QLD.list.size();i++) {
			if(QLD.list.get(i).getMaSV()==ma) {
				System.out.println("Mon hoc da co diem khong the xoa!");
				return;
			}
		}
		list.remove(index);
		System.out.println("Xoa thanh cong!");
	}

	private static void hienThi() {
		System.out.println("\n================HIEN THI DANH SACH MON HOC======================");
		System.out.printf("%3s %6s %-23s %5s %n","STT","Ma mon","Ten mon","He so");
		int stt=1;
		sapXep();
		for(int i=0;i<list.size();i++) {
			System.out.printf("%-3d",stt++);
			list.get(i).hienThi();
		}
		if(stt==1) {
			System.out.println("Danh sach rong!");
		}
	}
	private static void sapXep() {
		Collections.sort(list, new Comparator<MonHoc>() {
			@Override
			public int compare(MonHoc o1, MonHoc o2) {
				return o1.getTenMon().trim().compareToIgnoreCase(o2.getTenMon().trim());
			}
		});
	}
	public static int indexOf(int id) {
		for(int index=0;index<list.size();index++) {
			if(list.get(index).getMaMon()==id) {
				return index;
			}
		}
		return -1;
	}
	public static String tenMon(int maM) {
		for(int i=0;i<list.size();i++) {
			if(list.get(i).getMaMon()==maM) {
				return list.get(i).getTenMon();
			}
		}
		return "";
	}
	public static double heSo(int maM) {
		for(int i=0;i<list.size();i++) {
			if(list.get(i).getMaMon()==maM) {
				return list.get(i).getHeSo();
			}
		}
		return -1;
	}
}
