public class PaySys {
	@FunctionalInterface
	interface Payable {
		boolean processPayment(double amount);
	}

	public static void main(String[] args) {

		Payable creditCardPayment = (amount) -> amount < 5000;
		Payable bankTransferPayment = (amount) -> amount < 10000;
		double[] amounts = { 4000, 6000, 12000 };
		for (double amount : amounts) {
			System.out.println("Testing payment for amount: " + amount);
			boolean creditResult = creditCardPayment.processPayment(amount);
			boolean bankResult = bankTransferPayment.processPayment(amount);
			System.out.println("Credit Card Payment: " + (creditResult ? "Success" : "Failed"));
			System.out.println("Bank Transfer Payment: " + (bankResult ? "Success" : "Failed"));
			System.out.println("---------------------------------");
		}
	}
}