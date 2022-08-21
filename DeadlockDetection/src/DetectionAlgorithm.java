import java.util.Scanner;

public class DetectionAlgorithm {


	public static int ProccessCount /* n */ , ResourceInstanceCount /* r */;
	public static int ReqMatrix[][];// reaquest matrixi
	public static int Alloc[][]; // allocation matrixi
	public static int Resource[]; // kaynak matrisi kaynak bilgilerini alacağız
	public static int Work[]; // W = Tahsis - Kaynak;
	public static boolean finish[];
	/*
	 * programın çalıştığı ana main methodu
	 */
	public static void main(String[] args) {
		System.out.println("Deadlock karnai Kilitlenme Algoritmasi");
		input();
		show();
		cal();
	}

	/*
	 * Programın çalışması için gerekli matrisleri alır
	 */
	public static void input() {
		Scanner input = new Scanner(System.in);// kalvyeden giriş işlemleri için Scanner nesnesini tanımladık

		System.out.print("Proccess Sayisini Giriniz :");
		ProccessCount = input.nextInt();// Proccess sayısını kalvyeden alırıc bu değişkene

		System.out.print("\nKaynak Adedini Giriniz :");
		ResourceInstanceCount = input.nextInt();

		ReqMatrix = new int[ProccessCount][ResourceInstanceCount];
		Alloc = new int[ProccessCount][ResourceInstanceCount];
		Resource = new int[ResourceInstanceCount];
		Work = new int[ResourceInstanceCount];

		System.out.println("Request Matrixi Giriniz :");
		for (int i = 0; i < ProccessCount; i++) {
			for (int j = 0; j < ResourceInstanceCount; j++) {
				ReqMatrix[i][j] = input.nextInt(); // Request Matrisini alıyoruz klavyeden
			}
		}

		System.out.println("Allocation Matrix Giriniz :");
		for (int i = 0; i < ProccessCount; i++) {
			for (int j = 0; j < ResourceInstanceCount; j++) {
				Alloc[i][j] = input.nextInt(); // Allocation Matrisini alıyoruz klavyeden
			}
		}

		System.out.println("Mevcut Kaynagi Giriniz :");
		for (int j = 0; j < ResourceInstanceCount; j++) {
			Resource[j] = input.nextInt(); // Mevcut Kaynağı alıyoruz klavyeden
		}

		input.close();
	}

	public static void show() {
		System.out.print("Process\t Allocation\t Request\t Resource\t");
		for (int i = 0; i < ProccessCount; i++) {

			System.out.print("\nP" + (i + 1) + "\t");
			for (int j = 0; j < ResourceInstanceCount; j++) {
				System.out.print(Alloc[i][j] + " ");
			}
			System.out.print("\t\t");
			for (int j = 0; j < ResourceInstanceCount; j++) {
				System.out.print(ReqMatrix[i][j] + " ");
			}
			System.out.print("\t\t");
			if (i == 0) {
				for (int j = 0; j < ResourceInstanceCount; j++) {
					System.out.print(Resource[j] + " ");
				}
			}
		}
	}

	public static void cal() {
		 finish = new boolean[ProccessCount];
		int dead[] = new int[ProccessCount];

		// kaynak adedi kadar finish vektörüne false değerini atıyoruz
		for (int i = 0; i < ResourceInstanceCount; i++) {
			finish[i] = false;// burda derste anlatıldığı gibi finish matrisini öncelikle false olarak
								// dolduruyoruz kilitlenmeleri bulmak için kullanacağız
		}

		// burda work vektörünü bulacağız (Work = Allocation - Kaynak )
		int allocSum = 0;
		for (int i = 0; i < ResourceInstanceCount; i++) {
			for (int j = 0; j < ProccessCount; j++) {
				allocSum += Alloc[j][i];
			}
			Work[i] = Math.abs(Resource[i] - allocSum);
			allocSum = 0;
		}

 		// burda asıl hesaplama işlerini yapacağız
		for (int i = 0; i < ProccessCount; i++) {
			int sayac=0;
			for (int j = 0; j < ResourceInstanceCount; j++) {
				if (finish[i] == false) {
					if (ReqMatrix[i][j] <= Work[j]) {// buraya eğer 3 kere doğru dönerse alt işleme devam edecek
						sayac++;						
						if(sayac == ResourceInstanceCount) {
							Calc(i);
						}
					} else {
						break;
					}
				} else {
					break;
				}
			}
		}

		int j = 0;
		boolean flag = false;
		for (int i = 0; i < ProccessCount; i++) {
			if (finish[i] == false) {
				dead[j] = i;
				j++;
				flag = true;
			}
		}
		if (flag) {
			System.out.print("\n\nSistemde Kilitlenme var ve Kilitlenme surecleri\n");
			for (int i = 0; i < ProccessCount; i++) {
				if (finish[i] == false) {
					// System.out.print("P" + dead[i] + "\t");
					System.out.print("P" + i + "\t");
				}
			}
		} else {
			System.out.println("Deadlock Kilitlenme Yoktur.");
		}
	}

	private static void Calc(int i) {
		finish[i] = true;
		for (int k = 0; k < ResourceInstanceCount; k++) {
			Work[k] = Alloc[i][k] + Work[k];
		}	
	}
	
}
