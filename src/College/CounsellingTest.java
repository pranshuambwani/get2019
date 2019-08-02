package College;

import org.junit.Test;

public class CounsellingTest {
	@Test
	public void counsellingTest(){
		Counselling process = new Counselling();
		String path = "output.xlsx";
		String studentDetails = "studentDetails.xls";
		String programDetails = "programDetails.xls";
		process.studentCounselling(path, studentDetails, programDetails);
	}

}
