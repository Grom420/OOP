package Walls3d;

import java.util.PriorityQueue;

/**
 * TODO Class Description
 *
 * @author Дмитрий Колоярский
 * @since 15.04.2024
 */
public class Walls3d {

	private static final int[][] MAP_OF_WATERS = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

	/**
	 * Function to find the amount of water
	 *  the matrix is capable to hold
	 */
	private static int trapRainWater(int[][] heightMap) {
		int M = heightMap.length;
		int N = heightMap[0].length;

		// Stores if a cell of the matrix
		// is visited or not
		boolean[][] visited = new boolean[M][N];


		// Initialize a priority queue
		PriorityQueue<Node> pq = new PriorityQueue<>(new Compare());

		// Traverse over the matrix
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {

				// If element is not on
				// the boundary
				if (!(i == 0 || j == 0 || i == M - 1 || j == N - 1))
					continue;

				// Mark the current cell
				// as visited
				visited[i][j] = true;

				// Node for priority queue
				Node t = new Node();
				t.x = i;
				t.y = j;
				t.height = heightMap[i][j];

				// Pushe all the adjacent
				// node in the pq
				pq.offer(t);
			}
		}

		// Stores the total volume
		int ans = 0;


		// Stores the maximum height
		int max_height = Integer.MIN_VALUE;

		// Iterate while pq is not empty
		while (!pq.isEmpty()) {

			// Store the top node of pq
			Node front = pq.poll();

			// Update the max_height
			max_height = Math.max(max_height, front.height);

			// Stores the position of the
			// current cell
			int curr_x = front.x;
			int curr_y = front.y;

			for (int i = 0; i < 4; i++) {

				int new_x = curr_x + MAP_OF_WATERS[i][0];
				int new_y = curr_y + MAP_OF_WATERS[i][1];

				// If adjacent cells are out
				// of bound or already visited
				if (new_x < 0 || new_y < 0 || new_x >= M || new_y >= N || visited[new_x][new_y]) {
					continue;
				}

				// Stores the height of the
				// adjacent cell
				int height = heightMap[new_x][new_y];

				// If height of current cell
				// is smaller than max_height
				if (height < max_height) {


					// Increment the ans by
					// (max_height-height)
					ans = ans + max_height - height;
				}

				// Define a new node
				Node temp = new Node();
				temp.x = new_x;
				temp.y = new_y;
				temp.height = height;


				// Push the current node
				// in the pq
				pq.offer(temp);

				// Mark the current cell
				// as visited
				visited[new_x][new_y] = true;
			}
		}

		return ans;
	}

	public static void main(String[] args) {
		int[][] arr = { { 1, 4, 3, 1, 3, 2 }, { 3, 2, 1, 3, 2, 4 }, { 2, 3, 3, 2, 3, 1 } };
		System.out.println(trapRainWater(arr));
	}
}
