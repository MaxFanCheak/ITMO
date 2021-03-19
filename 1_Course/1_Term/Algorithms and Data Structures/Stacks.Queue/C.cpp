#include<stdio.h>
#include<algorithm>
#include<deque>
using namespace std;
deque <int> ::iterator queue[100000]{};
class backQueue {
	deque<int> val;
public:
	void push(int x) {
		val.push_back(x);
		queue[x] = val.end();
	}
	void popBack() {
		val.pop_back();
	}
	void popFront() {
		val.pop_front();
		
	}	
	int getQueue(int id) {
		return distance(val.begin(), queue[id])-1;
	}
	int getHead() {
		return *val.begin();
	}
	void print_stek() {
		for (auto i = val.begin(); i < val.end(); i++)
			printf("%d\n", *i);
		printf("\n\n");
	}
};
int scan()
{
	int mod = 0, znak = 1; char x = getchar();
	while (x > '9' || x < '0') { if (x == '-') znak = -1; x = getchar(); }
	while (x >= '0' && x <= '9') { mod = mod * 10 + x - '0'; x = getchar(); }
	return mod * znak;
}
void main() {
	backQueue val;
	int n, c;
	int x;
	n=scan();
	for (; n; n--) {
		c = scan();
		switch (c)
		{
		case 1:
			x = scan();
			val.push(x);
			break;
		case 2:
			val.popFront();
			break;
		case 3:
			val.popBack();
			break;
		case 4:
			x = scan();
			printf("%d\n", val.getQueue(x));
			break;
		case 5:
			printf("%d\n", val.getHead());
			break;
		default:
			break;
		}
	}
	
}