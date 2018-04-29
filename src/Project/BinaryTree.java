package Project;

import java.util.Stack;

class Node {
	int data;
	Node left;
	Node right;
	
	public Node(int ddata, Node left, Node right) {
		this.data = ddata;
		this.left = null;
		this.right = null;
	}

	public void displayNode(Node n) {
		System.out.print(n.data + " ");
	}
}

public class BinaryTree {
	Node root;

	public BinaryTree() {
		this.root = null;
	}
	

	public int getheight(Node root) {
		if (root == null)
			return 0;
		return Math.max(getheight(root.left), getheight(root.right)) + 1;
	}
	
	public void makeEmpty(){
		root=null;
	}
	public boolean isEmpty(){
		return root==null;
	}
	
	boolean search(int data){
		return search(root,data);
		}
	boolean search(Node current,int data){
		if(current==null)
			return false;	
		else if(current.data==data){
			return true;
		}
		else if (data<=current.data)
			return search(current.left,data);
		else  
			return search(current.right,data);
		
		
	}
	
	
	void insert(int data){
		root=insert(root,data);
		
	}
	Node insert(Node current,int data){
		if(current==null){
			
			current=new Node(data,null,null);
			
		}
		else{
			if(data<=current.data)
				current.left=insert(current.left,data);
			else{
				current.right=insert(current.right,data);
			}
		}
		return current;
	}
	boolean deleteNode(int key){
		if(search(key)){
			root=deleteNode(root,key);
			return true;}
		else{
			return false;
		}
				
	}
	
	Node deleteNode(Node current, int key)
    {
        
        if (current == null)
            return current;
        
        if (key < current.data)
            current.left = deleteNode(current.left, key);
 
        else if (key > current.data)
            current.right = deleteNode(current.right, key);
       
        else
        {
 
            // node with only one child or no child
            if ((current.left == null) || (current.right == null))
            {
                Node temp = null;
                if (temp == current.left)
                    temp = current.right;
                else
                    temp = current.left;
 
                // No child case
                if (temp == null)
                {
                    temp = current;
                    current = null;
                }
                else   // One child case
                    current = temp; 
              
            }
            else
            {
 
                //two childs case
                Node temp = current.right;
                while (temp.left != null)
                    temp = temp.left;
 
                current.data = temp.data;
 
                current.right = deleteNode(current.right, temp.data);
            }
            
        }
        return current;
    }
	@SuppressWarnings("unchecked")
	public String displayTree(Node root){
		String s="";
    	this.root=root;
        @SuppressWarnings("rawtypes")
		Stack globalStack = new Stack();
        globalStack.push(root);

        int nBlanks = 32;
        boolean isRowEmpty = false;

       	s+="................................................................\n";

        while(isRowEmpty == false){
            @SuppressWarnings("rawtypes")
			Stack localStack = new Stack();
            isRowEmpty = true;

            for(int j=0; j<nBlanks; j++){
                s+=' ';
            }

            while(globalStack.isEmpty() == false){
                Node temp = (Node)globalStack.pop();

                if(temp != null){
                    s+=temp.data;
                    localStack.push(temp.left);
                    localStack.push(temp.right);

                    if (temp.left != null || temp.right != null) {
                        isRowEmpty = false;
                    }
                }else{
                    s+="..";
                    localStack.push(null);
                    localStack.push(null);
                }

                for(int j=0; j<nBlanks*2-2; j++){
                    s+=' ';
                }
            }

            s+="\n";

            nBlanks/=2;

            while(localStack.isEmpty() == false){
                globalStack.push(localStack.pop());
            }

            s+="................................................................\n";
        }
        return s;
    }
}