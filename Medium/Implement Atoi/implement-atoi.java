//{ Driver Code Starts
//Initial template for JAVA

import java.util.Scanner;

class aToi
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		while(t>0)
		{
			String str = sc.nextLine();
			
			Solution obj = new Solution();
			int num = obj.atoi(str);
			
			System.out.println(num);
		t--;
		}
	}
}
// } Driver Code Ends


//User function template for JAVA

/*You are required to complete this method */
class Solution
{
    int atoi(String s) {
	// Your code here
	int n=0;
	int i=0;
	int flag=0;
	  if(s.charAt(i)=='-'){
	    i=1; 
	    flag=1;
	  }
	  else{
	      i=0;
	  }
	  while(i<s.length()){
	      if(s.charAt(i)>='0' && s.charAt(i)<='9'){
	            n=(n*10)+(s.charAt(i)-'0');
	      }
	      else{
	          return -1;
	      }
	      i++;
	  }
	  if(flag==1){
	      return -1*n;
	  }
	  return n;
    }
}
