import java.util.*;

public class ExtendedEuclideanAlgorithm {

	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		
		int a = -1;
		int b = -1;
		
		while (a < 0 || b < 0)
		{
			System.out.println("Give a and b");
			a = scan.nextInt();
			b = scan.nextInt();
		}
		
		if (a < b)
		{
			int temp = a;
			a = b;
			b = temp;
		}
		
		ArrayList<int[]> rows = new ArrayList<int[]>();
		int[] row0 = new int[3];
		int[] row1 = new int[3];
		 
		row0[0] = 1;
		row0[1] = 0;
		row0[2] = a;
		
		row1[0] = 0;
		row1[1] = 1;
		row1[2] = b;
		
		rows.add(row0);
		rows.add(row1);
		
		int i = 1;
		
		while (rows.get(i)[2] != 0)
		{
			i++;
			
			int q = Math.floorDiv(rows.get(i-2)[2], rows.get(i-1)[2]);
			
			int[] rowi = new int[3];
			
			rowi[0] = rows.get(i-2)[0] - q*rows.get(i-1)[0];
			rowi[1] = rows.get(i-2)[1] - q*rows.get(i-1)[1];
			rowi[2] = rows.get(i-2)[2] - q*rows.get(i-1)[2];
			
			rows.add(rowi);
		}
		
		for (int j = 0; j < rows.size(); j++)
		{
			System.out.print("Row " + j + ": " + rows.get(j)[0] + "  " + rows.get(j)[1] + "  " + rows.get(j)[2] + "\n");
		}
		
		System.out.print("x = " + rows.get(rows.size() - 2)[0] + ", y = " + rows.get(rows.size() - 2)[1] + ", gcd(" + a + ", " + b + ") = " + rows.get(rows.size() - 2)[2]);
		
		scan.close();

	}

}
