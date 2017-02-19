package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * Represents a 4x4 slider object which randomized tiles.
 * Each instance of Slider will be randomized.
 * 
 * @author Alvin Nguyen
 * @author
 *
 */
public class Slider {
	
	/** The number of rows in the slider. **/
	private static final int NUM_ROWS = 6;
	
	/** The number of columns in the slider. **/
	private static final int NUM_COLUMNS = 6;
	
	/** The 2d array of the slider - rows, columns. **/
	private final Tile[][] mySlider = new Tile[NUM_ROWS][NUM_COLUMNS];
	
	/** A counter for each move performed. */
	private long myCounter = 0;
	
	
	
	/** 
	 * The slider object; takes tiles and assigns them a number inside
	 * the List.
	 */
	public Slider() {
		// create 2D array of 0's
		for (int i = 0; i < NUM_ROWS; i++) {
			for (int j = 0; j < NUM_COLUMNS; j++) {
				mySlider [i][j] = new Tile(0);
			}
		}
		
		int num = 1;
		
		// fill 2D array with numbers
		for (int row = 1; row < NUM_ROWS-1; row++) {
			for (int col = 1; col < NUM_COLUMNS-1; col++) {
				mySlider [row][col] = new Tile(num);
				num++;
			}
		}
		System.out.print(mySlider);
	}
	
	/** Returns the move counter */
	public long getMoves() {
		return myCounter;
	}
	
	/**
	 * Messes the order of the 2d array to 'randomise' our tiles.
	 */
	
	
	/**
	 * returns the Slider.
	 * @return the SLider.
	 */
	public Tile[][] getSlider() {
		return mySlider;
	}

	
	public void move(final Tile theTile) {
		
		Tile blankTile = new Tile(16);
		Tile realBlankTile;
		Tile clickedTile;
		
		final int row = theTile.getRow();
		final int col = theTile.getColumn();
		
		if (mySlider[row][col + 1].equals(blankTile)) {
			
			realBlankTile = mySlider[row][col + 1];
			
			clickedTile = theTile;
			
			mySlider[row][col] = realBlankTile;
			mySlider[row][col + 1] = clickedTile;
			myCounter++;
<<<<<<< HEAD
=======
			
>>>>>>> branch 'master' of https://github.com/alveeno/sliderpuzzle.git
		} else if (mySlider[row][col - 1].equals(blankTile)) {
			realBlankTile = mySlider[row][col - 1];
			
			clickedTile = theTile;
			
			mySlider[row][col] = realBlankTile;
			mySlider[row][col - 1] = clickedTile;
			myCounter++;
<<<<<<< HEAD
=======
			
>>>>>>> branch 'master' of https://github.com/alveeno/sliderpuzzle.git
		} else if (mySlider[row + 1][col].equals(blankTile)) {
			realBlankTile = mySlider[row + 1][col];
			
			clickedTile = theTile;
			
			mySlider[row][col] = realBlankTile;
			mySlider[row + 1][col] = clickedTile;
			myCounter++;
<<<<<<< HEAD
=======
			
>>>>>>> branch 'master' of https://github.com/alveeno/sliderpuzzle.git
		} else if (mySlider[row + 1][col].equals(blankTile)) {
			realBlankTile = mySlider[row + 1][col];
			
			clickedTile = theTile;
			
			mySlider[row][col] = realBlankTile;
			mySlider[row + 1][col] = clickedTile;
			myCounter++;
		} else if (mySlider[row - 1][col].equals(blankTile)) {
			realBlankTile = mySlider[row - 1][col];
			
			clickedTile = theTile;
			
			mySlider[row][col] = realBlankTile;
			mySlider[row - 1][col] = clickedTile;
			myCounter++;
		}
	}
	
	/**
	 * counts the number of inversions and calculates their sum.
	 * @return the sum of inversions.
	 */
	public int sumInversions() {
		
		int inversionCount = 0;
		
		// convert 2D array to regular array.
		int numOfTiles = 15;
		int[] arr = new int [numOfTiles];
		int index = 0;
		for (int row = 1; row < 5; row++) {
			for (int col = 1; col < 5; col++) {
				arr[index] = mySlider[row][col].getNumber();
			}
		}
		
		for (int i = 0; i < numOfTiles; i++) {
			for (int j = i + 1; j < numOfTiles + 1; j++) {
				int current = arr[i];
				if (arr[j] < current) {
					inversionCount++;
				}
				
			}
		}
		return inversionCount;
	}
	
}
