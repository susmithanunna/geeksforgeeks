//{ Driver Code Starts
import java.util.*;

class FindMinCost
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t > 0)
		{
			int n = sc.nextInt();
			int m = sc.nextInt();
			int arr[][] = new int[n][m];
			for(int i=0; i<n; i++)
			{
				for(int j=0; j<m; j++ )
				{
					arr[i][j] = sc.nextInt();
				}
			}
			System.out.println(new Solution().maxArea(arr, n, m));
		t--;
		}
	}
}
// } Driver Code Ends


/*Complete the function given below*/
class Solution {
    public int maxArea(int M[][], int n, int m) {
        // add code here.
        int l[]=new int[m];
        int r[]=new int[m];
        int h[]=new int[m];
        int max=0;
        Arrays.fill(r,m);
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(M[i][j]==0){
                    h[j]=0;
                }
                else{
                    h[j]=h[j]+1;
                }
            }
            int cl=0;
            for(int j=0;j<m;j++){
                if(M[i][j]==0){
                   cl=j+1; 
                   l[j]=0;
                }
               else{
                    l[j]=(int)Math.max(l[j],cl);
               }
            }
            int cr=m;
            for(int j=m-1;j>=0;j--){
                if(M[i][j]==0){
                    cr=j;
                    r[j]=m;
                    
                    
                }
                else{
                r[j]=(int)Math.min(r[j],cr);
                }
            }
            for(int j=0;j<m;j++){
                max=(int)Math.max(max,h[j]*(r[j]-l[j]));
            }
        }
        return max;
    }
}