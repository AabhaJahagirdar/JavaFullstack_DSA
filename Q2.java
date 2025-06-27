import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;

/*
 * 
47)   Find and Replace Words in a File: Implement a program that reads a text file using FileReader,
 replaces all occurrences of a given word with another word, and writes the updated content to a new
  file using FileWriter.
  */
public class Q2 {
	public static void replace() throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("ABC.txt"));
		BufferedWriter bw = new BufferedWriter(new FileWriter("XYZ.txt"));
		String line;

		while ((line = br.readLine()) != null) {
			String replaced = line.replace("Hii", "Hello");
			bw.write(replaced);
			bw.newLine();
		}
		br.close();
		bw.close();

	}

	public static void main(String[] args) throws Exception {
		Q2.replace();
	}
}