#include <iostream>

#define NAMA "Muhammad Junaidi"

#define PANGKAT(x) (x*x)

#define MAX(A,B) ((A>B) ? A:B)

using namespace std;

int main() {

	cout << "Nama Muhammad Junaidi : " << NAMA << endl;

	cout << "Pangkat : " << PANGKAT(6) << endl;
	cout << "MAX : " << MAX(6,9) << endl;

	return 0;
}
