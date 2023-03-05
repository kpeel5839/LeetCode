class Solution {
    public boolean outOfRange(int index, int[] arr) {
        return !(0 <= index && index < arr.length);
    }

    public int minJumps(int[] arr) {
        Map<Integer, List<Integer>> index = new HashMap<>();
        boolean[] visited = new boolean[arr.length];

        for (int i = 0; i < arr.length; i++) {
            if (index.containsKey(arr[i])) {
                index.get(arr[i]).add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                index.put(arr[i], list);
            }
        }

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {arr.length - 1, 0});
        visited[arr.length - 1] = true;

        while (!q.isEmpty()) {
            int[] point = q.poll();

            if (point[0] == 0) { // 목적지 도달
                return point[1];
            }

            for (int i = -1; i <= 1; i += 2) {
                int newI = point[0] + i;

                if (outOfRange(newI, arr) || visited[newI]) {
                    continue;
                }

                visited[newI] = true;
                q.add(new int[] {newI, point[1] + 1});
            }

            if (index.get(arr[point[0]]).size() != 0) {
                for (Integer next : index.get(arr[point[0]])) {
                    if (!visited[next]) {
                        visited[next] = true;
                        q.add(new int[] {next, point[1] + 1});
                    }
                }

                index.get(arr[point[0]]).clear();
            }
        }

        return -1; // -1 return 될 일 없음
    }
}