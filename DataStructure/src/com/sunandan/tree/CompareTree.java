class CompareTree{

    public static void main(String[] args) {
        CompareTree c = new CompareTree();
        int[] arr = {1,2,3,4,5,6,7};
        Node<Integer> root_tree1=c.createBinaryTreeWithSortedArray(arr,0,arr.length-1);
        int[] arr1 = {1,2,3,4,5,6,7};
        Node<Integer> root_tree2=c.createBinaryTreeWithSortedArray(arr1,0,arr1.length-1);
        if(c.compareTree(root_tree1,root_tree2))
            System.out.print("Both Trees are equal");
        else
            System.out.print("Both Trees are not equal");
    }

    private boolean compareTree(Node<Integer> tree1, Node<Integer> tree2){
        if(tree1 == null && tree2 == null){
            return true;
        }
        if(tree1 != null && tree2!= null){
            return (tree1.data == tree2.data 
                        && compareTree(tree1.left,tree2.left)
                        && compareTree(tree1.right, tree2.right));
        }
        
        return false;
    }

    private Node<Integer> createBinaryTreeWithSortedArray(int[] arr,int first_pos,int last_pos){
        if(first_pos>last_pos)
                return null;
        int mid = (first_pos + last_pos)/2;
        Node<Integer> node = new Node<Integer>(arr[mid]);
        node.left = createBinaryTreeWithSortedArray(arr, first_pos, mid-1);
        node.right = createBinaryTreeWithSortedArray(arr, mid+1, last_pos);
        return node;
    }

}

class Node<T>{
    T data;
    Node<T> right;
    Node<T> left;
    Node(T data){
        this.data = data;
    }
}