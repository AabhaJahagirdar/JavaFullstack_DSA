public class RevStr {

	public static <T> String revStr(T str)
	{
		StringBuffer s = new StringBuffer((String)str);
		s.reverse();
		
		return s.toString();
		
	}
	
	
	public static void main(String[] args) {
		String str= "Hello";
		String revstr = RevStr.revStr(str);
		System.out.println(revstr);
	}
}