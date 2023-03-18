class BrowserHistory {
    
    List<String> l;
    int p = 0;

    public BrowserHistory(String homepage) {
        l = new ArrayList<>();
        visit(homepage);
    }
    
    public void visit(String url) {
        if (l.size() != 0) {
            l = l.subList(0, p + 1);
        }
        
        l.add(url);
        p = l.size() - 1;
    }
    
    public String back(int steps) {
        p -= Math.min(p, steps);
        return l.get(p);
    }
    
    public String forward(int steps) {
        p += Math.min(l.size() - 1 - p, steps);
        return l.get(p);
    }
    
    public void print() {
        System.out.println(l + " " + p);
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */