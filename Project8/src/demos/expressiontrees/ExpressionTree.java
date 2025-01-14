package demos.expressiontrees;


import java.util.Scanner;
import java.util.Stack;


/**
 * A basic Expressions tree class
 * @author Trevor Conger
 * @version 1.20.b
 *
 */

public class ExpressionTree{
	
	/**
	 * Basic Binary Tree Node class. 
	 * @author Trevor Conger
	 * @param <T>
	 */

	
	private class BTNode<T>{
		public T data;
		public BTNode<T> left;
		public BTNode<T> right;
		
		public BTNode(T data, BTNode<T> left, BTNode<T> right){
			this.data = data;
			this.left = left;
			this.right = right;
		}
		
	}
	
	/** Root of tree.  If tree is (not) empty, will be equal to null */
	private BTNode<String> root;
	
	
	/**
	 * Construct a tree from the given expression
	 * @param expression: infix expression with parentheses around all sub expressions and spaces between all tokens
	 * @throws RuntimeException For malformed infix expressions
	 */
	public ExpressionTree(String expression) throws RuntimeException{
		Scanner in = new Scanner(expression);
		root = buildTree(in);
		if(in.hasNext()){
			throw new RuntimeException("Symbols encountered after end of expression: " + in.next());
		}
		
	}
	
	/**
	 * Build left and right sub-trees recursively, operator in parent node
	 * @param in A scanner that has been advanced to the appropriate point in the expression
	 * @return The root node of the current (sub) tree
	 * @throws RuntimeException for illegal expressions
	 */
	private BTNode<String> buildTree(Scanner in) throws RuntimeException{

		BTNode<String> root = new BTNode<String>(null, null, null);

		if(!in.hasNext()){ //end of expression, so this node is null
			throw new RuntimeException("No expression found");
		}
		 //if this node is just a number, it doesn't need parens
		if (in.hasNextDouble()) {
			root.data = in.next();
			return root;
		}
		if (openParen(in)) {
			root.left = buildTree(in);
			
			if (closeParen(in)) {   // extra layer with no parens
				return root.left;
			}
			
			root.data = in.next();
			if ( ! isValidOperator(root.data)) {
				throw new RuntimeException("Invalid operator: " + root.data);
			}
			
			root.right = buildTree(in);
			if(!closeParen(in)) {
				throw new RuntimeException("Closing paren not found");
			}
		
			return root;
		}

		return root;
	}
	
    /**
     * Detect and consume (if present) a closing parenthesis
     * from the input expression.
     * @param in A scanner that has been parsed to the appropriate
     *       point in the exception
     * @return true if the closing paren was detected and consumed,
     *     false otherwise
     */
    private boolean closeParen(Scanner in) {
        if(in.hasNext("\\)")){
            in.next();//consume closing paren before returning
            return true;
        }
        return false;
    } // closeParen

	
    /**
     * Detect and consume (if present) an opening parenthesis from
     * the input expression
     * @param in A scanner that has been parsed to the appropriate point
     *           in the exception
     * @return true if the opening paren was detected and consumed,
     *          false otherwise
     */
    private boolean openParen(Scanner in) {
        if(in.hasNext("\\(")){
            in.next(); //consume open paren before returning
            return true;
        }
        
        return false;
    } // openParen

	/**
	 * Check to see if symbol contains +, -, *, or /
	 * @param symbol 
	 * @return true if symbol is one of the four allowed operators, 
	 * 			false otherwise
	 */
	private boolean isValidOperator(String symbol){
        return( symbol.equals("+")
                || symbol.equals("-")
                || symbol.equals("*")
                || symbol.equals("/"));
	}
	
	public static void main(String[] args){
		ExpressionTree et = new ExpressionTree("( ( 2 + ( 4 * 6 ) ) - ( 8 / 2 ) ) ");
		System.out.println(et + "= " + et.evaluateTree());
		System.out.println(et.printPostFix());

	}
	
	/** 
	 * Recursive method to print the inFix order of the tree
	 * Infix = in-order traversal
	 * @return String representation of tree
	 */
	public String printInFix() {
		return myPrintInFix(root);
	}
	/**
	 * Method to do operations recursivly to be completed when there are no more items left
	 * @param data of type BTNode<String> 
	 * @return A simplified string, will be done once there is null data
	 */
	private String myPrintInFix(BTNode<String> data) {
		if(data.left == null)  return data.data + " ";
		return "( " + myPrintInFix(data.left) + data.data + " " + myPrintInFix(data.right) + ") ";
	
	}
	
	/** 
	 * Recursive method to print the postFix of the tree
	 * @return PostFix representation of tree
	 */
	public String printPostFix() {
		return myPrintPostFix(root);
	}
	/**
	 * Recursive method to get the postFix of the tree
	 * @param data of type BTNode<String> 
	 * @return Will return a String with a simplified tree, till it is completed
	 */
	private String myPrintPostFix(BTNode<String> data) {
		if(data.left == null)  return data.data + " ";  
		return (myPrintPostFix(data.left) + myPrintPostFix(data.right) + data.data) + " ";
	}
	/**
	 * MakeArray method to make the array from the tree given
	 * @return a String array of the tree
	 */
	public String[] makeArray() {
		String str = printPostFix();
		String[] ary = new String[str.length()];
		for(int i = 0; i < ary.length; i++) {
			ary[i] = str.charAt(i) + "";
		}
		return ary;
	}
	/**
	 * Recursive method to evalute the tree
	 * @return Double value 
	 */
	public double evaluateTree() {
		return evaluateTree(root);
	}
	/**
	 * Recursive method to return the evaluation of the tree
	 * @param data of type BTNode<String>
	 * @return Return a evaluated partial tree until it will have no more data left on the tree
	 */
	private double evaluateTree(BTNode<String> data){
		if(data.left == null) return Double.parseDouble(data.data);
		double left = evaluateTree(data.left);
		double right = evaluateTree(data.right);	
		return applyOperator(data.data, left, right);
	}	
	

	/**
	 * Method to check if the string is a operator and to do an operation to send to the correct method
	 * @param operator This will be a String that will be the operator that must be used to perform a operation 
	 * @param left left operand
	 * @param right right operand
	 * @return result of applying operator to left and right operands
	 * @throws RuntimeException for anything other than +, -, *, /
	 */
	private double applyOperator(String operator, double left, double right)
			throws RuntimeException {
		if(!isValidOperator(operator)) {
			throw new RuntimeException("Opperator isnt valid " + operator);
		}
		if(operator.equals("-")) {
			return (left-right);
		}else if(operator.equals("+")) {
			return (left+right);
		}else if(operator.equals("*")) {
			return (left*right);
		}else{
			return (left/right);
		}
		
	}

} // class ExpressionTree