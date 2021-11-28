#include <stdio.h>
#include <string.h>

char NIM[16],NIMcpy[9],IFNIM[9]={'1','0','3','7','0','3','1','1','\0'};
int cmpNIM=0;

int main(){
	awal:
	printf("Input NIM 	: ");
	scanf("%s", NIM);
	if(strlen(NIM) < 15)
	{
		printf("!!! NIM terdeteksi kurang dari 15 digit !!!\n\n");
		goto awal;
	}
	else if(strlen(NIM) > 15)
	{
		printf("!!! NIM terdeteksi lebih dari 15 digit !!!\n\n");
		goto awal;
	}
	
	strncpy(NIMcpy,&NIM[4],8);
	cmpNIM = strcmp(IFNIM,NIMcpy);
	//printf("\nNIMcpy: %s\n",NIMcpy);
	
	if(cmpNIM==0){
		printf("NIM Informatika Diterima!\n");
		printf("\tNIM yang diinputkan: %s\n\n",NIM);
		getchar();
		goto awal;
	}else{
		printf("!!! NIM yang dimasukkan khusus NIM Informatika !!!\n\n");
		goto awal;
	}
}
