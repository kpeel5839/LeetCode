class Solution {
public:
    bool lemonadeChange(vector<int>& bills) {
        map<int,int>m;
        for(int i=0;i<bills.size();i++){
            if(bills[i]==5){
                m[bills[i]]++;
                continue;
            }
            int remainBill=bills[i]-5;
            if(remainBill==15){
                if(m[10]>=1&&m[5]>=1){
                    m[10]--;
                    m[5]--;
                    continue;
                }
                if(m[5]>=3){
                    m[5]-=3;
                    continue;
                }
                return false;
            }
            if(m[remainBill]==0){
                return false;
            }
            m[remainBill]--;
            m[bills[i]]++;
        }
        return true;
    }
};