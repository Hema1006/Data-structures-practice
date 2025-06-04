class Deletekth{
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
  public void delkth(int k){
        Node current=head;
        int count=1;
        if(k<=0 || head==null){
            return;
        }
        if(k==1){
            head=null;
            return;
        }
        while(current!=null&&current.next!=null){
            if((count+1)%k==0){
                current.next=current.next.next;
                count++;
            }
            else{
                current=current.next;
                count++;
            }
        }
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
       Deletekth sl=new Deletekth();
       sl.insertAtBeg(5);
       sl.insertAtBeg(6);
       sl.insertAtBeg(7);
       sl.insertAtBeg(8);
       sl.insertAtBeg(9);
       sl.insertAtBeg(10);
       sl.delkth(2);
       sl.display();
    }
}
