package datastructures.trie;

import java.util.Random;

public class BoggleBoard {

	public static void main(String[] args) {
		int matrixSize = 5;
		char[][] boggleBoard = new char[matrixSize][matrixSize];
		generateBoggleBoard(matrixSize, boggleBoard);
		displayBoggleBoard(boggleBoard);
		Trie trie = new Trie(matrixSize, boggleBoard);
		trie.createTrie(matrixSize, boggleBoard, null);
	}

		//Generating a Boggle Board randomly
		public static void generateBoggleBoard(int matrixSize, char[][] boggleBoard) {
			Random r = new Random();
			
			for(int i=0; i< matrixSize; i++) {
				for(int j=0; j<matrixSize; j++) {
					boggleBoard[i][j] = (char) (r.nextInt(26)+'a');
					//System.out.print(boggleBoard[i][j]+" ");
				}
				//System.out.println();
			}
		}
		
		//display the generated boggle board	
		private static void displayBoggleBoard(char[][] boggleBoard) {
				for(int row = 0; row<boggleBoard.length; row++) {
					for(int column = 0; column<boggleBoard[row].length; column++) {
						System.out.print(boggleBoard[row][column]+" ");
					}
					System.out.println();
				}
			
			}
		
		

}
