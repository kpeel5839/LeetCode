class Solution {
public:
    typedef vector<int>vi;
    typedef vector<vi>vii;
    typedef vector<vii>viii;
    vector<int> survivedRobotsHealths(vector<int>& positions, vector<int>& healths, string directions) {
        int n=positions.size();
        vii v;
        for(int i=0;i<n;i++){
            v.push_back({i,positions[i],healths[i],directions[i]=='L'?-1:1});
        }
        sort(v.begin(),v.end(),[](vi&o1,vi&o2){
            return o1[1]<o2[1];
        });
        stack<vi>st;
        for(int i=0;i<v.size();i++){
            if(v[i][3]==-1){
                while(st.size()!=0){
                    vi vv=st.top();st.pop();
                    if(vv[1]==v[i][2]){
                        v[vv[0]][2]=0;
                        v[i][2]=0;
                        break;
                    }else if(vv[1]<v[i][2]){
                        v[vv[0]][2]=0;
                        v[i][2]--;
                    }else{
                        v[vv[0]][2]--;
                        v[i][2]=0;
                        st.push({vv[0],v[vv[0]][2]});
                        break;
                    }
                }
            }
            if(v[i][3]==1){
                st.push({i,v[i][2]});
            }
        }
        sort(v.begin(),v.end(),[](vi&o1,vi&o2){
            return o1[0]<o2[0];
        });
        vi answer;
        for(int i=0;i<v.size();i++){
            if(v[i][2]!=0){
                answer.push_back(v[i][2]);
            }
        }
        return answer;
    }
};