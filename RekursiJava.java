package AIML;

public class RekursiJava {

	public RekursiJava() {
		// TODO Auto-generated constructor stub
	}
	static int power1(int a, int n) {
		int result = 1;
		for(int i=0;i<n;i++) {
			result *= a;
		}
		return result;
	}
	static int power2(int a , int n) {
		if(n==0) {
			return 1;
		} else
		{
			return a* power2(a,n-1);
		}
	}
	public static int factorial(int n) { 
		if (n == 1) {
			return 1;
		} 
		return n * factorial(n-1); 
	} 
	public static int Fibonacci ( int x ) { 
		if ( x < 2 ) {
			return 1; 
		} 
		else { 
			return Fibonacci(x - 1) + Fibonacci(x - 2); 
		} 
	} 
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("power = " +power1(3,3));
		System.out.println("power = " +power2(3,3));
	}

}
