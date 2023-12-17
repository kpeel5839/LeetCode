class FoodRatings {
    
    public class FoodRate implements Comparable<FoodRate> {
        
        int rating;
        String cuisine;
        String foodName;
        
        public FoodRate(int rating, String cuisine, String foodName) {
            this.rating = rating;
            this.cuisine = cuisine;
            this.foodName = foodName;
        }
        
        @Override
        public int compareTo(FoodRate o) {
            if (this.rating == o.rating) {
                return this.foodName.compareTo(o.foodName);
            }

            return o.rating - this.rating;
        }
        
        @Override
        public boolean equals(Object o) {
            FoodRate foodRate = (FoodRate) o;
            
            return this.rating == foodRate.rating 
                && this.cuisine.equals(foodRate.cuisine)
                && this.foodName.equals(foodRate.foodName);
        }
    }
    
    Map<String, FoodRate> ftf;
    Map<String, PriorityQueue<FoodRate>> ctf;

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        ftf = new HashMap<>();
        ctf = new HashMap<>();
        
        for (int i = 0; i < foods.length; i++) {
            ftf.put(foods[i], new FoodRate(ratings[i], cuisines[i], foods[i]));
            ctf.computeIfAbsent(cuisines[i], ignored -> new PriorityQueue<>()).add(new FoodRate(ratings[i], cuisines[i], foods[i]));
        }
    }
    
    public void changeRating(String food, int newRating) {
        FoodRate foodRate = ftf.get(food);
        FoodRate newFoodRate = new FoodRate(newRating, foodRate.cuisine, food);
        ftf.remove(food);
        ftf.put(food, newFoodRate);
        ctf.get(foodRate.cuisine).add(newFoodRate);
    }
    
    public String highestRated(String cuisine) {
        PriorityQueue<FoodRate> q = ctf.get(cuisine);
        
        while (true) {
            FoodRate foodRate = q.peek();
            if (ftf.get(foodRate.foodName).equals(foodRate)) {
                return foodRate.foodName;
            }
            q.poll();
        }
    }
    
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */