import java.util.ArrayList;

public class MorseCodeTree implements LinkedConverterTreeInterface<String> {
	private TreeNode<String> root;
	
	/**
	 * Constructor, calls the buildTree method
	 */
	public MorseCodeTree() {
		buildTree();
	}

	@Override
	public TreeNode<String> getRoot() {
		return new TreeNode<>(root);
	}

	@Override
	public void setRoot(TreeNode<String> newNode) {
		root = new TreeNode<>(newNode);
		
	}

	@Override
	public LinkedConverterTreeInterface<String> insert(String code, String result) {
		addNode(root, code, result);
		return this;
	}

	@Override
	public void addNode(TreeNode<String> root, String code, String letter) {
		if (code.length() == 1) {
            if (code.equals(".")) {
                root.left = new TreeNode<>(letter);
            } else if (code.equals("-")) {
                root.right = new TreeNode<>(letter);
            }
        } 
		else {
            if (code.charAt(0) == '.') {
                addNode(root.left, code.substring(1), letter);
            } else if (code.charAt(0) == '-') {
                addNode(root.right, code.substring(1), letter);
            }
        }	
	}

	@Override
	public String fetch(String code) {
		return fetchNode(root, code);
	}

	@Override
	public String fetchNode(TreeNode<String> root, String code) {
		String l = "";
        if (code.length() == 1) {
            if (code.equals(".")) {
                l = root.left.data;
            } else if (code.equals("-")) {
                l = root.right.data;
            }
        } else {
            if (!code.isEmpty()) {
                if (code.charAt(0) == '.') {
                    l = fetchNode(root.left, code.substring(1));
                } else if (!code.isEmpty() && code.charAt(0) == '-') {
                    l = fetchNode(root.right, code.substring(1));
                }
            }
        }
        return l;
	}

	@Override
	public LinkedConverterTreeInterface<String> delete(String data) throws UnsupportedOperationException {
		throw new UnsupportedOperationException("Not supported yet");
	}

	@Override
	public LinkedConverterTreeInterface<String> update() throws UnsupportedOperationException {
		throw new UnsupportedOperationException("Not supported yet");
	}

	@Override
	public void buildTree() {
		root = new TreeNode<>("");
		
		insert(".-" , "a");
		insert("-..." , "b");
		insert("-.-." , "c");
		insert("-.." , "d");
        insert("." , "e");
        insert("..-." , "f");
        insert("--." , "g");
        insert("...." , "h");
        insert(".." , "i");
        insert(".---" , "j");
        insert("-.-" , "k");
        insert(".-.." , "l");
        insert("--" , "m");
        insert("-." , "n");
        insert("---" , "o");
        insert(".--." , "p");
        insert("--.-" , "q");
        insert(".-." , "r");
        insert("..." , "s");
        insert("-" , "t");
        insert("..-" , "u");
        insert("...-" , "v");
        insert(".--" , "w"); 
        insert("-..-" , "x");  
        insert("-.--" , "y");
        insert("--.." , "z");	
	}

	@Override
	public ArrayList<String> toArrayList() {
		ArrayList<String> treeList = new ArrayList<>();
        LNRoutputTraversal(root, treeList);
        return treeList;
	}

	@Override
	public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list) {
		if (root != null) {
            LNRoutputTraversal(root.left, list);
            list.add(root.data);
            LNRoutputTraversal(root.right, list);
        }
		
	}

}
