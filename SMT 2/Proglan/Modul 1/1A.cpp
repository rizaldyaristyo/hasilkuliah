#include <stdio.h>
#define banyak 9

int main(){
	int arr[banyak] = {1,2,3,4,5,6,7,8,9};
	int i=0, ganjil=0, genap=0, total;
	
	while(i<banyak){
		printf("i=%d",arr[i]);
		if(arr[i]%2==0){
			genap++;
			printf("	<<------ genap\n");
		}else{
			ganjil++;
			printf("	<<------ ganjil\n");
		}
		total = genap+ganjil;
		i++;
	}
	printf("Jumlah Bilangan Ganjil = %d\n", ganjil);
	printf("Jumlah Bilangan Genap = %d\n", genap);
	printf("Total = %d\n", total);
	
}