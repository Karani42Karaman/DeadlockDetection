
import java.util.*;

public class Main {

	public static int ArrMax[][] = new int[100][100];
	public static int Alloc[][] = new int[100][100];
	public static int Need[][] = new int[100][100];
	public static int Avail[] = new int[100];
	public static int ProccessCount /* n */ , ResourceInstanceCount /* r */;

	public static void main(String[] args) {
		System.out.println("Deadlock Kilitlenme Algoritmasi");
		input();
		show();
		cal();
	}

	public static void input() {
		Scanner input = new Scanner(System.in);// kalvyeden giriş işlemleri için Scanner nesnesini tanımladık

		System.out.print("Proccess Sayisini Giriniz :");
		ProccessCount = input.nextInt();// Proccess sayısını kalvyeden alırıc bu değişkene

		System.out.print("\nKaynak Adedini Giriniz :");
		ResourceInstanceCount = input.nextInt();

		System.out.println("Max Matrix Giriniz :");
		for (int i = 0; i < ProccessCount; i++) {
			for (int j = 0; j < ResourceInstanceCount; j++) {
				ArrMax[i][j] = input.nextInt(); // Max Matrisini alıyoruz klavyeden
			}
		}

		System.out.println("Allocation Matrix Giriniz :");
		for (int i = 0; i < ProccessCount; i++) {
			for (int j = 0; j < ResourceInstanceCount; j++) {
				Alloc[i][j] = input.nextInt(); // Allocation Matrisini alıyoruz klavyeden
			}
		}

		System.out.println("Mevcut Kaynağı Giriniz :");
		for (int j = 0; j < ResourceInstanceCount; j++) {
			Avail[j] = input.nextInt(); // Mevcut Kaynağı alıyoruz klavyeden
		}

		input.close();
	}

	public static void show() {
		System.out.print("Process\t Allocation\t Max\t Available\t");
		for (int i = 0; i < ProccessCount; i++) {

			System.out.print("\nP" + (i + 1) + "\t");
			for (int j = 0; j < ResourceInstanceCount; j++) {
				System.out.print(Alloc[i][j] + " ");
			}
			System.out.print("\t\t");
			for (int j = 0; j < ResourceInstanceCount; j++) {
				System.out.print(ArrMax[i][j] + " ");
			}
			System.out.print("\t");
			if (i == 0) {
				for (int j = 0; j < ResourceInstanceCount; j++) {
					System.out.print(Avail[j] + " ");
				}
			}
		}

	}

	public static void cal() {
		int finish[] = new int[100];
		int need[][] = new int[100][100];
		int j;
		boolean flag = true;// başlangıç değeri
		int dead[] = new int[100];

		for (int i = 0; i < ResourceInstanceCount; i++) {
			finish[i] = 0;// burdaki 1 ve sıfır lar true false düşünülecek 1 = true vs 0 = false gibi
		}
		// need matrix i ni bulacağız
		for (int i = 0; i < ProccessCount; i++) {
			for (  j = 0; j < ResourceInstanceCount; j++) {
				need[i][j] = ArrMax[i][j] - Alloc[i][j];
			}
		}
		while (flag) {
			flag=false;
			for (int i = 0; i < ProccessCount; i++) {
				int c = 0;
				for (  j = 0; j < ResourceInstanceCount; j++) {

					if ((finish[i] == 0) && (need[i][j] <= Avail[j])) {
						c++;
						if (c == ResourceInstanceCount) {
							for (int k = 0; k < ResourceInstanceCount; k++) {
								Avail[k] += Alloc[i][j];
								finish[k] = 1;
								flag = true;
							}
							System.out.print("P" + i);
							if (finish[i] == 1) {
								i = ProccessCount;
							}
						}
					}
				}
			}
		}
		
		j=0;
		flag = false;
		for (int i = 0; i < ProccessCount; i++) {
			if(finish[i] == 0) {
				dead[j] = i;
				j++;
				flag = true;
			}
		}
		if(flag) {
			System.out.print("\n\nSistemde Kilitlenme var ve Kilitlenme sürecleri\n");
			for (int i = 0; i < ProccessCount; i++) {
				System.out.print("P"+dead[i]+"\t");
			}
		}else {
			System.out.println("Deadlock Kilitlenme Yoktur.");
		}
		
		
		
		
	}
}
