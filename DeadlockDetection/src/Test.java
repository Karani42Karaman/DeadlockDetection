import java.util.Scanner;

public class Test {

	public static int ReqMatrix[][] = new int[100][100];// reaquest matrixi
	public static int Alloc[][] = new int[100][100]; // allocation matrixi
	public static int Resource[] = new int[100]; // work matrisi kaynak bilgilerini alacağız
	public static int ProccessCount /* n */ , ResourceInstanceCount /* r */;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);// kalvyeden giriş işlemleri için Scanner nesnesini tanımladık

		System.out.print("Proccess Sayisini Giriniz :");
		ProccessCount = input.nextInt();// Proccess sayısını kalvyeden alırıc bu değişkene

		System.out.print("\nKaynak Adedini Giriniz :");
		ResourceInstanceCount = input.nextInt();

		 

		System.out.println("Allocation Matrix Giriniz :");
		for (int i = 0; i < ProccessCount; i++) {
			for (int j = 0; j < ResourceInstanceCount; j++) {
				Alloc[i][j] = input.nextInt(); // Allocation Matrisini alıyoruz klavyeden
			}
		}

		 

		input.close();
		
		
		
		
		
		
		System.out.print("Process\t Allocation\t Request\t Resource\t");
		for (int i = 0; i <ResourceInstanceCount ; i++) {

			System.out.print("\nP" + (i + 1) + "\t");
			for (int j = 0; j <ProccessCount ; j++) {
				System.out.print(Alloc[j][i] + " ");
			}
			 
		}
		
		
		

	}

}
