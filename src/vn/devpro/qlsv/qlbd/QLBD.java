package vn.devpro.qlsv.qlbd;


import java.util.Scanner;


import vn.devpro.qlsv.qld.QLD;
import vn.devpro.qlsv.qlmh.QLMH;
import vn.devpro.qusv.qlsv.QLSV;


public class QLBD {
	
	static Scanner sc = new Scanner(System.in);
	
	public static void quanLyBangDiem() {
		do {
			System.out.println("\n=====================CHUC NANG HIEN THI BANG DIEM=======================");
			System.out.println("Hay chon mot chuc nang");
			System.out.println("\t1.Hien thi bang diem cua tat ca sinh vien");
			System.out.println("\t2.Hien thi bang diem cua mon hoc");
			System.out.println("\t0.Quay lai");
			System.out.print("Nhap lua chon cua ban: ");
			int chon=Integer.parseInt(sc.nextLine());
			switch(chon) {
			case 1:hienThiDiemSV();break;
			case 2:hienThiDiemMon();break;
			case 0:
				return;
			default:
				System.out.println("Lua chon khong hop le!");
			}
		}while(true);
	}

	private static void hienThiDiemSV() {
		System.out.println("\n=================HIEN THI DIEM SINH VIEN===============");
		for(int i=0;i<QLSV.list.size();i++) {
			int stt=1;
			double tongDiem=0;
			double tongHeSo=0;
			System.out.println("Ma sinh vien: "+QLSV.list.get(i).getMaSV());
			System.out.println("Ho va ten: "+QLSV.list.get(i).getHoDem()+" "+QLSV.list.get(i).getTen());
			System.out.println("\n======BANG DIEM=========");
			System.out.printf("%3s %6s %-23s %5s %4s %n","STT","Ma mon","Ten mon","He so","Diem");
			for(int j=0;j<QLD.list.size();j++) {
				if(QLD.list.get(j).getMaSV()==QLSV.list.get(i).getMaSV()) {
					System.out.printf("%-3d",stt++);
					System.out.printf("%6d %-23s %5.1f %4.2f %n",QLD.list.get(j).getMaM(),
							QLMH.tenMon(QLD.list.get(j).getMaM()),QLMH.heSo(QLD.list.get(j).getMaM()),
							QLD.list.get(j).getDiem());
					if(QLD.list.get(j).getMaSV()==QLSV.list.get(i).getMaSV()) {
						tongDiem+=QLD.list.get(j).getDiem()*QLMH.heSo(QLD.list.get(j).getMaM());
						tongHeSo+=QLMH.heSo(QLD.list.get(j).getMaM());
					}	
				}
			}
			if(stt==1) {
				System.out.println("Sinh vien chua hoc mon nao!");
				System.out.println("--------------------------------------------------");
				continue;
			} 
			System.out.printf("Diem tong ket: %.2f%n",tongDiem/tongHeSo);
			System.out.println("--------------------------------------------------");
		}
	}
	private static void hienThiDiemMon() {
		System.out.println("\n===============HIEN THI DIEM MON HOC================");
		for(int i=0;i<QLMH.list.size();i++) {
			int stt=1;
			int dem=0;
			double tong=0;
			System.out.println("Ma mon hoc: "+QLMH.list.get(i).getMaMon());
			System.out.println("Ten mon hoc: "+QLMH.list.get(i).getTenMon());
			for(int j=0;j<QLD.list.size();j++) {
				if(QLD.list.get(j).getMaM()==QLMH.list.get(i).getMaMon()) {
					tong+=QLD.list.get(j).getDiem();
					dem++;
				}
			}
			System.out.printf("Diem trung binh chung: %.2f",tong/dem);
			System.out.println("\n===============DANH SACH SINH VIEN================");
			System.out.printf("%3s %-12s %-23s %4s %n","STT","Ma sinh vien","Ten sinh vien","Diem");
			for(int k=0;k<QLD.list.size();k++) {
				if(QLMH.list.get(i).getMaMon()==QLD.list.get(k).getMaM()) {
					System.out.printf("%-3d",stt++);
					System.out.printf("%-12d %13s %-10s %4.2f %n",QLD.list.get(k).getMaSV(),
					QLSV.hoDem(QLD.list.get(k).getMaSV()),QLSV.ten(QLD.list.get(k).getMaSV()),QLD.list.get(k).getDiem());
				}
				
			}
			if(stt==1) {
				System.out.println("Mon hoc chua co sinh vien nao hoc!");
				System.out.println("--------------------------------------------------");
				continue;
			}
			System.out.println("--------------------------------------------------");
		}
	}
}
