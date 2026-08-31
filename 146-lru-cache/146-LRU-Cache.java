class Node{
    public int key,val;
    public Node prev,next;

    public Node(int key,int val){
        this.key=key;
        this.val=val;
        prev=next=null;
    }
    public Node(){
        key=val=-1;
        prev=next=null;
    }
}

class LRUCache {
    public Map<Integer,Node>map;
    public int capacity;
    public Node head;
    public Node tail;

    public void deleteNode(Node node){
        Node prevNode=node.prev;
        Node nextNode=node.next;
        prevNode.next=nextNode;
        nextNode.prev=prevNode;
    }

    public void insertAfterHead(Node node){
        Node n=head.next;
        head.next=node;
        node.next=n;
        n.prev=node;
        node.prev=head;
    }

    public LRUCache(int capacity) {
       this.capacity=capacity;
       map=new HashMap<>();
       head=new Node();
       tail=new Node();

       head.next=tail;
       tail.prev=head;
    }

    public int get(int key) {
       if(!map.containsKey(key))return -1;

       Node node=map.get(key);
       int val=node.val;
       
       deleteNode(node);
       insertAfterHead(node);

       return val;
    }

    public void put(int key, int value) {
      if(map.containsKey(key)){
        Node node=map.get(key);
        node.val=value;

        deleteNode(node);
        insertAfterHead(node);

        return;
      }

      if(map.size()==capacity){
        Node node=tail.prev;
        map.remove(node.key);
        deleteNode(node);
      }
      Node newnode=new Node(key,value);
      map.put(key,newnode);
      insertAfterHead(newnode);
    }

}