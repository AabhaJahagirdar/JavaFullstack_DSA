import java.io.BufferedReader;
import java.io.Console;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class JavaIO {

	public static void scannerExmple() {
		Scanner objScanner = new Scanner(System.in);
		byte byteVar = objScanner.nextByte();
		short shortVar = objScanner.nextShort();
		int intVar = objScanner.nextInt();
		long longVar = objScanner.nextLong();
		float floatVar = objScanner.nextFloat();
		double doubleVar = objScanner.nextDouble();
	}

	public static void copyByte() {
		try (FileInputStream in = new FileInputStream(
				"D:\\SpringToolWorkspace\\Technowings_JAVA\\src\\corejava\\HelloJava.java");
				FileOutputStream out = new FileOutputStream(
						"D:\\SpringToolWorkspace\\Technowings_JAVA\\src\\corejava\\NewFile.Java");) {
			int c;
			while ((c = in.read()) != -1) {
				out.write(c);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void copyCharacter() {
		try (FileReader in = new FileReader("D:\\SpringToolWorkspace\\Technowings_JAVA\\src\\corejava\\HelloJava.java");
				FileWriter out = new FileWriter(
						"D:\\SpringToolWorkspace\\Technowings_JAVA\\src\\corejava\\MyFile.txt");) {
			int c;
			while ((c = in.read()) != -1) {
				out.write(c);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void readConsoleInput() {
		try (BufferedReader obj = new BufferedReader(new InputStreamReader(System.in));) {
			System.out.println("Enter Number Input");
			String str = obj.readLine();
			System.out.println("User Input : " + str);
			Integer obInteger = Integer.parseInt(str);
			int x = obInteger.intValue();

			System.out.println("Enter Character");
			System.out.println("User Enter : " + obj.read());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		// JavaIO.copyByte();
		// JavaIO.copyCharacter();
		// JavaIO.readConsoleInput();
		/*
		 * try { JavaIO.ScannerSum(); } catch (FileNotFoundException e) {
		 * e.printStackTrace(); }
		 */
		JavaIO.consoleStream_ValidateUserPassword();
	}// main

	public static void ScannerSum() throws FileNotFoundException {
		Scanner objScan = null;
		double sum = 0;
		try {
			objScan = new Scanner(new BufferedReader(
					new FileReader("D:\\SpringToolWorkspace\\Technowings_JAVA\\src\\corejava\\MyFile.txt")));
			objScan.useLocale(Locale.US);
			while (objScan.hasNext()) {
				if (objScan.hasNextDouble()) {
					sum += objScan.nextDouble();
				} else {
					objScan.next();
				}
			}
		} finally {
			objScan.close();
		}

		System.out.println("Sum = " + sum);
	}// ScannerSum()

	public static void consoleStream_ValidateUserPassword() {
		Console obj = System.console();
		if (obj == null) {
			System.err.println("System Console Not Found ... try to execute manually using javac and java utility");
			System.exit(1);
		}
		String username = obj.readLine("Enter Username : ");
		char[] oldPassword = obj.readPassword("Enter old Password : ");
		if (verify(username, oldPassword)) {
			boolean noMatch;
			do {
				char[] newPasswd1 = obj.readPassword("Enter New Password : ");
				char[] newPasswd2 = obj.readPassword("Enter New Password Again : ");
				noMatch = !Arrays.equals(newPasswd1, newPasswd2);
				if (noMatch) {
					obj.format("Password not match .. try again %n");
				} else {
					changePasswd(username, newPasswd1);
					obj.format("Password for %s changed %n", username);
					Arrays.fill(newPasswd1, ' ');
					Arrays.fill(newPasswd2, ' ');
				}

			} while (noMatch);
		}
		Arrays.fill(oldPassword, ' ');

	}

	public static boolean verify(String username, char[] passwd) {
		return true;
	}

	public static void changePasswd(String username, char[] passwd) {
		System.out.println("Password Updated Sucessfully... for " + username);

	}

}