#include <stdio.h>
#include <string.h>
#include <stdlib.h>

void cekName(char inName[20]);
void cekFrom(char inFrom[20]);
void cekDate(int date);
void list();

char book[10][100] = {"2021","A Book","Malang"};
char place[3][10] = {"Batu","Malang","Surabaya"};
char bookS[10];
char placeS[3];

int main(){
	char inName[20], inFrom[10], inBook[10];
	int inDate;
	
	printf("Wellcome\nInput Book = \n");
	scanf("%s", inBook);
	
	printf("Nama : ");
	scanf("%s", inName);
	cekName(inName);

	printf("From : ");
	scanf("%s", inFrom);	
	cekFrom(inFrom);
	
	printf("Date : ");
	scanf("%d", &inDate);
	cekDate(inDate);

	sprintf(inName, "%s, %s, %d", inName, inFrom, inDate);
	strcpy(bookS, inName);	
	printf("Menambahkan Buku Sukses!");	
	
	return 0;
}

void cekDate(int date){
	if(date <= 2018 || date >= 2021){
		printf("\n<<if");
	}else{
		printf("\n<<else");
	}
}

void cekFrom(char inFrom[]){
	int t=0;
	for(int i=0; place[i][0] != '\0'; i++){
		for(int j=0; place[i][j] != '\0'; j++){
			placeS[j]=place[i][j];
		}
		printf("\n%s = %s\n",inFrom,placeS);
		if(strcmp(inFrom,placeS) == 0){
			break;
			t=1;
		}
	}
	if(t==1){
		printf("\n>>if");
	}else{
		printf("\n>>else");
	}
}

void cekName(char inName[20]){
	int t=0;
	for(int i = 0; book[i][0] != '\0'; i++){
		for(int j=0; book[i][j] != '\0'; j++){
			bookS[j]=book[i][j];
		}
		printf("\n%s = %s\n",inName,bookS);
		if(strcmp(inName, bookS) == 0){
			break;
			t=1;
		}
	}
	if(t==1){
		printf("\n||if");
	}else{
		printf("\n||else");
	}
}

void list(){
	for(int i = 0; book[i][0] != '\0'; i++){
		//printf("\n%s\n", book[i]);
	}
}