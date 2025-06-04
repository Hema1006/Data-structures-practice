class Reversegrp{
    //class- Node
    static class Node{
        
        int data;
        Node next;/
        Node(int data){
            this.data=data;
        }
    }   
    //head 
    public Node head=null;
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
    public void display(){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+"->");
            temp=temp.next;
        }
        System.out.println("null");
    }
    public Node revgrp(Node head,int k){
        Node prev=null,next=null,temp=head;
        int count=0;
        while(temp!=null&&count<k){
            next=temp.next;
            temp.next=prev;
            prev=temp;
            temp=next;
            count++;
        }
        if(next!=null){
            head.next=revgrp(next,k);
        }
       return prev;
    }
}
 public class Main{   
    public static void main(String[] args){
        Reversegrp sl=new Reversegrp();
       sl.insertAtBeg(5);
       sl.insertAtBeg(6);
       sl.insertAtBeg(7);
       sl.insertAtBeg(8);
       sl.insertAtEnd(9);
       sl.insertAtspec(12,2);
       sl.head = sl.revgrp(sl.head, 2); 
       sl.display();
    }
}
