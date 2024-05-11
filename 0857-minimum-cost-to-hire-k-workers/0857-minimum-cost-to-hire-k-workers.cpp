class Solution {
public:
    typedef long long ll;
    typedef vector<ll>vl;
    typedef vector<vl>vll;
    typedef vector<int>vi;
    typedef vector<vi>vii;
    typedef vector<double>vd;
    typedef vector<vd>vdd;
    struct comp{
        bool operator()(ll o1,ll o2){
            return o1<o2;
        }
    };
    double mincostToHireWorkers(vector<int>& quality, vector<int>& wage, int k) {
        vi q=quality;
        vi w=wage;
        int n=q.size();
        double maxRate=0.0;
        double sum=0;
        vdd v;
        for(int i=0;i<n;i++){
            v.push_back({(double)w[i]/q[i],(double)i});
        }
        sort(v.begin(),v.end(),[](vd o1,vd o2){ return o1[0]<o2[0];});
        priority_queue<ll,vl,comp>pq;
        for(int i=0;i<k;i++){
            sum+=q[v[i][1]];
            maxRate=v[i][0];
            pq.push(q[v[i][1]]);
        }
        double res=sum*maxRate;
        for(int i=k;i<n;i++){
            sum-=pq.top();pq.pop();
            maxRate=v[i][0];
            sum+=q[v[i][1]];
            pq.push(q[v[i][1]]);
            res=min(res,maxRate*sum);
        }
        return res;
    }
};