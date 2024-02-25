class Solution {
public:
  typedef vector<int> vi;
  typedef vector<vi> vii;
  int n;
  vi count;
  vi parent;
  unordered_map<int,int>m;
  int find(int x){
    if(parent[x]==x){
      return x;
    }
    return parent[x]=find(parent[x]);
  }
  void uni(int a,int b){
    parent[b]=a;
    count[a]+=count[b];
  }
  bool canTraverseAllPairs(vector<int>& nums) {
    n=nums.size();
    parent=vi(n,0);
    count=vi(n,1);
    for(int i=0;i<n;i++){
      parent[i]=i;
    }
    for(int i=0;i<n;i++){
      for(int j=2;j*j<=nums[i];j++){
        if(nums[i]%j==0){
          if(m.find(j)!=m.end()){
            int a=find(i);
            int b=find(m[j]);
            if(a!=b){
              uni(a,b);
            }
          }else{
            m[j]=i;
          }
          while(nums[i]%j==0){
            nums[i]/=j;
          }
        }
      }
      if(nums[i]!=1){
        if(m.find(nums[i])!=m.end()){
          int a=find(i);
          int b=find(m[nums[i]]);
          if(a!=b){
            uni(a,b);
          }
        }else{
          m[nums[i]]=i;
        }
      }
    }
    return count[find(0)]==n;
  }
};