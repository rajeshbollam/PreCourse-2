//Time Complexity: Average-O(nlogn), Worst-O(n^2)
//Space Complexity: O(logn) stack space
import java.util.Stack;

class IterativeQuickSort { 
    void swap(int arr[], int i, int j) 
    { 
    //Try swapping without extra variable 
         arr[i] = arr[i] + arr[j];
         arr[j] = arr[i] - arr[j];
         arr[i] = arr[i] - arr[j];
    } 
  
    /* This function is same in both iterative and 
       recursive*/
    int partition(int arr[], int l, int h) 
    { 
        //Compare elements and swap.
        int pivot = arr[h];
        int i = l - 1;
        for(int j=l;j<=h;j++){
            if(arr[j]<pivot){
                i++;
                swap(arr,i,j);
            }
        }
        i++;
        swap(arr,i,h);
        return i;
    } 
  
    // Sorts arr[l..h] using iterative QuickSort 
    void QuickSort(int arr[], int l, int h) 
    { 
        //Try using Stack Data Structure to remove recursion.
        Stack<int[]> myStack = new Stack<>();
        myStack.push(new int[]{l,h});
        while(!myStack.isEmpty()){
            int[] temp = myStack.pop();
            int low = temp[0];
            int high = temp[1];

            if(low<high){
                int pIndex = partition(arr,l,h);
                myStack.push(new int[]{l,pIndex-1});
                myStack.push(new int[]{pIndex+1,h});
            
            }
        }

    } 
  
    // A utility function to print contents of arr 
    void printArr(int arr[], int n) 
    { 
        int i; 
        for (i = 0; i < n; ++i) 
            System.out.print(arr[i] + " "); 
    } 
  
    // Driver code to test above 
    public static void main(String args[]) 
    { 
        IterativeQuickSort ob = new IterativeQuickSort(); 
        int arr[] = { 4, 3, 5, 2, 1, 3, 2, 3 }; 
        ob.QuickSort(arr, 0, arr.length - 1); 
        ob.printArr(arr, arr.length); 
    } 
} 
