#include <iostream>
#include <string>
#include <typeinfo>

template<typename T, typename U>
T max(T data1, U data2) {
	return (data1 > data2 ) ? data1 : data2 ;
}

int main() {

	auto a = 4;
	auto b = 2.5;
	auto c = "tes";
	auto d = 2.5f;
	auto f = max(a,b);
	auto e = max(2.5, 3.5f);

	std::cout << a << " : " << typeid(a).name() << std::endl;
	std::cout << b << " : " << typeid(b).name() << std::endl;
	std::cout << c << " : " << typeid(c).name() << std::endl;
	std::cout << d << " : " << typeid(d).name() << std::endl;
	std::cout << f << " : " << typeid(f).name() << std::endl;
	std::cout << e << " : " << typeid(e).name() << std::endl;

	return 0;
}