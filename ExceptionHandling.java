import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*
* Throwable
* 		Exception
* 		RuntimeException
* 		Error
*/
public class ExceptionHandling {

	public static void uncaughtException(int a, int b) {
		int res = a / b;
		System.out.println("Result : " + a + "/" + b + "=" + res);
	}

	public static void caughtException(int a, int b) {
		try {
			int res = a / b;

			System.out.println("Result : " + a + "/" + b + "=" + res);
		} // end try
		catch (ArithmeticException e) {
			e.printStackTrace();
			System.out.println("getMessage :" + e.getMessage());
			System.out.println("toString() :" + e.toString());
			System.out.println("Message from getStackTrace() :");
			for (StackTraceElement element : e.getStackTrace()) {
				System.out.println("Array element Message : " + element);
			}
		} // end catch
		finally {
			System.out.println("Its always Execute ...");
		}
	}

	public static void multipleCatch() {
		try {
			Integer in = Integer.valueOf("abc");
			in.intValue();
		} catch (ArithmeticException e) {

		} catch (NumberFormatException e) {

		}
	}

	/*
	 * public static void unreachableCaught() { try { int arr[]= {1,5}; arr[2]=5/0;
	 * } catch(Exception e) {e.printStackTrace();} catch(ArithmeticException e)
	 * {e.printStackTrace();} //unreachable catch }
	 */
	public static void nestedTry() {
		try {
			int arr[] = { 7, 9, 4, 6 };
			try {
				int res = arr[3] / 0;
			} // innerTry
			catch (ArithmeticException e) {
				e.printStackTrace();
			}
			arr[4] = 79;
		} // outerTry
		catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
		}
	}

	public static void tryWithResources() {
		try (BufferedReader br = new BufferedReader(
				new FileReader("D:\\SpringToolWorkspace\\Technowings_JAVA\\src\\corejava\\HelloJava.java"));) {
			String str;
			while ((str = br.readLine()) != null) {
				System.out.println(str);
			}
		} catch (IOException io) {
			io.printStackTrace();
		}

	}

	public static void withoutTryWithResources() {
		try {
			String str;
			BufferedReader br = new BufferedReader(new FileReader("d:\\myfile.txt"));
			while ((str = br.readLine()) != null) {
				System.out.println(str);
			}
			br.close();
		} catch (IOException io) {
			io.printStackTrace();
		}

	}

	public static void validateVotingAge(int age) throws NumberFormatException, ArithmeticException {
		if (age > 18) {
			System.out.println("Eligible for voting");
		} else {
			throw new ArithmeticException("Age is not valid");
		}
	}

	public static void main(String[] args) {
		// ExceptionHandling.caughtException(10, 0);
		// ExceptionHandling.nestedTry();
		// ExceptionHandling.tryWithResources();
		try {
			ExceptionHandling.validateVotingAge(12);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (ArithmeticException e) {
			e.printStackTrace();
		}
		try {
			ExceptionHandling.sum(0, 5);
		} catch (CustomException e) {
			e.printStackTrace();
		}
		System.out.println("Its message after call method");
	}

	static void sum(int a, int b) throws CustomException {
		if (a < 0) {
			throw new CustomException(a);
		} else {
			System.out.println("Sum = " + (a + b));
		}
	}
}// class end

class CustomException extends Exception {
	private int e;

	public CustomException(int x) {
		this.e = x;
	}

	@Override
	public String toString() {
		return "CustomeException " + this.e + "is less than zero";
	}
}

class CustomException2 extends Exception {

	public CustomException2(String message) {
		super(message);
	}

}