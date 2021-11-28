#include <stdio.h>
#include <stdlib.h>
#define EXIT_SUCCESS 0

char noHp[12];

char pulsa[5][10] = {"5000","10000","20000","15000","50000"};
int pulsaInput;

void login();
void cekNomorHp();
void cekPulsa();
void berhasil();
void dafftarPulsa();

int main(){
	login();
	return 0;
}

void login(){
	printf("Masukkan Nomor HP : ");
	gets(noHp);
	cekNomorHp();
	dafftarPulsa();
	printf("Masukkan Pulsa : ");
	scanf("%d",&pulsaInput);
	cekPulsa();
	berhasil();
}

void cekNomorHp(){
	for(int i = 0; i < 12; i++){
		if(!noHp[i]){
			printf("Nomor Hp yang dimasukan salah\n\n");
			login();
		}
	}
}

void cekPulsa(){
	for(int i = 0; i <= 5; i++){
		if(pulsaInput==1||pulsaInput==2||pulsaInput==3||pulsaInput==4||pulsaInput==5){
			break;
		}else{
			printf("Pulsa tidak ada\n\n");
			login();
		}
	}
}

void berhasil(){
	printf("\nSelamat transaksi berhasil");
	exit(EXIT_SUCCESS);
}

void dafftarPulsa(){
	printf("\nDaftar Pulsa :\n");
	for(int i = 0; pulsa[1][i] != '\0'; i++){
		printf("%d. %s\n", i+1, pulsa[i]);
	}
}