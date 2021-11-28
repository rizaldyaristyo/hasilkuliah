#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <conio.h>

int main(){
	
	//resetall
	int lcase=0,ucase=0,numer=0,spcch=0,i,j,k,m;
	int passlen,userlen,usercmp,passcmp,noUrut;
	char reguserchk[20],userString[20],passString[20],kodeString[20];
	char userName[50][20], password[50][20], kodeUser[50][5];
	char regUserName[20], regPassword[20];
	char inputUsername[20], inputPassword[20];
	int pil;
	//nullify
	for(j=0;j<=0;j++){
		for(i=0;i<=50;i++){
			userName[j][i]='\0';
			password[j][i]='\0';
			//printf("j= %d\t",j);
		}
	}
	
	//		"torture field"		//
	//
	//	end of "torture field"	//
	
	system("cls");
	awal:
	printf("\nMENU\n");
	printf(" 1. Registrasi\n");
	printf(" 2. Login\n");
	printf(" 3. Tampilkan semua data\n");
	printf(" 4. EXIT\n");
	printf("PILIH MENU : ");
	scanf("%d", &pil);
	
	switch(pil)
	{
	case 1:
		//system("cls");
		reg1:
		lcase=0,ucase=0,numer=0,spcch=0;
		fflush(stdin);
		printf("\n==REGISTRASI==\n");
		printf("Enter your Name: ");
		gets( regUserName);
		printf("Enter your password: ");
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
		} //printf("spcch val: %d",spcch);//cek status spcch
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
		
		
		
		spcch=0; //reset status spcch
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
			if(!userName[j][1]){
				/*printf("ada slot di j=%d\n",j);
				printf("userlen: %d\n",userlen);
				printf("converting char ke string \n");*/
				for(i=0;i<=50;i++){
					for(k=0;k<=userlen;k++){
						userString[k]=userName[i][k];
					}
					/*printf("\n\nuserString	i=%d: %s.",i,userString);
					printf("\nregUserName	i=%d: %s.",i,regUserName);*/
					usercmp=strcmp(userString,regUserName);
					if(usercmp==0){
						printf("Username Duplikat Tidak Tersedia");
						goto reg1;
					}
				}
			break;
			}else{
				/*printf("tidak ada slot di j=%d\n",j);
				printf("konten [%d][2]: %c\n",j,userName[j][1]);*/
			}
		}
		
		/*	
		printf("\ncopying ");
		for(i=0;regUserName[i]!=0;i++){
		printf("%c",regUserName[i]);
		}
		printf(" and its password to array data\n");
		*/
		
		for(i=0;regUserName[i]!=0;i++){
    	userName[j][i]=regUserName[i];
		}
		for(i=0;regPassword[i]!=0;i++){
    	password[j][i]=regPassword[i];
		}
		
		/*
		printf("\nusername and password confirmation: \n");
		printf("username ");
		for(i=0;regUserName[i]!=0;i++){
		printf("%c",userName[j][i]);
		}
		printf(" dengan password: ");
		for(i=0;regPassword[i]!=0;i++){
		printf("%c",password[j][i]);
		}
		printf(" berhasil dibuat");
		*/
			
		printf("\nRegistrasi berhasil");
		printf("\nTekan Enter Untuk Kembali ke Menu awal");
		getch();
		system("cls");
		goto awal;
		
				
		break;
	case 2:
		login:
		printf("input username: ");
		scanf("%s",inputUsername);
	for(k=0;k<=0;k++){
		for(i=0;i<=50;i++){
					for(k=0;k<=20;k++){
						userString[k]=userName[i][k];
					}
					/*printf("\n\nuserString 	i=%d: %s.",i,userString);
					printf("\ninputUsername	i=%d: %s.",i,inputUsername);*/
					usercmp=strcmp(userString,inputUsername);
					if(usercmp==0){
						printf("input password: ");
						scanf("%s",inputPassword);
						for(k=0;k<=20;k++){
						passString[k]=password[i][k];
						}
						/*printf("\n\npassString 	i=%d: %s.",i,passString);
						printf("\ninputPassword	i=%d: %s.",i,inputPassword);*/
						passcmp=strcmp(passString,inputPassword);
						if(passcmp==0){
						printf("\n\nSELAMAT DATANG %s\n",inputUsername);
						goto urdata;
						}else{printf("\nPassword Salah!\n"); goto login;}
					}
		}
	}
		printf("Username Tidak ditemukan!\n");
		goto awal;
	
		urdata:
		printf("Data Anda\n");
		printf("Username: %s\n",inputUsername);
		for(i=0;i<=2;i++){kodeUser[j][i]=inputUsername[i];}
		for(i=0;i<=2;i++){kodeString[i]=kodeUser[j][i]-32;}
		noUrut=j+1;
		printf("KodeUser: %s-%04d\n", kodeString,noUrut);
		printf("\n\nTekan Enter Untuk Kembali ke Menu awal");
		getch();
		system("cls");
		goto awal;
		break;
	
	case 3:
		printf("==LIST DATA==\n");
		for(m=0;m<=50;m++){
			if(userName[m][1]){
				//printf("ada data di slot j=%d\n",j);
				printf("\n\n==%d==\n",(m+1));
				printf(" Username : ");
				for(i=0;userName[m][i]!=0;i++){
					printf("%c",userName[m][i]);
				}
				printf("\nKode User : ");
				for(i=0;i<=2;i++){kodeString[i]=userName[m][i]-32;}
				noUrut=m+1;
				printf("KodeUser: %s-%04d\n", kodeString,noUrut);
				
			}else{
				//printf("tidak ada data di slot j=%d\n",j);
				break;
			}
		}
		goto awal;
		break;
	
	case 4:
		exit(0);
		break;
	default:
		break;
	}
	
	
	
	return 0;
}