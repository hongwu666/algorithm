package com.hongwu.algorithm.manytree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class ManyNodeTree {

	// 树根
	private ManyTreeNode root;

	public ManyTreeNode getRoot() {
		return root;
	}

	public void setRoot(ManyTreeNode root) {
		this.root = root;
	}

	// 构造函数
	public ManyNodeTree() {
		root = new ManyTreeNode();
		root.getData().setNodeName("root");
	}

	// 构造函数
	public ManyNodeTree(int key) {
		root = new ManyTreeNode();
		root.getData().setKey(key);
		root.getData().setNodeName("root");
	}

	// 遍历多叉树
	public String iteratorTree(ManyTreeNode treeNode) {

		StringBuilder sb = new StringBuilder();

		if (treeNode != null) {

			if ("root".equals(treeNode.getData().getNodeName())) {
				sb.append(treeNode.getData().getKey() + ",");
			}

			for (ManyTreeNode index : treeNode.getChildList()) {

				sb.append(index.getData().getKey() + ",");

				if (index.getChildList() != null && index.getChildList().size() > 0) {

					sb.append(iteratorTree(index));

				}
			}
		}

		return sb.toString();
	}

	// 遍历多叉树
	public List<List<Integer>> iteratorTree2(ManyTreeNode treeNode) {

		StringBuilder sb = new StringBuilder();
		List<List<Integer>> tatol = new ArrayList<>();
		if (treeNode != null) {
			ArrayDeque<Integer> que = new ArrayDeque<>();
			if ("root".equals(treeNode.getData().getNodeName())) {
				que.add(treeNode.getData().getKey());
			}

			iteratorTree3(treeNode, que, tatol);

		}

		return tatol;
	}

	private ManyTreeNode iteratorTree3(ManyTreeNode treeNode, ArrayDeque<Integer> que, List<List<Integer>> tatol) {

		if (treeNode.getChildList() != null && treeNode.getChildList().size() > 0) {
			for (ManyTreeNode index : treeNode.getChildList()) {
				que.add(index.getData().getKey());

				ManyTreeNode node = iteratorTree3(index, que, tatol);
				if (node != null) {
					que.add(node.getData().getKey());
				} else {
					List<Integer> asda = new ArrayList<>();
					for (Integer a : que) {
						asda.add(a);
					}
					tatol.add(asda);
					que.pollLast();
				}
			}
		}

		return null;

	}

	public List<ManyTreeNode> dsf(ManyTreeNode treeNode) {
		return treeNode.getChildList();
	}

	// 构造多叉树
	public static ManyNodeTree createTree() {

		// 用构造函数指定根节点的值
		ManyNodeTree tree = new ManyNodeTree(60);

		// 第一层的节点
		ManyTreeNode node1 = new ManyTreeNode(40);
		ManyTreeNode node2 = new ManyTreeNode(50);
		ManyTreeNode node3 = new ManyTreeNode(30);

		tree.getRoot().getChildList().add(0, node1);
		tree.getRoot().getChildList().add(1, node2);
		tree.getRoot().getChildList().add(2, node3);

		// 第二层的节点
		ManyTreeNode node21 = new ManyTreeNode(85);
		ManyTreeNode node22 = new ManyTreeNode(70);
		ManyTreeNode node23 = new ManyTreeNode(15);
		ManyTreeNode node24 = new ManyTreeNode(102);
		ManyTreeNode node25 = new ManyTreeNode(83);
		ManyTreeNode node26 = new ManyTreeNode(9);

		tree.getRoot().getChildList().get(0).getChildList().add(0, node21);
		tree.getRoot().getChildList().get(0).getChildList().add(1, node22);
		tree.getRoot().getChildList().get(0).getChildList().add(2, node23);

		tree.getRoot().getChildList().get(1).getChildList().add(0, node24);
		tree.getRoot().getChildList().get(1).getChildList().add(1, node25);

		tree.getRoot().getChildList().get(2).getChildList().add(0, node26);

		// 第三层的节点
		ManyTreeNode node31 = new ManyTreeNode(15);
		ManyTreeNode node32 = new ManyTreeNode(20);
		ManyTreeNode node33 = new ManyTreeNode(100);
		ManyTreeNode node44 = new ManyTreeNode(600);

		tree.getRoot().getChildList().get(0).getChildList().get(0).getChildList().add(0, node31);
		tree.getRoot().getChildList().get(0).getChildList().get(0).getChildList().add(1, node32);
		tree.getRoot().getChildList().get(0).getChildList().get(0).getChildList().add(2, node33);

		tree.getRoot().getChildList().get(0).getChildList().get(2).getChildList().add(0, node44);

		return tree;

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ManyNodeTree testTree = ManyNodeTree.createTree();
		String result = testTree.iteratorTree(testTree.getRoot());
		System.out.println(result);
		
		List<List<Integer>> result1 = testTree.iteratorTree2(testTree.getRoot());
		for(List<Integer> a:result1){
			System.out.println(a.toString());
		}
	}
}
