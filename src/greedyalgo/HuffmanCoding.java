package greedyalgo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class HuffmanCoding {

	public static void nodeTraversal(String s, HuffmanNode root) {
		if (root == null)
			return;
		if (root.left == null && root.right == null) {
			System.out.println(root.ch + " " + s);
			return;
		}

		if (root.left != null)
			nodeTraversal(s + "0", root.left);

		if (root.right != null)
			nodeTraversal(s + "1", root.right);

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		sc.close();

		int len = s.length();
		Map<String, Integer> hmap = new HashMap<>();
		String ch;
		int value;
		for (int i = 0; i < len; i++) {
			ch = "" + s.charAt(i);
			if (hmap.containsKey(ch)) {
				value = hmap.get(ch);
				hmap.replace(ch, value + 1);
			} else
				hmap.put(ch, 1);
		}

		Set<HuffmanNode> nodeSet = new TreeSet<>();
		Iterator<Map.Entry<String, Integer>> it = hmap.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Integer> item = it.next();
			nodeSet.add(new HuffmanNode(item.getKey(), item.getValue()));
		}

		Iterator<HuffmanNode> jt = nodeSet.iterator();
		while (jt.hasNext()) {
			System.out.println(jt.next());
		}

		HuffmanNode a, b, newNode = null;
		while (nodeSet.size() != 1) {
			jt = nodeSet.iterator();
			a = jt.next();
			b = jt.next();
			nodeSet.remove(a);
			nodeSet.remove(b);
			newNode = new HuffmanNode(a.ch + b.ch, a.count + b.count);
			newNode.left = a;
			newNode.right = b;
			nodeSet.add(newNode);
		}
		nodeTraversal("", newNode);
	}
}
