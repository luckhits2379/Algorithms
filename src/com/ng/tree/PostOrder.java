package com.ng.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class PostOrder {


	//Simple recursive Solution
	public void recursive(TreeNode root, List<Integer> opList) {

		if (root == null) {

			return;
		}

		recursive(root.left, opList);
		recursive(root.right, opList);

		opList.add(root.val);

	}

	//Use preOrder and then reverse it, visit left then right to get correct order
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


			//first push left
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

	//Same as reversing preorder, instead of reversing list, use result in stack
	public List<Integer>  usingTwoStacks(TreeNode root) {

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


	// Keep going left and push node to stack untill curr is not null
	// Process node when curr is null in 2 scenarios
	// 1: if node at the top of the stack doest have right substree, means right is done. no right sub tree.
	// 2: if node at top of the stack has right sub tree and equals prev processed nodes, means prev processed node was right subtree, hance right processing done
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<Integer> usingOneStack(TreeNode root){


		List<Integer> list = new ArrayList();

		if (root == null) {

			return list;
		}

		Stack<TreeNode> stk = new Stack();
		TreeNode curr = root;
		TreeNode prev = null;

		while (curr != null || !stk.isEmpty()) {

			//keep going left
			if (curr != null) {

				stk.push(curr);
				curr = curr.left;

				//process nodes (above mentioned 2 cases)	
			} else if (stk.peek().right == null || stk.peek().right == prev) {

				prev = stk.pop();
				list.add(prev.val);

				//go to right subtree	
			} else {

				curr = stk.peek().right;

			}

		}

		return list;

	}





}
