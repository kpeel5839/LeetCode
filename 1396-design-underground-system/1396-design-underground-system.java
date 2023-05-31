class UndergroundSystem {

    public class Start {
        String station;
        int startTime;
        
        public Start(String station, int startTime) {
            this.station = station;
            this.startTime = startTime;
        }
    }
    
    public Map<Integer, Start> check;
    public Map<String, Map<String, int[]>> train;

    public UndergroundSystem() {
        check = new HashMap<>();
        train = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        check.put(id, new Start(stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        Start start = check.get(id);
        
        if (!train.containsKey(start.station)) {
            train.put(start.station, new HashMap<>());
        }
           
        int[] result = train.get(start.station).getOrDefault(stationName, new int[] {0, 0});
        int time = t - start.startTime;
        result[0] += time;
        result[1]++;
        train.get(start.station).put(stationName, result);
    }
    
    public double getAverageTime(String startStation, String endStation) {
        int[] result = train.get(startStation).get(endStation);    
        return (double) result[0] / (double) result[1];
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */