package jan4;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadData {

	public static void main(String[] args) throws Throwable{
		FileInputStream fi=new FileInputStream("f:\\mydata.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(fi);
		XSSFSheet ws=wb.getSheet("Login");
		int rc=ws.getLastRowNum();
		System.out.println(rc);
		for(int i=1;i<=rc;i++)
		{
			String username=ws.getRow(i).getCell(0).getStringCellValue();
			if(wb.getSheet("Login").getRow(i).getCell(1).getCellType()==Cell.CELL_TYPE_NUMERIC)
			{
				//get integer type column
				int celldata=(int)wb.getSheet("login").getRow(i).getCell(1).getNumericCellValue();
				//conver celldata integer to string type
				String password=String.valueOf(celldata);
				System.out.println(username+" "+password);
				ws.getRow(i).createCell(2).setCellValue("success");
			}
		}
		fi.close();
		FileOutputStream fo=new FileOutputStream("G:\\res.xlsx");
		wb.write(fo);
		fo.close();
		wb.close();
				
			}
		}