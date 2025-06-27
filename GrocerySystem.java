public class GrocerySystem {

	public interface InventoryManager {
		void addItem(GroceryItem item);

		GroceryItem[] getAllItems();
	}

	@FunctionalInterface
	public interface ItemFilter {
		GroceryItem[] filterItems(GroceryItem[] items);
	}

	@FunctionalInterface
	public interface ItemSorter {
		GroceryItem[] sortItems(GroceryItem[] items);
	}

	@FunctionalInterface
	public interface ValueCalculator {
		double calculateTotalValue(GroceryItem[] items);
	}

	public static void main(String[] args) {
		Inventory inventory = new Inventory();
		inventory.addItem(new GroceryItem("Apple", 100, 10, "Fruit"));
		inventory.addItem(new GroceryItem("Milk", 60, 5, "Dairy"));
		inventory.addItem(new GroceryItem("Bread", 30, 9, "Bakery"));
		inventory.addItem(new GroceryItem("Banana", 40, 12, "Fruit"));

		GroceryItem[] allitems = inventory.getAllItems();

		// Lambada ItemFilter by category
		ItemFilter fruitFilter = (items) -> {
			int count = 0;
			for (GroceryItem item : items) {
				if (item != null && item.getCategory().equalsIgnoreCase("Fruit")) {
					count++;
				} // if end
			} // for end
			GroceryItem[] result = new GroceryItem[count];
			int index = 0;
			for (GroceryItem item : items) {
				if (item != null && item.getCategory().equalsIgnoreCase("Fruit")) {
					result[index++] = item;
				} // if end
			} // for end
			return result;
		};
		System.out.println("Filter Items by Fruit ...");
		for (GroceryItem item : fruitFilter.filterItems(allitems)) {
			System.out.println("Filter Fruit Items : " + item);
		}

		// Lambda ItemSorter
		ItemSorter priceSort = (items) -> {
			GroceryItem[] sorted = new GroceryItem[items.length];
			for (int i = 0; i < items.length; i++) {
				sorted[i] = items[i];
			}

			for (int i = 0; i < sorted.length - 1; i++) {
				for (int j = i + 1; j < sorted.length; j++) {
					if (sorted[i].getPrice() > sorted[j].getPrice()) {
						GroceryItem temp = sorted[i];
						sorted[i] = sorted[j];
						sorted[j] = temp;
					}
				} // inner for

			} // outer for

			return sorted;
		};

		System.out.println("Sorted Items ....");
		for (GroceryItem item : priceSort.sortItems(allitems)) {
			System.out.println("Sorted " + item);
		}

		// Lambda ValueCalculator
		ValueCalculator totalValue = (items) -> {
			double total = 0;
			for (GroceryItem item : items) {
				if (item != null) {
					total += item.getPrice() * item.getQuantity();
				} // if
			} // for
			return total;
		};
		System.out.println("Total Inventory Value Rs. " + totalValue.calculateTotalValue(allitems));
	}// main end
}// GrocerySystem

class GroceryItem {
	private String name;
	private double price;
	private int quantity;
	private String category;

	public GroceryItem(String name, double price, int quantity, String category) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}

	public String getCategory() {
		return category;
	}

	@Override
	public String toString() {
		return "GroceryItem [name=" + name + ", price=" + price + ", quantity=" + quantity + ", category=" + category
				+ "]";
	}
}// GroceryItem

class Inventory implements GrocerySystem.InventoryManager {
	private GroceryItem[] items = new GroceryItem[100];
	private int count = 0;

	@Override
	public void addItem(GroceryItem item) {
		if (count < items.length) {
			items[count++] = item;
		}
	}

	@Override
	public GroceryItem[] getAllItems() {
		GroceryItem[] result = new GroceryItem[count];
		for (int i = 0; i < count; i++) {
			result[i] = items[i];
		}
		return result;
	}

}