#include <stdio.h>
#include <string.h>

int main(){
	char namaDepan[20], namaBelakang[20], nim[20];
	
	printf("Input Data Anda\n");
	printf("Masukkan Nama Depan : ");
	scanf("%s", namaDepan);
	printf("Masukkan Nama Belakang : ");
	scanf("%s", namaBelakang);
	reinput:
	printf("Masukkan Nim : ");
	scanf("%s", nim);

	int nimlen=strlen(nim);
	if (nimlen!=15){
		printf("\nNim harus berjumlah 15 digit \n");
		goto reinput;
	}
	
	char namaLengkap[20];
	strcpy(namaLengkap,namaDepan);
	strcat(namaLengkap,namaBelakang);
	
	printf("\nSelamat %s, Data kamu berhasil dibuat\n", namaDepan);
	printf("=================\n");
	printf("Nama Lengkap : %s\n", namaLengkap);
	printf("Nim: %s\n", nim);
	printf("=================\n\n");

}