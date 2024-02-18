class Solution {
public:
  typedef vector<int>vi;
  typedef vector<vi>vii;
  typedef vector<vii>viii;
  typedef long long ll;
  typedef vector<ll>vl;
  typedef vector<vl>vll;
  typedef vector<vll>vlll;
  struct lessComp{
    bool operator()(vl&o1,vl&o2){
      if(o1[1]==o2[1]){
        return o1[0]>o2[0];
      }
      return o1[1]>o2[1];
    }
  };
  struct comp{
    bool operator()(ll&o1,ll&o2){
      return o1>o2;
    }
  };
  vi roomsCount;
  priority_queue<ll,vl,comp>remainRooms;
  priority_queue<vl,vll,lessComp>rooms;//{방번호, 끝나는 시각}
  int n;
  vii m;
  void solve(){
    for(int i=0;i<n;i++){
      remainRooms.push(i);
    }
    for(int i=0;i<m.size();i++){
      while(rooms.size()!=0&&m[i][0]>=rooms.top()[1]){
        remainRooms.push(rooms.top()[0]);rooms.pop();
      }
      if(remainRooms.size()!=0){
        int roomNumber=remainRooms.top();
        rooms.push({roomNumber,m[i][1]});remainRooms.pop();
        roomsCount[roomNumber]++;
      }else{
        vl room=rooms.top();rooms.pop();
        ll endTime=room[1]+(m[i][1]-m[i][0]);
        rooms.push({room[0],endTime});
        roomsCount[room[0]]++;
      }
    }
  }
  int mostBooked(int n, vector<vector<int>>& meetings) {
    roomsCount=vi(n,0);
    this->n=n;
    m=meetings;
    sort(m.begin(),m.end(),[](vi&o1,vi&o2){
      if(o1[0]==o2[0]){
        return o1[1]<o2[1];
      }
      return o1[0]<o2[0];
    });
    solve();
    ll maxCount=*max_element(begin(roomsCount),end(roomsCount));
    for(int i=0;i<n;i++){
      if(maxCount==roomsCount[i]){
        return i;
      }
    }
    return -1;
  }
};