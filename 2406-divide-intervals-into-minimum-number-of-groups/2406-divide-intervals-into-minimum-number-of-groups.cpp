class Solution {
public:

    typedef vector<int>vi;
    typedef vector<vi>vii;

    struct comp{
        bool operator()(int o1,int o2){
            return o1>o2;
        }
    };

    int minGroups(vector<vector<int>>& in) {
        sort(in.begin(),in.end(),[](vi&o1,vi&o2){
            if(o1[0]==o2[0]){
                return o1[1]<o2[1];
            }
            return o1[0]<o2[0];
        });
        priority_queue<int,vi,comp>pq;
        for(int i=0;i<in.size();i++){
            int a=in[i][0];
            int b=in[i][1];
            if(pq.empty()||a<=pq.top()){
                pq.push(b);
                continue;
            }
            pq.pop();
            pq.push(b);
        }
        return pq.size();
    }
};