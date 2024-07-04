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
    ListNode* mergeNodes(ListNode* head) {
        vector<int>v;
        ListNode* cur=head;
        int sum=-1;
        while(cur!=nullptr){
            if(cur->val==0){
                if(sum!=-1){
                    v.push_back(sum);
                }
                sum=0;
            }
            sum+=cur->val;
            cur=cur->next;
        }
        ListNode* answerHead=new ListNode(0);
        cur=answerHead;
        for(int i=0;i<v.size();i++){
            cur->next=new ListNode(v[i]);
            cur=cur->next;
        }
        return answerHead->next;
    }
};