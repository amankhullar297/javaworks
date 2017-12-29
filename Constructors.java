//import java.util.*;
public class Constructors {
	
	Constructors()
	{
		System.out.println("Constructor");
	}
	
Constructors(String n)
{
	System.out.println("Constructors wid name");
}
}
	
class person extends Constructors
{
public person() {
System.out.println("Person");	// TODO Auto-generated constructor stub
}
person(String n)
{
//super(n);
System.out.println("Person wid name");
}
}

class Taste
{
public static void main(String[] args) {
	person p=new person("Aman");
	//System.out.println(p);
		
	
	}
	}

