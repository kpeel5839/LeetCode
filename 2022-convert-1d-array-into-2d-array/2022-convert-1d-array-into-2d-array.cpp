#include <bits/stdc++.h>

using namespace std;

class Solution {
public:
    typedef vector<int>vi;
    typedef vector<vi>vii;
    vector<vector<int>> construct2DArray(vector<int>& original, int m, int n) {
        vii answer(m,vi(n,0));
        for(int i=0;i<original.size();i++){
            int h=i/n;
            int w=i%n;
            if(m<=h||n<=w){
                return {};
            }
            answer[h][w]=original[i];
            if(i+1==original.size()&&(h!=m-1||w!=n-1)){
                return {};
            }
        }
        return answer;
    }
};