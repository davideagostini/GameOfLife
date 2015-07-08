/** Game of Life
 * 
 * -- RULE --
 * cells near < 2   -> die
 * cells near > 3   -> die
 * cells near 2||3  -> alive
 * cells near =3    -> born
 *
 */

public class GameOfLife {

	public static void main(String[] args) {
		Integer matrix[][] = {
				{0, 1, 1, 0},
				{1, 1, 1, 0},
				{0, 1, 0, 0},
				{0, 1, 0, 0}
			};
		
		System.out.println("FIRST GENERATION");
		printMatrix(matrix);
		nextGeneration(matrix);
		System.out.println("SECOND GENERATION");
		printMatrix(matrix);
	}

	/**
	 * print the multidimensional array
	 * 
	 * @param the multidimensional matrix
	 */
	public static void printMatrix(Integer matrix[][]) {
		for(int i=0; i<matrix.length; i++) {
			for(int j=0; j<matrix[i].length; j++)
				System.out.print(matrix[i][j]+"\t");
			System.out.println();
		}
	}

	/**
	 * count the neighbor
	 * 
	 * @param the multidimensional matrix
	 * @param int x the matrix rows
	 * @param int y the matrix columns
	 * @return the number of neighbor
	 */
	public static int countNeighbor(Integer matrix[][], int x, int y) {
		int counter = 0;
		int innerX, innerY = 0;
		for(innerX = (x-1); innerX <= (x+1); innerX++) {
			for(innerY = (y-1); innerY <= (y+1); innerY++) {
				try {
					if(matrix[innerX][innerY] != null && matrix[innerX][innerY] == 1) {
						if(innerX != x || innerY != y) 
							counter++;
					}
				}		
				catch(ArrayIndexOutOfBoundsException e) {
					continue;
				}
			}
		}
		return counter;
	}

	/**
	 * the next generation check if:
	 * 
	 * Any live cell with fewer than two live neighbours dies, as if caused by under-population.
	 * Any live cell with two or three live neighbours lives on to the next generation.
	 * Any live cell with more than three live neighbours dies, as if by overcrowding.
	 * Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.
	 * 
	 * @param the multidimensional matrix
	 * 
	 */
	public static void nextGeneration(Integer matrix[][]) {
		for(int i = 0; i<matrix.length; i++) {
			for(int j=0; j<matrix[i].length; j++) {
				if(matrix[i][j] == 1) {
					if(countNeighbor(matrix, i, j) < 2 || countNeighbor(matrix, i, j) > 3)
						matrix[i][j] = 0;
					else if(countNeighbor(matrix, i, j) == 2 || countNeighbor(matrix, i, j) == 3)
						matrix[i][j] = 1;
				}
				else {
					if(countNeighbor(matrix, i, j) == 3)
						matrix[i][j] = 1;
				}
			}
		}
	}
}
