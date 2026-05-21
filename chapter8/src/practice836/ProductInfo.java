package practice836;

public class ProductInfo extends Product {
  interface Shipping {
	  int shipping();
	  int handling();
  }
  public ProductInfo(String code, String name) {
	  this.code = code;
	  this.name = name;
  }
  public String info() {
	  return String format("%s, %f, %s5, %s, %s" name, code, price, shipping, handling);
  }


}
