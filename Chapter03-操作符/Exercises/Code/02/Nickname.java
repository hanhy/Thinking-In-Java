public class Nickname {
	public static void main(String[] args) {
		Tree tree1 = new Tree();
		Tree tree2 = new Tree();
		
		tree1.height = 10.2f;
		tree2.height = 4.5f;
		
		System.out.println("tree1's height: " + tree1.height + "\ntree2's height: " + tree2.height);
		
		tree1 = tree2;
		tree1.height = 8.8f;
		
		System.out.println("tree1's height: " + tree1.height + "\ntree2's height: " + tree2.height);
	}			
}

class Tree {
	float height;
}
