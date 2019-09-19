import java.io.*;
class LinkedList { 
    Node head; // head of list 
  
    /* Linked list Node*/
    class Node { 
        int data; 
        Node next; 
  
        // Constructor to create a new node 
        // Next is by default initialized 
        // as null 
        Node(int d) { data = d; } 
    } 
    
    
   LinkedList addNode(LinkedList list,int data)
    {
    	Node temp=new Node(data);
    	temp.next=list.head;
    	list.head=temp;
    	return list;
    	
    	
    }

   LinkedList deleteNode(LinkedList list )
   {
	   Node temp;
	   temp=head;
	   head=head.next;
	   temp.next=null;
	      
	   
	   return list;
   }

    void display(LinkedList list)
    {
    	Node temp=list.head;
    	System.out.println("items are ");
    	while(temp!=null)
    	{
    		System.out.println(temp.data);
    		temp=temp.next;
    		
    	}
    	
    	System.out.println("\n\n");
    	
    }

    LinkedList move(LinkedList list)
    {
    	Node prev=null;
    	Node temp;
    	Node cur;
    	cur=list.head;
    	while(cur.next!=null)

    	{
    		
    		prev=cur;
    		cur=cur.next;
    		
    		
    	}

    	temp=cur;
    	temp.next=head;
    	head=temp;
    	prev.next=null;
    	
    	
    	return list;
    }
    
    
}



public class LinkedLists{

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		LinkedList list=new LinkedList();
		int choice=0,data=0;
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		do
		{
			
			System.out.println("1:add element to head");
			System.out.println("2:delete element from head ");
			System.out.println("3:view content");
			System.out.println("4:move last element to first");
			System.out.println("5:exit");
			System.out.println("enter your choice : ");
			try {
			choice=Integer.parseInt(in.readLine());
			}catch(IOException e)
			{
				e.printStackTrace();
			}


			switch(choice)
			{

			case 1:
				System.out.println("============================");
				System.out.println("\n\n enter the data ");
				try {
					data=Integer.parseInt(in.readLine());
					}catch(IOException e)
					{
						e.printStackTrace();
					}
				
				list=list.addNode(list, data);
				System.out.println("============================");
				break;

			case 2:System.out.println("============================\n");
			System.out.println("deleted successfully");
				list=list.deleteNode(list);
				System.out.println("============================");
				break;
				
				
			case 3:
				System.out.println("============================\n");
				
				list.display(list);
				System.out.println("============================");
				break;
			case 4:
				System.out.println("============================\n");
				list=list.move(list);
				System.out.println(" moved successfully ");
				System.out.println("============================");
				break;

			case 5:System.exit(0);
			
			
			
			}
			
			
		}while(true);
		
		

	}

}
