
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Market {

	public static void main(String[] args) {
		boolean cont = true;

		Map<String, Double> food = new HashMap<>();
		ArrayList<String> order = new ArrayList<String>();
		ArrayList<Double> pricing = new ArrayList<Double>();

		food.put("raspberry", 1.99);
		food.put("apples", 0.99);
		food.put("peanut", 4.99);
		food.put("food", 2.99);
		food.put("parmesan", 7.99);
		food.put("pesto", 1.49);
		food.put("steak", 5.99);
		food.put("guacomole", 8.99);

		System.out.println("Welcome to Guenther's Market!\n");
		System.out.println("Item            Price");
		System.out.println("======================");

		for (String key : food.keySet()) {

			String str1 = "";
			str1 += String.format("%-16s", key);
			str1 += String.format("%.2f", food.get(key));
			System.out.println(str1);
		}
		System.out.println("\n");

		Scanner scan = new Scanner(System.in);

		do {
			System.out.println("Enter an item that you would like.");
			String response = scan.nextLine();

			if (food.containsKey(response)) {
				order.add(response);
				pricing.add(food.get(response));
				System.out.println("Adding " + response + " to the cart at $" + food.get(response));
				System.out.println("Would you like to order anything else (y/n)?");

				String yn = scan.nextLine();

				if (yn.equalsIgnoreCase("n")) {
					cont = false;
					System.out.println("Thanks for your order! You ordered: ");

					for (int i = 0; i < order.size(); i++) {
						String str2 = "";
						str2 += String.format("%-10s", order.get(i));
						str2 += String.format("%.2f", pricing.get(i));
						System.out.println(str2);
					}
					String avg = String.format("%.2f", getAverage(pricing));
					System.out.println("The average price was: " + avg);
				}
			} else {
				System.out.println("Sorry, we don't have those. Please try again.");
			}
		} while (cont);

		System.out.println("The highest cost item is at index " + (highestCost(pricing)));
		System.out.println("The lowest cost item is at index " + (lowestCost(pricing)));

	}

	public static double getAverage(ArrayList<Double> pricing) {
		double sum = 0;
		for (double num : pricing) {
			sum += num;
		}
		return (sum / pricing.size());
	}

	public static int highestCost(ArrayList<Double> pricing) {
		Double max = Collections.max(pricing);
		int highestIndex = pricing.indexOf(max);
		return highestIndex;
	}

	public static int lowestCost(ArrayList<Double> pricing) {
		Double min = Collections.min(pricing);
		int lowestIndex = pricing.indexOf(min);
		return lowestIndex;
	}

}
