
public class TreeNode<T> {
	/**
	 * Data of current node
	 */
	protected T data;
	
	/**
	 * Left child node
	 */
	protected TreeNode<T> left;
	
	/**
	 * Right child node
	 */
	protected TreeNode<T> right;
	
	/**
	   * The constructor that creates a data set to the dataNode and new TreeNode with left and right child set to null.
	   *
	   * @param dataNode the data to be stored in the TreeNode
	   */
	   public TreeNode (T dataNode) {
		   this.data = dataNode;
		   this.left = null;
		   this.right = null;
	   }
	   
	   /**
	    * The contructor that will be used to make deep copy
	    * @param node the node to deep copy from
	    */
	   public TreeNode (TreeNode<T> node) {
		   data = node.data;
		   left = new TreeNode<>(node.left);
		   right = new TreeNode<>(node.right);
	   }
	   
	   /**
	    * Return the data within this TreeNode
	    * @return the data within the TreeNode
	    */
	    public T getData() {
	    	return data;
	    }

}
