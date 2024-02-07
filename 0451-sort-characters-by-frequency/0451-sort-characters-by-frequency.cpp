class Solution {
public:
  
  typedef pair<char, int> pci;
  typedef vector<pci> vpci;
  
  string frequencySort(string s) {
    map<char, int> m;
    
    for (auto v : s) {
      m[v]++;
    }
    
    vpci count;
    
    for (auto v : m) {
      count.push_back({v.first, v.second});
    }
    
    sort(count.begin(), count.end(), [](pci& o1, pci& o2) {
      return o1.second > o2.second;
    });
    
    string answer;
    for (auto value : count) {
      for (int i = 0; i < value.second; i++) {
        answer.push_back(value.first);
      }
    }
    return answer;
  }
};