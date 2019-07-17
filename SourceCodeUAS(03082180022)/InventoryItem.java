public class InventoryItem {
	private Item item;
	private int qty;

	public InventoryItem(Item item) {
		this.item = item;
		this.qty = 0;
	}

	public InventoryItem(Item item, int qty) {
		this.item = item;
		this.qty = qty;
	}

	public Item getItem() { return this.item; }

	public int getQty() { return this.qty; }


	public void setQty(int qty) {
		if (qty < 0) throw new IllegalArgumentException();
		this.qty = qty;
	}
	
	public String toString() {
		return String.format("<InventoryItem:%s:%d>", item.toString(), qty);
	}
}
