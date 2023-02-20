import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class GreedySolver {

	// Global Variables
	public ArrayList<String> Item_name = new ArrayList<String>();
	public ArrayList<Integer> Item_weight = new ArrayList<Integer>();
	public ArrayList<Integer> Item_value = new ArrayList<Integer>();
	ArrayList<Item> itemList = new ArrayList<Item>();
	int length = 0;

	// Get the values from the input file
	public void readInput() {
		// Make sure arrays are clear for new reading
		Item_name.clear();
		Item_weight.clear();
		Item_value.clear();
		itemList.clear();
		length = 0;

		// Create File Variable and read
		// Replace MainClass with the name of your main class
		String jarDir = System.getProperty("user.dir");
		jarDir = jarDir + File.separator + "knapsack_input.txt";
		File myFile = new File(jarDir);

		try {
			Scanner myReader = new Scanner(myFile);
			while (myReader.hasNextLine()) {
				Item_name.add(myReader.nextLine());
				Item_weight.add(Integer.parseInt(myReader.nextLine()));
				Item_value.add(Integer.parseInt(myReader.nextLine()));
				length++;
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("An error has occurred reading the input file");
			e.printStackTrace();
		}
	}
	
	public ArrayList<Item> createItemList(){
		if(Item_name.isEmpty()) {
			return null;
		}
		
		for(int i = 0; i < length; i++) {
			itemList.add(new Item(Item_name.get(i), Item_weight.get(i), Item_value.get(i)));
		}
		
		return itemList;
	}
	
	public void highValHeuristic(int weight) {
		int finalV = 0;
		int finalW = 0;
		
		// Sort the list
		itemList.sort((item1, item2) -> Integer.valueOf(item2.value).compareTo(Integer.valueOf(item1.value)));
		
		for(int i = 0; i < itemList.size(); i++) {
			if(itemList.get(i).weight <= weight) {
				finalW = finalW + itemList.get(i).weight;
				finalV = finalV + itemList.get(i).value;
				weight = weight - itemList.get(i).weight;
			}
		}
		
		System.out.println("High value heuristic:");
		System.out.println("W: " + finalW);
		System.out.println("V: " + finalV);
	}
	
	public void ratioHeuristic(int weight) {
		int finalV = 0;
		int finalW = 0;
		
		itemList.sort((item1, item2) -> {
			Double i1 = (double)item1.value/item1.weight;
			Double i2 = (double)item2.value/item2.weight;
			
			return i2.compareTo(i1);
		});
		
		for(int i = 0; i < itemList.size(); i++) {
			if(itemList.get(i).weight <= weight) {
				finalW = finalW + itemList.get(i).weight;
				finalV = finalV + itemList.get(i).value;
				weight = weight - itemList.get(i).weight;
			}
		}
		
		System.out.println("Value to weight heuristic");
		System.out.println("W: " + finalW);
		System.out.println("V: " + finalV);
		
	}
	
	class Item {
		// Variables
		private String name;
		private int weight;
		private int value;

		// Constructor for the Node class
		public Item(String name, int weight, int value) {
			this.name = name;
			this.weight = weight;
			this.value = value;
		}

		String getName() {
			return name;
		}

		int getWeight() {
			return weight;
		}

		int getValue() {
			return value;
		}
	}
}
