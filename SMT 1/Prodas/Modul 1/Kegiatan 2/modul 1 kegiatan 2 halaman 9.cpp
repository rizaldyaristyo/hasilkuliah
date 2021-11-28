#include <stdio.h>

int nilai1,nilai2,nilai3,ratarata;
float nilaiakhir;
const float a = .04;

int main(){
	printf ("\t\t>>> NILAI PRAKTIKUM <<<\n\n");
	
	printf("Masukkan nilai 1 : ");
	scanf("%i", &nilai1);
	printf("Masukkan nilai 2 : ");
	scanf("%i", &nilai2);
	printf("Masukkan nilai 3 : ");
	scanf("%i", &nilai3);
	printf("nilai akhir 4 persen dari rata rata nilai yang diperoleh\n\n");
	
	ratarata = (nilai1 + nilai2 + nilai3) / 3;
	printf("rata-rata nilai yang kamu peroleh adalah : %i\n", ratarata);;
	nilaiakhir = ratarata * a;
	printf("nilai akhir yang kamu peroleh adalah : %0.1f\n", nilaiakhir);
	
	
	return 0;
}