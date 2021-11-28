#include <stdio.h>
#include <windows.h>
#include <conio.h>


int main()
{
	int P1=0,P2=0;
	reset:
	int pilihan,giliran=0; //giliran P1=0 P2=1
	char kotak[9]={'0','1','2','3','4','5','6','7','8'};
	awal:
	system("cls");
    printf("___________.__         ___________               ___________            \n");
	printf("\\__    ___/|__| ____   \\__    ___/____    ____   \\__    ___/_versi_c__\n");
	printf("  |    |   |  |/ ___\\    |    |  \\__  \\ _/ ___\\    |    | /  _ \\_/ __ \\ \n");
	printf("  |    |   |  |\\  \\__    |    |   / __ \\\\  \\___    |    |(  <_> )  ___/ \n");
	printf("  |____|   |__|\\___  >   |____|  (____  /\\___  >   |____| \\____/ \\___  >\n");
	printf("                   \\/                 \\/     \\/                      \\/  \n");
    printf("\n\t\t\t     ==Skor==\n");
	printf("\t\t\t   Player 1 (X): %d\n",P1);
    printf("\t\t\t   Player 2 (O): %d\n\n",P2);
    printf("\t\t\t     |     |     \n");
    printf("\t\t\t  %c  |  %c  |  %c  \n", kotak[0], kotak[1], kotak[2]);
    printf("\t\t\t_____|_____|_____\n");
    printf("\t\t\t     |     |     \n");
    printf("\t\t\t  %c  |  %c  |  %c  \n", kotak[3], kotak[4], kotak[5]);
    printf("\t\t\t_____|_____|_____\n");
    printf("\t\t\t     |     |     \n");
    printf("\t\t\t  %c  |  %c  |  %c  \n", kotak[6], kotak[7], kotak[8]);
    printf("\t\t\t     |     |     \n\n");

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
		
	else if (kotak[0]!='0'&&kotak[1]!='1'&&kotak[2]!='2'&&kotak[3]!='3'&&kotak[4]!='4'&&kotak[5]!='5'&&kotak[6]!='6'&&kotak[7]!='7'&&kotak[8]!='8')
	{printf("\t\t\tSeri!"); getch(); goto reset;}
	else{
		if(giliran==0){
			system("color 0A");
			printf("\t\t\tP1 masukkan angka: ");
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
			else{
				printf("Input salah");
				getch();
				goto awal;
			}
			giliran=1;
			goto awal;
		}else{
			system("color 0B");
			printf("\t\t\tP2 masukkan angka: ");
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
			else{
				printf("Input salah");
				getch();
				goto awal;
			}
			giliran=0;
			goto awal;
			
		}
	}
		
	return 0;
}