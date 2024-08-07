class Solution {
public:
    vector<string>a={"","Thousand ","Million ","Billion "};
    vector<string>b={"","One","Two","Three","Four","Five","Six","Seven","Eight","Nine"};
    vector<string>c={"Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
    vector<string>d={"","","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
    string numberToWords(int num) {
        if(num==0){
            return "Zero";
        }
        string s=to_string(num);
        string ss=s;
        for(int i=0;i<s.size();i++){
            ss[i]=s[(int)s.size()-1-i];
        }
        s=ss;
        stack<string>st;
        for(int i=0;i<s.size();i+=3){
            string temp="";
            int third=i+2<s.size()?(int)(s[i+2]-'0'):0;
            int second=i+1<s.size()?(int)(s[i+1]-'0'):0;
            int first=i<s.size()?(int)(s[i]-'0'):0;
            if(third!=0){
                temp+=b[third]+" Hundred ";
            }
            if(second==1){
                temp+=c[first]+" ";
            }else if(second!=0){
                temp+=d[second]+" ";
                if(first!=0){
                    temp+=b[first]+" ";
                }
            }else if(first!=0){
                temp+=b[first]+" ";
            }
            temp+=a[i/3];
            st.push(temp);
        }
        string answer="";
        while(st.size()!=0){
            string ss=st.top();st.pop();
            answer+=ss;
        }
        return answer.substr(0,(int)answer.size()-1);
    }
};