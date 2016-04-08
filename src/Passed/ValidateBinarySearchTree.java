package Passed;

import util.TreeNode;

public class ValidateBinarySearchTree {
	 public boolean isValidBST(TreeNode root) {
	        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
	    }
	    
	    boolean helper(TreeNode root, long min, long max) {
	        if(root == null) return true;
	        if(root.val >= max || root.val <= min) return false;
	        return helper(root.left,min,root.val) && helper(root.right,root.val,max);
	    }

	    // 
	    // second solution
	    //第二种方法是直接按照定义递归求解。 
	    //“根据题目中的定义来实现，其实就是对于每个结点保存左右界，
	    //也就是保证结点满足它的左子树的每个结点比当前结点值小，右子树的每个结点比当前结 点值大。
	    //对于根节点不用定位界，所以是无穷小到无穷大，接下来当我们往左边走时，
	    //上界就变成当前结点的值，下界不变，而往右边走时，下界则变成当前结点 值，上界不变。
	    //如果在递归中遇到结点值超越了自己的上下界，则返回false，否则返回左右子树的结果。” 
	    //
//	    public boolean isValidBST(TreeNode root) {
//	        return isBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
//	     }  
	        
//	    public boolean isBST(TreeNode node, long low, long high){  
//	        if(node == null)  
//	            return true;  
	              
//	        if(low < node.val && node.val < high)
//	            return isBST(node.left, low, node.val) && isBST(node.right, node.val, high);  
//	        else  
//	            return false;  
//	     } 
}
