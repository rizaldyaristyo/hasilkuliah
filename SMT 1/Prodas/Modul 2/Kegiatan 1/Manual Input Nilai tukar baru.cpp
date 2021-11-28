#include <stdio.h>

int hitungrpa(int nim4){
	float rpa;
	rpa = nim4*8;
	
	return rpa;	
}

long long int hitungrpb(int nim5){
	double rpb;
	rpb=nim5-12345;
	
	return rpb;	
}

int hitungrpc(long long nim15){
	double rpc;
	rpc=nim15/23456789;
	
	return rpc;	
}

float konversidolar(float rp){
	double dolar;
	dolar=rp/14755.65;
	
	return dolar;
}

float konversieuro(float rp){
	double euro;
	euro=rp/17240.50;
	
	return euro;
}

float konversiringgit(float rp){
	double ringgit;
	ringgit=rp/3518.62;
	
	return ringgit;
}

int main(){
	long long int nim15; // = 202010370311440LL; // = 201910370311340LL;
	
	printf("NIM: ");
	scanf("%I64d", &nim15);
	
	long long int nim4 = nim15%10000LL;
	long long int nim5 = nim15/10000000000LL;
	double dolara, euroa, ringgita;

	// printf("NIM4 : %I64d\n", nim4);
	// printf("NIM5 : %I64d\n", nim5);
	// printf("NIM15: %I64d\n", nim15);
	
	float rp = hitungrpa(nim4);
	printf("\nKonversi Rupiah A adalah %.0lf rupiah sama dengan: ", rp);
	
	dolara = konversidolar(rp);
	printf(" \n %.2f dolar\n", dolara);
	
	euroa = konversieuro(rp);
	printf(" %.2f euro\n", euroa);
	
	ringgita = konversiringgit(rp);
	printf(" %.2f ringgit\n", ringgita);
	
	
	rp = hitungrpb(nim5);
	printf("\nKonversi Rupiah B adalah %.0lf rupiah sama dengan: ", rp);
	
	dolara = konversidolar(rp);
	printf(" \n %.2f dolar\n", dolara);
	
	euroa = konversieuro(rp);
	printf(" %.2f euro\n", euroa);
	
	ringgita = konversiringgit(rp);
	printf(" %.2f ringgit\n", ringgita);
	
	
	rp = hitungrpc(nim15);
	printf("\nKonversi Rupiah C adalah %.0lf rupiah sama dengan: ", rp);
	
	dolara = konversidolar(rp);
	printf(" \n %.2f dolar\n", dolara);
	
	euroa = konversieuro(rp);
	printf(" %.2f euro\n", euroa);
	
	ringgita = konversiringgit(rp);
	printf(" %.2f ringgit\n", ringgita);
	
}	



