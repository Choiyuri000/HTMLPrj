package co.yedam.shop;

public class Item {
	private String itemNo;
	private String itemName;
	private String itemDesc;
	private double likeIt;
	private double price;
	private double priceOff;
	private String image;

	public String getItemNo() {
		return itemNo;
	}

	public void setItemNo(String itemNo) {
		this.itemNo = itemNo;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemDesc() {
		return itemDesc;
	}

	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}

	public double getLikeIt() {
		return likeIt;
	}

	public void setLikeIt(double likeIt) {
		this.likeIt = likeIt;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getPriceOff() {
		return priceOff;
	}

	public void setPriceOff(double priceOff) {
		this.priceOff = priceOff;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "Item [itemNo=" + itemNo + ", itemName=" + itemName + ", itemDesc=" + itemDesc + ", likeIt=" + likeIt
				+ ", price=" + price + ", priceOff=" + priceOff + ", image=" + image + "]";
	}

}
