package vn.devpro.qlsv.qltk;

import java.util.Scanner;

import vn.devpro.qlsv.qld.QLD;
import vn.devpro.qlsv.qlmh.QLMH;
import vn.devpro.qusv.qlsv.QLSV;

public class QLTK {
	
	static Scanner sc = new Scanner(System.in);
	
	public static void quanLyTimKiem() {
		do {
			System.out.println("\n===================CHUC NANG TIM KIEM=====================");
			System.out.println("Hay chon mot chuc nang");
			System.out.println("\t1.Tim kiem theo ma sinh vien");
			System.out.println("\t2.Tim kiem theo ma mon hoc");
			System.out.println("\t0.Quay lai");
			System.out.print("Nhap lua chon cua ban: ");
			int chon = Integer.parseInt(sc.nextLine());
			switch(chon) {
			case 1:timTheoMaSV();break;
			case 2:timTheoMaM();break;
			case 0:
				return;
			default:
				System.out.println("Lua chon khong hop le!");
			}
		}while(true);
	}

	private static void timTheoMaSV() {
		System.out.println("\n============CHUC NANG TIM KIEM THEO MA SINH VIEN==================");
		System.out.print("Nhap ma sinh vien: ");
		int stt=1;
		double tongDiem=0;
		double tongHeSo=0;
		int ma = Integer.parseInt(sc.nextLine());
		int index = QLSV.indexOf(ma);
		if(index == -1) {
			System.out.println("Sinh vien khong co trong danh sach!");
			return;
		}
		System.out.println("Ten sinh vien: "+QLSV.hoDem(ma)+" "+QLSV.ten(ma));
		System.out.println("\n======BANG DIEM=========");
		System.out.printf("%3s %6s %-23s %5s %4s %n","STT","Ma mon","Ten mon","He so","Diem");
		for(int j=0;j<QLD.list.size();j++) {
			if(QLD.list.get(j).getMaSV()==ma) {
				System.out.printf("%-3d",stt++);
				System.out.printf("%6d %-23s %5.1f %4.2f %n",QLD.list.get(j).getMaM(),
						QLMH.tenMon(QLD.list.get(j).getMaM()),QLMH.heSo(QLD.list.get(j).getMaM()),
						QLD.list.get(j).getDiem());
				if(QLD.list.get(j).getMaSV()==ma) {
					tongDiem+=QLD.list.get(j).getDiem()*QLMH.heSo(QLD.list.get(j).getMaM());
					tongHeSo+=QLMH.heSo(QLD.list.get(j).getMaM());
				}	
			}
		}
		if(stt==1) {
			System.out.println("Sinh vien chua hoc mon nao!");
			return;
		}
		System.out.printf("Diem tong ket: %.2f%n",tongDiem/tongHeSo);
	}

	private static void timTheoMaM() {
		System.out.println("\n============CHUC NANG TIM KIEM THEO MA MON HOC==================");
		System.out.print("Nhap ma mon hoc: ");
		int stt=1;
		int dem=0;
		double tong=0;
		int ma = Integer.parseInt(sc.nextLine());
		int index = QLMH.indexOf(ma);
		if(index == -1) {
			System.out.println("Mon hoc khong co trong danh sach!");
			return;
		}
		System.out.println("Ten mon hoc: "+QLMH.tenMon(ma));
		for(int j=0;j<QLD.list.size();j++) {
			if(QLD.list.get(j).getMaM()==ma) {
				tong+=QLD.list.get(j).getDiem();
				dem++;
			}
		}
		System.out.printf("Diem trung binh chung: %.2f",tong/dem);
		System.out.println("\n===============DANH SACH SINH VIEN================");
		System.out.printf("%3s %-12s %-23s %4s %n","STT","Ma sinh vien","Ten sinh vien","Diem");
		for(int k=0;k<QLD.list.size();k++) {
			if(QLD.list.get(k).getMaM()==ma) {
				System.out.printf("%-3d",stt++);
				System.out.printf("%-12d %13s %-10s %4.2f %n",QLD.list.get(k).getMaSV(),
				QLSV.hoDem(QLD.list.get(k).getMaSV()),QLSV.ten(QLD.list.get(k).getMaSV()),QLD.list.get(k).getDiem());
			}
			
		}
		if(stt==1) {
			System.out.println("Mon hoc chua co sinh vien nao hoc!");
		}
	}
}
