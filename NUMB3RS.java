import java.util.Scanner;
public class NUMB3RS {
	
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		
		int n,d,p,t;
		
		int c = sc.nextInt();
		
		for(int i = 0; i < c; i++)
		{
			n = sc.nextInt();
			d = sc.nextInt();
			p = sc.nextInt();
			
			int[][] map = new int[n][n];
			
			double[][] cache = new double[d + 1][n];	
			
			int[] total = new int[n];
			
			for(int j = 0; j < n; j++)
			{
				for(int k = 0; k < n; k++)
				{
					map[j][k] = sc.nextInt();
					total[j] += map[j][k];
				}
			}
			
			t = sc.nextInt();
			
			int[] q = new int[t];
			
			for(int j = 0; j < t; j++)
			{
				q[j] = sc.nextInt();
			}
			
			for(int j = 0; j < n; j++)
			{
				if(map[p][j] == 1) cache[1][j] = 1.0/total[p];
			}
			
			for(int j = 2; j < d + 1; j++)
			{
				for(int k = 0; k < n; k++)
				{
					for(int l = 0; l < n; l++)
					{
						if(map[k][l] == 1) cache[j][k] += cache[j-1][l] * (1.0 / total[l]);  
					}
				}
			}
			
			for(int j = 0; j < t; j++)
			{
				System.out.println(String.format("%.8f", cache[d][q[j]]));
			}
		}
		
		sc.close();
		
	}

}
