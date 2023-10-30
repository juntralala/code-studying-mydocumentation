#include <stdio.h>

int main() {
	char nama[20],hobby[20];
	int umur;

	printf("Nama : ");
	fgets(nama, sizeof(nama), stdin);

	printf("Umur : ");
	scanf("%d", &umur);

	puts("<========================================>");
	printf("Nama\t: %s",nama);
	printf("Umur\t: %d",umur);


	return 0;
}