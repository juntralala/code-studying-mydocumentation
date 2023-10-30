#include <iostream>
#include <string>

using namespace std;

int main() {

	string kata = "kucing";
	//menampilkan string
	cout << kata << endl;

	// mengambil karakter berdasarkan index
	cout << "index ke 0 : " << kata[0] << endl;
	cout << "index ke 1 : " << kata[1] << endl;
	cout << "index ke 2 : " << kata[2] << endl;
	cout << "index ke 3 : " << kata[3] << endl;
	cout << "index ke 4 : " << kata[4] << endl;
	cout << "index ke 5 : " << kata[5] << endl;
	cout << "index ke 6 : " << kata[6] << endl;

	// merubah karakter pada indeks
	kata[5] = 'k';
	kata[4] = 'e';
	cout << kata << endl;

	// mengambung / concatenatioin
	string kata2 = kata + " oren";
	cout << kata2 << endl;

	string kata3 = " cetar";
	kata2.append(kata3);
	cout << kata2 << endl;

	string kata4 = "membahana";
	kata2 += " " + kata4;
	cout << kata2 << endl;

	return 0;
}