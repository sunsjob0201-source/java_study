package rekkyo;

public enum Season {
    SPRING(0, "春"),
    SUMMER(1, "夏"),
    AUTUMN(2, "秋"),
    WINTER(3, "冬");
	
	private int code;
	private String jpName;
	
	private Season(int code, String jpName) {
		this.code =code;
		this.jpName = jpName;
	}
	
	public int toSeasonValue() {
		return this.code;
	}
	
	@Override
	public String toString() {
		return this.jpName;
	}
}