package com.ng.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrder {


	//Simple recursive Solution
	public void recursive(TreeNode root, List<Integer> opList) {

		if (root == null) {

			return;
		}

		recursive(root.left, opList);
		opList.add(root.val);
		recursive(root.right, opList);

	}


	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<Integer> usingStack(TreeNode root) {

		List<Integer> list = new ArrayList();

		if(root == null){

			return list;
		}

		Stack<TreeNode> stk = new Stack();
		TreeNode curr = root;

		while(curr != null || !stk.isEmpty()){

			//keep going left
			if(curr != null){

				stk.push(curr);
				curr = curr.left;

				//process the node and add right subtree to stack
			}else{

				TreeNode temp = stk.pop();
				list.add(temp.val);
				curr = temp.right;

			}

		}

		return list;

	}

}
