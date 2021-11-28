#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <conio.h>

int main(){
	int i,j;
	int pilihan,cekispunct,statslot=0;
	int cekspecial,cekbesar,cekkecil,cekangka;
	char getusername[20],getpassword[20];
	char revpassword[20];
	char username1[20],password1[20];
	char username2[20],password2[20];
	char username3[20],password3[20];
	char username4[20],password4[20];
	char username5[20],password5[20];
	
	for(i=0;i<=20;i++){
		username1[i]='\0';
		username2[i]='\0';
		username3[i]='\0';
		username4[i]='\0';
		username5[i]='\0';
	}
		
	awal:
	printf("MENU\n");
	printf(" 1. Registrasi (slot registrasi: %d/5)\n",statslot);
	printf(" 2. Login\n");
	printf(" 3. Tampilkan semua data\n");
	printf(" 4. EXIT\n");
	printf("PILIH MENU : ");
	scanf("%d",&pilihan);
	switch(pilihan)
	{
	case 1:
		registrasi:
		fflush(stdin);
		printf("==REGISTRASI==\n");
		printf("Input Username	: ");
		gets( getusername);
		printf("Input Password	: ");
		gets( getpassword);
		
		if(getusername==username1||getusername==username2||getusername==username3||getusername==username4||getusername==username5){
			printf("Username Duplikat!");
			getch();
			goto awal;
		}
		
		/*
		
		kode persyaratan
		coming soon!
		
		*/
		
		if(username1[0]=='\0'){
			for(i=0;getusername[i]!=0;i++){
				username1[i]=getusername[i];
				password1[i]=getpassword[i];
			}
			username1[i]='\0';
			password1[i]='\0';
		}else if(username2[0]=='\0'){
			for(i=0;getusername[i]!=0;i++){
				username2[i]=getusername[i];
				password2[i]=getpassword[i];
			}
			username2[i]='\0';
			password2[i]='\0';
		}else if(username3[0]=='\0'){
			for(i=0;getusername[i]!=0;i++){
				username3[i]=getusername[i];
				password3[i]=getpassword[i];
			}
			username3[i]='\0';
			password3[i]='\0';
		}else if(username4[0]=='\0'){
			for(i=0;getusername[i]!=0;i++){
				username4[i]=getusername[i];
				password4[i]=getpassword[i];
			}
			username4[i]='\0';
			password4[i]='\0';
		}else if(username5[0]=='\0'){
			for(i=0;getusername[i]!=0;i++){
				username5[i]=getusername[i];
				password5[i]=getpassword[i];
			}
			username5[i]='\0';
			password5[i]='\0';
		}else
		{
			printf("Slot Registrasi Penuh!\n");
			goto awal;
		}
		
		printf("Registrasi Berhasil!\n");
		statslot++;
		getch();
		goto awal;
		
		break;
	case 2:
		break;
	case 3:
		printf("==DATA==\n");
		if(username1[0]!='\0'){
			printf("==1==\n");
			printf("\n username1: %s",username1);
			printf("\n password1: %s\n\n",password1);
			if(username2[0]!='\0'){
				printf("\n==2==\n");
				printf("\n username2: %s",username2);
				printf("\n password2: %s\n\n",password2);
				if(username3[0]!='\0'){
					printf("\n==3==\n");
					printf("\n username3: %s",username3);
					printf("\n password3: %s\n\n",password3);
					if(username4[0]!='\0'){
						printf("\n==4==\n");
						printf("\n username4: %s",username4);
						printf("\n password4: %s\n\n",password4);
						if(username5[0]!='\0'){
							printf("\n==5==\n");
							printf("\n username5: %s",username5);
							printf("\n password5: %s\n\n",password5);
						}
					}
				}
			}
			
		}else{
			getch();
		} 	
		break;
	
	default:
		printf("\nDadaaahh~");
		getch();
		exit(0);
		break;
	}
}