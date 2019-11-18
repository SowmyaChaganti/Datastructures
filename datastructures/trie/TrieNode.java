package datastructures.trie;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
	
	//constructors
	public TrieNode() {}
	
	public TrieNode(char c) {
		this.c = c;
	}
	
	char c;
	boolean isLeaf;
	Map<TrieNode, TrieNode> children = new HashMap<>();
	Map<Character, TrieNode> subChildren = new HashMap<>();
	
}
