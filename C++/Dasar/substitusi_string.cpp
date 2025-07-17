#include <iostream>
#include <string>
using namespace std;

int main() {

	string kalimat1 = "ipul bermain-main di planet nebula";
	string kalimat2 = "chef ilham memasak untuk maulid baginda rasullah";
	cout << "1. " << kalimat1 << endl;
	cout << "2. " << kalimat2 << endl << endl;

	// swap string
	kalimat1.swap(kalimat2);
	cout << "1. " << kalimat1 << endl;
	cout << "2. " << kalimat2 << endl << endl;

	// replace, mengganti string
	kalimat1.replace(5, 5, "ipul");
	kalimat2.replace(kalimat2.find("planet nebula"), 13, "bulan");
	cout << "<<====== replace string ======>>" << endl;
	cout << "1. " << kalimat1 << endl;
	cout << "2. " << kalimat2 << endl << endl;

	// insert string
	kalimat2.insert(5,"ganteng ");
	cout << "<<====== replace string ======>>" << endl;
	cout << "1. " << kalimat1 << endl;
	cout << "2. " << kalimat2 << endl << endl;

	return 0;
}