package Walls3d;

import java.util.Comparator;

/**
 * Comparator function to implement
 * the min heap using priority queue
 *
 * @author Дмитрий Колоярский
 * @since 14.04.2024
 */
public class Compare implements Comparator<Node> {
	@Override
	public int compare(Node a, Node b) {
		return a.height - b.height;
	}
}
