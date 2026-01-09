package h3;

public class H3_main {
  
  public static void main(String[] args) {
    
    int[] array = {5, 100, 2, 6, 8, 10, 9, 1, 3, 7, 4, 6, 7, 6, 7};
    
    System.out.println("Unsortiertes Array:");
    printArray(array);
    
    int[] sortedArray = mergeSort(array);
    
    System.out.println("Sortiertes Array:");
    printArray(sortedArray);
  }

  public static int [] mergeSort(int [] array){
    if (array.length <= 1) {
      return array;
    }else {
      int [] left = new int[array.length / 2];
      int [] right = new int [array.length - left.length];
      
      for (int i = 0; i < array.length /2; i++) {
        left[i] = array[i];
      }
      for (int j = array.length / 2; j < array.length; j++) {
    	right[j - left.length] = array[j];
        
      }
      
      left = mergeSort(left);
      right = mergeSort(right);
      return merge(left, right);
    } // end of if-else // end of if
    
  }
  
  public static int[] merge(int [] links, int [] rechts){
    int [] ende = new int [links.length + rechts.length];
    int l = 0;
    int r = 0;
    int q = 0;
    while (l < links.length && r < rechts.length) { 
      if (links[l] <= rechts[r]) {
        ende[q] = links[l];
        l++;
      }else {
        ende[q] = rechts[r];
        r++; 
      } // end of if-else // end of if
      q++;
    } // end of while
    
    while (l < links.length) { 
      ende[q] = links[l];
      l++;
      q++;
    } // end of while
    
    while (r < rechts.length) { 
      ende[q] = rechts[r];
      r++;
      q++;
    } // end of while
    
    return ende;
  }
  
  private static void printArray(int[] array) {
	    for (int i = 0; i < array.length; i++) {
	        System.out.print(array[i] + " ");
	    }
	    System.out.println();
	}
}
    