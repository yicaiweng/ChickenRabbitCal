package calculation;
import Jama.Matrix;
import java.util.Scanner;

public class ChickenRabbitCal{
	private double headCount;
	private double feetCount;
	private Scanner scanner;
	
	public void getAnswer(){
		
		scanner = new Scanner(System.in);

		System.out.println("Enter the number of head count");
		headCount = scanner.nextDouble();
		System.out.println("Enter the numbe of feet count");
		feetCount = scanner.nextDouble();
			
		double[][] lhsArr = { {1, 1}, {2, 4}};
		double[] rhsArr = {headCount, feetCount};
		
		Matrix lhs = new Matrix(lhsArr);
		Matrix rhs = new Matrix(rhsArr, 2);
		
		Matrix ans = lhs.solve(rhs);
		
		System.out.println("there are " + Math.round(ans.get(0, 0)) + " of chickens");
		System.out.println("there are " + Math.round(ans.get(1, 0)) + " of rabbits");
	}
}