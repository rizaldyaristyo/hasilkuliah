#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <conio.h>

int main(){
	
	//resetall
	int besarTabel=1000,panjangTabel=100;
	int lcase=0,ucase=0,numer=0,spcch=0,i,j,k,l,m,len,
	passlen,userlen,usercmp,passcmp,kodecmp,noUrut,pil;
	char regpasschk[panjangTabel],userString[panjangTabel],passString[panjangTabel],kodeString[7],kodeStringTemp[7],
	userName[besarTabel][panjangTabel],password[besarTabel][panjangTabel],kodeUser[besarTabel][7],userSave[panjangTabel],passSave[panjangTabel],
	kodeSave[7],regUserName[panjangTabel],regPassword[panjangTabel],inputUsername[panjangTabel],inputPassword[panjangTabel];
	
	//nullify
	/*end[0]='\0';
	for(i=0;i<=besarTabel;i++){
		for(k=0;k<=panjangTabel;k++){
			userName[i][k]='\0';
			password[i][k]='\0';
			kodeUser[i][k]='\0';
			kodeString[k]='\0';}}
			*/

	FILE *fp;
	fp = fopen("userdata.txt","r");
	i=0;while(fscanf(fp,"%s",userSave)!=EOF){
			len=strlen(userSave);
			for(k=0;k<=len-1;k++){
				userName[i][k]=userSave[k];
				//printf("%c",userName[i][k]);
			}
			i++;
	}
	fclose(fp);
	fp = fopen("passdata.txt","r");
	i=0;while(fscanf(fp,"%s",passSave)!=EOF){
			len=strlen(passSave);
			for(k=0;k<=len-1;k++){
				password[i][k]=passSave[k];
				//printf("%c",password[i][k]);
			}
			i++;
	}
	fclose(fp);
	fp = fopen("kodedata.txt","r");
	i=0;while(fscanf(fp,"%s",kodeSave)!=EOF){
			for(k=0;k<=7;k++){
				kodeUser[i][k]=kodeSave[k];
				//printf("%c",kodeUser[i][k]);
			}
			i++;
	}
	fclose(fp);
	
	/*printf("\n\n cek keutuhan data :\n");
	for(i=0;i<=7;i++){
		for(k=0;k<=7;k++){
			printf("%c",kodeUser[i][k]);
		}
		printf("\n");
	}*/
	
	
	printf("...file loaded!\n");
	awal:
	printf("MENU\n");
	printf(" 1. Registrasi\n");
	printf(" 2. Login\n");
	printf(" 3. Tampilkan semua data\n");
	printf(" 4. Save and EXIT\n");
	printf("PILIH MENU : ");
	scanf("%d", &pil);
	switch(pil)
	{case 1:
		reg1:
		lcase=0,ucase=0,numer=0,spcch=0;
		fflush(stdin);
		printf("==REGISTRASI==\n");
		printf("Input username: ");
		gets( regUserName);
		printf("Input password: ");
		gets( regPassword);
		userlen=strlen(regUserName);
		if(userlen<6){
		printf("Error: Username minimum 6 char \n");
		goto reg1;
		spcch=0;}
		for(i=0;regUserName[i]!=0;i++){
		if((regUserName[i]=='!'||regUserName[i]=='@'||regUserName[i]=='#'||regUserName[i]=='$'
		||regUserName[i]=='%'||regUserName[i]=='^'||regUserName[i]=='&'||regUserName[i]=='*'
		||regUserName[i]=='('||regUserName[i]==')'||regUserName[i]==','))
		spcch++;}
		if(spcch>0){
		printf("Karakter Spesial selain titik (.) terdeteksi!\n");
		printf("Username tidak boleh mengikutsertakan Karakter Spesial selain titik (.)\n\n");
		goto reg1;}
		strcpy(regpasschk,regPassword);
    	strrev(regpasschk);
    	if(!strcmp(regPassword,regpasschk)){
 	    printf("%s adalah palindrome\n", regPassword);
		printf("Password tidak boleh berbentuk palindrome\n\n");
		goto reg1;}
		spcch=0;
		passlen=strlen(regPassword);
		if(passlen<8){
		printf("Error: Password minimum 8 char \n");
		goto reg1;}
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
		goto reg1;}
		for(j=0;j<=besarTabel;j++){
			if(!userName[j][0]){
				for(i=0;i<=besarTabel;i++){
					for(k=0;k<=userlen;k++){
						userString[k]=userName[i][k];}
					usercmp=strcmp(userString,regUserName);
					if(usercmp==0){
						printf("Username Duplikat Tidak Tersedia");
						goto reg1;}
				}
			noUrut=j;
			//printf("\n\nnoUrut val: %d\n",noUrut);
			break;}
		}
		
		fp = fopen("userdata.txt","w+");
		for(i=0;regUserName[i]!=0;i++){
    		userName[j][i]=regUserName[i];
			userSave[k]=userName[i][k];
		}
		fprintf(fp,"%s\n",userSave);	
		fclose(fp);
		
		fp = fopen("passdata.txt","w+");
		for(i=0;regPassword[i]!=0;i++){
    		password[j][i]=regPassword[i];
			passSave[k]=password[i][k];
		}
		fprintf(fp,"%s\n",passSave);
		fclose(fp);
		
		
		
		printf("username berhasil didaftarkan\n");
		printf(" Username	: ");
		for(i=0;regUserName[i]!=0;i++){
			printf("%c",userName[j][i]);}
		printf("\n Password	: ");
		for(i=0;regPassword[i]!=0;i++){
			printf("%c",password[j][i]);}
		printf("\n Kode User	: ");
		for(i=0;i<=2;i++){
		if(userName[j][i] >= 'A' && userName[j][i] <= 'Z'){
			{kodeUser[j][i]=userName[j][i];}
    		}else{kodeUser[j][i]=userName[j][i]-32;}
		}

		noUrut++;
		for(i=0;i<=2;i++){
			printf("%c",kodeUser[j][i]);
			kodeString[i]=kodeUser[j][i];
			}
		printf("\n\n");
		//kodeString[3]='\0';
		//sprintf(urutString, "%04d", noUrut); gagal pake sprintf karena bentrok dengan strcat
		strcpy(kodeStringTemp,"");
		sprintf(kodeStringTemp,"%s-%04d",kodeString,noUrut);
		
		fp = fopen("kodedata.txt","w+");
	   	for(i=0;i<=7;i++){
		   kodeUser[j][i]=kodeStringTemp[i];
		   kodeSave[k]=kodeUser[i][k];  
		   }
		fprintf(fp,"%s\n",kodeSave);
		fclose(fp);
		
		for(i=0;i<=7;i++){printf("%c",kodeUser[j][i]);}		
		
		getch();
		//kodeStringTemp[0]='\0';
		system("cls");
		goto awal;
		break;
	
	case 2:
		login:
		printf("==LOGIN==\n");
		printf("Input username	: ");
		scanf("%s",inputUsername);
		for(i=0;i<=besarTabel;i++){
					for(k=0;k<=panjangTabel;k++){
						userString[k]=userName[i][k];
						//printf("i val : %d",i);
						for(l=0;l<=7;l++){
							//printf("%c",kodeUser[i][l]);
							kodeStringTemp[l]=kodeUser[i][l];
						}
					}
					/*printf("\n\nuserString 	i=%d: %s.",i,userString);
					printf("\ninputUsername	i=%d: %s.",i,inputUsername);*/
					usercmp=strcmp(userString,inputUsername);
					kodecmp=strcmp(kodeStringTemp,inputUsername);
					//fflush(stdout);
					if(usercmp==0){
						printf("input password: ");
						scanf("%s",inputPassword);
						for(k=0;k<=panjangTabel;k++){
						   	passString[k]=password[i][k];
						}
						/*printf("\n\npassString 	i=%d: %s.",i,passString);
						printf("\ninputPassword	i=%d: %s.",i,inputPassword);*/
						passcmp=strcmp(passString,inputPassword);
						if(passcmp==0){goto urdata;
						}else{printf("\nPassword Salah!\n"); goto login;}
					}else if(kodecmp==0){
						
							printf("input password: ");
							scanf("%s",inputPassword);
							for(k=0;k<=panjangTabel;k++){
							   	passString[k]=password[i][k];
							}
							/*printf("\n\npassString 	i=%d: %s.",i,passString);
							printf("\ninputPassword	i=%d: %s.",i,inputPassword);*/
							passcmp=strcmp(passString,inputPassword);
							if(passcmp==0){goto urdata;
							}else{printf("\nPassword Salah!\n"); goto login;}
						
					}
		}
	
		printf("Username Tidak ditemukan!\n\n");
		getch();
		system("cls");
		goto awal;
	
		urdata:
		for(k=0;k<=panjangTabel;k++){
			userString[k]=userName[i][k];
		}
		printf("\nSELAMAT DATANG %s\n",userString);
		printf("== Data Anda ==\n");
		printf(" Username	: %s\n",userString);
		printf(" KodeUser	: %s\n",kodeStringTemp);
		kodeStringTemp[0]='\0';
		getch();
		system("cls");
		goto awal;
		//break;
	
	case 3:
		printf("==LIST DATA==\n");
		for(m=0;m<=besarTabel;m++){
			if(userName[m][1]){
				//printf("ada data di slot j=%d\n",j);
				printf("\n==%d==\n",(m+1));
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
				printf("%s-%04d\n", kodeString,noUrut);
				
			}else
			{
				//printf("tidak ada data di slot j=%d\n",j);
				break;
			}
		}
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