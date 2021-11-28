#include <stdio.h>

int hitungrpa(int nim4){
	float rpa;
	rpa = nim4*8;
	
	return rpa;	
}

int hitungrpb(int nim5){
	double rpb;
	rpb=nim5-12345;
	
	return rpb;	
}

int hitungrpc(long long nim15){
	double rpc;
	rpc=nim15/23456789;
	
	return rpc;	
}

int main(){
	long long int nim15 = 201910370311340LL;
	int nim4 = 1340, nim5 = 20191;
	double dolara, dolarb, dolarc, euroa, eurob, euroc, ringgita, ringgitb, ringgitc;
	printf("NIM: %I64d\n", nim15);
	int rpa = hitungrpa(nim4);
	int rpb = hitungrpb(nim5);
	int rpc = hitungrpc(nim15);
	
	printf("\nKonversi Rupiah A adalah %d rupiah sama dengan: ", rpa);
	dolara = rpa/14684.0;
	printf(" \n %.2f dolar\n", dolara);
	euroa = rpa/17290.0;
	printf(" %.2f euro\n", euroa);
	ringgita = rpa/3573.0;
	printf(" %.2f ringgit\n", ringgita);
	
	printf("\nKonversi Rupiah B adalah %d rupiah sama dengan: ", rpb);
	dolarb = rpb/14684.0;
	printf(" \n %.2f dolar\n", dolarb);
	eurob = rpb/17290.0;
	printf(" %.2f euro\n", eurob);
	ringgitb = rpb/3573.0;
	printf(" %.2f ringgit\n", ringgitb);
	
	printf("\nKonversi Rupiah C adalah %d rupiah sama dengan: ", rpc);
	dolarc = rpc/14684.0;
	printf(" \n %.2f dolar\n", dolarc);
	euroc = rpc/17290.0;
	printf(" %.2f euro\n", euroc);
	ringgitc = rpc/3573.0;
	printf(" %.2f ringgit\n", ringgitc);
	
}	


