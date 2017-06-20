package Loaders;
import Product.*;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Виталий on 20.06.2017.
 */
public class loadSet {
    public static List<Product> LFromExcel(List<Product> list, String file) throws FileNotFoundException, IOException {
        list = new ArrayList<Product>();
//		XSSFWorkbook myExcelBook = new XSSFWorkbook(new FileInputStream(file));
//		XSSFSheet myExcelSheet = myExcelBook.getSheet("AUTOSPACE");
        XSSFWorkbook wb  = new XSSFWorkbook(file);
        XSSFSheet sheet = wb.getSheet("AUTOSPACE");
        for (int i = 0; i < sheet.getLastRowNum()+1;) {
            XSSFRow row = sheet.getRow(i);

            try{String brand = row.getCell(0).getStringCellValue();
                System.out.print(brand);
                String art = (String)row.getCell(1).getRawValue();
                System.out.print(art);
                int count = Integer.parseInt(row.getCell(2).getRawValue());
                System.out.print(count);
                double cost = Double.parseDouble(row.getCell(3).getRawValue());
                System.out.println(cost);
                list.add(new Product(brand, art, count, cost));
                i++;
            }
            catch(NullPointerException e){
                break;
            }
        }
        System.out.println("Количество брендов: " + list.size());
        wb.close();
        return list;

   }

}
