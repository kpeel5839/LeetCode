/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    vector<int> nodesBetweenCriticalPoints(ListNode* head) {
        ListNode*cur=head;
        vector<int>v;
        int prev=-1;
        int cnt=0;
        while(true){
            cnt++;
            if(cur->next==nullptr){
                break;
            }
            int next=cur->next->val;
            int val=cur->val;
            int prepre=cur->val;
            cur=cur->next;
            if(prev==-1){
                prev=prepre;
                continue;
            }
            if(val<prev&&val<next){
                v.push_back(cnt);
            }
            if(val>prev&&val>next){
                v.push_back(cnt);
            }
            prev=prepre;
        }
        if(v.size()<=1){
            return {-1,-1};
        }
        int minimumDistance=1e9;
        for(auto&vv:v){
            cout<<vv<<" ";
        }
        for(int i=1;i<v.size();i++){
            minimumDistance=min(minimumDistance,v[i]-v[i-1]);
        }
        return {minimumDistance,v.back()-v[0]};
    }
};