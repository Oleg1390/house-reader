package reader.test.java;

import java.io.File;

public class JunitTest {
	@Test
	public void �lassAvailabilityTest() {
		String path = "resource/address.xml";
		File f = new File(path);
		if(!f.exists()) {
			System.out.println("����� �� ����������");
		} else {
			System.out.println("C���������");
		}
	}
}
