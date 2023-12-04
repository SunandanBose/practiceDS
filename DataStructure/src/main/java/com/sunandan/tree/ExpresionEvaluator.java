package com.sunandan.tree;

class ExpresionEvaluator{

	static String answer = "";
	final static String[] expression = {"+","-","*","/"};
	public static void main(String[] args) {
		GenericNode root = createDummydata();
		compute(root);
		System.out.println(answer);
	}

	private static void compute(GenericNode root){
		if(root == null)
			return;
		compute(root.left);
		evaluateExpression((String)root.data);
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


	private static GenericNode createDummydata(){
		GenericNode root;
		root = new GenericNode("+");
		root.right = (new GenericNode("2"));
		root.left = (new GenericNode("*"));
		root.left.left = (new GenericNode("-"));
		root.left.right = (new GenericNode("4"));
		root.left.left.left = (new GenericNode("5"));
		root.left.left.right = (new GenericNode("3"));
		return root;
	}
}



