

class ExpresionEvaluator{

	static String answer = "";
	final static String[] expression = {"+","-","*","/"};
	public static void main(String[] args) {
		Node root = createDummydata();
		compute(root);
		System.out.println(answer);
	}

	private static void compute(Node root){
		if(root == null)
			return;
		compute(root.left);
		evaluateExpression(root.data);
		compute(root.right);
	}

	private static void evaluateExpression(String data){
		if(answer.length()<1){
			answer = answer + data;
			return;
		}
		StringBuilder sb = new StringBuilder(answer);
		for(String s : expression){
			if(s.equals(data)){
				sb.append(data);
				answer = sb.toString();
				return;
			}
		}
		sb.insert(0,"(");
		sb.append(data+")");
		answer = sb.toString();
	}


	private static Node createDummydata(){
		Node root;
		root = new Node("+");
		root.right = (new Node("2"));
		root.left = (new Node("*"));
		root.left.left = (new Node("-"));
		root.left.right = (new Node("4"));
		root.left.left.left = (new Node("5"));
		root.left.left.right = (new Node("3"));
		return root;
	}
}

class Node{
	public String data;
	public Node right;
	public Node left;
	Node(String data){
		this.data = data;
		this.right = null;
		this.left = null;
	}
}