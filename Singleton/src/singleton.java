class Single{
	
	private static Single obj =null;
	
	
	public String p;
	private Single( String a) {
		
	p = a;
	System.out.println(p);
	}
	
	
	
	
	public static Single getInstance(String p) {
		if( obj==null ) {
			obj = new Single(p);
		}
		return obj;
	}
}


public class singleton {
	
	public static void main(String args[]) {
	String p="Hello";
	String q="World";
	
	Single a=Single.getInstance(p);
	Single b=Single.getInstance(q);
	System.out.println(a.p);
	System.out.println(b.p);
	a.p="Twinkle";
	b.p="Lahariya";
	System.out.println(a.p);
	System.out.println(b.p);
	}
}
