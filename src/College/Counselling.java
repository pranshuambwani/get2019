package College;

import java.io.File;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class Counselling {

	Queue<String> students = new LinkedList<String>();
	HashMap<String, Integer> program = new HashMap<String, Integer>();
	HashMap<String, String> studentpref = new HashMap<String, String>();

	/**
	 * Read from program file and store in program list
	 * 
	 * @param filePath
	 *            path of file
	 */
	public void readProgramFile(String filePath) {

		File file = new File(filePath);
		Workbook workbook;
		try {
			workbook = Workbook.getWorkbook(file);
			Sheet sheet = workbook.getSheet(0);
			for (int col = 1; col < sheet.getRows(); col++) {
				Cell cell = sheet.getCell(0, col);
				String programName = cell.getContents();
				cell = sheet.getCell(1, col);
				Integer capacity = Integer.parseInt(cell.getContents());
				program.put(programName, capacity);
			}
		} catch (Exception ex) {
			System.out.println("Message " + ex.getMessage());
		}

	}

	/**
	 * Read from student preference file and store in program list
	 * 
	 * @param filePath
	 *            path of file
	 */
	public void readStudentPref(String filePath) {

		File file = new File(filePath);
		Workbook workbook;
		try {
			workbook = Workbook.getWorkbook(file);
			Sheet sheet = workbook.getSheet(0);
			for (int col = 1; col < sheet.getRows(); col++) {
				Cell cell = sheet.getCell(0, col);
				String studenName = cell.getContents();
				students.add(studenName);
				cell = sheet.getCell(1, col);
				String pref = cell.getContents();
				studentpref.put(studenName, pref);
			}
		} catch (Exception ex) {
			System.out.println("Message " + ex.getMessage());
		}

	}

	/**
	 * Counselling of student and allotment of colleges
	 * 
	 * @param path
	 *            of new allotment file
	 * @param programfile
	 *            program file
	 * @param studentpreference
	 *            file
	 */
	public void studentCounselling(String path, String programfile,
			String studentpreference) {
		readProgramFile(programfile);
		readStudentPref(studentpreference);
		WritableWorkbook workbook;
		try {
			workbook = Workbook.createWorkbook(new File(path));
			WritableSheet sheet = workbook.createSheet("Output", 0);
			Integer count = 1;
			sheet.addCell(new Label(0, 0, "Student Name"));
			sheet.addCell(new Label(1, 0, "College Alloted"));
			while (!students.isEmpty()) {
				String studentName = students.remove();
				String pref = studentpref.get(studentName);
				String preference[] = new String[5];
				preference = pref.split(",");
				boolean assign = false;
				for (int loop = 0; loop < pref.length(); loop++) {
					if (assign)
						break;
					String subject = preference[loop];
					Integer capacity = program.get(subject);
					if (capacity > 0) {
						Label label = new Label(0, count, studentName);
						sheet.addCell(label);
						Label label1 = new Label(1, count, preference[loop]);
						sheet.addCell(label1);
						count++;
						assign = true;
						capacity--;
						program.put(subject, capacity);
					}
				}
			}
			workbook.write();
			workbook.close();
		} catch (Exception ex) {
			System.out.println("hello " + ex.getMessage());
		}

	}

}