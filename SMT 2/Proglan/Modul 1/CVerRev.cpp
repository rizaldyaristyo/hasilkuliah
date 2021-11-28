#include <stdio.h>
#include <string.h>

char NIM[16],NIMcpy[9],IFNIM[9]={'1','0','3','7','0','3','1','1','\0'};
int cmpNIM=0;

int main(){
	awal:
	try{
		printf("Input NIM 	: ");
		scanf("%s", NIM);
		if(strlen(NIM) < 15)
		{
			throw 10;
		}
		else if(strlen(NIM) > 15)
		{
			throw 'a';
		}
		strncpy(NIMcpy,&NIM[4],8);
		cmpNIM = strcmp(IFNIM,NIMcpy);
		//printf("\nNIMcpy: %s\n",NIMcpy);
		
		if(cmpNIM==0){
			printf("NIM Informatika Diterima!\n");
			printf("\tNIM yang diinputkan: %s\n\n",NIM);
		}else{
			short c=10;
			throw (c);
		}
	}catch(int a){
			printf("!!! NIM terdeteksi kurang dari 15 digit !!!\n\n");
			goto awal;
	}catch(char b){
			printf("!!! NIM terdeteksi lebih dari 15 digit !!!\n\n");
			goto awal;
	}catch(short c){
			printf("!!! NIM yang dimasukkan khusus NIM Informatika !!!\n\n");
			goto awal;
	}
	return 0;
}
