package h2;

public class H2_main {
  
  private static int [] cache = new int [1000];
  
  public static void main(String [] args) {
	  int n = 10; 

	  benchmark(n);
  }
 
  public static void benchmark(int n){
    long testaAnfang = System.nanoTime();
    int ausgabeA = fibonacci(n);
    long testaEnde = System.nanoTime();
    System.out.println("a) Fibonacci("+n+") = "+ausgabeA);
    System.out.println("a) Ausführungszeit: " + (testaEnde - testaAnfang) + " ns");
    System.out.println("");
    
    long testbAnfang = System.nanoTime();
    int ausgabeB = fibonacciCached(n);
    long testbEnde = System.nanoTime();
    System.out.println("b) Fibonacci("+n+") = "+ausgabeB);
    System.out.println("b) Ausführungszeit: " + (testbEnde - testbAnfang) + " ns");
    System.out.println("");
    
    long testcAnfang = System.nanoTime();
    int ausgabeC = fibonacciIterativ(n);
    long testcEnde = System.nanoTime();
    System.out.println("c) Fibonacci("+n+") = "+ausgabeC);
    System.out.println("c) Ausführungszeit: " + (testcEnde - testcAnfang) + " ns"); 
    
  }
  
  public static int fibonacciCached(int n) {
    if (n == 1) {
      return 1;
    } // end of if
    else if (n == 2) {
      return 1;
    } // end of if
    else {
      if (cache[n] != 0) {
        return cache[n];
      } // end of if
      else {
        cache[n] = fibonacciCached(n-1) + fibonacciCached(n-2);
        return cache [n];
      } // end of if-else
    }
  }
    
  public static int fibonacci (int n){
    if (n == 1) {
      return 1;
    } // end of if
    else if (n == 2) {
      return 1;
    } // end of if
    else {
      return fibonacci(n-1) + fibonacci(n-2);
    } // end of if-else
    
  }
  
  public static int fibonacciIterativ (int n){

    if (n == 1) return 1;
    
    if (n == 2) return 1;
    int a = 1;
    int b = 1;
    int c = 0;
    for (int i = 3; i <= n; i++) {
      c = a+b;
      a = b;
      b = c;
    }
    return c;
    
  }
  
}
