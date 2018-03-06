package xls;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;

import java.io.FileOutputStream;
import java.io.IOException;

public class SizeApp {

	public static void main(String[] args) throws IOException {
		
		Workbook wb = new HSSFWorkbook();
		Sheet sheet=wb.createSheet("Лист_01");
		Row row = sheet.createRow(0);
		Cell cell = row.createCell(0);
		cell.setCellValue("Новая ячейка");

		Cell cell2 = row.createCell(0);
		cell2.setCellValue("Новая ячейка");
		sheet.setColumnWidth(0, 5000);
		//sheet.autoSizeColumn(0);
		row.setHeightInPoints(15);
		
		sheet.addMergedRegion(new CellRangeAddress(0, 1, 0, 3));
		
		//FileOutputStream fos = new FileOutputStream("C:/ALL/tmp/Размер_Ячейки.xls");
		FileOutputStream fos = new FileOutputStream("Размер_Ячейки.xls");
		wb.write(fos);
		fos.close();	

	}

}
