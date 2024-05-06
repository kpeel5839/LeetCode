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
    ListNode* removeNodes(ListNode* head) {
        deque<int>dq;
        ListNode* cur=head;
        while(cur!=nullptr){
            while(dq.size()!=0&&dq.back()<cur->val){
                dq.pop_back();
            }
            dq.push_back(cur->val);
            cur=cur->next;
        }
        ListNode* answer=new ListNode();
        cur=answer;
        while(dq.size()!=0){
            cur->next=new ListNode(dq.front());dq.pop_front();
            cur=cur->next;
        }
        return answer->next;
    }
};