public class TestComputer {
	public static void main(String []args) {
		Computer myComputer = new Computer();

		myComputer.replaceCPU(new CPU("Intel", // merek
									  3.4, // clock
									  8)); // core

		myComputer.replaceMemory(1,	// slot number
								 new Memory(4) // memory size 4gb
								);

		myComputer.replaceMemory(3,	// slot number
								 new Memory(4) // memory size 4gb
								);

		myComputer.addStorage(new SSD(128)); // ssd capacity GB
		myComputer.addStorage(new HDD(512)); // hdd capacity GB

		myComputer.replacePSU(new PSU(600)); // PSU power watt

		String spec = myComputer.getSpec();
		String expectedSpec = 
		"CPU: Intel 3.4Ghz 8 core(s)\n" +
		"===\n" +
		"Memory: 8GB\n" +
		"Slot 1: 4GB\n" +
		"Slot 3: 4GB\n" +
		"===\n" +
		"Storage: 640GB\n" +
		"SSD: 128GB\n" +
		"HDD: 512GB\n" +
		"===\n" + 
		"PSU: 600watt";

		System.out.println(expectedSpec.equals(myComputer.getSpec()));

		System.out.println(
				myComputer.getSpec()
		);

		myComputer.addStorage(new SSD(1024));

		expectedSpec = 
		"CPU: Intel 3.4Ghz 8 core(s)\n" +
		"===\n" +
		"Memory: 8GB\n" +
		"Slot 1: 4GB\n" +
		"Slot 3: 4GB\n" +
		"===\n" +
		"Storage: 1664GB\n" +
		"SSD: 128GB\n" +
		"HDD: 512GB\n" +
		"SSD: 1024GB\n" + 
		"===\n" + 
		"PSU: 600watt";

		System.out.println(expectedSpec.equals(myComputer.getSpec()));
	}
}