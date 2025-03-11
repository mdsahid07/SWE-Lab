package application;
import products.Product;
import shoppingcart.ShoppingCart;


public class Application {

	public static void main(String[] args) {
		ShoppingCart cart = new ShoppingCart();
		Product p1 = new Product("A123", 100.0, "TV");
		cart.addToCart(p1);
		Product p2 = new Product("A665", 75.0, "MP3 Player");
		cart.addToCart(p2);
		Product p3 = new Product("A665", 75.0, "MP3 Player");
		cart.addToCart(p3);
		
		cart.print();
		
		cart.removeFromCart(p3);
		cart.removeFromCart(p2);
		
		cart.print();
	}
}
