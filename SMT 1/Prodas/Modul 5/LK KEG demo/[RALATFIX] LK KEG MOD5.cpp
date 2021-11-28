#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <conio.h>

int main(){
	
	//resetall
	int lcase=0,ucase=0,numer=0,spcch=0,i,j,k,m;
	int passlen,userlen,usercmp,passcmp,kodecmp,noUrut;
	char reguserchk[20],userString[20],passString[20],kodeString[9],kodeStringTemp[9];
	char userName[50][20], password[50][20], kodeUser[50][7];
	char regUserName[20], regPassword[20],end[0];
	char inputUsername[20], inputPassword[20];
	int pil;
	//nullify
	end[0]='\0';
	for(i=0;i<=50;i++){
		for(k=0;k<=20;k++){
			userName[i][0]='\0';
			password[i][0]='\0';
			kodeUser[i][0]='\0';
			kodeString[0]='\0';
		}
	}
		
	system("cls");
	awal:
	printf("MENU\n");
	printf(" 1. Registrasi\n");
	printf(" 2. Login\n");
	printf(" 3. Tampilkan semua data\n");
	printf(" 4. EXIT\n");
	printf("PILIH MENU : ");
	scanf("%d", &pil);
	
	switch(pil)
	{
	case 1:
		reg1:
		lcase=0,ucase=0,numer=0,spcch=0;
		fflush(stdin);
		printf("\n==REGISTRASI==\n");
		printf("Input username: ");
		gets( regUserName);
		printf("Input password: ");
		gets( regPassword);
		
		userlen=strlen(regUserName);
		if(userlen<6){
		printf("Error: Username minimum 6 char \n");
		goto reg1;
		spcch=0;
		}
		for(i=0;regUserName[i]!=0;i++){
		if((regUserName[i]=='!'||regUserName[i]=='@'||regUserName[i]=='#'||regUserName[i]=='$'
		||regUserName[i]=='%'||regUserName[i]=='^'||regUserName[i]=='&'||regUserName[i]=='*'
		||regUserName[i]=='('||regUserName[i]==')'||regUserName[i]==','))
		spcch++;
		}
		if(spcch>0){
		printf("Karakter Spesial selain titik (.) terdeteksi!\n");
		printf("Username tidak boleh mengikutsertakan Karakter Spesial selain titik (.)\n\n");
		goto reg1;
		}
		strcpy(reguserchk,regUserName);
    	strrev(reguserchk);
    	if(!strcmp(regUserName,reguserchk)){
 	    printf("%s adalah palindrome\n", regUserName);
		goto reg1;
		}

		spcch=0;
		passlen=strlen(regPassword);
		if(passlen<8){
		printf("Error: Password minimum 8 char \n");
		goto reg1;
		}
		for(i=0;regPassword[i]!=0;i++){
		if(regPassword[i]>='A' && regPassword[i]<='Z')
		ucase++;
		if(regPassword[i]>='a' && regPassword[i]<='z')
		lcase++;
		if(regPassword[i]>='0' && regPassword[i]<='9')
		numer++;
		if((regPassword[i]=='!'||regPassword[i]=='@'||regPassword[i]=='#'||regPassword[i]=='$'
		||regPassword[i]=='%'||regPassword[i]=='^'||regPassword[i]=='&'||regPassword[i]=='*'
		||regPassword[i]=='('||regPassword[i]==')'||regPassword[i]=='.'||regPassword[i]==','))
		spcch++;
		}if(ucase==0){
		printf("Alfabet Kapital tidak ditemukan!\n");
		printf("Password harus terdiri dari huruf kecil, kapital, angka, dan karakter spesial\n\n");
		goto reg1;
		}else if(lcase==0){
		printf("Alfabet kecil tidak ditemukan!\n");
		printf("Password harus terdiri dari huruf kecil, kapital, angka, dan karakter spesial\n\n");
		goto reg1;
		}else if(numer==0){
		printf("Angka tidak ditemukan!\n");
		printf("Password harus terdiri dari huruf kecil, kapital, angka, dan karakter spesial\n\n");
		goto reg1;
		}else if(spcch==0){
		printf("Karakter Spesial tidak ditemukan!\n");
		printf("Password harus terdiri dari huruf kecil, kapital, angka, dan karakter spesial\n\n");
		goto reg1;
		}
		
		for(j=0;j<=50;j++){
			if(!userName[j][0]){
				printf("\ntempat simpan di slot %d\n",j);
				for(i=0;i<=50;i++){
					for(k=0;k<=userlen;k++){
						userString[k]=userName[i][k];
					}
					usercmp=strcmp(userString,regUserName);
					if(usercmp==0){
						printf("Username Duplikat Tidak Tersedia");
						goto reg1;
					}
				}
			noUrut=j;
			break;
			}
		}
		
		
		for(i=0;regUserName[i]!=0;i++){
    	userName[j][i]=regUserName[i];
		}
		for(i=0;regPassword[i]!=0;i++){
    	password[j][i]=regPassword[i];
		}
		
		printf("username berhasil didaftarkan\n");
		printf(" Username	: ");
		for(i=0;regUserName[i]!=0;i++){
			printf("%c",userName[j][i]);
		}
		printf("\n Password	: ");
		for(i=0;regPassword[i]!=0;i++){
			printf("%c",password[j][i]);
		}
		printf("\n Kode User	: ");
		for(i=0;i<=2;i++){
		if(userName[j][i] >= 'A' && userName[j][i] <= 'Z'){
			{kodeUser[j][i]=userName[j][i];}
    		}else{
			{kodeUser[j][i]=userName[j][i]-32;}
			}
		}

		noUrut++;
		for(i=0;i<=2;i++){kodeString[i]=kodeUser[j][i];}
		kodeString[3]='\0';
		//sprintf(urutString, "%04d", noUrut); gagal pake sprintf karena bentrok dengan strcat
		snprintf(kodeStringTemp, 9, "%s-%04d%c",kodeString,noUrut,end[0]);
	   	for(i=0;i<=7;i++){kodeUser[j][i]=kodeStringTemp[i];}
	   		
			for(i=0;i<=7;i++){
		   	   printf("%c",kodeUser[j][i]);
			}
			
		printf("\n\n");
		getch();
			for(i=0;i<=10;i++){
				kodeStringTemp[i]='\0';
			}
		system("cls");
		goto awal;
		break;
	
	case 2:
		login:
		printf("==LOGIN==\n");
		printf("Input username	: ");
		scanf("%s",inputUsername);
	for(k=0;k<=0;k++){
		for(i=0;i<=50;i++){
					for(k=0;k<=20;k++){
						printf("%c",userName[i][k]);
						userString[k]=userName[i][k];
					}
					
					printf("\ngap\n");
					
					for(k=0;k<=7;k++){
						printf("%c",kodeUser[i][k]);
						kodeString[k]=kodeUser[i][k];
					}
					kodecmp=strcmp(kodeString,inputUsername);
					usercmp=strcmp(userString,inputUsername);
					if(usercmp==0||kodecmp==0){
						printf("Input password	: ");
						scanf("%s",inputPassword);
						for(k=0;k<=20;k++){
						passString[k]=password[i][k];
						}
						passcmp=strcmp(passString,inputPassword);
						if(passcmp==0){
							for(k=0;k<=20;k++){
								userString[k]=userName[i][k];
								kodeString[k]=kodeUser[i][k];
							}
							printf("\n\nSELAMAT DATANG %s\n",userString);
							goto urdata;
						}else{printf("\nPassword Salah!\n"); goto login;}
					}
		}
	}
		printf("Username Tidak ditemukan!\n");
		goto awal;
	
		urdata:
		printf("== Data Anda ==\n");
		printf("Username	: %s\n",userString);
		printf("KodeUser	: %s\n",kodeString);
		getch();
		system("cls");
		goto awal;
		//break;
	
	case 3:
		printf("==LIST DATA==\n");
		for(m=0;m<=50;m++){
			if(userName[m][1]){
				//printf("ada data di slot j=%d\n",j);
				printf("\n\n==%d==\n",(m+1));
				printf(" Username : ");
				for(i=0;userName[m][i]!=0;i++){
					printf("%c",userName[m][i]);}
				printf("\nKode User : ");
				
				for(i=0;i<=2;i++){
				if(userName[m][i] >= 'A' && userName[m][i] <= 'Z'){
				kodeString[i]=userName[m][i];
				}else{kodeString[i]=userName[m][i]-32;}
				}
				noUrut=m+1;
				printf("KodeUser: %s-%04d\n", kodeString,noUrut);
				
			}else{
				//printf("tidak ada data di slot j=%d\n",j);
				break;
			}
		}
		printf("\n\n");
		getch();
		system("cls");
		goto awal;
		break;
	default:
		exit(0);
		break;
	}
	
	
	
	return 0;
}