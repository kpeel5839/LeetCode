class Solution {
public:
    typedef vector<int>vi;
    typedef vector<vi>vii;
    typedef vector<vii>viii;
    vi copy(vi arr){
        vi copyArr(arr.size());
        for(int i=0;i<arr.size();i++){
            copyArr[i]=arr[i];
        }
        return copyArr;
    }
    void printArr(vi arr){
        for(int i=0;i<arr.size();i++){
            cout<<arr[i]<<" ";
        }
        cout<<"\n";
    }
    vector<vector<int>> combinationSum2(vector<int>& candidates, int target) {
        viii answer(target+1,vii());
        sort(candidates.begin(),candidates.end());
        vii ca;
        int cnt=1;
        for(int i=1;i<candidates.size();i++){
            if(candidates[i]!=candidates[i-1]){
                ca.push_back({candidates[i-1],cnt});
                cnt=1;
            }else{
                cnt++;
            }
        }
        ca.push_back({candidates.back(),cnt});

        for(int i=0;i<ca.size();i++){
            for(int c=1;c<=ca[i][1];c++){
                for(int j=0;j<target;j++){
                    if(target<j+ca[i][0]*c){
                        break;
                    }
                    vi pushBackArr;
                    for(int k=0;k<c;k++){
                        pushBackArr.push_back(ca[i][0]);
                    }
                    if(j==0){
                        answer[j+ca[i][0]*c].push_back(pushBackArr);
                    }else{
                        for(int k=0;k<answer[j].size();k++){
                            vi newArr=copy(answer[j][k]);
                            bool isNotGood=false;
                            for(int kk=0;kk<newArr.size();kk++){
                                if(newArr[kk]==ca[i][0]){
                                    isNotGood=true;
                                    break;
                                }
                            }
                            if(isNotGood){
                                continue;
                            }
                            for(int kk=0;kk<pushBackArr.size();kk++){
                                newArr.push_back(pushBackArr[kk]);
                            }
                            answer[j+ca[i][0]*c].push_back(newArr);
                        }
                    }
                }
            }
        }
        return answer[target];
    }
};