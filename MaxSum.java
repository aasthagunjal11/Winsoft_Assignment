import java.util.ArrayList;

public class MaxSum { 
	static int max(int x, int y) { 
        return (x > y) ? x : y; 
    } 

	static int maxPathSum(int X[], int Y[], int m, int n) { 
		int i = 0, j = 0; 

		int result = 0, sum1 = 0, sum2 = 0;
        ArrayList<Integer> ans=new ArrayList<>(); 

		while (i < m && j < n) { 
			if (X[i] < Y[j]){ 
				sum1 += X[i++];
                ans.add(X[i++]);
            } 

			else if (X[i] > Y[j]){ 
				sum2 += Y[j++];
                ans.add(Y[i++]);
            } 

			else { 
				result += max(sum1, sum2) + X[i];
                ans.add(X[i]);
                
				sum1 = 0; 
				sum2 = 0; 

				i++; 
				j++; 
			} 
		} 

		while (i < m){ 
			sum1 += X[i++];
            ans.add(X[i++]);
        } 

		while (j < n){ 
			sum2 += Y[j++];
            ans.add(Y[i++]);
        } 

		result += max(sum1, sum2); 
        System.out.println(ans.toString());
		return result; 
	} 

	public static void main(String[] args) 
	{  
		
        int X[] = { 3, 6, 7, 8, 10, 12, 15, 18, 100 };
        int Y[] = { 1, 2, 3, 5, 7, 9, 10, 11, 15, 16, 18, 25, 50 };

		int m = X.length; 
		int n = Y.length; 

		System.out.println( "Maximum sum path is :"+maxPathSum(X, Y, m, n)); 
	} 
} 

