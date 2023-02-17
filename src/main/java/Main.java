import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// Get user input
		Scanner text = new Scanner(System.in);
		System.out.println("How much Weight? ");
		
		int weight = Integer.parseInt(text.nextLine());
		text.close();
		
		GreedySolver greed = new GreedySolver();
		greed.readInput();
		ArrayList<GreedySolver.Item> list = greed.createItemList();
		greed.highValHeuristic(weight);
	}
}
