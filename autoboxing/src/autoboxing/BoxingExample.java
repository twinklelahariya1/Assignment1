package autoboxing;

class BoxingExample{  
	  public static void main(String args[]){  
	    Integer a=50;  
	    
	    Character s = 'i';
	    char ch=s;
	    int a1 = s; //auto UnBoxing;
	        Integer a2=new Integer(a1);//Boxing  
	  
	        Integer a3=5;//Boxing  
	          
	        System.out.println(a+ " "+ ch+ " " + a1 +" "+ a2+" "+a3);  
	 }   
	}