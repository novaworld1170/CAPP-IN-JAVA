import java.io.*;
import java.util.*;

/*Node Class or node of the linked list*/
class Node{
  int data;
  Node next;
  Node(int data){
    this.data=data;
    next = null;
  }
}

/*Linked list class*/
class LinkedList{
  Node head;

/*insert function insert at last index*/
  public void insert(int d){
    Node newNode=new Node(d);
    if(head==null){
      head=newNode;
    }else{
      Node last=head;
      while(last.next!=null){
        last=last.next;
      }
      last.next=newNode;
    }
  }

/*Inserting at specific index*/
  public void insertAt(int index,int data){
    if(index>size()){
      System.out.println("Invalid Index!");
    }else{
      Node newNode = new Node(data);
      Node node=head;
      int count=0;
      if(index==0){
        insertAtStart(data);
      }else{
        while(count<index-1){
            node = node.next;
            count++;
        }
        Node temp=node.next;
        node.next=newNode;
        node.next.next=temp;
      }
    }

  }

/*Deleting last element from the LinkedList*/
public void delete(){
  if(isEmpty()){
    System.out.println("List is empty!");
  }else{
    Node last = head;
    while(last.next.next!=null){
      last=last.next;
    }
    last.next=null;
  }
}

/*Deleting element at specific index*/
public void deleteAt(int index){
  if(index==0){
    deleteAtStart();
  }else if(index>size()-1){
    System.out.println("Invalid Index!");
  }
  else{
    int count = 0;
    Node last = head;
    while(count<index-1){
      last=last.next;
      count++;
    }
    last.next=last.next.next;
  }
}

/*Deleting element from front*/
public void deleteAtStart(){
  head=head.next;
}
/*Inserting at front*/
public void insertAtStart(int data){
  Node newNode = new Node(data);
  if(head==null){
    insert(data);
  }else{
    Node temp=head;
    head=newNode;
    head.next=temp;
  }
}

/*Size of the Linked List*/
public int size(){
  Node curr=head;
  int count=0;
  while(curr!=null){
    curr=curr.next;
    count++;
  }
  return count;
}

/*Reversing the LinkedList*/
public void reverse(){
  Node curr=head;
  Node prev=null;
  Node forward=null;
  while(curr.next!=null){
    forward=curr.next;
    curr.next=prev;
    prev=curr;
    curr=forward;
  }
  head=curr;
  head.next=prev;
}


/*Printing the LinkedList*/
  public void printList(){
    Node node=head;
    while(node.next!=null){
      System.out.print(node.data+" ");
      node=node.next;
    }System.out.print(node.data+" ");
    System.out.println();
  }
  public boolean isEmpty(){
    if(head==null)
      return true;
    return false;
  }
}

/*Main Clss */
class LinkedListMain{
  public static void main(String[] args){
      LinkedList list = new LinkedList();
      Scanner scan = new Scanner(System.in);
      PrintStream ps = new PrintStream(System.out);
      while(true){
        ps.println("Enter the operations!\n 1. Insert \n 2. Insert At Index \n 3. Display \n 4. Delete From last \n 5. Delet At Index \n 6. Delete At start \n 7. Size \n 8. CheckForEmpty \n 9. Reverse the linkedList \n 10.Exit");

        int T=scan.nextInt();
        switch(T){
          case 1: ps.println("Enter the no. of elements you want to insert in the LinkedList!");
                  int n = scan.nextInt();
                  while(n-->0){
                    list.insert(scan.nextInt());
                  }
                  break;
          case 2: ps.println("Enter the index and element");
                  int index = scan.nextInt();
                  int element=scan.nextInt();
                  list.insertAt(index,element);
                  break;
          case 3: list.printList();
                  break;
          case 4: list.delete();
                  break;
          case 5: ps.println("Enter the index!");
                  list.deleteAt(scan.nextInt());
                  break;
          case 6: list.deleteAtStart();
                  break;
          case 7: ps.println("Size of the Linked List is "+ list.size());
                  break;
          case 8: if(list.isEmpty()){
                    ps.println("List is Empty!");
                  }else{
                    ps.println("List is not Empty!");
                  }
                  break;
          case 9: list.reverse();
                  list.printList();
                  break;
          case 10: System.exit(0);
          default: ps.println("Enter the valid options!");
        }
      }
  }
}
