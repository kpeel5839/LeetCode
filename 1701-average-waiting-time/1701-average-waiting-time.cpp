class Solution {
public:
    double averageWaitingTime(vector<vector<int>>& customers) {
        double average=0;
        double size=customers.size();
        double time=0;
        for(int i=0;i<customers.size();i++){
            time=max(time,(double)customers[i][0]);
            time+=customers[i][1];
            average+=(time-customers[i][0]);
        }
        return average/size;
    }
};