class Solution {
    ArrayList<Integer> findTwoElement(int arr[]) {
        // code here
        //nested loop for 1 to n
        //hashmap solution
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        ArrayList<Integer>ans=new ArrayList<>();
        for(int i=1;i<=arr.length;i++){
            if(!map.containsKey(i)){
                ans.add(i);
            }
            else{
                if(map.get(i)==2){
                    ans.add(0,i);
                }
            }
        }
        return ans;
    }
}
