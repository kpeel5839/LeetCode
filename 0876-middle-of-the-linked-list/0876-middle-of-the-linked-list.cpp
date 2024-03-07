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
  ListNode* middleNode(ListNode* head) {
    ListNode* cur=head;
    int size=0;
    while(cur!=nullptr){
      size++;
      cur=cur->next;
    }
    cur=head;
    int selectedNode=size/2+1;
    size=0;
    while(cur!=nullptr){
      size++;
      if(size==selectedNode){
        return cur;
      }
      cur=cur->next;
    }
    return nullptr;
  }
};