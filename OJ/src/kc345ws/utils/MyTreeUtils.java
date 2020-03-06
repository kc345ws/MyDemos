package kc345ws.utils;
import java.util.LinkedList;

import com.kc345ws.oj.TreeNode;

//��������
public class MyTreeUtils {
	//��α�������������
	public static TreeNode createBinary(Object[] objects) {
		LinkedList<TreeNode> treeNodes = new LinkedList<>();
		int index = 1;
		TreeNode rooTreeNode = new TreeNode((int)objects[0]);
		treeNodes.add(rooTreeNode);
		TreeNode tempNode = null;
		while(!treeNodes.isEmpty()) {
			tempNode = treeNodes.poll();
			if(index < objects.length) {
				if(objects[index]!=null) {			
					TreeNode l = new TreeNode((int)objects[index]);
					tempNode.left=l;
					treeNodes.add(l);
					index++;
				}else {
					tempNode.left=null;
					index++;
				}				
				if(objects[index]!=null) {			
					TreeNode l = new TreeNode((int)objects[index]);
					tempNode.right=l;
					treeNodes.add(l);
					index++;
				}else {
					tempNode.right=null;
					index++;
				}	
			}
		}
		return rooTreeNode;
	}
}
