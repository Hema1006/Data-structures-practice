class Middlelist{
    //class- Node
    static class Node{
        
        int data;//4 
        Node next;//12
        Node(int data){
            this.data=data;
        }
    }   
    private Node head=null;
//insertAtBeg()
public void insertAtBeg(int data){
    Node newNode=new Node(data);
    newNode.next=head;
    head=newNode;
}
    public void insertAtEnd(int data){
        Node newNode=new Node(data);
        if(head==null){
            head=head.next;
            head=newNode;
            return;
        }
        Node temp=head;
        
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=newNode; 
    }
public int findmid(){
        Node slow=head;
        Node fast=head;
        while(fast!=null&&fast.next!=null&&fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow.data;
    }
}
public class Main{   
    public static void main(String[] args){
       Middlelist sl=new Middlelist();
       sl.insertAtBeg(5);
       sl.insertAtBeg(6);
       sl.insertAtBeg(7);
       sl.insertAtBeg(8);
       sl.insertAtEnd(9);
       sl.insertAtspec(12,2);
       int mid=sl.findmid();
       System.out.println(mid);
}
}
