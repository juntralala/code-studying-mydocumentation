#include <iostream>

template<typename T>
void print(T data) {
	std::cout << data << std::endl;
}

template<typename T>
int toInt(T data) {
	return int(data);
}
 
template<typename T, typename U>
T max(T a,U b) {
	return (a > b) ? a : b;
}

int main() {

	print(100);
	print(99.99);
	print('c');

	std::cout << toInt(99.99) << std::endl;

	std::cout <<           max(6.1, 5.55) << std::endl;
	std::cout << max<int, int>(6.1, 5.55) << std::endl;

	return 0;
}