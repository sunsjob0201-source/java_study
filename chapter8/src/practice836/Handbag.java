package practice836;

public class Handbag extends Productinfo {
	private int size;
    
	public Handbag(String code, String name, int size) {
		super(code, name);
		this.size = size;
	}
	@Override
	public int shipping() {
		if (size == 1) {
			return 500;
		}else if (size == 2) {
			return 700;
		}else {
			return 1000;
		}
		
		@Override
		public int handling() {
			if (size >= 2) {
				return 200;
			}else {
				return 0;
			}
			}
		@Override
		
		public int price() {
			String c = getCode().substring(0, 3);
			
			if(c.equals("SIG")) {
				return 10000;
			}else if (c.equals("SHO")) {
				return 12000;
			}else {
				return 15000;
			}
		}
		
		@Override
		public String info() {
			return "バッグ ; " + super.info();
		
	}

}