#include <stdio.h>
#include <stdlib.h>

int main(){
	int hb1,total=0,disk;
	char a;
	
	do{
		system("cls");
		int stat=1;
		for(int i=0;i<3;i++)
		{
		printf("masukkan harga barang %i: ",stat);
		scanf("%i",&hb1);
		total = total+hb1;
		stat++;
		}
		
		if (total>=500000){
			printf("anda mendapatkan potongan 25 persen\n");
			disk=total*0.25;
			printf("\ntotal harga : %i\n",total);
			printf("diskon : %i\n",disk);
			printf("total bayar anda sebesar : %i\n",(total-disk));
			printf("\n\nselamat berbelanja kembali :v\n");
		}else if (total>=300000){
			printf("anda mendapatkan potongan 20 persen\n");
			disk=total*0.20;
			printf("\ntotal harga : %i\n",total);
			printf("diskon : %i\n",disk);
			printf("total bayar anda sebesar : %i\n",(total-disk));
			printf("\n\nselamat berbelanja kembali :v\n");
		}else if (total>=100000){
			printf("anda mendapatkan potongan 10 persen\n");
			disk=total*0.10;
			printf("\ntotal harga : %i\n",total);
			printf("diskon : %i\n",disk);
			printf("total bayar anda sebesar : %i\n",(total-disk));
			printf("\n\nselamat berbelanja kembali :v\n");
		}else {
			printf("tidak ada potongan , terimakasih\n");
			printf("\ntotal bayar anda sebesar : %i\n",total);
			printf("\nselamat berbelanja kembali :v\n");
		}
		
		fflush(stdin);
		printf("Apakah anda ingin melakukan transaksi lagi? (y/n): ");
		scanf("%c", &a);
		
	}while(a == 'Y' || a == 'y');

	return 0;
}