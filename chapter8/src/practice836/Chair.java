package practice836;

public class Chair extends ProductInfo{
	public Chair(String code, String name) {
		super(code, name);
	}

@Override
    public int shipping() {
	String c = getCode().substring(0);
	if (c == "S") {
		return 1200;
	}else if (c == "O") {
		return 1400;
	}else {
		return 2000;
	}
	 @Override
	 public int handling() {
		 return 200;
	 }
	 @Override
	 public int price() {
		 String c = getCode().substring(0);
		 if(c == "S") {
			 return 12000;
		 }else if (c == "O") {
			 return 20000;
		 }else {
			 return 30000;
		 }
		 
	 
}

}
