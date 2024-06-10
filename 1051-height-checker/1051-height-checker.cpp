class Solution {
public:
    int heightChecker(vector<int>& heights) {
        vector<int>copy;
        for(auto v:heights)copy.push_back(v);
        sort(heights.begin(),heights.end());
        int answer=0;
        for(int i=0;i<heights.size();i++){
            if(heights[i]!=copy[i]){
                answer++;
            }
        }
        return answer;
    }
};