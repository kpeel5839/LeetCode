class Solution {
public:
    typedef vector<int>vi;

    vector<int> missingRolls(vector<int>& rolls, int mean, int n) {
        int sum=0;
        for(int i=0;i<rolls.size();i++){
            sum+=rolls[i];
        }
        int goal=mean*(rolls.size()+n);
        goal-=sum;
        vi answer;
        for(int i=0;i<n;i++){
            int diff=min(6,goal-(n-(i+1)));
            if(diff==0){
                return {};
            }
            answer.push_back(diff);
            goal-=diff;
        }
        if(goal!=0){
            return {};
        }
        return answer;
    }
};