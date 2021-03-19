#include <iostream>
#include <vector>
#include <string>

using namespace std;
int scanInt() {
	char x = getchar();
	int mod = 0, znak = 1;
	while (x > '9' || x < '0') { if (x == '-')znak = -1; x = getchar(); }
	while (x >= '0' && x <= '9') { mod = mod * 10 + x - '0'; x = getchar(); }
	return mod * znak;
}
int main()
{
    int n, m;
    n = scanInt();
    m = scanInt();
    if (n < m) {
        int k = n;
        n = m;
        m = k;
    }
    vector<vector<int>> d(n, vector<int>(pow(2,m)));
    for (int j = 0; j < (1 << m); j++)
        d[0][j] = 1;
    for (int i{ 1 }; i < n; i++) {
        for (int j{ 0 }; j < pow(2, m); j++)
        {
            for (int k{ 0 }; k < pow(2, m); k++)
            {
                int x{ j ^ k };
                int y{ j & k };
                int bol{ 0 };
                while (x != 0 && (x % 4 != 0) || y % 4 == 1 || y % 4 == 2)
                {
                    x /= 2;
                    y /= 2;
                    bol++;
                }
                if (bol > m - 2) d[i][j] += d[i - 1][k];
            }
        }
    }
    int answer{ 0 };
    for (int i{ 0 }; i < (1 * pow(2,m)); i++)
        answer += d[n - 1][i];
    printf("%d", answer);
}