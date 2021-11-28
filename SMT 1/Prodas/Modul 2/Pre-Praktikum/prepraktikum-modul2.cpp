	#include <stdio.h>

int calcare	(int hektare){
	int are;
	are = hektare * 100;
	
	return are;
}
	
int calcm (int are){
	int m_persegi;
	m_persegi = are * 100;
	
	return m_persegi;
}

int calccm (int m_persegi){
	int cm_persegi;
	cm_persegi = m_persegi * 10000;
	
	return cm_persegi;
}


int main(){
	int hektare, are, m_persegi, cm_persegi;
	
	printf("Masukkan satuan luas dalam hektare: ");
	scanf("%d", &hektare);
	printf("konversi satuan luas %d hektare sama dengan : ", hektare);
	
	are = calcare(hektare);
	m_persegi = calcm(are);
	cm_persegi = calccm(m_persegi);
	
	printf("\n %d are \n %d meter persegi \n %d centimeter persegi \n",are , m_persegi, cm_persegi);
	
	return 0;
}
	