import java.util.Scanner;

public class Loto{
public static void main(String[] args) {
	 Scanner s = new Scanner(System.in);

	 int[] dizi = new int[6];            
	 
	 System.out.println("Kolon say�s�n� giriniz"); 
	 	int kolon = s.nextInt();

	 while(kolon == 0 || kolon>8) {
		 if(kolon==0) {
		 System.out.println("L�tfen 0�dan b�y�k bir tamsay� giriniz"); 
		 	kolon = s.nextInt(); 
		 }else if(kolon>8) {
			 System.out.println("L�tfen 8�dan k���k bir tamsay� giriniz"); 
			 	kolon = s.nextInt(); 
	 }}
	 
	 for (int i = 1; i <= kolon; i++) {
		 System.out.print(i + ". Kolon"+ " "); 
	 for (int j = 0; j <= 5; j++) {
		 dizi[j] = (int)(Math.random()*11);
		 for(int b=0;b<dizi.length;b++) {
			 if(dizi[j]==dizi[b]) {
				 dizi[j] = (int)(Math.random()*50);

			 }
		 }
		 
		 System.out.print(dizi[j] + " ");
	 }
	 System.out.println("");
	 }
	 
}
}