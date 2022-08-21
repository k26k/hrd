package array;

public class Product {
	String productName;
	int price;
	
	public Product() {
		this("none", 1);
	}

	public Product(String productName, int price) {
		this.productName = productName;
		this.price = price;
	}
	
	public String showInfo() {
		return productName+", "+price;
	}
}
