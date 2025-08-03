#include <iostream>
#include <bitset>

int main() {
    // std::cout << 0x78 << std::endl;
    // std::cout << std::hex << 12 << std::endl;
    // std::cout << std::oct << 12 << std::endl;
    int inputan; 
    std::cin >> inputan;
    std::cout << std::bitset<8>(inputan) << std::endl;

}