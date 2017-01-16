package calculation;

import Jama.Matrix;
import java.util.Scanner;

public class ChickenRabbitCal {
	private double headCount;
	private double feetCount;
	private double chicken, rabbit, feetDiffCount;
	private Scanner scanner;
	private int option;

	public void getAnswer() {
		scanner = new Scanner(System.in);

		System.out.println("Enter the number of head count");
		headCount = scanner.nextDouble();
		System.out.println("Enter the numbe of feet count");
		feetCount = scanner.nextDouble();
		
		System.out.println("***********************************************");
		System.out.println("*********Which Method would you like***********");
		System.out.println("*************1. use equations******************");
		System.out.println("*************2. mathematic   ******************");
		System.out.println("***********************************************");
		
		option = scanner.nextInt();
		do {
			if (option == 1) {
				System.out.println("Op 1 was selected");
				
				double[][] lhsArr = { { 1, 1 }, { 2, 4 } };
				double[] rhsArr = { headCount, feetCount };

				Matrix lhs = new Matrix(lhsArr);
				Matrix rhs = new Matrix(rhsArr, 2);

				Matrix ans = lhs.solve(rhs);

				System.out.println("there are " + Math.round(ans.get(0, 0)) + " of chickens");
				System.out.println("there are " + Math.round(ans.get(1, 0)) + " of rabbits");
				break;
			}//end of op.1
			if(option == 2){
				//assume yard has only chicken, 2 x headcount = chickenCount
				//chicken feet is less than the total of feeCount: feetDiffCount = feeCount - chickenCount
				//rabbit has two more feet than chicken: 4 - 2 = 2;
				//chickenCount = feetDiffCount / 2 
				//rabbitCount = headCount - chickenCount
				
				System.out.println("method 2was selected");
				chicken = 2 * headCount;
				feetDiffCount = feetCount - chicken;
				chicken = feetDiffCount / 2;
				rabbit = headCount - chicken;
				System.out.println("there are "+ (int) chicken + " chickens and " + (int) rabbit + " rabbits");
				break;
			}
		} while(option == 1 || option == 2);

	}
}