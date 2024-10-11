class Solution {
public:
    typedef vector<int>vi;
    typedef vector<vi>vii;
    struct comp{
        bool operator()(int o1,int o2){
            return o1>o2;
        }
    };
    int smallestChair(vector<vector<int>>& times, int targetFriend) {
        vii ar(1e5+1);
        vii le(1e5+1);
        int targetArrival=times[targetFriend][0];
        for(int i=0;i<times.size();i++){
            ar[times[i][0]].push_back(i);
            le[times[i][1]].push_back(i);
        }
        priority_queue<int,vi,comp>pq;
        for(int i=0;i<=1e5;i++){
            pq.push(i);
        }
        map<int,int>m;
        for(int i=0;i<=1e5;i++){
            for(int j=0;j<le[i].size();j++){
                int seatNumber=m[le[i][j]];
                pq.push(seatNumber);
            }
            if(targetArrival==i){
                return pq.top();
            }
            if(!ar[i].empty()){
                int seatNumber=pq.top();pq.pop();
                m[ar[i][0]]=seatNumber;
            }
        }
        return 0;
    }
};