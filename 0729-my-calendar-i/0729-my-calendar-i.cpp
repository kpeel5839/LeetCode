class MyCalendar {
public:
    typedef vector<int>vi;
    typedef vector<vi>vii;
    vii books;
    MyCalendar() {
    }
    
    bool book(int start, int end) {
        for(int i=0;i<books.size();i++){
            if(
                (books[i][0]<=start&&start<books[i][1])||(books[i][0]<=end-1&&end-1<books[i][1])
                ||
                (start<=books[i][0]&&books[i][0]<end)||(start<=books[i][1]-1&&books[i][1]-1<end)
            ){
                return false;
            }
        }
        books.push_back({start,end});
        return true;
    }
};

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar* obj = new MyCalendar();
 * bool param_1 = obj->book(start,end);
 */