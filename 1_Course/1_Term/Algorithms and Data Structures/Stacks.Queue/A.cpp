#include<vector>
#include<stdio.h>
#include<algorithm>
using namespace std;
class minStek {
	long* val{ nullptr };
	long* minVal{ nullptr };
	int size{ 0 };
	int capacity{ 0 };
public: 
	void setCapacity(int cap) {
		if (cap == 0) cap = size;
		long* temp = new long[cap];
		memcpy(temp, val, size * sizeof(long));
		delete[] val;
		val = temp;
		long* temp1 = new long[cap];
		memcpy(temp1, minVal, size * sizeof(long));
		delete[] minVal;
		minVal = temp1;
		capacity = cap;
	}
	void push(long x) {
	if (capacity > size) {
		val[size++] = x;
		if (size - 1 > 0) minVal[size - 1] = std::min(minVal[size - 2], x);
		else minVal[size - 1] = x;
	}
	else {
		if (capacity == 0)
			setCapacity(1);
		else
			setCapacity(capacity * 2);
		val[size++] = x;
		if (size-1 > 0) minVal[size-1] = std::min(minVal[size - 2], x);
		else minVal[size-1] = x;
	}
		}
		void pop() {
				size--;
		}
		long min() {
			if (size > 0)
				return minVal[size-1];
		}
		
		
};
signed main() {
	int n, c;
	long x;
	scanf("%ld", &n);
	minStek val;
	for (; n; n--) {
		scanf("%ld", &c);
		switch (c)
		{
		case 1:
			scanf("%ld", &x);
			val.push(x);
		break;
		case 2:
			val.pop();
		break;
		case 3:
			printf("%ld\n", val.min());
		break;
		default:
			break;
		}
	}

}