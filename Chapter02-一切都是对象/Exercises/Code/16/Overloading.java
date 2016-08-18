//: initialization/Overloading.java
// DemonStration of both constructor
// and ordinary method overloading

/**
* This is a class for tree
* @author Howie Han
*/
class Tree {
	/** height of the tree; */
	int height;
	
	/**
	* a constructor without parameter
	*/
	Tree() {
		System.out.println("planting a seedling");
		height = 0;
	}

	/**
	* a constructor with a parameter representing height
	* @param initialHeight height
	Tree(int initialHeight) {
		height = initialHeight;
		System.out.println("Creating new Tree that is " + 
			height + "feet tall");		
	}	

	/** 
	* a method without parameter
	*/
	void info() {
		System.out.println("Tree is " + height + " feet tall");
	}
	
	/**
	* a method with a method
	* @param s description
	*/
	void info(String s){
		System.out.println(s + ": Tree is " + height + " feet tall");
	}
}
public class Overloading {
	/**
	* call
	*/
	public static void main(String[] args) {
		for (int i = 0; i < 5; i ++){
			Tree t = new Tree();
			t.info();
			t.info("overloaded method");	
		}
		// Overloaded constructor:
		new Tree();
	}
}
