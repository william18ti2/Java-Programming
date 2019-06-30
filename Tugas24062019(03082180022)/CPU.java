
public class CPU {

	private String brand;
	private double clock;
	private int core;
	
	public CPU(String brand, double clock, int core) {
		this.brand = brand;
		this.clock = clock;
		this.core = core;
	}
	
	public String getBrand() {
		return this.brand;
	}
	
	public double getClock() {
		return this.clock;
	}
	
	public int getCore() {
		return this.core;
	}
}
