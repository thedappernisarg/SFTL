
import java.awt.Point;
import java.util.ArrayList;
import java.util.Scanner;
public class Playfair {

	// the grid that will be build when a new key is entered
	private char[][] grid;

	/**
	 * Constructor that receives the key as parameter
	 */
	public Playfair(String key) {
		// build the grid only once
		grid = new char[5][5];
		// and add our key
		setKey(key);
	}

    Playfair() {
        throw new UnsupportedOperationException("Not yet implemented");
    }

	/**
	 * To fill the grid the first time and when the key changes
	 */
	public void setKey(String key) {

		if(key == null)
			key = "A";
		char[] single = new char[26];
		int nbIn = 0;
		boolean[] done = new boolean[26];

		char[] keyDigit = key.toUpperCase().toCharArray();
		for(char c : keyDigit) {
			if(c < 'A' || c > 'Z')
				continue;
			char actual = c;
			if(actual == 'J')
				actual = 'I';
			int index = actual - 'A';
			if(done[index])
				continue;
			done[index] = true;
			single[nbIn++] = actual;
		}
		if(nbIn == 0) {
			single[nbIn++] = 'A';
			done[0] = true;
		}
		for(char c = 'A'; c <= 'Z'; c++) {
			if(c == 'J')
				continue;
			if(done[c - 'A'])
				continue;
		
			single[nbIn++] = c;
		}
		nbIn = 0;
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				grid[i][j] = single[nbIn++];
			}
		}
	}

	/**
	 * The encode the text received as parameter
	 */
	public String encode(String clear) {
		if(clear == null)
			return "";
		char[] digit = clear.toUpperCase().toCharArray();
		ArrayList<LetterPair> aList = new ArrayList<LetterPair>();
		int index = 0;
		int i = 0;
		LetterPair lp = null;
		while(i < digit.length) {
			if(digit[i] == 'J')
				digit[i] = 'I';
			if(digit[i] < 'A' || digit[i] > 'Z') {
				i++;
				continue;
			}
			if(index == 0) {
				lp = new LetterPair(digit[i++], true);
				aList.add(lp);							// add to ArrayList
				index = 1;								// looking for second letter
				continue;
			}
			if(lp.left == digit[i]) {
				lp.setRight('X');
			}
			else {
				lp.setRight(digit[i++]);
			}
			index = 0;
		}
		if(index == 1)
			lp.setRight('X');

		return aListToString(aList);
	}

	public String decode(String coded) {
		// empty String
		if(coded == null) {
			return "";
		}
		// the message shoul have an even number of characters
		char[] digit = coded.toUpperCase().toCharArray();
		// we copy the valid characters into a StringBuilder
		StringBuilder sb = new StringBuilder(digit.length);
		for(int i = 0; i < digit.length; i++) {
			// if not valid character just ignore it
			if(digit[i] < 'A' || digit[i] > 'Z')
				continue;
			// switch J for I
			if(digit[i] == 'J')
				digit[i] = 'I';
			// append the valid character
			sb.append(digit[i]);
		}
		// if not an even number of characters exit
		if(sb.length() % 2 != 0)
			return "--- Invalid coded message ---";
		
		// build an arrayList to hold our letter pairs
		ArrayList<LetterPair> aList = new ArrayList<LetterPair>();
		// make an array of the valid char[] out of the StringBuilder
		digit = sb.toString().toCharArray();
		// populate it
		for(int i = 0; i < digit.length; i += 2) {
			// create a decoding pair
			LetterPair lp = new LetterPair(digit[i], false);
			lp.setRight(digit[i+1]);
			aList.add(lp);
		}
		// return the String representation of the ArrayList
		return aListToString(aList).toLowerCase();
	}
	
	/** 
	 * Returns as a String the content of an ArraList of LetterPair
	 */
	private String aListToString(ArrayList<LetterPair> aList) {
		// if the ArrayList is empty just return "" as coded message
		if(aList.size() == 0)
			return "";
		// StringBuilder to cumulate the elements
		StringBuilder sb = new StringBuilder();
		// put the first element
		sb.append(aList.get(0).getPair());
		// put the other ones preceeded by "-"
		for(int i = 1; i < aList.size(); i++) {
			sb.append('-');
			sb.append(aList.get(i).getPair());
		}
		return sb.toString();
		
	}
	/**
	 * For debug purpose display the Grid
	 */
	public void dumpGrid() {
		System.out.println("--- GRID ---");
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				System.out.print(" " + grid[i][j]);
			}
			System.out.println();
		}
	}
	
	/**
	 * For the GUI returns the Grid
	 */
     public char[][] getGrid() {
    	 return grid;
     }
	/**
	 * To unit test our class
	 */
	public static void main(String[] args) {
		Playfair pf = new Playfair("123456");
		System.out.println("Grid that should start with \"A\"");
		pf.dumpGrid();
		// test with our example
		pf = new Playfair("DreamInCode");
		System.out.print("Grid that should start with \"DreamInCode\"");
		System.out.println("  (Note: \"D\" and \"E\" won't be repeated)");	
		pf.dumpGrid();
		
		// see how will be encrypted the "secret message two" message
		String clear = "secret message two";
		System.out.println("Original: " + clear);
		String coded = pf.encode(clear);
		System.out.println("   Coded: " + coded);
		// and how it will be decoded
		System.out.println(" Decoded: " + pf.decode(coded));
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the key: ");
		// read the key and create a Playfair object with it
		String key = scan.nextLine();
		Playfair userPlayfair = new Playfair(key);
		// input message from user
		System.out.print("Enter message: ");
		String message = scan.nextLine();
		System.out.println("          Original: " + message);
		// code it and decode it back
		coded = userPlayfair.encode(message);
		System.out.println("Encoded message is: " + coded);
		System.out.println("translated back ? : " + userPlayfair.decode(coded));		


	}

    void setvisible(boolean b) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
	
	/**
	 * A class to handle the pairs of letters
	 */
	private class LetterPair {
		// the first letter 
		private char left;
		// the coordinates of the letter in the Grid
		private Point pLeft, pRight;
		// the coded 2 letters
		private char[] digit;
		// if coding or decoding
		boolean coding;
		
		/**
		 * Constructor built with the first letter
		 */
		private LetterPair(char left, boolean coding) {
			// store the left letter
			this.left = left;
			// store if we are coding or decoding
			this.coding = coding;
			// and find its coordinates in the Grid
			pLeft = findPos(left);
			// prepare the array to hold the 2 coded values
			digit = new char[2];
		}
		/**
		 * To set the second letter
		 */
		private void setRight(char right) {
			// and find its position in the Grid
			pRight = findPos(right);
			
			// now we can determine the type and act accordingly
			if(pLeft.x == pRight.x)				// if in the same row
				sameRow();
			else if(pLeft.y == pRight.y)
				sameColumn();				// else if in the same column
			else
				diffRowCol();					// so neither of them
			
			// store the coded value
			digit[0] = grid[pLeft.x][pLeft.y];
			digit[1] = grid[pRight.x][pRight.y];
		}
		private void sameRow() {
			if(coding) {
				// to the right
				pLeft.y++;
				pRight.y++;
				// wrap around at column 5
				pLeft.y %= 5;
				pRight.y %= 5;
			}
			else {
				// to the left
				pLeft.y--;
				pRight.y--;
				// wrap around at column 0
				if(pLeft.y < 0)
					pLeft.y = 4;
				if(pRight.y < 0)
					pRight.y = 4;
			}
				
		}
		private void sameColumn() {
			if(coding) {
				// under it
				pLeft.x++;
				pRight.x++;
				// wrap around a row 5
				pLeft.x %= 5;
				pRight.x %= 5;
			}
			else {
				// over it
				pLeft.x--;
				pRight.x--;
				// wrap around at row 0
				if(pLeft.x < 0)
					pLeft.x = 4;
				if(pRight.x < 0)
					pRight.x = 4;
			}
		}
		private void diffRowCol() {
			// the column of both of them (the one of the other letter)
			int leftColumn = pRight.y;
			int rightColumn = pLeft.y;
			// replace these value in our coordinates
			pLeft.y = leftColumn;
			pRight.y = rightColumn;
		}

		private Point findPos(char c) {
			// scan the whole grid for the letter
			for(int x = 0; x < 5; x++) {
				for(int y = 0; y < 5; y++) {
					// if found
					if(grid[x][y] == c) {
						return new Point(x, y);
					}
				}
			}
			throw new IllegalStateException("Letter " + c + " not found in the Grid");
		}
		
		private String getPair() {
			return new String(digit);
		}
	}
}

