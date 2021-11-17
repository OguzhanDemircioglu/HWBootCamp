import java.util.Scanner;


public class ArraySizeDuplicate {

	public static void main(String[] args) {
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
			if( dizi[i] > dizi[j] ) {
				temp = dizi[i];
                dizi[i] = dizi[j];
                dizi[j]= temp;
			}}}
		
		int length = dizi.length;
		length = removeDuplicateElements(dizi, length);
		
		System.out.println("Yeni Dizi");
		for(int i=0; i < length;i++) {
			System.out.println(dizi[i]);
	}}
	public static int removeDuplicateElements(int arr[], int n){  
        if (n==0 || n==1){  
            return n;  
        }  
        int[] temp = new int[n];  
        int j = 0;  
        for (int i=0; i<n-1; i++){  
            if (arr[i] != arr[i+1]){  
                temp[j++] = arr[i];  
            }  
         }  
        temp[j++] = arr[n-1];     
        // Changing original array  
        for (int i=0; i<j; i++){  
            arr[i] = temp[i];  
        }  
        return j;  
    }  
	
}
