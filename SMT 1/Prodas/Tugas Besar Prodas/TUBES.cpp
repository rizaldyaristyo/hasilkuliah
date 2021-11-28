//START
#include <stdio.h>
#include <string.h>
#include <windows.h>
#include <conio.h>
#include <time.h>
time_t waktu;
FILE *fp;

char kotak[9]={'0','1','2','3','4','5','6','7','8'};
void lvln();
void lvli();
void mabar();
void logic(char kotak[9]);
void papan(char kotak[9]);
void splash(){
	system("cls");
	printf("\n\n\n\t\t\tCreated by:\n");
	printf("\t\t\t   ____              _                   _   _          \n");
	printf("\t\t\t  / __ \\ __ _ _ _ __| |_ __ _ _ ___ __ _| |_(_)___ _ _  \n");
	printf("\t\t\t / / _` / _` | '_(_-<  _/ _| '_/ -_) _` |  _| / _ \\ ' \\ \n");
	printf("\t\t\t \\ \\__,_\\__,_|_| /__/\\__\\__|_| \\___\\__,_|\\__|_\\___/_||_|\n");
	printf("\t\t\t  \\____/  ");
	
	for (int i = 0; i < 45; i++)
        printf("%c", '.'); 
	printf("\r\t\t\t  \\____/  ");
	for (int i = 0; i < 45; i++) { 
        printf("%c", '>');    
        Sleep(15);
    }
	printf("\r\t\t\t  \\____/  ");
	for (int i = 0; i < 45; i++) { 
        printf("%c", '.');    
        Sleep(15);
    }
}
void logo(){
    printf("___________.__         ___________               ___________            \n");
	printf("\\__    ___/|__| ____   \\__    ___/____    ____   \\__    ___/__________\n");
	printf("  |    |   |  |/ ___\\    |    |  \\__  \\ _/ ___\\    |    | /  _ \\_/ __ \\ \n");
	printf("  |    |   |  |\\  \\__    |    |   / __ \\\\  \\___    |    |(  <_> )  ___/ \n");
	printf("  |____|   |__|\\___  >   |____|  (____  /\\___  >   |____| \\____/ \\___  >\n");
	printf("                   \\/                 \\/     \\/  TIC-TAC-TOE Versi C \\/  \n");
}
int main()
{
	splash();
	Sleep(300);
	menu:
	int pilihan,i;
	system("cls");
	logo();
	printf("\n\t\t\t     ==Menu==\n\t\t\t 1.) VS COM Lv.0\n\t\t\t 2.) VS COM Logic\n\t\t\t");
	printf(" 3.) VS Human\n\t\t\t 0.) EXIT\n\n\t\t\t Pilihan: ");
	scanf("%d",&pilihan);
	switch(pilihan)
	{
	case 1:
		lvln();
		goto menu;
		break;
	case 2:
		lvli();
		goto menu;
		break;
	case 3:
		mabar();
		goto menu;
		break;
	default:
		splash();
		printf("Bye");
		for(i=0;i<=2;i++)
		{
			Sleep(300);
			printf("~");
		}
		Sleep(1000);
		printf("\n\n\n");
		exit(0);
	}
	
	
	return 0;
}
void lvln()
{
	int P1=0,P2=0,i;
	reset:
	int pilihan,giliran=0; //giliran P1=0 P2=1
	char kotak[9]={'0','1','2','3','4','5','6','7','8'};
	awal:
	system("cls");
	logo();
	printf("\n\t\t\t     ==Skor==\n");
	printf("\t\t\t   Player 1  (X): %d\n",P1);
    printf("\t\t\t   Com(lv.0) (O): %d\n\n",P2);
    papan(kotak);
	//whorizontal P1
	if		(kotak[0]=='X'&&kotak[1]=='X'&&kotak[2]=='X') {printf("\t\t\tP1 Menang!"); P1++; getch(); goto reset;}
	else if (kotak[3]=='X'&&kotak[4]=='X'&&kotak[5]=='X') {printf("\t\t\tP1 Menang!"); P1++; getch(); goto reset;}
	else if (kotak[6]=='X'&&kotak[7]=='X'&&kotak[8]=='X') {printf("\t\t\tP1 Menang!"); P1++; getch(); goto reset;}
	//wvertikal P1
	else if (kotak[0]=='X'&&kotak[3]=='X'&&kotak[6]=='X') {printf("\t\t\tP1 Menang!"); P1++; getch(); goto reset;}
	else if (kotak[1]=='X'&&kotak[4]=='X'&&kotak[7]=='X') {printf("\t\t\tP1 Menang!"); P1++; getch(); goto reset;}
	else if (kotak[2]=='X'&&kotak[5]=='X'&&kotak[8]=='X') {printf("\t\t\tP1 Menang!"); P1++; getch(); goto reset;}
	//wdiagonal P1
	else if (kotak[0]=='X'&&kotak[4]=='X'&&kotak[8]=='X') {printf("\t\t\tP1 Menang!"); P1++; getch(); goto reset;}
	else if (kotak[2]=='X'&&kotak[4]=='X'&&kotak[6]=='X') {printf("\t\t\tP1 Menang!"); P1++; getch(); goto reset;}
	//whorizontal P2
	else if (kotak[0]=='O'&&kotak[1]=='O'&&kotak[2]=='O') {printf("\t\t\tKomputer Menang!"); P2++; getch(); goto reset;}
	else if (kotak[3]=='O'&&kotak[4]=='O'&&kotak[5]=='O') {printf("\t\t\tKomputer Menang!"); P2++; getch(); goto reset;}
	else if (kotak[6]=='O'&&kotak[7]=='O'&&kotak[8]=='O') {printf("\t\t\tKomputer Menang!"); P2++; getch(); goto reset;}
	//wvertikal P2
	else if (kotak[0]=='O'&&kotak[3]=='O'&&kotak[6]=='O') {printf("\t\t\tKomputer Menang!"); P2++; getch(); goto reset;}
	else if (kotak[1]=='O'&&kotak[4]=='O'&&kotak[7]=='O') {printf("\t\t\tKomputer Menang!"); P2++; getch(); goto reset;}
	else if (kotak[2]=='O'&&kotak[5]=='O'&&kotak[8]=='O') {printf("\t\t\tKomputer Menang!"); P2++; getch(); goto reset;}
	//wdiagonal P2
	else if (kotak[0]=='O'&&kotak[4]=='O'&&kotak[8]=='O') {printf("\t\t\tKomputer Menang!"); P2++; getch(); goto reset;}
	else if (kotak[2]=='O'&&kotak[4]=='O'&&kotak[6]=='O') {printf("\t\t\tKomputer Menang!"); P2++; getch(); goto reset;}
	//seri
	else if (kotak[0]!='0'&&kotak[1]!='1'&&kotak[2]!='2'&&kotak[3]!='3'&&kotak[4]!='4'&&kotak[5]!='5'&&kotak[6]!='6'&&kotak[7]!='7'&&kotak[8]!='8')
	{printf("\t\t\tSeri!"); getch(); goto reset;}
	else{
		if(giliran==0){
			system("color 0A");
			printf("\t\t\tP1 masukkan angka (99 untuk keluar): ");
			scanf("%d",&pilihan);
			if	   (pilihan==0&&kotak[0]=='0') kotak[0]='X';
			else if(pilihan==1&&kotak[1]=='1') kotak[1]='X';
			else if(pilihan==2&&kotak[2]=='2') kotak[2]='X';
			else if(pilihan==3&&kotak[3]=='3') kotak[3]='X';
			else if(pilihan==4&&kotak[4]=='4') kotak[4]='X';
			else if(pilihan==5&&kotak[5]=='5') kotak[5]='X';
			else if(pilihan==6&&kotak[6]=='6') kotak[6]='X';
			else if(pilihan==7&&kotak[7]=='7') kotak[7]='X';
			else if(pilihan==8&&kotak[8]=='8') kotak[8]='X';
			else if(pilihan==99) goto menu;
			else{
				printf("Input salah");
				getch();
				goto awal;
			}
			giliran=1;
			goto awal;
		}else{
			system("color 0B");
			printf("\t\t\tComputer");
			for(i=0;i<=2;i++){
				Sleep(500*i/2);
				printf(".");
			}
			err:
			pilihan=rand()%(8+1-0)+0;
			if	   (pilihan==0&&kotak[0]=='0') kotak[0]='O';
			else if(pilihan==1&&kotak[1]=='1') kotak[1]='O';
			else if(pilihan==2&&kotak[2]=='2') kotak[2]='O';
			else if(pilihan==3&&kotak[3]=='3') kotak[3]='O';
			else if(pilihan==4&&kotak[4]=='4') kotak[4]='O';
			else if(pilihan==5&&kotak[5]=='5') kotak[5]='O';
			else if(pilihan==6&&kotak[6]=='6') kotak[6]='O';
			else if(pilihan==7&&kotak[7]=='7') kotak[7]='O';
			else if(pilihan==8&&kotak[8]=='8') kotak[8]='O';
			else goto err;
			giliran=0;
			goto awal;
			
		}
	}
	menu:;
}

void lvli(){
	int P1=0,P2=0,i;
	reset:
	int pilihan,giliran=0,terisi=0,random=0; //giliran P1=0 P2=1
	char kotak[9]={'0','1','2','3','4','5','6','7','8'};
	awal:
	system("cls");
	logo();
	printf("\n\t\t\t     ==Skor==\n");
	printf("\t\t\t   Player 1   (X): %d\n",P1);
    printf("\t\t\t   Com(logic) (O): %d\n\n",P2);
    papan(kotak);
	//whorizontal P1
	if		(kotak[0]=='X'&&kotak[1]=='X'&&kotak[2]=='X') {printf("\t\t\tP1 Menang!"); P1++; getch(); goto reset;}
	else if (kotak[3]=='X'&&kotak[4]=='X'&&kotak[5]=='X') {printf("\t\t\tP1 Menang!"); P1++; getch(); goto reset;}
	else if (kotak[6]=='X'&&kotak[7]=='X'&&kotak[8]=='X') {printf("\t\t\tP1 Menang!"); P1++; getch(); goto reset;}
	//wvertikal P1
	else if (kotak[0]=='X'&&kotak[3]=='X'&&kotak[6]=='X') {printf("\t\t\tP1 Menang!"); P1++; getch(); goto reset;}
	else if (kotak[1]=='X'&&kotak[4]=='X'&&kotak[7]=='X') {printf("\t\t\tP1 Menang!"); P1++; getch(); goto reset;}
	else if (kotak[2]=='X'&&kotak[5]=='X'&&kotak[8]=='X') {printf("\t\t\tP1 Menang!"); P1++; getch(); goto reset;}
	//wdiagonal P1
	else if (kotak[0]=='X'&&kotak[4]=='X'&&kotak[8]=='X') {printf("\t\t\tP1 Menang!"); P1++; getch(); goto reset;}
	else if (kotak[2]=='X'&&kotak[4]=='X'&&kotak[6]=='X') {printf("\t\t\tP1 Menang!"); P1++; getch(); goto reset;}
	//whorizontal P2
	else if (kotak[0]=='O'&&kotak[1]=='O'&&kotak[2]=='O') {printf("\t\t\tKomputer Menang!"); P2++; getch(); goto reset;}
	else if (kotak[3]=='O'&&kotak[4]=='O'&&kotak[5]=='O') {printf("\t\t\tKomputer Menang!"); P2++; getch(); goto reset;}
	else if (kotak[6]=='O'&&kotak[7]=='O'&&kotak[8]=='O') {printf("\t\t\tKomputer Menang!"); P2++; getch(); goto reset;}
	//wvertikal P2
	else if (kotak[0]=='O'&&kotak[3]=='O'&&kotak[6]=='O') {printf("\t\t\tKomputer Menang!"); P2++; getch(); goto reset;}
	else if (kotak[1]=='O'&&kotak[4]=='O'&&kotak[7]=='O') {printf("\t\t\tKomputer Menang!"); P2++; getch(); goto reset;}
	else if (kotak[2]=='O'&&kotak[5]=='O'&&kotak[8]=='O') {printf("\t\t\tKomputer Menang!"); P2++; getch(); goto reset;}
	//wdiagonal P2
	else if (kotak[0]=='O'&&kotak[4]=='O'&&kotak[8]=='O') {printf("\t\t\tKomputer Menang!"); P2++; getch(); goto reset;}
	else if (kotak[2]=='O'&&kotak[4]=='O'&&kotak[6]=='O') {printf("\t\t\tKomputer Menang!"); P2++; getch(); goto reset;}
	//seri
	else if (kotak[0]!='0'&&kotak[1]!='1'&&kotak[2]!='2'&&kotak[3]!='3'&&kotak[4]!='4'&&kotak[5]!='5'&&kotak[6]!='6'&&kotak[7]!='7'&&kotak[8]!='8')
	{printf("\t\t\tSeri!"); getch(); goto reset;}
	else{
		if(giliran==0){
			system("color 0A");
			printf("\t\t\tP1 masukkan angka (99 untuk keluar): ");
			scanf("%d",&pilihan);
			if	   (pilihan==0&&kotak[0]=='0') kotak[0]='X';
			else if(pilihan==1&&kotak[1]=='1') kotak[1]='X';
			else if(pilihan==2&&kotak[2]=='2') kotak[2]='X';
			else if(pilihan==3&&kotak[3]=='3') kotak[3]='X';
			else if(pilihan==4&&kotak[4]=='4') kotak[4]='X';
			else if(pilihan==5&&kotak[5]=='5') kotak[5]='X';
			else if(pilihan==6&&kotak[6]=='6') kotak[6]='X';
			else if(pilihan==7&&kotak[7]=='7') kotak[7]='X';
			else if(pilihan==8&&kotak[8]=='8') kotak[8]='X';
			else if(pilihan==99) goto menu;
			else{
				printf("Input salah");
				getch();
				goto awal;
			}
			giliran=1;
			terisi++;
			goto awal;
		}else{
			system("color 0B");
			printf("\t\t\tComputer");
			for(i=0;i<=2;i++){
				Sleep(500*i/2);
				printf(".");
			}
			if(terisi==1){
				do{
					random=rand()%(8+1-0)+0;
				}while(random==4);
				if		(kotak[4]!='X') kotak[4]='O';
				else if (kotak[random]!='X'){
					printf("Rand Decision on %d", random);
					Sleep(200);
					kotak[random]='O';
				}
			}
			else if(terisi==3){
				if	   (kotak[0]=='X'&&kotak[1]=='X'&&kotak[2]!='O') kotak[2]='O';
				else if(kotak[1]=='X'&&kotak[2]=='X'&&kotak[0]!='O') kotak[0]='O';
				else if(kotak[3]=='X'&&kotak[4]=='X'&&kotak[5]!='O') kotak[5]='O';
				else if(kotak[4]=='X'&&kotak[5]=='X'&&kotak[3]!='O') kotak[3]='O';
				else if(kotak[6]=='X'&&kotak[7]=='X'&&kotak[8]!='O') kotak[8]='O';
				else if(kotak[7]=='X'&&kotak[8]=='X'&&kotak[6]!='O') kotak[6]='O';
				else if(kotak[0]=='X'&&kotak[4]=='X'&&kotak[8]!='O') kotak[8]='O';
				else if(kotak[4]=='X'&&kotak[8]=='X'&&kotak[0]!='O') kotak[0]='O';
				else if(kotak[2]=='X'&&kotak[4]=='X'&&kotak[6]!='O') kotak[6]='O';
				else if(kotak[4]=='X'&&kotak[6]=='X'&&kotak[2]!='O') kotak[2]='O';
				else if(kotak[6]=='X'&&kotak[8]=='X'&&kotak[7]!='O') kotak[7]='O';
				else if(kotak[2]=='X'&&kotak[8]=='X'&&kotak[5]!='O') kotak[5]='O';
				else if(kotak[0]=='X'&&kotak[6]=='X'&&kotak[3]!='O') kotak[3]='O';
				else if(kotak[0]=='X'&&kotak[2]=='X'&&kotak[1]!='O') kotak[1]='O';
				else if(kotak[3]=='X'&&kotak[6]=='X'&&kotak[4]!='O') kotak[4]='O';
				else if(kotak[0]=='X'&&kotak[8]=='X'&&kotak[4]!='O') kotak[4]='O';
				else if(kotak[0]=='X'&&kotak[3]=='X'&&kotak[6]!='O') kotak[6]='O';
				else if(kotak[3]=='X'&&kotak[6]=='X'&&kotak[0]!='O') kotak[0]='O';
				else if(kotak[1]=='X'&&kotak[4]=='X'&&kotak[7]!='O') kotak[7]='O';
				else if(kotak[4]=='X'&&kotak[7]=='X'&&kotak[1]!='O') kotak[1]='O';
				else if(kotak[2]=='X'&&kotak[5]=='X'&&kotak[8]!='O') kotak[8]='O';
				else if(kotak[5]=='X'&&kotak[8]=='X'&&kotak[2]!='O') kotak[2]='O';
				else{
					int random;
					rand:
					do{
						random=rand()%(8+1-0)+0;
					}while(random==4);
					if	   (random==0&&kotak[0]=='0') kotak[random]='O';
					else if(random==1&&kotak[1]=='1') kotak[random]='O';
					else if(random==2&&kotak[2]=='2') kotak[random]='O';
					else if(random==3&&kotak[3]=='3') kotak[random]='O';
					else if(random==4&&kotak[4]=='4') kotak[random]='O';
					else if(random==5&&kotak[5]=='5') kotak[random]='O';
					else if(random==6&&kotak[6]=='6') kotak[random]='O';
					else if(random==7&&kotak[7]=='7') kotak[random]='O';
					else if(random==8&&kotak[8]=='8') kotak[random]='O';
					else goto rand;
					printf("Rand Decision on %d", random);
					Sleep(200);
				}
			}
			else if(terisi==5||terisi==7){
				logic(kotak);
			}
			else printf("terisi var error");	
			giliran=0;
			terisi++;
			goto awal;
		}
	}
	menu:;
}

void mabar(){

	int P1=0,P2=0;
	reset:
	int pilihan,giliran=0; //giliran P1=0 P2=1
	char kotak[9]={'0','1','2','3','4','5','6','7','8'};
	awal:
	system("cls");
	logo();
	printf("\n\t\t\t     ==Skor==\n");
	printf("\t\t\t   Player 1 (X): %d\n",P1);
    printf("\t\t\t   Player 2 (O): %d\n\n",P2);
    papan(kotak);
	//whorizontal P1
	if		(kotak[0]=='X'&&kotak[1]=='X'&&kotak[2]=='X') {printf("\t\t\tP1 Menang!"); P1++; getch(); goto reset;}
	else if (kotak[3]=='X'&&kotak[4]=='X'&&kotak[5]=='X') {printf("\t\t\tP1 Menang!"); P1++; getch(); goto reset;}
	else if (kotak[6]=='X'&&kotak[7]=='X'&&kotak[8]=='X') {printf("\t\t\tP1 Menang!"); P1++; getch(); goto reset;}
	//wvertikal P1
	else if (kotak[0]=='X'&&kotak[3]=='X'&&kotak[6]=='X') {printf("\t\t\tP1 Menang!"); P1++; getch(); goto reset;}
	else if (kotak[1]=='X'&&kotak[4]=='X'&&kotak[7]=='X') {printf("\t\t\tP1 Menang!"); P1++; getch(); goto reset;}
	else if (kotak[2]=='X'&&kotak[5]=='X'&&kotak[8]=='X') {printf("\t\t\tP1 Menang!"); P1++; getch(); goto reset;}
	//wdiagonal P1
	else if (kotak[0]=='X'&&kotak[4]=='X'&&kotak[8]=='X') {printf("\t\t\tP1 Menang!"); P1++; getch(); goto reset;}
	else if (kotak[2]=='X'&&kotak[4]=='X'&&kotak[6]=='X') {printf("\t\t\tP1 Menang!"); P1++; getch(); goto reset;}
	//whorizontal P2
	else if (kotak[0]=='O'&&kotak[1]=='O'&&kotak[2]=='O') {printf("\t\t\tP2 Menang!"); P2++; getch(); goto reset;}
	else if (kotak[3]=='O'&&kotak[4]=='O'&&kotak[5]=='O') {printf("\t\t\tP2 Menang!"); P2++; getch(); goto reset;}
	else if (kotak[6]=='O'&&kotak[7]=='O'&&kotak[8]=='O') {printf("\t\t\tP2 Menang!"); P2++; getch(); goto reset;}
	//wvertikal P2
	else if (kotak[0]=='O'&&kotak[3]=='O'&&kotak[6]=='O') {printf("\t\t\tP2 Menang!"); P2++; getch(); goto reset;}
	else if (kotak[1]=='O'&&kotak[4]=='O'&&kotak[7]=='O') {printf("\t\t\tP2 Menang!"); P2++; getch(); goto reset;}
	else if (kotak[2]=='O'&&kotak[5]=='O'&&kotak[8]=='O') {printf("\t\t\tP2 Menang!"); P2++; getch(); goto reset;}
	//wdiagonal P2
	else if (kotak[0]=='O'&&kotak[4]=='O'&&kotak[8]=='O') {printf("\t\t\tP2 Menang!"); P2++; getch(); goto reset;}
	else if (kotak[2]=='O'&&kotak[4]=='O'&&kotak[6]=='O') {printf("\t\t\tP2 Menang!"); P2++; getch(); goto reset;}
	//seri
	else if (kotak[0]!='0'&&kotak[1]!='1'&&kotak[2]!='2'&&kotak[3]!='3'&&kotak[4]!='4'&&kotak[5]!='5'&&kotak[6]!='6'&&kotak[7]!='7'&&kotak[8]!='8')
	{printf("\t\t\tSeri!"); getch(); goto reset;}
	else{
		if(giliran==0){
			system("color 0A");
			printf("\t\t\tP1 masukkan angka (99 untuk keluar): ");
			scanf("%d",&pilihan);
			if	   (pilihan==0&&kotak[0]=='0') kotak[0]='X';
			else if(pilihan==1&&kotak[1]=='1') kotak[1]='X';
			else if(pilihan==2&&kotak[2]=='2') kotak[2]='X';
			else if(pilihan==3&&kotak[3]=='3') kotak[3]='X';
			else if(pilihan==4&&kotak[4]=='4') kotak[4]='X';
			else if(pilihan==5&&kotak[5]=='5') kotak[5]='X';
			else if(pilihan==6&&kotak[6]=='6') kotak[6]='X';
			else if(pilihan==7&&kotak[7]=='7') kotak[7]='X';
			else if(pilihan==8&&kotak[8]=='8') kotak[8]='X';
			else if(pilihan==99) goto menu;
			else{
				printf("Input salah");
				getch();
				goto awal;
			}
			giliran=1; goto awal;
		}else{
			system("color 0B");
			printf("\t\t\tP2 masukkan angka (99 untuk keluar): ");
			scanf("%d",&pilihan);
			if	   (pilihan==0&&kotak[0]=='0') kotak[0]='O';
			else if(pilihan==1&&kotak[1]=='1') kotak[1]='O';
			else if(pilihan==2&&kotak[2]=='2') kotak[2]='O';
			else if(pilihan==3&&kotak[3]=='3') kotak[3]='O';
			else if(pilihan==4&&kotak[4]=='4') kotak[4]='O';
			else if(pilihan==5&&kotak[5]=='5') kotak[5]='O';
			else if(pilihan==6&&kotak[6]=='6') kotak[6]='O';
			else if(pilihan==7&&kotak[7]=='7') kotak[7]='O';
			else if(pilihan==8&&kotak[8]=='8') kotak[8]='O';
			else if(pilihan==99) goto menu;
			else{
				printf("Input salah");
				getch();
				goto awal;
			}
			giliran=0; goto awal;
		}
	}
	menu:;
}
void logic(char kotak[9]){
	if	   (kotak[0]=='O'&&kotak[1]=='O'&&kotak[2]=='2') kotak[2]='O';
	else if(kotak[1]=='O'&&kotak[2]=='O'&&kotak[0]=='0') kotak[0]='O';
	else if(kotak[3]=='O'&&kotak[4]=='O'&&kotak[5]=='5') kotak[5]='O';
	else if(kotak[4]=='O'&&kotak[5]=='O'&&kotak[3]=='3') kotak[3]='O';
	else if(kotak[6]=='O'&&kotak[7]=='O'&&kotak[8]=='8') kotak[8]='O';
	else if(kotak[7]=='O'&&kotak[8]=='O'&&kotak[6]=='6') kotak[6]='O';
	else if(kotak[0]=='O'&&kotak[4]=='O'&&kotak[8]=='8') kotak[8]='O';
	else if(kotak[4]=='O'&&kotak[8]=='O'&&kotak[0]=='0') kotak[0]='O';
	else if(kotak[2]=='O'&&kotak[4]=='O'&&kotak[6]=='6') kotak[6]='O';
	else if(kotak[4]=='O'&&kotak[6]=='O'&&kotak[2]=='2') kotak[2]='O';
	else if(kotak[6]=='O'&&kotak[8]=='O'&&kotak[7]=='7') kotak[7]='O';
	else if(kotak[2]=='O'&&kotak[8]=='O'&&kotak[5]=='5') kotak[5]='O';
	else if(kotak[0]=='O'&&kotak[6]=='O'&&kotak[3]=='3') kotak[3]='O';
	else if(kotak[0]=='O'&&kotak[2]=='O'&&kotak[1]=='1') kotak[1]='O';
	else if(kotak[3]=='O'&&kotak[6]=='O'&&kotak[4]=='4') kotak[4]='O';
	else if(kotak[0]=='O'&&kotak[8]=='O'&&kotak[4]=='4') kotak[4]='O';
	else if(kotak[1]=='O'&&kotak[7]=='O'&&kotak[4]=='4') kotak[4]='O';
	else if(kotak[3]=='O'&&kotak[5]=='O'&&kotak[4]=='4') kotak[4]='O';
	else if(kotak[0]=='O'&&kotak[3]=='O'&&kotak[6]=='6') kotak[6]='O';
	else if(kotak[3]=='O'&&kotak[6]=='O'&&kotak[0]=='0') kotak[0]='O';
	else if(kotak[1]=='O'&&kotak[4]=='O'&&kotak[7]=='7') kotak[7]='O';
	else if(kotak[4]=='O'&&kotak[7]=='O'&&kotak[1]=='1') kotak[1]='O';
	else if(kotak[2]=='O'&&kotak[5]=='O'&&kotak[8]=='8') kotak[8]='O';
	else if(kotak[5]=='O'&&kotak[8]=='O'&&kotak[2]=='2') kotak[2]='O';
	else if(kotak[0]=='X'&&kotak[1]=='X'&&kotak[2]=='2') kotak[2]='O';
	else if(kotak[1]=='X'&&kotak[2]=='X'&&kotak[0]=='0') kotak[0]='O';
	else if(kotak[3]=='X'&&kotak[4]=='X'&&kotak[5]=='5') kotak[5]='O';
	else if(kotak[4]=='X'&&kotak[5]=='X'&&kotak[3]=='3') kotak[3]='O';
	else if(kotak[6]=='X'&&kotak[7]=='X'&&kotak[8]=='8') kotak[8]='O';
	else if(kotak[7]=='X'&&kotak[8]=='X'&&kotak[6]=='6') kotak[6]='O';
	else if(kotak[0]=='X'&&kotak[4]=='X'&&kotak[8]=='8') kotak[8]='O';
	else if(kotak[4]=='X'&&kotak[8]=='X'&&kotak[0]=='0') kotak[0]='O';
	else if(kotak[2]=='X'&&kotak[4]=='X'&&kotak[6]=='6') kotak[6]='O';
	else if(kotak[4]=='X'&&kotak[6]=='X'&&kotak[2]=='2') kotak[2]='O';
	else if(kotak[6]=='X'&&kotak[8]=='X'&&kotak[7]=='7') kotak[7]='O';
	else if(kotak[2]=='X'&&kotak[8]=='X'&&kotak[5]=='5') kotak[5]='O';
	else if(kotak[0]=='X'&&kotak[6]=='X'&&kotak[3]=='3') kotak[3]='O';
	else if(kotak[0]=='X'&&kotak[2]=='X'&&kotak[1]=='1') kotak[1]='O';
	else if(kotak[3]=='X'&&kotak[6]=='X'&&kotak[4]=='4') kotak[4]='O';
	else if(kotak[0]=='X'&&kotak[8]=='X'&&kotak[4]=='4') kotak[4]='O';
	else if(kotak[1]=='X'&&kotak[7]=='X'&&kotak[4]=='4') kotak[4]='O';
	else if(kotak[3]=='X'&&kotak[5]=='X'&&kotak[4]=='4') kotak[4]='O';
	else if(kotak[0]=='X'&&kotak[3]=='X'&&kotak[6]=='6') kotak[6]='O';
	else if(kotak[3]=='X'&&kotak[6]=='X'&&kotak[0]=='0') kotak[0]='O';
	else if(kotak[1]=='X'&&kotak[4]=='X'&&kotak[7]=='7') kotak[7]='O';
	else if(kotak[4]=='X'&&kotak[7]=='X'&&kotak[1]=='1') kotak[1]='O';
	else if(kotak[2]=='X'&&kotak[5]=='X'&&kotak[8]=='8') kotak[8]='O';
	else if(kotak[5]=='X'&&kotak[8]=='X'&&kotak[2]=='2') kotak[2]='O';
	else{
		int random;
		rand:
		do{
			random=rand()%(8+1-0)+0;
		}while(random==4);
		if	   (random==0&&kotak[0]=='0') kotak[random]='O';
		else if(random==1&&kotak[1]=='1') kotak[random]='O';
		else if(random==2&&kotak[2]=='2') kotak[random]='O';
		else if(random==3&&kotak[3]=='3') kotak[random]='O';
		else if(random==4&&kotak[4]=='4') kotak[random]='O';
		else if(random==5&&kotak[5]=='5') kotak[random]='O';
		else if(random==6&&kotak[6]=='6') kotak[random]='O';
		else if(random==7&&kotak[7]=='7') kotak[random]='O';
		else if(random==8&&kotak[8]=='8') kotak[random]='O';
		else goto rand;
		printf("Rand Decision on %d", random);
		Sleep(200);
	}
}

void papan(char kotak[9]){
 	time(&waktu);
    printf("\n\t\t\t     |     |     \n");
    printf("\t\t\t  %c  |  %c  |  %c  \n", kotak[0], kotak[1], kotak[2]);
    printf("\t\t\t_____|_____|_____\n");
    printf("\t\t\t     |     |     \n");
    printf("\t\t\t  %c  |  %c  |  %c  \n", kotak[3], kotak[4], kotak[5]);
    printf("\t\t\t_____|_____|_____\n");
    printf("\t\t\t     |     |     \n");
    printf("\t\t\t  %c  |  %c  |  %c  \n", kotak[6], kotak[7], kotak[8]);
    printf("\t\t\t     |     |     \n\n");
    fp = fopen("rekam-jejak-3t.txt","a");
	fprintf(fp,"Waktu: %s", ctime(&waktu));
    fprintf(fp,"\t\t\t     |     |     \n");
    fprintf(fp,"\t\t\t  %c  |  %c  |  %c  \n", kotak[0], kotak[1], kotak[2]);
    fprintf(fp,"\t\t\t_____|_____|_____\n");
    fprintf(fp,"\t\t\t     |     |     \n");
    fprintf(fp,"\t\t\t  %c  |  %c  |  %c  \n", kotak[3], kotak[4], kotak[5]);
    fprintf(fp,"\t\t\t_____|_____|_____\n");
    fprintf(fp,"\t\t\t     |     |     \n");
    fprintf(fp,"\t\t\t  %c  |  %c  |  %c  \n", kotak[6], kotak[7], kotak[8]);
    fprintf(fp,"\t\t\t     |     |     \n\n");
    fclose(fp);
}

//EOF