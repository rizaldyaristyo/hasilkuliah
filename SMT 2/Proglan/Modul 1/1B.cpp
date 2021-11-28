#include <stdio.h>
#define arrlen 9
int wanted=9;

int find(int x, int arr[arrlen]){
	int i=0, ada=0;
	printf("Search for \"%d\"",wanted);
	while(i < arrlen){
		printf("\n%d",arr[i]);
		if (arr[i] == x){
			printf("  <<-------- found \"%d\" @arr[%d] ",arr[i],i);
			ada++;
		}
		i++;
	}
	if(ada==0){
		return 0;
	}else{
	   	return -1;
	}
}

int main(){
	int arr[arrlen] = {1,2,3,4,5,6,7,8,9};
	if(find(wanted,arr) == -1) puts("\n\nAngka ada di array!");
	else puts("\nAngka tidak ada di array!");
	return 0;
}
