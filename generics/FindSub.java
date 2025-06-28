/*
7)Find substring and its number of occurrence , if found return range of index where it found
 
"Rust’s rich type system and ownership model guarantee memory-safety and thread-safety — enabling 
	you to eliminate many classes of bugs at compile-time. "
 
Sting subStr="safety";
*/
public class FindSub {
	
	public static <T> void findSub(T str ,T sub ){
		int count=0;
		int sublen = ((String) sub).length();
		for(int i =0 ;i<((String)str).length()-sublen;i++){
			if(((String)str).substring(i,i+sublen).equals(sub)) {
				System.out.println("\n\nSubstring Found");
				System.out.println("Start index "+i);
				System.out.println("End index "+(i+sublen-1));
				count++;
				System.out.println("\n\n");
			}
		}	
		System.out.println("String occurrence "+count+" times");
	}
	
	public static void main(String[] args) {
		String str="Rust’s rich type system and ownership model guarantee memory-safety and thread-safety — enabling you to eliminate many classes of bugs at compile-time. ";
		String substr="safety";
		FindSub.findSub(str, substr);
    }
}