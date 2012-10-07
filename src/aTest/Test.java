package aTest;


public class Test {

	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		int[][][] src= new  int[2][2][2];
		int[][][] dst= new int[2][2][2] ;		
		{
		src[0][0][0]=0;
		src[0][0][1]=1;
		src[0][1][0]=2;
		src[0][1][1]=3;
		}
		
		
		src[1][0][0]=4;
		src[1][0][1]=5;
		src[1][1][0]=6;
		src[1][1][1]=7;
		copy2(src,dst);
		
	}

	private synchronized static void copy2(int[][][] src, int[][][] dst) {
		for(int i=0;i<2;i++)
		{
			for(int j=0;j<2;j++)
			{
				for(int k=0;k<2; k++)
				{
					dst[i][j][k]= src[i][j][k];
					System.out.println(dst[i][j][k]);
				}
			}
		}
	
		
		
	}

}
