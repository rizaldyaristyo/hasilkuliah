#include <stdio.h>
#include <string.h>
//#include <stdlib.h>
#include <conio.h>
#include <windows.h>

int main(){
	
		int besarTabel=1000,
/*chg*/	panjangTabel=20;
		int lcase=0,ucase=0,numer=0,spcch=0,i,j,k,l,m,
		passlen,userlen,usercmp,passcmp,kodecmp,noUrut,pil,len;
		char regpasschk[panjangTabel],userString[panjangTabel],passString[panjangTabel],kodeString[9],kodeStringTemp[9],
/*chg*/	userSave[panjangTabel],kodeSave[panjangTabel],passSave[panjangTabel],pilc,
		userName[besarTabel][panjangTabel],password[besarTabel][panjangTabel],kodeUser[besarTabel][8],
		regUserName[panjangTabel],regPassword[panjangTabel],inputUsername[panjangTabel],inputPassword[panjangTabel];

	awal:
/*chg<*/	
	FILE *fp;
	Sleep(50);
	printf("== MENU ==\t\t");
	char a=177,b=219; for (int i = 0; i < 15; i++)printf("%c", a);
	printf("Fetching File...");
	printf("\r");
	printf("== MENU ==\t\t");
	fp = fopen("userdata.txt","r");
	if(fp==NULL){
		fp = fopen("userdata.txt","w+");
	}
	i=0;while(fscanf(fp,"%s",userSave)!=EOF){
			len=strlen(userSave);
			if(userSave[0]=='¤'){
				userName[i][0]='\0';
				i++;
			}else{
				for(k=0;k<=len-1;k++){
					userName[i][k]=userSave[k];
					//printf("%c",userName[i][k]);
				}
				i++;
			}
	}
	fclose(fp);
	//loading at 33%
	for (int i = 0; i < 5; i++){
		printf("%c", b);
		Sleep(30);
	}
	fp = fopen("passdata.txt","r");
	if(fp==NULL){
		fp = fopen("passdata.txt","w+");
	}
	i=0;while(fscanf(fp,"%s",passSave)!=EOF){
			len=strlen(passSave);
			if(passSave[0]=='¤'){
				password[i][0]='\0';
				i++;
			}else{
				for(k=0;k<=len-1;k++){ 
					password[i][k]=passSave[k];
					//printf("%c",password[i][k]);
				}
				i++;
			}
			
	}
	fclose(fp);
	//loading at 66%
	for (int i = 0; i < 5; i++){
		printf("%c", b);
		Sleep(15);
	}
	fp = fopen("kodedata.txt","r");
	if(fp==NULL){
		fp = fopen("kodedata.txt","w+");
	}
	i=0;while(fscanf(fp,"%s",kodeSave)!=EOF){
			if(kodeSave[0]=='¤'){
				for(k=0;k<=7;k++){
					kodeUser[i][k]='\0';
					//printf("%c",kodeUser[i][k]);
				}
				kodeUser[i][8]='\0';
				i++;
			}else{
				for(k=0;k<=7;k++){
					kodeUser[i][k]=kodeSave[k];
					//printf("%c",kodeUser[i][k]);
				}
				i++;
				kodeUser[i][8]='\0';
			}
	}
	fclose(fp);
	//loading at 99%
	for (int i = 0; i < 5; i++){
		printf("%c", b);
		Sleep(5);
	}
	printf("(100%%!)         \n");
/*>chg*/	
	//printf("\nMENU\n");
	printf(" 0. Refresh data\n");
	printf(" 1. Registrasi\n");
	printf(" 2. Login\n");
	printf(" 3. Tampilkan semua data\n");
	printf(" 4. EXIT\n");
	printf("PILIH MENU : ");
	scanf("%d", &pil);
	switch(pil)
	{case 1:
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
		spcch=0;
		passlen=strlen(regPassword);
		if(passlen<8){
		printf("Error: Password minimum 8 char \n");
		goto reg1;}
		strcpy(regpasschk,regPassword);
    	strrev(regpasschk);
    	if(!strcmp(regPassword,regpasschk)){
 	    printf("%s adalah palindrome\n", regPassword);
		printf("Password tidak boleh berbentuk palindrome\n\n");
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
			break;}
		}
		for(i=0;regUserName[i]!=0;i++){userName[j][i]=regUserName[i];}
		for(i=0;regPassword[i]!=0;i++){password[j][i]=regPassword[i];}
		printf("username berhasil didaftarkan\n");
		printf(" Username	: ");
		for(i=0;regUserName[i]!=0;i++){printf("%c",userName[j][i]);}
		printf("\n Password	: ");
		for(i=0;regPassword[i]!=0;i++){printf("%c",password[j][i]);}
		printf("\n Kode User	: ");
		for(i=0;i<=2;i++){
		if(userName[j][i] >= 'A' && userName[j][i] <= 'Z'){
			{kodeUser[j][i]=userName[j][i];}
    		}else{kodeUser[j][i]=userName[j][i]-32;}
		}
		noUrut++;
		for(i=0;i<=2;i++){kodeString[i]=kodeUser[j][i];}
		kodeString[3]='\0';
		//sprintf(urutString, "%04d", noUrut); gagal pake sprintf karena bentrok dengan strcat
		snprintf(kodeStringTemp, 9, "%s-%04d",kodeString,noUrut);
	   	for(i=0;i<=7;i++){kodeUser[j][i]=kodeStringTemp[i];}
			for(i=0;i<=7;i++){printf("%c",kodeUser[j][i]);}
/*chg<*/
		fp = fopen("userdata.txt","w+");
		for(m=0;m<=besarTabel;m++){
				for(i=0;i<=besarTabel;i++){
					for(k=0;userName[i][k]!=0;k++){
						//printf("cek");
						userSave[k]=userName[i][k];
					}
					userSave[k]='\0';
					for(l=0;l<=0;l++){
						//printf("%s",userSave);
						fprintf(fp,"%s\n",userSave);	
					}
					if(!userName[i+1][0]){
						goto save1;
					}
				}
		}
		save1:
		fclose(fp);
		fp = fopen("kodedata.txt","w+");
		for(m=0;m<=besarTabel;m++){
				for(i=0;i<=besarTabel;i++){
					for(k=0;k<=7;k++){
						kodeSave[k]=kodeUser[i][k];
					}
					kodeSave[k]='\0';
					for(l=0;l<=0;l++){
						fprintf(fp,"%s\n",kodeSave);
					}
					if(!kodeUser[i+1][0]){
						goto save2;
					}
				}
		}
		save2:
		fclose(fp);
		fp = fopen("passdata.txt","w+");
		for(m=0;m<=besarTabel;m++){
				for(i=0;i<=besarTabel;i++){
					for(k=0;password[i][k]!=0;k++){
						passSave[k]=password[i][k];
					}
					passSave[k]='\0';
					for(l=0;l<=0;l++){
						fprintf(fp,"%s\n",passSave);
					}
					if(!password[i+1][0]){
						fclose(fp);
						//printf("...file saved!");
						goto eoreg;
					}
				}
		}
		eoreg:			
/*>chg*/
		getch();
		kodeStringTemp[0]='\0';
		system("cls");
		goto awal;
		break;
	case 2:
		login:
		printf("\n==LOGIN==\n");
		printf("Input username	: ");
		scanf("%s",inputUsername);
		for(i=0;i<=besarTabel;i++){
					for(k=0;k<=panjangTabel;k++){
						userString[k]=userName[i][k];
						//printf("%c",userName[i][k]);
						for(l=0;l<=7;l++){
							kodeStringTemp[l]=kodeUser[i][l];
						}
/*chg*/				kodeStringTemp[8]='\0';
					}
					/*printf("\n\nuserString 	i=%d: %s.",i,userString);
					printf("\ninputUsername	i=%d: %s.",i,inputUsername);*/
					usercmp=strcmp(userString,inputUsername);
					kodecmp=strcmp(kodeStringTemp,inputUsername);
					//fflush(stdout);
					if(usercmp==0){
						printf("Input password	: ");
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
						
							printf("Input password	: ");
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
		for(k=0;k<=panjangTabel;k++){userString[k]=userName[i][k];}
		printf("\nSELAMAT DATANG %s\n",userString);
		printf("== Data Anda ==\n");
		printf(" Username	: %s\n",userString);
		printf(" KodeUser	: %s\n",kodeStringTemp);
		kodeStringTemp[0]='\0';
/*chg<*/
		printf("\nUbah password %s? (y/n): ", userString);
		scanf(" %c", &pilc);
		if(pilc=='y'||pilc=='Y'){
			strcpy(regpasschk,inputPassword);
			sochg:
			printf("\nMasukkan password baru: ");
			scanf("%s",inputPassword);
			lcase=0,ucase=0,numer=0,spcch=0;
			if(!strcmp(regpasschk,inputPassword)){
				printf("Error: Password baru sama dengan password lama\n");
				goto sochg;
			}
			passlen=strlen(inputPassword);
			if(passlen<8){
				printf("Error: Password minimum 8 char \n");
			goto sochg;}
			strcpy(regpasschk,inputPassword);
	    	strrev(regpasschk);
	    	if(!strcmp(inputPassword,regpasschk)){
		 	    printf("%s adalah palindrome\n", inputPassword);
				printf("Password tidak boleh berbentuk palindrome\n\n");
			goto sochg;}
			for(m=0;inputPassword[m]!=0;m++){
				if(inputPassword[m]>='A' && inputPassword[m]<='Z')
				ucase++;
				if(inputPassword[m]>='a' && inputPassword[m]<='z')
				lcase++;
				if(inputPassword[m]>='0' && inputPassword[m]<='9')
				numer++;
				if((inputPassword[m]=='!'||inputPassword[m]=='@'||inputPassword[m]=='#'||inputPassword[m]=='$'
				||inputPassword[m]=='%'||inputPassword[m]=='^'||inputPassword[m]=='&'||inputPassword[m]=='*'
				||inputPassword[m]=='('||inputPassword[m]==')'||inputPassword[m]=='.'||inputPassword[m]==','))
				spcch++;
			}if(ucase==0){
				printf("Alfabet Kapital tidak ditemukan!\n");
				printf("Password harus terdiri dari huruf kecil, kapital, angka, dan karakter spesial\n\n");
				goto sochg;
			}else if(lcase==0){
				printf("Alfabet kecil tidak ditemukan!\n");
				printf("Password harus terdiri dari huruf kecil, kapital, angka, dan karakter spesial\n\n");
				goto sochg;
			}else if(numer==0){
				printf("Angka tidak ditemukan!\n");
				printf("Password harus terdiri dari huruf kecil, kapital, angka, dan karakter spesial\n\n");
				goto sochg;
			}else if(spcch==0){
				printf("Karakter Spesial tidak ditemukan!\n");
				printf("Password harus terdiri dari huruf kecil, kapital, angka, dan karakter spesial\n\n");
				goto sochg;
			}
			passlen=strlen(inputPassword);
			//printf("besar passlen %d",passlen);
			for(k=0;k<=passlen;k++){
				password[i][k]=inputPassword[k];
			}
			fp = fopen("passdata.txt","w+");
			rewind(fp);
			for(m=0;m<=besarTabel;m++){
					for(i=0;i<=besarTabel;i++){
						for(k=0;password[i][k]!=0;k++){
							passSave[k]=password[i][k];
						}
						passSave[k]='\0';
						for(l=0;l<=0;l++){
							fprintf(fp,"%s\n",passSave);
						}
						if(!password[i+1][0]){
							fclose(fp);
							printf("Password baru telah diterapkan!");
							getch();
							system("cls");
							goto awal;
							//break;
						}
					}
			}
		}else{
			pilc='\0';
			printf("Hapus akun? (y/n): ");
			scanf(" %c", &pilc);
			if(pilc=='y'||pilc=='Y'){
				pilc='\0';
				printf(" Anda akan menghapus akun %s",userString);
				printf("\n Lanjutkan? (y/n): ");
				scanf(" %c", &pilc);
				if(pilc=='y'||pilc=='Y')
				{
					passlen=strlen(inputPassword);
					userlen=strlen(userString);
					//printf("besar passlen %d",passlen);
					k=0;
					password[i][k]='¤';
					userName[i][k]='¤';
					kodeUser[i][k]='¤';	
					fp = fopen("userdata.txt","w+");
					rewind(fp);
					for(m=0;m<=besarTabel;m++){
							for(i=0;i<=besarTabel;i++){
								for(k=0;userName[i][k]!=0;k++){
									//printf("cek");
									userSave[k]=userName[i][k];
								}
								userSave[k]='\0';
								for(l=0;l<=0;l++){
									//printf("%s",userSave);
									fprintf(fp,"%s\n",userSave);	
								}
								if(!userName[i+1][0]){
									goto remkode;
								}else if(userName[i+1][0]=='¤'){
									fprintf(fp,"¤\n");
									i++;
								}
							}
					}
					remkode:
					fclose(fp);
					fp = fopen("kodedata.txt","w+");
					rewind(fp);
					for(m=0;m<=besarTabel;m++){
							for(i=0;i<=besarTabel;i++){
								for(k=0;k<=7;k++){
									kodeSave[k]=kodeUser[i][k];
								}
								kodeSave[k]='\0';
								for(l=0;l<=0;l++){
									fprintf(fp,"%s\n",kodeSave);
								}
								if(!kodeUser[i+1][0]){
									goto rempass;
								}else if(userName[i+1][0]=='¤'){
									fprintf(fp,"¤\n");
									i++;
								}
							}
					}
					rempass:
					fclose(fp);
					fp = fopen("passdata.txt","w+");
					rewind(fp);
					for(m=0;m<=besarTabel;m++){
						for(i=0;i<=besarTabel;i++){
							for(k=0;password[i][k]!=0;k++){
								passSave[k]=password[i][k];
							}
							passSave[k]='\0';
							for(l=0;l<=0;l++){
								fprintf(fp,"%s\n",passSave);
							}
							if(!password[i+1][0]){
								fclose(fp);
								printf("\n username telah dihapus!");
								getch();
								
								for(k=0;k<=passlen+userlen;k++){
									password[i][k]='\0';
									userName[i][k]='\0';
								}
								for(k=0;k<=7;k++){
									kodeUser[i][k]='\0';
								}
								kodeUser[i][k]='\0';
								
								system("cls");
								goto awal;
								//break;
							}else if(userName[i+1][0]=='¤'){
								fprintf(fp,"¤\n");
								i++;
							}
						}
					}
				}
				system("cls");
				goto awal;
			}else{
				system("cls");
				goto awal;
			}
		}
/*>chg*/
	case 3:
		printf("\n==LIST DATA==\n");
		for(m=0;m<=besarTabel;m++){
			if(userName[m][1]){
				//printf("ada data di slot j=%d\n",j);
				printf("\n==%d==\n",(m+1));
				printf(" Username : ");
				for(i=0;userName[m][i]!=0;i++){
					printf("%c",userName[m][i]);}
				printf("\nKode User : ");
				for(i=0;i<=7;i++){
					printf("%c",kodeUser[m][i]);}			
			}else{
				printf("\n--Akhir List Data--");
				//printf("tidak ada data di slot j=%d\n",j);
				break;
			}
		}
		getch();
		system("cls");
		goto awal;
		break;
	
	case 0:
		system("cls");
		goto awal;
		break;
	
	default:

		exit(0);
		break;
	}	
	return 0;
}
