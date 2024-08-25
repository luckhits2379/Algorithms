package com.ng.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreOrder {


	//Simple recursive Solution
	public void recursive(TreeNode root, List<Integer> opList) {

		if (root == null) {

			return;
		}

		opList.add(root.val);

		recursive(root.left, opList);
		recursive(root.right, opList);


	}


	//Use stack
	public List<Integer>  usingStack(TreeNode root) {

		List<Integer> list = new ArrayList<Integer>();

		if(root == null) {

			return list;
		}


		Stack<TreeNode> stk = new Stack<TreeNode>();
		stk.push(root);

		while(!stk.isEmpty()) {

			TreeNode temp = stk.pop();

			list.add(temp.val);

			//first push right
			if(temp.right != null) {

				stk.push(temp.right);
			}


			if(temp.left != null) {

				stk.push(temp.left);
			}


		}


		return list;
	}

}
