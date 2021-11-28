#include <stdio.h>
#include <string.h>

int main(){
	char var1[] = "Informatika UMM";
	char huruf = 'i';
	char *var2;
	
	var2 = strchr(var1, huruf);
	
	printf("Karakter '%c' pada kalimat '%s' ditemukan pada penggalan kata \"%s\" "
	, huruf, var1, var2);
	
	return 0;
}