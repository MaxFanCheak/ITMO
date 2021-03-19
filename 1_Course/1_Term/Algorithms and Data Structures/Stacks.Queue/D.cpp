#include<stdio.h>
#include<algorithm>
#include<list>
using namespace std;
struct trolQueue {
	list<int>right;
	list<int>left;
	bool majorityR{ 1 };
	void put(int value) {
		right.push_back(value);
	}
	void putMid(int value) {
		right.push_front(value);
	}

	void get() {
		printf("%d\n", left.back());
		left.pop_back();
	}
	void resize() {
		if (right.size() > left.size()) {
			left.push_front(right.front());
			right.pop_front();
		}

	}
};

int scanInt()
{
	int mod = 0, znak = 1; char x = getchar();
	while (x > '9' || x < '0') { if (x == '-') znak = -1; x = getchar(); }
	while (x >= '0' && x <= '9') { mod = mod * 10 + x - '0'; x = getchar(); }
	return mod * znak;
}
char scanChar()
{
	char x = getchar();
	while (true)
		if (x == '+' || x == '-' || x == '*') return x;
		else x = getchar();
}
void main() {
	trolQueue val;
	int n, x;
	char c;
	n = scanInt();
	for (; n; n--) {
		c = scanChar();
		switch (c)
		{
		case '+':
			x = scanInt();
			val.put(x);
			break;
		case '*':
			x = scanInt();
			val.putMid(x);
			break;
		case '-':
			val.get();
			break;
		default:
			break;
		}
		val.resize();
	}

}

