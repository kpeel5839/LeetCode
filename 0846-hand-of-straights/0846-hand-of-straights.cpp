class Solution {
public:
    bool isNStraightHand(vector<int>& hand, int groupSize) {
        int n=hand.size();
        if(n%groupSize!=0){
            return false;
        }
        sort(hand.begin(),hand.end());
        map<int,int>m;
        for(auto&v:hand)m[v]++;
        for(int i=0;i<n;i++){
            if(!m[hand[i]]){
                continue;
            }
            for(int j=0;j<groupSize;j++){
                if(!m[hand[i]+j]){
                    return false;
                }
                m[hand[i]+j]--;
            }
        }
        return true;
    }
};