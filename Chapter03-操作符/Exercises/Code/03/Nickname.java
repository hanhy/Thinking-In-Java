public class Nickname {
	static void changeHeight(Tree x) {
		x.height = 10.0f;
	}
	public static void main(String[] args) {
		Tree tree = new Tree();
		tree.height = 8.1f;
		
		System.out.println("tree's height: " + tree.height);
		changeHeight(tree);
		System.out.println("tree's height: " + tree.height);
	}
}

class Tree {
	float height;
}
