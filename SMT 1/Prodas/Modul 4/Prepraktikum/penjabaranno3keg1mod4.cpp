#include <stdio.h>
int main()
{
	char karakter[4];
	int i;
	
	printf("Masukkan 4 karakter sembarang : ");;
	
	/*
	for(i=0;i<=4;i=i+1)
	{
		scanf("%c",&karakter[i]);
	}
	*/ 
	
	// penjabaran
	scanf("%c",&karakter[0]);
	scanf("%c",&karakter[1]);
	scanf("%c",&karakter[2]);
	scanf("%c",&karakter[3]);
	
	/*
	printf("\n\nkarakter dalam urutan terbalik : \n");
	for (i=4-1;i>=0;i=i-1)
	{
		printf("%c\t", karakter[i]);
	}
	*/
	
	// penjabaran
	printf("%c\t", karakter[3]);
	printf("%c\t", karakter[2]);
	printf("%c\t", karakter[1]);
	printf("%c\t", karakter[0]);
	
	printf("\n");
	printf("%c\t", karakter[4]);
	return 0;
}