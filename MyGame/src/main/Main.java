package main;


public class Main {
	
	private static int []num={0,1,2,3,4,5,6,7,8,9};
	
	private static int []index={1,3,5,2,4,2,6,1,3,7,5};
	
	public static void main(String[] args) {
		StringBuffer buffer=new StringBuffer();
		for(int i=0;i<index.length;i++){
			buffer.append(num[index[i]]);
		}
		System.out.println("b:"+buffer.toString());
	}

}
