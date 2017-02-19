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
 * @author David Glines
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
	 * returns the Slider.
	 * @return the SLider.
	 */
	public Tile[][] getSlider() {
		return mySlider;
	}

	/**
	 * Move the tile.
	 * 
	 * blankTile is an comparison tile for the real blank tile.
	 * the realBlankTile is the real blank tile.
	 * the clickedTile is the tile we clicked.
	 * 
	 * Check to see if the neighboring tiles are legal and equal to 16.
	 * 
	 * @param theTile the tile which we are trying to move.
	 */
	public void move(final Tile theTile) {
		myCounter++;
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
			
		} else if (mySlider[row][col - 1].equals(blankTile)) {
			realBlankTile = mySlider[row][col - 1];
			
			clickedTile = theTile;
			
			mySlider[row][col] = realBlankTile;
			mySlider[row][col - 1] = clickedTile;
			
		} else if (mySlider[row + 1][col].equals(blankTile)) {
			realBlankTile = mySlider[row + 1][col];
			
			clickedTile = theTile;
			
			mySlider[row][col] = realBlankTile;
			mySlider[row + 1][col] = clickedTile;
			
		} else if (mySlider[row + 1][col].equals(blankTile)) {
			realBlankTile = mySlider[row + 1][col];
			
			clickedTile = theTile;
			
			mySlider[row][col] = realBlankTile;
			mySlider[row + 1][col] = clickedTile;
			
		} else if (mySlider[row - 1][col].equals(blankTile)) {
			realBlankTile = mySlider[row - 1][col];
			
			clickedTile = theTile;
			
			mySlider[row][col] = realBlankTile;
			mySlider[row - 1][col] = clickedTile;
		}
	}
}
