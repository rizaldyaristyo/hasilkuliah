#include <stdio.h>
const float phi=3.14;const int maxsize=255;
const char rootdir='C';const float min_kelvin=80.0;const double R=8.314472;
int jumlah=0;char jawaban='B';double suhu_awal=25.0;float radius=0.0;
double harga=10000.00;int nilai_hexa=0x1A;int nilai_oktal=022;
int main(){ printf("Nilai Jumlah: %i\n", jumlah); printf("Nilai Jawaban: %c\n", jawaban);
printf("Nilai Suhu Awal: %.1lf\n", suhu_awal); printf("Nilai Radius: %.1f\n", radius);
printf("Nilai Harga: %.2lf\n", harga); printf("Nilai Nillai Hexa: %x\n", nilai_hexa);
printf("Nilai Nilai Oktal: %o\n", nilai_oktal); printf("Nilai Phi: %.2f\n", phi);
printf("Nilai Maxsize: %i\n", maxsize); printf("Nilai Rootdir: %c\n", rootdir);
printf("Nilai Min Kelvin: %.f\n", min_kelvin); printf("Nilai R: %.6f\n", R); return 0;}