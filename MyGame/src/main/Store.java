package main;

public class Store {
	public static String name="李四";
	static{
		name="张三";
	}
	
	public void getText(){
		System.out.println("getText:"+name);
	}
	  
	
	public static void main(String[] args) {
		Store store=new Store();
		store.getText();
	}
}
