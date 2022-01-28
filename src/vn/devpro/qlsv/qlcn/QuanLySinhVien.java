package vn.devpro.qlsv.qlcn;

import java.util.Scanner;

import vn.devpro.qlsv.qlbd.QLBD;
import vn.devpro.qlsv.qld.QLD;
import vn.devpro.qlsv.qlmh.QLMH;
import vn.devpro.qlsv.qltk.QLTK;
import vn.devpro.qusv.qlsv.QLSV;

public class QuanLySinhVien {

	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		do {
			System.out.println("=============CHUONG TRINH QUAN LY SINH VIEN================");
			System.out.println("Hay chon mot chuc nang");
			System.out.println("\t1.Cap nhat danh sach");
			System.out.println("\t2.Hien thi bang diem");
			System.out.println("\t3.Tim kiem thong tin");
			System.out.println("\t0.Thoat khoi chuong trinh");
			System.out.print("Nhap lua chon cua ban: ");
			int chon = Integer.parseInt(sc.nextLine());
			switch(chon) {
			case 1:capNhatDanhSach();break;
			case 2:hienThiDanhSach();break;
			case 3:timKiemThongTin();break;
			case 0:
				System.out.println("Da thoat khoi chuong trinh!");
				return;
			default:
				System.out.println("Lua chon khong hop le!");
			}
		}while(true);
	}

	private static void capNhatDanhSach() {
		do {
			System.out.println("===============CHUC NANG CAP NHAT DANH SACH===================");
			System.out.println("Hay chon mot chuc nang");
			System.out.println("\t1.Cap nhat danh sach sinh vien");
			System.out.println("\t2.Cap nhat danh sach mon hoc");
			System.out.println("\t3.Cap nhat bang diem");
			System.out.println("\t0.Quay loai");
			System.out.print("Nhap lua chon cua ban: ");
			int chon = Integer.parseInt(sc.nextLine());
			switch(chon) {
			case 1:QLSV.capNhat();break;
			case 2:QLMH.capNhat();break;
			case 3:QLD.capNhat();break;
			case 0:
				return;
			default:
				System.out.println("Lua chon khong hop le!");
			}
		}while(true);
	}

	private static void hienThiDanhSach() {
		QLBD.quanLyBangDiem();
	}

	private static void timKiemThongTin() {
		QLTK.quanLyTimKiem();
	}

}
