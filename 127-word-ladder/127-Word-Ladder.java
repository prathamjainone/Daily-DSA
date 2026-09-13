class Solution {
    public int ladderLength(String start, String end, List<String> list) {
        
        Queue<String>q=new ArrayDeque<>();
        HashSet<String>set=new HashSet<>();
        for(String i:list){
            set.add(i);
        }
        if(set.contains(start)){
            set.remove(start);
        }
        q.add(start);
        int level=1;
        while(!q.isEmpty()){
            int size=q.size();
            while(size-->0){
                String s=q.poll();
                for(int i=0;i<s.length();i++){
                    for(char j='a';j<='z';j++){
                        String n=s.substring(0,i)+j+s.substring(i+1);
                        if(n.equals(s))continue;
                        if(set.contains(n)){
                            if(n.equals(end))return level+1;
                            q.offer(n);
                            set.remove(n);
                        }
                    }
                }
            }
            level++;
        }
        return 0;
    }
}