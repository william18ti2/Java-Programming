import java.util.List;
import java.util.ArrayList;

public class Computer {

	public CPU CPU;
	public PSU PSU;
	public List<Memory> Memory;
	public List<Storage> Storage;
	
	public Computer() {
		this.Memory = new ArrayList<Memory>();
		
		this.Memory.add(new Memory(0));
		this.Memory.add(new Memory(0));
		this.Memory.add(new Memory(0));
		this.Memory.add(new Memory(0));
		
		this.Storage = new ArrayList<Storage>();
	}
	
	public void replaceCPU(CPU newCPU) {
		this.CPU = newCPU;
	}
	
	public void replaceMemory(int i, Memory newMemory) {
		this.Memory.set(i,newMemory);
	}
	
	public void replacePSU(PSU newPSU) {
		this.PSU = newPSU;
	}
	
	public void addStorage(SSD newSSD) {
		this.Storage.add(newSSD);
	}
	
	public void addStorage(HDD newHDD) {
		this.Storage.add(newHDD);
	}
	
	public String getSpec() {
		return "CPU: " + this.CPU.getBrand() + " " + this.CPU.getClock() + "Ghz " + this.CPU.getCore() + " core(s)\n"
				+ "===\n"
				+ "Memory: " + getTotalMemorySize() + "GB\n"
				+ printMemList()
				+ "===\n"
				+ "Storage: " + getTotalStorageSize() + "GB\n"
				+ printStoList()
				+ "===\n"
				+ "PSU: " + this.PSU.getPower() + "watt";
		
	}
	
	public int getTotalMemorySize() {
		int temp = 0;
		for (Memory i:Memory) {
			temp += i.getCapacity();
		}
		return temp;
	}
	
	public String printMemList() {
		String temp = "";
		for (Memory i:Memory) {
			if (i.getCapacity() != 0)
				temp = temp + "Slot " + Memory.indexOf(i) + ": " + i.getCapacity() + "GB\n";
		}
		return temp;
	}
	
	public int getTotalStorageSize() {
		int temp = 0;
		for (Storage i:Storage) {
			temp += i.getCapacity();
		}
		return temp;
	}
	
	public String printStoList() {
		String temp = "";
		for (Storage i:Storage) {
			temp = temp + i.getClass().getName() + ": " + i.getCapacity() + "GB\n";
		}
		return temp;
	}
	
	
}
