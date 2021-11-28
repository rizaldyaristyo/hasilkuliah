#include <stdio.h>
#include <string.h>
int main(){
	char var1[] = "Universitas ";
	char var2[] = "Muhammadiyah Malang";
	
	printf("\tSetelah strcat(var1,var2):\n");
	printf("line 8: %s\n", var1);
	printf("line 9: %s\n", var2);
	printf("line 10: %s%s\n\n", var1, var2);
	
	strcat(var1,var2);
	printf("\tSetelah strcat(var1,var2):\n");
	printf("line 14: %s\n", var1);
	printf("line 15: %s\n", var2);
	printf("line 16: %s%s\n", var1, var2);
	
	return 0;
}