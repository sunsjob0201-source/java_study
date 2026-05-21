package practice836;

public abstract class  ProductInfo extends Product {
  public interface Shipping {
	  int shipping();
	  int handling();
  }
  public ProductInfo(String code, String name) {
	 super(code, name);
  }
  @Override
  public String info() {
	  return String.format("%s %s 価格:%d円 送料:%d円 手数料:%d円", getCode(), getName(), price(), shipping(), handling());
  }


}
