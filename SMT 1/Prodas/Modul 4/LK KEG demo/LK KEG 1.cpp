#include <stdio.h>
#include <stdlib.h>

int main(){
	int pil;
	float det, idx3[3][3], idx2[2][2];
	awal:
	system("cls");
	printf("masukkan ordo matrix yang diinginkan (2x2 atau 3x3) : ");
	scanf("%i", &pil);
	switch(pil)
	{
	case 2:
	
		printf("masukkan angka angka matrix :\n");
		for(int a=0;a<=1;a++){
			for(int aa=0;aa<=1;aa++){
			printf("masukkan index [%i] [%i] : ",a,aa);
			scanf("%f", &idx2[a][aa]);
			}
		}
		printf("hasil inputan : \n");
		for (int b=0;b<=1;b++){
			for (int bb=0;bb<=1;bb++){
			printf("%.1f \t\t", idx2[b][bb]);
			}
			printf("\n");
		}
		det=(idx2[0][0]*idx2[1][1]-idx2[1][0]*idx2[0][1]);
		printf("\nNilai determinan yang dihasilkan adalah : %.2f\n",det);
		break;


	case 3:
		printf("masukkan angka angka matrix :\n");
		for(int a=0;a<=2;a++){
			for(int aa=0;aa<=2;aa++){
			printf("masukkan index [%i] [%i] : ",a,aa);
			scanf("%f", &idx3[a][aa]);
			}
		}
		printf("hasil inputan : \n");
		for (int b=0;b<=2;b++){
			for (int bb=0;bb<=2;bb++){
			printf("%.1f \t\t", idx3[b][bb]);
			}
			printf("\n");
		}
		det=(idx3[0][0]*idx3[1][1]*idx3[2][2]+
		idx3[0][1]*idx3[1][2]*idx3[2][0]+
		idx3[0][2]*idx3[2][0]*idx3[2][1])-
		(idx3[0][1]*idx3[1][0]*idx3[2][2]+
		idx3[0][0]*idx3[1][2]*idx3[2][1]+
		idx3[0][2]*idx3[1][1]*idx3[2][0]);
		printf("\nNilai determinan yang dihasilkan adalah : %.2f\n",det);
		break;
	
	default:
		goto awal;
	}
}