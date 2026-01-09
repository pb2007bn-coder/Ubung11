package h1;

public class H1_main {
  
  
  public static void main (String [] args){
	  Node e = new Node(null);   
      Node d = new Node(e);      
      Node c = new Node(d);      
      Node b = new Node(c);      
      Node a = new Node(b);
    
    a.setNext(b);
    b.setNext(c);
    c.setNext(d);
    d.setNext(e);
    e.setNext(null);
    
    int test = distance(a,e);
    System.out.println(test);
  }
    
  public static int distance(Node x, Node y){
    
    if (x == y) {
      return 0;
    } // end of if
    else {
      return 1+ distance(x.getNext(),y);
    } // end of if-else
    
  }
    
}

