#include<iostream>
#include<math.h>
#include<algorithm>
using namespace std;
int h{ 0 };
int n, m;
int res{ 0 };
int* tree;
int* ad;
int* adFlag;
int pow2(int p)
{
    int r{ 1 };
    while (p--)
    {
        r *= 2;
    }
    return r;
}

void propagate(int i) {
    if (ad[i] != 0) {
        ad[2 * i + 1] += ad[i];
        ad[2 * i + 2] += ad[i];
        tree[i] += ad[i];
        ad[i] = 0;
    }
}

int min(int i, int lx, int rx, int l, int r)
{
    if (l > r)
        return 1000000001;
    if (lx > rx || rx < l || lx > r)
        return 1000000001;
    if (l <= lx && rx <= r) {
        return tree[i] + ad[i];
    }
    int m = (lx + rx) >> 1;
    propagate(i);
    tree[i] = min(tree[2 * i + 1] + ad[2 * i + 1], tree[2 * i + 2] + ad[2 * i + 2]);
    return min(min(2 * i + 1, lx, m, l, min(r, m)), min(2 * i + 2, m + 1, rx, max(l, m + 1), r));
}

void add(int i, int v, int lx, int rx, int l, int r)
{
    if (l > r)
        return;
    if (lx > rx || rx < l || lx > r)
        return;
    if (l <= lx && rx <= r) {
        if (lx != rx) {
            ad[i] += v;
        }
        else {
           tree[i] += v;
        }
        return;
    }
    int tmp = (lx + rx) >> 1;
    propagate(i);
    add((i << 1) + 1, v, lx, tmp, l, min(r, tmp));
    add((i << 1) + 2, v, tmp + 1, rx, max(l, tmp + 1), r);
    tree[i] = min(tree[(i << 1) + 1] + ad[(i << 1) + 1], tree[(i << 1) + 2] + ad[(i << 1) + 2]);
}

void push(int ind, int elem) {
    ind = h - 1 + ind;
    tree[ind] = elem;
    while (ind != 0) {
        ind = (ind - 1) / 2;
        tree[ind] = min(tree[2 * ind + 1], tree[2 * ind + 2]);
    }
}
void printTree(int size) {
    while (size--)  cout << tree[size] + ad[size];
}
int main() {
    ios_base::sync_with_stdio(false);
    //cin.tie(null);
    cin >> n >> m;
    while (pow2(++h) < n);
    //cout<<h;
    int size = pow2(h + 1);
    tree = new int[size - 1]{ 0 };
    ad = new int[size - 1]{ 0 };
    adFlag = new int[size - 1]{ 0 };
    h = pow2(h);
    for (int i{ 0 }; i < m; i++) {
        int com;
        cin >> com;
        if (com == 1) {
            int l, r, v;
            cin >> l >> r >> v;
            add(0, v, 1, h, l, r);
            //printTree(size - 1);
        }
        else {
            int l, r;
            cin >> l >> r;
            //int ind = h - 1 + b;
            cout << min(0, 1, h, l, r) << endl;
        }
    }
    return 0;
}