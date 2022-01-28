package vn.devpro.qusv.qlsv;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import vn.devpro.qlsv.qld.QLD;



public class QLSV {

	static int autoId=1;
	
	static Scanner sc = new Scanner(System.in);
	
	public static ArrayList<SinhVien> list = new ArrayList<>();
	
	static ArrayList<SinhVien> listClone = new ArrayList<>();
	
	public static void capNhat() {
		do {
			System.out.println("\n===============CAP NHAT THONG TIN SINH VIEN================");
			System.out.println("Hay chon mot chuc nang");
			System.out.println("\t1.Them mot sinh vien vao danh sach");
			System.out.println("\t2.Sua thong tin sinh vien");
			System.out.println("\t3.Xoa thong tin tin sinh vien");
			System.out.println("\t4.Hien thi danh sach sinh vien sap xep theo ten");
			System.out.println("\t0.Quay lai");
			System.out.print("Nhap lua chon cua ban: ");
			int chon=Integer.parseInt(sc.nextLine());
			switch(chon) {
			case 1:themSinhVien();break;
			case 2:suaSinhVien();break;
			case 3:xoaSinhVien();break;
			case 4:hienThi();break;
			case 0:
				return;
			default:
				System.out.println("Lua chon khong hop le!");
			}
		}while(true);
	}

	private static void themSinhVien() {
		System.out.println("\n=============CHUC NANG THEM SINH VIEN==================");
		System.out.print("\tNhap ho dem: "); String hoDem = sc.nextLine();
		if(hoDem.trim().length()==0) {
			System.out.println("Ho dem khong duoc de trong");
			return;
		}
		System.out.print("\tNhap ten: "); String ten = sc.nextLine();
		if(ten.trim().length()==0) {
			System.out.println("Ten khong duoc de trong");
			return;
		}
		System.out.print("\tNhap nam sinh: "); int namSinh = Integer.parseInt(sc.nextLine());
		System.out.print("\tNhap gioi tinh: "); String gioiTinh = sc.nextLine();
		SinhVien sv = new SinhVien(autoId,hoDem,ten,namSinh,gioiTinh);
		list.add(sv);
		autoId++;
		System.out.println("Them sinh vien thanh cong!");
		
	}
	
	private static void suaSinhVien() {
		System.out.println("\n==================CHUC NANG SUA SINH VIEN==================");
		System.out.print("Nhap ma sinh vien can sua: ");
		int ma = Integer.parseInt(sc.nextLine());
		int index = indexOf(ma);
		if(index ==-1) {
			System.out.println("Ma sinh vien khong ton tai");
			return;
		}
		System.out.println("\tChon thong tin can sua");
		System.out.println("\t1.Sua ho dem");
		System.out.println("\t2.Sua ten");
		System.out.println("\t3.Sua nam sinh");
		System.out.println("\t4.Sua  gioi tinh");
		System.out.println("\t0.Quay lai");
		System.out.print("Nhap lua chon cua ban: ");
		int chon = Integer.parseInt(sc.nextLine());
		switch(chon) {
		case 1:
			System.out.print("\tNhap ho dem moi: ");
			String hoDem = sc.nextLine();
			list.get(index).setHoDem(hoDem);
			System.out.println("Sua ho dem thanh cong!");
			break;
		case 2:
			System.out.print("\tNhap ten moi: ");
			String ten = sc.nextLine();
			list.get(index).setTen(ten);
			System.out.println("Sua ten thanh cong!");
			break;
		case 3:
			System.out.print("\tNhap nam sinh moi: ");
			int namSinh = Integer.parseInt(sc.nextLine());
			list.get(index).setNamSinh(namSinh);
			System.out.println("Sua nam sinh thanh cong!");
			break;
		case 4:
			System.out.print("\tNhap gioi tinh moi: ");
			String gioiTinh = sc.nextLine();
			list.get(index).setGioiTinh(gioiTinh);
			System.out.println("Sua gioi tinh thanh cong!");
			break;
		case 0:
			return;
		default:
			System.out.println("Lua chon khong hop le!");
		}
	}
	private static void xoaSinhVien() {
		System.out.println("\n==================CHUC NANG XOA SINH VIEN====================");
		System.out.print("\tNhap ma sinh vien can xoa: ");
		int ma = Integer.parseInt(sc.nextLine());
		int index = indexOf(ma);
		if(index ==-1) {
			System.out.println("Ma sinh vien khong ton tai");
			return;
		}
		for(int i=0;i<QLD.list.size();i++) {
			if(QLD.list.get(i).getMaSV()==ma) {
				System.out.println("Sinh vien da co diem khong the xoa!");
				return;
			}
		}
		list.remove(index);
		System.out.println("Xoa sinh vien thanh cong!");
	}

	private static void hienThi() {
		listClone = (ArrayList<SinhVien>)list.clone();
		System.out.println("\n====================DANH SACH SINH VIEN===============");
		int stt=1;
		sapXep();
		System.out.printf("%3s %12s %-23s %8s %9s %n","STT","Ma sinh vien","Ho ten","Nam sinh","Gioi tinh");
		for(int i=0;i<listClone.size();i++) {
			System.out.printf("%-3d",stt++);
			listClone.get(i).hienThi();
		}
		if(stt==1) {
			System.out.println("DANH SACH RONG!");
		}
	}
	public static int indexOf(int id) {
		for(int index=0;index<list.size();index++) {
			if(list.get(index).getMaSV()==id) {
				return index;
			}
		}
		return -1;
	}
	private static void sapXep() {
		Collections.sort(listClone, new Comparator<SinhVien>() {
			@Override
			public int compare(SinhVien o1, SinhVien o2) {
				return o1.getTen().trim().compareToIgnoreCase(o2.getTen().trim());
			}
		});
	}
	public static String hoDem(int maSV) {
		for(int i=0;i<list.size();i++) {
			if(list.get(i).getMaSV()==maSV) {
				return list.get(i).getHoDem();
			}
		}
		return "";
	}
	public static String ten(int maSV) {
		for(int i=0;i<list.size();i++) {
			if(list.get(i).getMaSV()==maSV) {
				return list.get(i).getTen();
			}
		}
		return "";
	}
}
