package jan4;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadWriteExcel {

	public static void main(String[] args) throws Throwable{
		//Read the path of excel
		FileInputStream fi=new FileInputStream("D:\\testdata.xlsx");
		//get workbook
		XSSFWorkbook wb=new XSSFWorkbook(fi);
		//get sheet from wb
		XSSFSheet ws=wb.getSheet("login");
		//get first row from sheet
		XSSFRow r=ws.getRow(0);
		//count no.of rows in a sheet
		int rc=ws.getLastRowNum();
		//count no.of colums in first row
		int cc=r.getLastCellNum();
		System.out.println(rc+" "+cc);
		for(int i=1;i<=rc;i++)
		{
			//print second row first column data
			String username=ws.getRow(i).getCell(0).getStringCellValue();
			//print second row second column data
			String password=ws.getRow(i).getCell(1).getStringCellValue();
			System.out.println(username+" "+password);
			//write some text into results column
			ws.getRow(i).createCell(2).setCellValue("success");
			
		}
		fi.close();
		//create new workbook
		FileOutputStream fo=new FileOutputStream("G:\\results.xlsx");
		wb.write(fo);
		fo.close();
		wb.close();
		

	}

}
