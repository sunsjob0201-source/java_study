package practice836;

public class Handbag extends Productinfo{
	private int size(1:小, 2:中, 3:大);
    
	public Handbag(String code, String name, int size) {
		this.code = code;
		this.name = name;
		this.size = size;
	}
	var s = size;
	public int shipping() {
		if (s == 1) {
			return 500;
		}else if (s == 2) {
			return 700;
		}else {
			return 1000;
		}
		public int handling() {
			if (s >= 2) {
				return 200;
			}else {
				return 0;
			}
			}
		var c = code.substring(0, 3);
		public int price() {
			if(c == "SIG") {
				return 10000;
			}else if (c == "SHO") {
				return 12000;
			}else {
				return 15000;
			}
		}
		
	}

}