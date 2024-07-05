	import java.util.Scanner;
	import java.lang.Math;
	
	public class Application {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nEnter operation (add, subtract, multiply, divide, pow, sqrt, log, log10, sin, cos, tan, factorial) or 'exit' to quit:");
            String operation = scanner.next();

            if (operation.equalsIgnoreCase("exit")) {
                System.out.println("Exiting calculator...");
                break;
            }

            //The If Statement is used to filter out the one operand calculations to strictly pertain to two operand calculations.
            if (!operation.equalsIgnoreCase("sqrt") && !operation.equalsIgnoreCase("log")
                    && !operation.equalsIgnoreCase("log10") && !operation.equalsIgnoreCase("sin")
                    && !operation.equalsIgnoreCase("cos") && !operation.equalsIgnoreCase("tan")
                    && !operation.equalsIgnoreCase("factorial")) {
                System.out.print("Enter first number: ");
                double num1 = scanner.nextDouble();
                System.out.print("Enter second number: ");
                double num2 = scanner.nextDouble();

                switch (operation.toLowerCase()) {
                    case "add":
                        System.out.println("Result: " + add(num1, num2));
                        break;
                    case "subtract":
                        System.out.println("Result: " + subtract(num1, num2));
                        break;
                    case "multiply":
                        System.out.println("Result: " + multiply(num1, num2));
                        break;
                    case "divide":
                        System.out.println("Result: " + divide(num1, num2));
                        break;
                    case "pow":
                        System.out.println("Result: " + power(num1, num2));
                        break;
                    default:// if none of the switch case for the two operand operation choices are not chosen then default to invalid choice.
                        System.out.println("Invalid operation.");
                        break;
                }
            } else { //If the strictly two operand operations are not used or skipped we go to the one operand operations with this else statement.
                System.out.print("Enter number: ");
                double num = scanner.nextDouble();

                switch (operation.toLowerCase()) {
                    case "sqrt":
                        System.out.println("Result: " + sqrt(num));
                        break;
                    case "log":
                        System.out.println("Result: " + log(num));
                        break;
                    case "log10":
                        System.out.println("Result: " + log10(num));
                        break;
                    case "sin":
                        System.out.println("Result: " + sin(Math.toRadians(num)));
                        break;
                    case "cos":
                        System.out.println("Result: " + cos(Math.toRadians(num)));
                        break;
                    case "tan":
                        System.out.println("Result: " + tan(Math.toRadians(num)));
                        break;
                    case "factorial":
                        System.out.println("Result: " + factorial((int) num));
                        break;
                    default: // if no choices match the switch cases for the single operand operations then default to invalid choice.
                        System.out.println("Invalid operation.");
                        break;
                }
            }
        }

        scanner.close();
    }

    public static double add(double a, double b) {//Addition
        return a + b;
    }

    public static double subtract(double a, double b) {//Subtraction
        return a - b;
    }

    public static double multiply(double a, double b) {//Multiplication
        return a * b;
    }

    public static double divide(double a, double b) {//Division, make sure to check for dividing by zero to ensure an illegal exeption is thrown to avoid further calculation for division if that occurs.
        if (b == 0) {
            throw new IllegalArgumentException("Error! You Cannot Divide By Zero");
        } else {
            return a / b;
        }
    }

    // Factorial calculation with progress display
    public static long factorial(int num) {
        if (num < 0) {
            System.out.println("Factorial of a negative number is undefined.");
            return 0;
        }

        // Start the factorial calculation with progress display
        System.out.print("Calculating factorial: ");
        long result = factorialHelper(num, num);

        // Move to the next line after progress display completes
        System.out.println();

        return result;
    }

    private static long factorialHelper(int originalNum, int num) {
        if (num <= 1) {
            return 1;
        }

        // Calculate progress and update progress bar
        int progress = (int) (((double) (originalNum - num + 1) / originalNum) * 100);
        System.out.print("\rCalculating factorial: " + progress + "%");

        // Recursively calculate factorial
        long result = num * factorialHelper(originalNum, num - 1);

        return result;
    }
    //Exponentiation:
    public static double power(double base, double exponent) {
    return Math.pow(base, exponent);
    }
    
    //Square Root:
    public static double sqrt(double number) {
    	return Math.sqrt(number);
    }
    
    //Natural Logarithmic:
    public static double log(double number) {
    	return Math.log(number); 
    }
    
    //Base-10 Logarithm:
    public static double log10(double number) {
    	return Math.log10(number);
    }
    
    //Sine Function:
    public static double sin(double angleRadians) {
    	return Math.sin(angleRadians);
    }
    
    //Cosine Function:
    public static double cos(double angleRadians) {
    	return Math.cos(angleRadians);
    }
  
    //Tangent Function:
    public static double tan(double angleRadians) {
    	return Math.tan(angleRadians);
    }
}
