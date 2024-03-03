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
  ListNode* removeNthFromEnd(ListNode* head, int n) {
    ListNode* cur=head;
    vector<int> arr;
    int size=0;
    while(true){
      arr.push_back(cur->val);
      size++;
      if(cur->next==nullptr){
        break;
      }
      cur=cur->next;
    }
    int removePoint=size-n;
    vector<int> ansArr;
    for(int i=0;i<arr.size();i++){
      if(i==removePoint){
        continue;
      }
      ansArr.push_back(arr[i]);
    }
    if(ansArr.size()==0){
      return nullptr;
    }
    ListNode* ansHead=new ListNode(ansArr[0]);
    cur=ansHead;
    for(int i=1;i<ansArr.size();i++){
      cur->next=new ListNode(ansArr[i]);
      cur=cur->next;
    }
    return ansHead;
  }
};