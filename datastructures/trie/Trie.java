package datastructures.trie;

import java.util.ArrayList;

public class Trie {
	TrieNode root;
	int matrixSize = 5;

	// constructors
	public Trie() {

	}

	public Trie(int matrixSize, char[][] boggleBoard) {
		root = new TrieNode();
	}

	public void createTrie(int matrixSize, char[][] boggleBoard, String direction) {
		//boolean done = false;
		TrieNode pCrawl = root;
		
		for(int row = 0; row<boggleBoard.length; row++) {
			for(int column = 0; column<boggleBoard[row].length; column++) {
				char element = boggleBoard[row][column];
				int neighbourCount;
				TrieNode node;
				
				if(row==0 && column==0) {
					node = pCrawl.children.get(element);
				}
				else {
					node = pCrawl.children.get(1);
					System.out.println(node.toString());
				}

				//calculate neighbours
				if( (row == 0 && column ==0) || 
						(row == matrixSize && column == matrixSize) || 
						(row == 0 && column == matrixSize) || 
						(row == matrixSize && column == 0) ){
					neighbourCount = 3;
				}
				else if(row == 0 && (column>0 && column < matrixSize-1)  ||
						((row > 0 && row < matrixSize-1) && column == 0) ||
						(row == matrixSize && (column>0 && column < matrixSize-1) )||
						((row > 0 && row < matrixSize-1) && column == matrixSize)
						) {
					
					neighbourCount = 5;
				}
				else {
					neighbourCount = 8;
				}
				
				//get neighbour elements
				ArrayList neighbours = new ArrayList<>();
				char e = '\0';
				char se = '\0';
				char s = '\0';
				char sw = '\0';
				char w = '\0';
				char nw = '\0';
				try {
					 e = (neighbourCount != 8) ? boggleBoard[row][column+1] : null;
					 se = (neighbourCount != 8) ? boggleBoard[row+1][column+1] : null;
					 s = (neighbourCount != 8) ?  boggleBoard[row+1][column] : null;
					 sw = (neighbourCount != 8) ?  boggleBoard[row+1][column-1] : null;
					 w = (neighbourCount != 8) ?  boggleBoard[row][column-1] : null;
					 nw = (neighbourCount != 8) ?  boggleBoard[row-1][column-1] : null;
				}
				catch(Exception ex) {}
				finally {
					neighbours.add(e);
					neighbours.add(se);
					neighbours.add(s);
					neighbours.add(sw);
					neighbours.add(w);
					neighbours.add(nw);
				}
				
				//add children to root node
				TrieNode t = new TrieNode();
					//if node has no known neighbors return true and mark visited 
					if(row>matrixSize || column>matrixSize) {
						//done = true;
						//mark root node as visited
					}
					else {
						node = pCrawl.children.get(element);
						for(int d=0; d<neighbours.size(); d++) {
							char temp = (Character) neighbours.get(d);
							if(node == null) {
								node = new TrieNode();
							}
							t = pCrawl.children.put(node.subChildren.put(temp, node), node);
							//node.children.put(temp, node);
						}
						
						//create a node of the element if null
						if(node == null) {
							node = new TrieNode();
							node = pCrawl.children.put(t, node);
						}
						node = pCrawl.children.put(t, node);
					}
					
					

				
				
			}
			
		}
		
	}

}
