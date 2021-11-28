#include <stdio.h>
#define a 2.5


int main ()
{
	int nim,bil1,bil2,bil3,
	jumlah;
	float hasil;
	
	printf( 'masukkan 3 digit trakhir nim anda : ');  // apostrof (') diganti quotation (")
	scanf ("%d", &nim);
	printf( "masukkan bilangan pertama : ");
	scanf ("%d", bil1);  // kekurangan simbol and (&) sebelum int bil1
	printf( "masukkan bilangan kedua : ");
	scanf ("%f", &bil2);  // format %f seharusnya diganti %i / %d karena tipe data bukan float
	jumlah = nim -(bil1+bil2)  // kekurangan semicolon (;)
	
	printf("jumlah yang diperoleh : %d \n", jumlah);
	printf("\nmasukkan bilangan ketiga : ");
	scanf ("%d", &bil3);
	hasil = jumlah*bil3\a  // simbol (\) nyasar mungkin maksudnya operator (/)
	printf( "\nnim anda adalah : %d /n", nim);  // char (/n) di akhir salah,
												// dapat dihapus karena newline di depan sudah ada yang benar,
												//atau mau ditambahkan newline kedua jadi harus diperbaiki menjadi (\n)
	printf("hasil yang anda peroleh dari data diatas adalah : %f /n", hasil); // char (/n) salah, diperaiki menjadi (\n)
	
	return 0;
}