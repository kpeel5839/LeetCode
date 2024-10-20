class Solution {
public:
    bool parseBoolExpr(string expression) {
        stack<char>operations;
        stack<char>booleans;
        stack<int>indexes;
        stack<int>bracketIndexes;
        map<char,int> m;
        for(int i=0;i<expression.size();i++){
            char c=expression[i];
            if(c==','){
                continue;
            }
            if(c=='('){
                bracketIndexes.push(i);
                continue;
            }
            if(c=='!'||c=='&'||c=='|'){
                operations.push(c);
                continue;
            }
            if(c==')'){
                int limit=bracketIndexes.top();bracketIndexes.pop();
                m=map<char,int>();
                while(true){
                    if(indexes.empty()||limit>indexes.top()){
                        break;
                    }
                    int idx=indexes.top();indexes.pop();
                    char boolean=booleans.top();booleans.pop();
                    m[boolean]++;
                }
                char operation=operations.top();operations.pop();
                char result;
                if(operation=='&'){
                    if(m['f']==0){
                        result='t';
                    }else{
                        result='f';
                    }
                }else if(operation=='|'){
                    if(m['t']==0){
                        result='f';
                    }else{
                        result='t';
                    }
                }else{
                    if(m['t']==0){
                        result='t';
                    }else{
                        result='f';
                    }
                }
                indexes.push(i);
                booleans.push(result);
                continue;
            }
            indexes.push(i);
            booleans.push(expression[i]);
        }
        return booleans.top()=='t'?true:false;
    }
};