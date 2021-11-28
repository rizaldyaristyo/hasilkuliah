#include <stdio.h>

int main(){
	int hb1,total=0,disk;
	//int i=1;
	
	printf(">>>INFOTECH STORE<<<\n\n");
	
	for(int i=1;i<4;i++)
	{
	printf("masukkan harga barang %i: ",i);
	scanf("%i",&hb1);
	total = total+hb1;
	}

	/*do{
	printf("masukkan harga barang %i: ",i);
	scanf("%i",&hb1);
	total = total+hb1;
	i++;
	}while(i!=4);*/
		
	/*while (i!=4){
	printf("masukkan harga barang %i: ",i);
	scanf("%i",&hb1);
	total = total+hb1;
	i++;}*/
	
	if (total>=500000){
		disk=total*0.25;
		printf("anda mendapatkan potongan 25 persen\n");
		printf("\ntotal harga : %i\n",total);
		printf("diskon : %i\n",disk);
		printf("total bayar anda sebesar : %i\n",(total-disk));
		printf("\n\nselamat berbelanja kembali :v\n");
	}else if (total>=300000){
		disk=total*0.20;
		printf("anda mendapatkan potongan 20 persen\n");
		printf("\ntotal harga : %i\n",total);
		printf("diskon : %i\n",disk);
		printf("total bayar anda sebesar : %i\n",(total-disk));
		printf("\n\nselamat berbelanja kembali :v\n");
	}else if (total>=100000){
		disk=total*0.10;
		printf("anda mendapatkan potongan 10 persen\n");
		printf("\ntotal harga : %i\n",total);
		printf("diskon : %i\n",disk);
		printf("total bayar anda sebesar : %i\n",(total-disk));
		printf("\n\nselamat berbelanja kembali :v\n");
	}else{
		printf("tidak ada potongan , terimakasih\n");
		printf("\ntotal bayar anda sebesar : %i\n",total);
		printf("\nselamat berbelanja kembali :v\n");
	}

	return 0;
}