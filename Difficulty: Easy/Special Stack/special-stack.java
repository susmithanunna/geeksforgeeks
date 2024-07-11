//{ Driver Code Starts
import java.util.Scanner;
import java.util.Stack;
class SpeStack{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			int n=sc.nextInt();
			Stack<Integer> s=new Stack<>();
			GfG g=new GfG();
			while(!g.isEmpty(s)){
			    g.pop(s);
			}
			while(!g.isFull(s,n)){
				g.push(sc.nextInt(),s);
			}
		System.out.println(g.min(s));
		}
	}
}
// } Driver Code Ends


/*Complete the function(s) below*/
class GfG{
    int min=0;
	public void push(int x,Stack<Integer> s1)
	{
	    //add code here.
	    if(s1.isEmpty()){
	        s1.add(x);
	          
	        min=x;
	        
	    }
	    else if(x>=min){
	           s1.add(x);
	       } 
	   else if(x<min){
	           int t=2*x-min;
	           min=x;
	           s1.add(t);
	       }
	}
	public int pop(Stack<Integer> s1)
        {
            //add code here.
             if(!s1.isEmpty()){
	       if(min<s1.peek()){
	           return s1.pop();
	       }
	       else{
	           int t=min;
	           min=2*min-s1.pop();
	          
	           return t;
	       }
	    }
	    return -1;
	}
	public int min(Stack<Integer> s1)
        {
           //add code here.
           return min;
	}
	public boolean isFull(Stack<Integer>s1, int n)
        {
           //add code here.
           return s1.size()==n?true:false;
	}
	public boolean isEmpty(Stack<Integer>s1)
        {
           //add code here.
           return s1.isEmpty();
	}
}