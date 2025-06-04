class SinglyLinkedList{
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
    public void deleteAtBeg(){
        if(head==null){
            return;
        }
        if(head.next==null){
            head=null;
            return;
        }
        head=head.next;
    }
    public void deleteAtEnd(){
        if(head==null){
            return;
        }
        if(head.next==null){
            head=null;
            return;
        }
        Node temp=head;
        while(temp.next.next!=null){
            temp=temp.next;
        }
        temp.next=temp.next.next;
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
    public void deleteatspec(int pos){
        Node temp=head;
        if(head == null){
            return;
        }
        if(pos==1){
            head=head.next;
            return;
        }
        for(int i=1;i<pos-1&&temp.next!=null;i++){
            temp=temp.next;
        }
        if(temp==null || temp.next==null){
            System.out.println("Index out of bound");
        }
        temp.next=temp.next.next;
    }
    public void display(){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+"->");
            temp=temp.next;
        }
        System.out.println("null");
    }
}
public class Main{   
    public static void main(String[] args){
       SinglyLinkedList sl=new SinglyLinkedList();
       sl.insertAtBeg(5);//1000
       sl.insertAtBeg(6);//2000
       sl.insertAtBeg(7);//3000
       sl.insertAtBeg(8);//4000
       sl.insertAtEnd(9);//5000
       sl.insertAtspec(12,2);
       sl.deleteAtBeg();
       sl.deleteAtEnd();
       sl.deleteatspec();
       sl.display();
}
}
