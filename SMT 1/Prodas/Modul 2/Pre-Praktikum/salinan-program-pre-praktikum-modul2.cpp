#include <stdio.h>

int main(){
	int hektare, are, m_persegi, cm_persegi;
	
	printf("Masukkan satuan luas dalam hektare: ");
	scanf("%d", &hektare);
	
	are = hektare * 100;
	m_persegi = are * 100;
	cm_persegi = m_persegi * 10000;
	
	printf("konversi satuan luas adalah %d hektare sama dengan : ", hektare);
	printf("\n %d are%d meter persegi \n %d centimeter persegi\n", are, m_persegi, cm_persegi);
	
	return 0;
}
	