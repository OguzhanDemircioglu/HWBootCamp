import java.util.Scanner;


public class ArraySort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);

		System.out.println("Kaç haneli dizi oluþturmak istiyorsunuz");
		int DiziSayisi=scan.nextInt();
		
		int dizi[] = new int[DiziSayisi];
		System.out.println("Dizi sayýlarýný girin");
		
		for(int i=0; i < dizi.length;i++) {
			dizi[i]=scan.nextInt();
		}
		
		System.out.println("Sizin Diziniz:");
			for(int i=0; i < dizi.length;i++) {
				System.out.println(dizi[i]);
		}
		
		int temp=0;
			
		for(int i=0;i<dizi.length;i++ ) {
			for(int j=i+1;j<dizi.length;j++) {
			if( dizi[i] < dizi[j] ) {
				temp = dizi[i];
	            dizi[i] = dizi[j];
	            dizi[j]= temp;
			}
		}}
		System.out.println("Dizin Büyükten Küçüðe sýralandý");
		for(int i=0; i < dizi.length;i++) {
			System.out.println(dizi[i]);}
		
	}}
