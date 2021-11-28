#include <stdio.h>

int main(){
	int arr[9] = {1,2,3,4,5,6,7,8,9};
	int i=0, ganjil, genap, total;
	
	while(i<=9){
		printf("i=%d\n",i);
		if(arr[i]%2==0){ ganjil = arr[i];}
		if(arr[i]/2==0){ genap += arr[i];}
		total += arr[i];
		i++;
	}
	
	printf("Jumlah Bilangan Ganjil = %d\n", ganjil);
	printf("Jumlah Bilangan Genap = %d\n", genap);
	printf("Total = %d\n", total);
	
}