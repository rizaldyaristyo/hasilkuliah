#include <stdio.h>
int hitungrpa(int nim4){float rpa;rpa = nim4*8;return rpa;}
int hitungrpb(int nim5){double rpb;rpb=nim5-12345;return rpb;}
int hitungrpc(long long nim15){double rpc;rpc=nim15/23456789;return rpc;}
float konversidolar(float rp){double dolar;dolar=rp/14684.0;return dolar;}
float konversieuro(float rp){double euro;euro=rp/17290.0;return euro;}
float konversiringgit(float rp){double ringgit;ringgit=rp/3573.0;return ringgit;}
int main(){long long int nim15 = 201910370311340LL;int nim4 = 1340, nim5 = 20191;
double dolara, euroa, ringgita;printf("NIM: %I64d\n", nim15);float rp = hitungrpa(nim4);
printf("\nKonversi Rupiah A adalah %.0lf rupiah sama dengan: ", rp);dolara = konversidolar(rp);
printf(" \n %.2f dolar\n", dolara);euroa = konversieuro(rp);printf(" %.2f euro\n", euroa);
ringgita = konversiringgit(rp);printf(" %.2f ringgit\n", ringgita);rp = hitungrpb(nim5);
printf("\nKonversi Rupiah B adalah %.0lf rupiah sama dengan: ", rp);dolara = konversidolar(rp);
printf(" \n %.2f dolar\n", dolara);euroa = konversieuro(rp);printf(" %.2f euro\n", euroa);
ringgita = konversiringgit(rp);printf(" %.2f ringgit\n", ringgita);rp = hitungrpc(nim15);
printf("\nKonversi Rupiah C adalah %.0lf rupiah sama dengan: ", rp);dolara = konversidolar(rp);
printf(" \n %.2f dolar\n", dolara);euroa = konversieuro(rp);printf(" %.2f euro\n", euroa);
ringgita = konversiringgit(rp);printf(" %.2f ringgit\n", ringgita);}