import java.util.Scanner; 
  
class Swap { 
  
    public static void main(String a[]) 
    { int x, y, temp;
	      System.out.println("Enter x and y");
	      Scanner in = new Scanner(System.in);
	     
	      x = in.nextInt();
	      y = in.nextInt();
         
        x = x + y; 
        y = x - y; 
        x = x - y; 
        System.out.println("After swaping:"
                           + " x = " + x + ", y = " + y); 
    } 
} 
