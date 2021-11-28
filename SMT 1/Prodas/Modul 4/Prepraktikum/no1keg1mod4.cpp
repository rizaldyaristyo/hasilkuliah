#include <stdio.h>

int main(void)
{
	
	char karakter1, karakter2, karakter3;
	
	printf("Input 3 karakter sembarang \n");
	
	printf("Karakter pertama: ");
	scanf(" %c",&karakter1);
	printf("Karakter kedua: ");
	scanf(" %c",&karakter2);
	printf("Karakter ketiga: ");
	scanf(" %c",&karakter3);
	
	// tampilkan karakter dengan urutan terbalik
	printf("\n");
	printf("karakter yang diinput adalah: %c \n", karakter3);
	printf("karakter yang diinput adalah: %c \n", karakter2);
	printf("karakter yang di input adalah: %c \n", karakter1);
	
	printf("\n");
	return 0;
}