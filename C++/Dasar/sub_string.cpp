#include <iostream>
#include <string>
using namespace std;

int main() {

	string kalimat1 = "ipul seorang pedagang kaya raya";
	string kalimat2 = "udin seorang pendakwah dikampung kristen";
	cout << kalimat1 << endl;
	cout << kalimat2 << endl;

	// substring, mengambil di tengah-tengah
	// .substr(index,panjang)
	cout << kalimat1.substr(13, 20) << endl;
	cout << kalimat2.substr(13, 20) << endl; 

	// mecari posisi substring
	cout << "posisi kata \"kaya\" : " << kalimat1.find("kaya") << endl;
	cout << "posisi kata \"kristen\" : " << kalimat2.find("kristen") << endl;

	int a = kalimat2.find("di");
	cout << a << endl;
	cout << kalimat2.find("di", a + 1) << endl;

	// mencari posisinya dari belakang -> .rfind
	cout << kalimat2.rfind("n") << endl;

	return 0;
}