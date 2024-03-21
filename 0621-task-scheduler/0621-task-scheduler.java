class Solution {
  public int leastInterval(char[] tasks, int n) {
    int size=tasks.length;
    int[] count=new int[26];
    for(int i=0;i<size;i++){
      count[tasks[i]-'A']++;
    }
    int[] wait=new int[26];
    int answer=0;
    while(true){
      int execute=-1;
      int maxCount=0;
      boolean isSuccess=true;
      for(int i=0;i<26;i++){
        if(count[i]!=0){
          isSuccess=false;
        }
        if(count[i]!=0&&wait[i]==0&&maxCount<count[i]){
          execute=i;
          maxCount=count[i];
        }
        wait[i]=Math.max(0,wait[i]-1);
      }
      if(execute!=-1){
        count[execute]--;
        wait[execute]=n;
      }
      if(isSuccess){
        break;
      }
      answer++;
    }
    return answer;
  }
}