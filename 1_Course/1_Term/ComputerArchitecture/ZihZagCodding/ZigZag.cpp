#include <iostream>
#include<string>
using namespace std;
unsigned main() {
	long long x;
	int i{ 16 };
	int bin[16]{};
	cin >> x;
	if (x >= 0) x *= 2;
	else x = 2 * (-x)-1;
	long long copy{ x };
	while(i--){
		bin[i] = copy % 2;
		copy /= 2;
	}
	cout << '\n';
	while (++i != 16)	cout << bin[i];
	if (x % 2 == 0)x = x / 2;
	else x = (x + 1) / (-2);
	cout << "\n\n" << x;
	return 0;
} 