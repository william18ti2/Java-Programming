import java.util.List;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Comparator;

public class Inventory {
	private List<InventoryItem> items;
	private int testing;

	public Inventory() {
		this.items = new ArrayList<InventoryItem>();
	}

	public List<InventoryItem> getItems() { return this.items; }


	public int getItemTotalCount() {
		this.testing = 0;
		for (InventoryItem i: items) {
			this.testing += i.getQty();
		}
		return this.testing;
	}

	public boolean available(Item item) {
		for (InventoryItem i: items) {
			if (i.getItem().getName().equals(item.getName())) {
				return true;
			}
		}
		return false;
	}

	public int search(Item item) {
		for (InventoryItem i: items) {
			if (i.getItem().getName().equals(item.getName())) {
				return items.indexOf(i);
			}
		}
		return -1;
	}


	public int getItemCount(Item item) {
		if (available(item)) return items.get(search(item)).getQty();
		return -1;
	}


	public int takeItem(Item item, int qty) {
		if (!available(item)) {
			throw new NoSuchElementException();
		}
		if (qty <= 0) throw new IllegalArgumentException();

		int amount = getItemCount(item);
		if (qty < amount) {
			items.get(search(item)).setQty(amount-qty);
			return qty;
		} else if (qty > amount) {
			items.get(search(item)).setQty(0);
			return amount;
		}
		return -1;
	}


	public void putItem(Item item, int qty) {
		if (qty <= 0) throw new IllegalArgumentException();
		items.add(new InventoryItem(item,qty));
	}

	public List<InventoryItem> getOrderByPrice() {
		this.items.sort(new Comparator<InventoryItem>() {
			public int compare(InventoryItem Item1, InventoryItem Item2) {
				return (int)(Item1.getItem().getPrice()- Item2.getItem().getPrice()) * -1;
			}
		});
		return this.items;
	}
	public List<InventoryItem> getOrderByWeight() {
		this.items.sort(new Comparator<InventoryItem>() {
			public int compare(InventoryItem Item1, InventoryItem Item2) {
				return (int)(Item1.getItem().getWeight()*100- Item2.getItem().getWeight()*100) * -1;
			}
		});
		return this.items;
	}
	public List<InventoryItem> getOrderByQty() {
		this.items.sort(new Comparator<InventoryItem>() {
			public int compare(InventoryItem Item1, InventoryItem Item2) {
				return (int)(Item1.getQty()- Item2.getQty()) * -1;
			}
		});
		return this.items;
	}
}
