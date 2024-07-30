class Solution {
public:
    int minimumDeletions(string s) {
        int n=s.size();
        vector<int>v(n,0);
        int cnt=0;
        int answer=1e9;
        stack<char>st;
        st.push(s[0]);
        for(int i=n-1;0<=i;i--){
            if(s[i]=='a'){
                v[i]++;
            }
            v[i]+=(i==n-1?0:v[i+1]);
        }
        for(int i=1;i<n;i++){
            if(s[i]=='a'&&s[i-1]=='b'){
                answer=min(answer,cnt+v[i]);
            }
            while(st.size()!=0&&st.top()=='b'&&s[i]=='a'){
                st.pop();
                cnt++;
            }
            st.push(s[i]);
        }
        return min(answer,cnt);
    }
};