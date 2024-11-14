impl Solution {
    pub fn minimized_maximum(n: i32, quantities: Vec<i32>) -> i32 {
        let (mut low, mut high) = (1, *quantities.iter().max().unwrap());
        let mut res = 0;
    
        while low <= high {
            let mid = low + (high - low) / 2;
            let stores_needed: i32 = quantities.iter()
                .map(|&quantity| (quantity as f64 / mid as f64).ceil() as i32)
                .sum();
            
            if stores_needed <= n {
                res = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        res
    }
}