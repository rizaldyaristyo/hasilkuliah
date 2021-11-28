#include <stdio.h>

int find(int x, int arr[8]){
	int i;
	
	while( i < 100){
		if (arr[1] == x){
			printf("\narr[1]==x nih\n");
		}
	}
	return -1;
}

int main(){
	int x;
	int arr[8] = {1,2,3,4,5,6,7,8,9};
	if(find(9,arr) == -1) puts("Angka ada di array!");
	puts("Angka tidak ada di array!");
	return 0;
}
