package java_assignment;

public class Calculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Java calculator");
		System.out.println();
		if (args.length != 3) {
			System.out.println("Usage: java calculator operad1 opertator operand2");
			System.exit(0);
		}

		var result = 0;
		switch (args[1].charAt(0)) {
		case '+':
			result = Integer.parseInt(args[0]) + Integer.parseInt(args[2]);
			break;
		case '-':
			result = Integer.parseInt(args[0]) - Integer.parseInt(args[2]);
			break;
		case '*':
			result = Integer.parseInt(args[0]) * Integer.parseInt(args[2]);
			break;
		case '.':
			result = Integer.parseInt(args[0]) * Integer.parseInt(args[2]);
			break;
		case '/':
			if (Integer.parseInt(args[2]) != 0) {
				result = Integer.parseInt(args[0]) / Integer.parseInt(args[2]);
			} else {
				System.out.println("Usage:  operand2 cant be 0");
				System.exit(0);
			}
			break;
		default:
			System.out.println("Usage: opertator should be + pr - or */. or /");
			System.exit(0);
		}

		System.out.println(args[0] + " " + args[0] + " " + args[0] + " = " + result);

	}

}
