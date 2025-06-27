
@FunctionalInterface
interface Pay {
	boolean proPay(double amt);
}

public class PayTest {
	public static void main(String[] args) {

		Pay bT = amt -> amt < 10000;
		Pay cC = amt -> amt < 5000;

		double[] amt = { 4000, 6000, 12000, 1400 };

		for (double amt1 : amt) {
			System.out.println("Test the amount " + amt1);

			boolean ccResult = cC.proPay(amt1);

			System.out.println("payment os credit card ( true if amount < 5000): " + (ccResult ? "Success" : "fail"));

			boolean btResult = bT.proPay(amt1);

			System.out.println("payment of bank transfer (true if amount < 10000): " + (btResult ? "Success" : "fail"));

		}
	}
}