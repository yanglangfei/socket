package main;

public class Store {
	public static String name="����";
	static{
		name="����";
	}
	
	public void getText(){
		System.out.println("getText:"+name);
	}
	  
	
	public static void main(String[] args) {
		Store store=new Store();
		store.getText();
	}
}
