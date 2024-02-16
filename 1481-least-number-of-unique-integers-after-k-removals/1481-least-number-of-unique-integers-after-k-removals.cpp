class Solution {
public:
  int findLeastNumOfUniqueInts(vector<int>& arr, int k) {
    map<int,int>m;
    for (int i=0;i<arr.size();i++){
      m[arr[i]]++;
    }
    int answer=m.size();
    vector<int>count;
    for(auto v:m){
      count.push_back(v.second);
    }
    sort(count.begin(),count.end(),[](int& o1,int& o2){
      return o1<o2;
    });
    for(auto v:count){
      if(k<v){
        break;
      }
      k-=v;
      answer--;
    }
    return answer;
  }
};