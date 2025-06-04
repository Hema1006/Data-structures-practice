class Reverselist{
    //class- Node
    static class Node{
        
        int data; 
        Node next;
        Node(int data){
            this.data=data;
        }
    }   
    private Node head=null;
//insertAtBeg()
public void insertAtBeg(int data){//5
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
public void insertAtspec(int data,int pos){
        Node newNode=new Node(data);
        if(pos<0){
            System.out.print("Invalid position");
            return;
        }
        if(pos==1){
            insertAtBeg(data);
            return;
        }
        Node temp=head;
        for(int i=1;i<pos-1&&temp.next!=null;i++){
            temp=temp.next;
        }
        newNode.next=temp.next;
        temp.next=newNode;
    }
public void rev(){
        Node next=null;
        Node prev=null;
        Node current=head;
        while(current!=null){
            next=current.next;
            current.next=prev;
            prev=current;
            current=next;
        }
        head=prev;
    }
}
public class Main{   
    public static void main(String[] args){
       Reverselist sl=new Reverselist();
       sl.insertAtBeg(5);
       sl.insertAtBeg(6);
       sl.insertAtBeg(7);
       sl.insertAtBeg(8);
       sl.insertAtEnd(9);
       sl.insertAtspec(12,2);
       sl.display();
       sl.rev();
       sl.display();
}
}
