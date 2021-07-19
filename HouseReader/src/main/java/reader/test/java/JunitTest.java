package reader.test.java;

import java.io.File;

public class JunitTest {
	@Test
	public void ÑlassAvailabilityTest() {
		String path = "resource/address.xml";
		File f = new File(path);
		if(!f.exists()) {
			System.out.println("Ôàéëà íå ñóùåñòâóåò");
		} else {
			System.out.println("Cóùåñòâóåò");
		}
	}
}
