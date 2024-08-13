class KthLargest {
public:
    struct bigger{
        bool operator()(int o1,int o2){
            return o1<o2;
        }
    };
    struct smaller{
        bool operator()(int o1,int o2){
            return o1>o2;
        }
    };
    int k;
    priority_queue<int,vector<int>,smaller>ma;
    priority_queue<int,vector<int>,bigger>mi;
    KthLargest(int k, vector<int>& nums) {
        this->k=k;
        for(int i=0;i<nums.size();i++){
            ma.push(nums[i]);
        }
        while(ma.size()!=0&&ma.size()!=k){
            int v=ma.top();ma.pop();
            mi.push(v);
        }
    }
    
    int add(int val) {
        if(ma.size()==0){
            ma.push(val);
            return ma.top();
        }
        if(ma.top()<val){
            ma.push(val);
            mi.push(ma.top());ma.pop(); 
        }
        return ma.top();
    }
};

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest* obj = new KthLargest(k, nums);
 * int param_1 = obj->add(val);
 */