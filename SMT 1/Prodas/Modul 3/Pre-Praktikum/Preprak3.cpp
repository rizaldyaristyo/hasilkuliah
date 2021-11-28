#include <stdio.h>

int main (){
int bil;
	
	for (int i=0; i<5; i++){
		printf ("masukkan sebuah bilangan :");
		scanf ("%d", &bil);
		
		if ( bil > 0)
		{
			if (bil%2==0){printf ("%d adalah bilangan genap positif\n", bil);}
			else{printf ("%d adalah bilangan ganjil positif\n", bil);}
		}
		else if(bil < 0)
		{
			if (bil%2==0){printf ("%d adalah bilangan genap negatif\n", bil);}
			else{printf ("%d adalah bilangan ganjil negatif\n", bil);}
		}else
		{
			printf ("bilangan yang anda input adalah angka 0\n");
		}
			
	}
	return 0;
}