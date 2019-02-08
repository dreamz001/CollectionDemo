package com.rajinder.java8;

public class Greeter {

	public void greet(Greeting greeting) {
		greeting.perform();
	}
	
	public static void main(String[] args) {
		Greeter greeter=new Greeter();
		Greeting greetingImpl=new GreetingImpl();
		greeter.greet(greetingImpl);
		
		//anonymous inner class
		new Greeting() {
			
			@Override
			public void perform() {
				System.out.println("SSA Ji-1");
				
			}
		};

		MyLambda lambda = () -> System.out.println("SSA Ji");
		lambda.foo();
		MyAdd myAdd=(x, y) -> x+y;
		System.out.println(myAdd.addNum(10, 15));
		
		SafeDivision safeDivision= ( x,  y) -> {
				if(y==0)
				return 0;
				return x/y;
			};
		System.out.println(safeDivision.divide(5, 0));
		System.out.println(safeDivision.divide(10, 2));
		CountLength countLength = s ->  s.length();
		System.out.println("Length of Rajinder is :"+countLength.length("Rajinder"));
		
	}
}

interface MyLambda{
	void foo();
}

interface MyAdd{
	int addNum(int x, int y);
}

interface SafeDivision{
	float divide(float x, float y); 
}

interface CountLength{
	int length(String s);
}