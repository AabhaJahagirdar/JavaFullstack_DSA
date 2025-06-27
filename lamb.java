/*Create an interface Payable with a method processPayment(double amount) that
returns a boolean indicating success. Implement this interface in two classes:
CreditCardPayment (returns true if amount < 5000) and
BankTransferPayment (returns true if amount < 10000).
Write a program to test payment processing for different amounts using both implementations.
 
Implementation Guidance:
 
Define the Payable interface with boolean processPayment(double amount).
In CreditCardPayment, return true if amount < 5000, else false.
In BankTransferPayment, return true if amount < 10000, else false.
Create a main method to test payments with amounts like 4000, 6000, and 12000.
 */

public class lamb {

	@FunctionalInterface
	interface BankTransferPayment {
		boolean bankProcess(double amount);
	}

	@FunctionalInterface
	interface CreditCardPayment {
		boolean creditProcess(double amount);
	}

	public static void main(String[] args) {

		BankTransferPayment bp = (amount) -> {
			if (amount < 10000 && amount > 5000) {
				return true;
			}
			return false;
		};

		CreditCardPayment cp = (amount) -> {
			if (amount < 5000) {
				return true;
			}
			return false;
		};

		System.out.println("CreditCardPayment " + cp.creditProcess(400));

		System.out.println("BankTransferPayment " + bp.bankProcess(8000));
	}
}