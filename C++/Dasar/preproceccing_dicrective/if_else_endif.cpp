#include <iostream>

#define ID 1

#if ID == 1
	#define JOB "ADMIN"
#elif ID == 2
	#define JOB "MODERATOR"
#else
	#define JOB "PENGGUNA"
#endif 


using namespace std;

int main() {

	cout << "JOB : " << JOB << endl;

	return 0;
}