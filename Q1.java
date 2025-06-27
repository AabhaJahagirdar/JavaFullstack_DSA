import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

/*46)   Reverse Content of a Large File: Read a large text file using BufferedReader, 
 * reverse the content line by line, and write it to another file using BufferedWriter 
 * without loading the entire file into memory.
 
 
48)   Custom CSV Parser: Create a program that reads a CSV file using BufferedReader, processes each 
line to extract values (handling quoted strings properly), and writes a formatted output using BufferedWriter.
 
49)   Word Frequency Counter in Large File: Read a large text file using BufferedReader and count 
the frequency of each unique word, ignoring case sensitivity. Store the results in another file.

 */
public class Q1 {

	public static void creatreFile() throws Exception {
		File f = new File("ABC.txt");
		if (f.createNewFile()) {
			FileWriter fw = new FileWriter("ABC.txt");
			fw.write("Hi \n Its me");
			fw.close();
		}
	}

	public static void revFile() throws Exception {
		File f2 = new File("XYZ.txt");
		f2.createNewFile();
		BufferedReader br = new BufferedReader(new FileReader("ABC.txt"));
		BufferedWriter bw = new BufferedWriter(new FileWriter("XYZ.txt"));
		String line;
		while ((line = br.readLine()) != null) {

			String reversedLine = new StringBuilder(line).reverse().toString();
			bw.write(reversedLine);
			bw.newLine();

		}
		br.close();
		bw.close();

	}

	public static void main(String[] args) throws Exception {
		Q1.creatreFile();
		Q1.revFile();
	}
}