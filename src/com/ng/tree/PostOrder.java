package com.ng.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class PostOrder {
	

	public void recursive(TreeNode root, List<Integer> opList) {

		if (root == null) {

			return;
		}

		recursive(root.left, opList);
		recursive(root.right, opList);

		opList.add(root.val);

	}

	
	public List<Integer>  reversingPreOrder(TreeNode root) {

		List<Integer> list = new ArrayList<Integer>();

		if(root == null) {

			return list;
		}


		Stack<TreeNode> stk = new Stack<TreeNode>();
		stk.push(root);

		while(!stk.isEmpty()) {

			TreeNode temp = stk.pop();

			list.add(temp.val);

			if(temp.left != null) {

				stk.push(temp.left);
			}

			if(temp.right != null) {

				stk.push(temp.right);
			}

		}
		
		Collections.reverse(list);
		
		return list;
	}
	
	
	public List<Integer>  using2Stacks(TreeNode root) {

		List<Integer> list = new ArrayList<Integer>();

		if(root == null) {

			return list;
		}
		
		Stack<TreeNode> resultStk = new Stack<TreeNode>();
		Stack<TreeNode> stk = new Stack<TreeNode>();
		stk.push(root);

		while(!stk.isEmpty()) {

			TreeNode temp = stk.pop();

			resultStk.push(temp);

			if(temp.left != null) {

				stk.push(temp.left);
			}

			if(temp.right != null) {

				stk.push(temp.right);
			}

		}
		
		while(!resultStk.isEmpty()) {
			
			list.add(resultStk.pop().val);
		}
		
		return list;
	}
	
	



}
