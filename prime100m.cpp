#include <iostream>
#include <cstdlib>
#include <cstring>

using namespace std;

#define MAX 100000000

void sangNGT(bool *arr){
	memset(arr, true, MAX);
	for (int i = 2; i*i <= MAX; ++i){
		if (arr[i]){
			for (int j = i*i; j<MAX; j += i){
				arr[j] = false;
			}
		}
	}
}

int main(int argc, char const *argv[])
{
	bool *arr = new bool[MAX];
	sangNGT(arr);
	freopen("prime100m.txt", "w", stdout);
	for (int i = 2; i<MAX; ++i){
		if (arr[i]){
			cout << i << " ";
		}
	}
	return 0;
}
