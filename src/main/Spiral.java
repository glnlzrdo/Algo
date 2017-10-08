package main;

public class Spiral {

	private static void printSpiral(int n) {
		String[][] board = new String[n][n];
		int currCol = 0;
		int currRow = 0;
		int val = 0;
		int availCol = n;
		int availRow = n - 1;

		while (val < n * n) {

			// right
			for (; currCol < availCol; currCol++) {
				if (val < 9)
					board[currRow][currCol] = " 0" + ++val + " ";
				else
					board[currRow][currCol] = " " + ++val + " ";
			}
			currCol--;

			// down
			for (; currRow < availRow; currRow++) {
				if (val < 9)
					board[currRow + 1][currCol] = " 0" + ++val + " ";
				else
					board[currRow + 1][currCol] = " " + ++val + " ";
			}

			currCol--;

			// left
			for (; currCol >= n - availCol; currCol--)
				if (val < 9)
					board[currRow][currCol] = " 0" + ++val + " ";
				else
					board[currRow][currCol] = " " + ++val + " ";

			currCol++;
			currRow--;

			// up
			for (; currRow >= n - availRow; currRow--)
				if (val < 9)
					board[currRow][currCol] = " 0" + ++val + " ";
				else
					board[currRow][currCol] = " " + ++val + " ";
			currRow++;
			currCol++;
			availCol--;
			availRow--;
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (j == n - 1)
					System.out.println("*" + board[i][j] + "*");
				else
					System.out.print("*" + (board[i][j].length() > 4 ? board[i][j].substring(1) : board[i][j]));
			}
		}
	}

	public static void main(String[] args) {
		printSpiral(5);
	}

}
