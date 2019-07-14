import java.util.List;
import java.io.File;
import java.util.Arrays;

public class TestManusiaCSV {
	public static void main(String []args) {
		List<Manusia> m = Arrays.asList(new Manusia[]{
			new Manusia("Andi", 10, 50.3, true),
			new Manusia("Badu", 20, 70.5, false)
		});
		CSV<Manusia> manusiaCSV = new Manusias(); 

		manusiaCSV.write(new File("manusia.csv").toPath(), m);

		List<Manusia> o = manusiaCSV.read(new File("manusia.csv").toPath());
	}
}