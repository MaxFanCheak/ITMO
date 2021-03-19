
#include<vector>
#include<stdio.h>
#include<algorithm>
#include<cstring>
using namespace std;
class unicStek {
	int* val{ nullptr };
	bool* rep{ nullptr };
	int size{ 0 };
	int capacity{ 0 };
public:
	void setCapacity(int cap) {
		if (cap == 0) cap = size;
		int* temp = new int[cap];
		memcpy(temp, val, size * sizeof(int));
		delete[] val;
		val = temp;
		bool* temp1 = new bool[cap];
		memcpy(temp1, rep, size * sizeof(bool));
		rep = nullptr;
		rep = temp1;
		capacity = cap;
	}
	void push(int x) {
		if (capacity > size) {
			if (val[size - 1] != x) {
				val[size++] = x;
				rep[size - 1] = 0;

			}
			else {
				rep[size - 1] = 1;
			}

		}
		else {
			if (capacity == 0)
				setCapacity(1);
			else
				setCapacity(capacity * 2);
			if (val[size - 1] != x) {
				val[size++] = x;
				rep[size - 2] = 0;
				rep[size - 1] = 0;
			}
			else {
				rep[size - 1] = 1;
			}
		}
	}
	int top() {
		return val[size - 1];
	}
	bool topRep() {
		return rep[size - 1];
	}
	void pop() {
		size--;
	}
	int get_size()const {
		return size;
	}
	void print_stek() {
		for (int i{ 0 }; i < size; i++)
			printf("%d, %d\n", val[i], rep[i]);
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
signed main() {
	int n, x;
	n = scan();
	unicStek val;
	x = scan();
	val.push(x);
	n--;
	bool repeat{ 0 };
	int count{ 1 };
	int res{ 0 };
	for (; n; n--) {
		x = scan();
		if (repeat) {
			if (x == val.top()) {
				count++;
			}
			else {
				if (count >= 3) {
					res += count;
					val.pop();
				}
				count = 1;
				repeat = 0;
				if (val.top()==x){
					count++;
				    repeat = 1;
					if (val.topRep()) count++;
					else val.push(x);
				}
				else val.push(x);
			}
		}
		else{
			if (x == val.top()) {
				repeat = 1;
				count++;
			}
			val.push(x);
		}
	}
	if(!repeat&&x==val.top()){
		count++;
		if (val.topRep()) count++;
	}
	if (count >= 3) {
		res += count;
		val.pop();
	}
	printf("%d", res);
}