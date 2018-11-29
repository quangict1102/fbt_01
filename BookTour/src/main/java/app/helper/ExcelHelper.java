package app.helper;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import app.bean.UserInfo;

public class ExcelHelper {

	public static List<UserInfo> readExcel(MultipartFile file) {
		try {

			Workbook workbook = new XSSFWorkbook(file.getInputStream());
			Sheet datatypeSheet = workbook.getSheetAt(0);
			DataFormatter fmt = new DataFormatter();
			Iterator<Row> iterator = datatypeSheet.iterator();
			List<UserInfo> listOfUserInfo = new ArrayList<UserInfo>();
			while (iterator.hasNext()) {
				Row currentRow = iterator.next();
				UserInfo userInfo = new UserInfo();
				userInfo.setFullName((fmt.formatCellValue(currentRow.getCell(0))));
				userInfo.setGender(Integer.parseInt(fmt.formatCellValue(currentRow.getCell(1))));
				userInfo.setAddress((fmt.formatCellValue(currentRow.getCell(2))));
				userInfo.setEmail((fmt.formatCellValue(currentRow.getCell(3))));
				userInfo.setPhoneNumber((fmt.formatCellValue(currentRow.getCell(4))));
				userInfo.setPassword(Md5Helper.getCodeMd5((fmt.formatCellValue(currentRow.getCell(5)))));
				userInfo.setRole((fmt.formatCellValue(currentRow.getCell(6))));
				listOfUserInfo.add(userInfo);
			}

			for (UserInfo UserInfo : listOfUserInfo) {
				System.out.println(UserInfo);
			}
			workbook.close();
			return listOfUserInfo;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
