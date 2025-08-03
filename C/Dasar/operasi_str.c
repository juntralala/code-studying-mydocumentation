#include <stdio.h>

int main() {

	char nama[] = "Muhammad Junaidi";
	char copy[20];

	strcpy(copy, nama); // mencopy str
	strlen(nama); // mengambil  panjang str
	strcmp(copy, nama); // membandingkan str jika sama return true
	strchr(copy, "J"); // mencari char didalam string
	strstr(copy, "Jun"); // mencari string didalam string
	printf("%s",copy);

	return 0;
}