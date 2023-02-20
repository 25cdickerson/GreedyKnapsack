import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// Get user input
		Scanner text = new Scanner(System.in);
		System.out.println("How much Weight? ");
		
		int weight = Integer.parseInt(text.nextLine());
		text.close();
		
		// Create a new GreedySolver and use the High Value Heuristic
		GreedySolver greed = new GreedySolver();
		greed.readInput();
		greed.createItemList();
		greed.highValHeuristic(weight);
		
		GreedySolver greed0 = new GreedySolver();
		greed0.readInput();
		greed0.createItemList();
		greed0.ratioHeuristic(weight);
	}
}
