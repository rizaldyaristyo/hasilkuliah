#include <stdio.h>
#include <string.h>
#include <stdlib.h>

void cekName(char inName[20]);
void cekFrom(char inFrom[20]);
void cekDate(int date);
void list();

char book[50][50] = {"A Book, Malang. 2021"};
char place[3][10] = {"Batu","Malang","Surabaya"}; int placeCount = 3;
char bookString[10];
char placeString[10];

int main(){  
	char inName[20], inFrom[10], name[50];
	int inDate;
	printf("Wellcome\nInput Book = \n");
	printf("Nama : ");
	gets(inName);
	//scanf("%s", inName);
	cekName(inName);
	//fflush(stdin);
	
	printf("From : ");
	gets(inFrom);
	//scanf("%s", inFrom);
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
		printf("Hanya untuk buku terbitan 2019-2020!");
		exit(0);
		//printf("%s == %s",inFrom,placeString);
		//printf("\n ----------> cekDate if'd!\n");	
	}
}

void cekFrom(char inFrom[]){
	for(int c=0;place[c][0] != '\0';c++){
		for(int d=0;book[c][d] != '\0';d++){
			placeString[d]=place[c][d];
		}
		int frcmp = strcmp(inFrom,placeString);
		if(frcmp != 0){
			printf("Hanya buku berasal dari Malang, Surabaya, dan Batu yang dapat di input\n");
			exit(0);
		}
		
	}
}

void cekName(char inName[]){
	for(int i = 0; book[i][0] != '\0'; i++){
		for(int j = 0; book[i][j] != ','; j++){
			bookString[j]=book[i][j];
			
		}
		printf("\nbookString checked: %s\n", bookString);
		if(strcmp(inName, bookString) == 0){
			printf("Nama Buku Duplikat!");
			exit(0);
			//printf("%s == %s",inName,bookString);
			//printf("\n ----------> cekName broke!\n");
		}
	}
}

void list(){
	for(int i = 0; book[i][0] != '\0'; i++){
		printf("\n%d.) %s", i+1, book[i]);
	}
}