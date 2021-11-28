#include <stdio.h>
#include <string.h>
#include <stdlib.h>

void cekName(char inName[20]);
void cekFrom(char inFrom[20]);
void cekDate(int date);
void list();

char book[50][100] = {"A Book, Malang. 2021"};
char place[3][10] = {"Batu","Malang","Surabaya"};
char bookString[10];
char placeString[10];

int main(){  
	char inName[20], inFrom[10], name[50];
	int inDate;
	printf("Wellcome\nInput Book = \n");
	printf("Nama : ");
	scanf("%s", inName);
	cekName(inName);
	printf("From : ");
	scanf("%s", inFrom);
	cekFrom(inFrom);
	printf("Date : ");
	scanf("%d", &inDate);
	cekDate(inDate);
	sprintf(name, "%s, %s. %d", inName, inFrom, inDate);
	strcpy(book[1],name);
	printf("Menambahkan Buku Sukses!");
	list();
	return 0;
}

void cekDate(int date){
	if(date <= 2018 || date >= 2021){
		
	}
}

void cekFrom(char inFrom[]){
	for(int i = 0; place[i][0] != '\0'; i++){
		for(int j = 0; place[i][j] != '\0'; i++){
			placeString[i]=place[i][j];
		}
		if(strcmp(inFrom, placeString) == 0){
			printf("%s == %s",inFrom,placeString);
			printf("\n ----------> cekFrom broke!\n");
			break;
		}
	}
}

void cekName(char inName[]){
	for(int i = 0; book[i][0] != '\0'; i++){
		for(int j = 0; place[i][j] != '\0'; i++){
			bookString[i]=book[i][j];
		}
		if(strcmp(inName, bookString) == 0){
			printf("%s == %s",inName,bookString);
			printf("\n ----------> cekName broke!\n");
			break;
		}
	}
}

void list(){
	for(int i = 0; book[i][0] != '\0'; i++){
		printf("\n%d.) %s", i+1, book[i]);
	}
}