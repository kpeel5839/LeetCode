class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        String[] words1=s1.split(" ");
        String[] words2=s2.split(" ");
        Map<String,Integer>m1=new HashMap<>();
        Map<String,Integer>m2=new HashMap<>();
        List<String>answer=new ArrayList<>();
        for(int i=0;i<words1.length;i++){
            m1.put(words1[i],m1.getOrDefault(words1[i],0)+1);
        }
        for(int i=0;i<words2.length;i++){
            m2.put(words2[i],m2.getOrDefault(words2[i],0)+1);
        }
        for(int i=0;i<words1.length;i++){
            if(m1.get(words1[i])!=1){
                continue;
            }
            if(!m2.containsKey(words1[i])){
                answer.add(words1[i]);
            }
        }
        for(int i=0;i<words2.length;i++){
            if(m2.get(words2[i])!=1){
                continue;
            }
            if(!m1.containsKey(words2[i])){
                answer.add(words2[i]);
            }
        }
        return answer.toArray(new String[0]);
    }
}