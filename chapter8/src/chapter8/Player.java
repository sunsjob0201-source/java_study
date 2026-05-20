package chapter8;

public class Player {
    private String name;
    private ChipSet chips;
    
    public Player(String name, ChipSet chips) {
    	this.name = name;
    	this.chips = chips; 
    }
    public Player(String name, int p);
	}
	
	public int getPoints() {
		return chips;
	}
    public int change(int p) {
    return chips + p;
    }
    
    public String getName() {
    	return name;
    }
    public String toString() {
    	return System.out.println(this.name + "/点数:" + p + "(c10:" + c10 + ",c1:" + c1);
    }
}
