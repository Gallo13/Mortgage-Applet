import java.util.Scanner;

class MortgageConsole{

public static void main (String[] argv)
	{
	Scanner myscan = new Scanner(System.in);

	double amount, rate, term, payment;
	
	System.out.print("Enter the amount: ");
	amount = myscan.nextDouble();

	System.out.print("Enter the annual interest rate: ");
	rate = myscan.nextDouble();
	
	System.out.print("Enter the term: ");
	term = myscan.nextDouble();

	LoanCalc myloancalc = new LoanCalc(amount, rate, term);
	
	payment = myloancalc.getPayment();

	double tax /= 12;
	double insurance /= 12;
	double total = payment + tax + insurance;

	System.out.print("" + total);
	}
}