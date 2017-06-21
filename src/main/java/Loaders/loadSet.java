package Loaders;
import Product.*;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Виталий on 20.06.2017.
 */
public class loadSet {
    public static List<Product> LFromExcel(List<Product> list, String file) throws FileNotFoundException, IOException {
        list = new ArrayList<Product>();

        XSSFWorkbook wb  = new XSSFWorkbook(file);
        XSSFSheet sheet = wb.getSheet("Ajusa");
        for (int i = 0; i < sheet.getLastRowNum()+1;) {
            XSSFRow row = sheet.getRow(i);

            try{String brand = row.getCell(0).getStringCellValue();
           //     System.out.print(brand +" ");
                String art = (String)row.getCell(1).getRawValue();
           //     System.out.print(art +" ");
                int count = Integer.parseInt(row.getCell(2).getRawValue());
          //      System.out.print(count +" ");
                double cost = Double.parseDouble(row.getCell(3).getRawValue());
          //      System.out.println(cost);
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

   public static void setToExcel(List<Product> list, String file) throws IOException {
// Создаем документ
       Workbook book = new HSSFWorkbook();
       // Создаем лист
       Sheet sheet = book.createSheet("AUTOSPACE");
       // Нумерация начинается с нуля
       for (int i = 0; i < list.size(); i++) {
           Row row = sheet.createRow(i);
           // Создаем ячейку
           Cell brand = row.createCell(0);
           brand.setCellValue(list.get(i).getBrand());
           Cell art = row.createCell(1);
           art.setCellValue(list.get(i).getArt());
           Cell count = row.createCell(2);
           count.setCellValue(list.get(i).getCount());
           Cell cost = row.createCell(3);
           cost.setCellValue(list.get(i).getCost());
           Cell rus = row.createCell(4);
           rus.setCellValue(list.get(i).getCostFrom());
           // Меняем размер столбца
           sheet.autoSizeColumn(1);

           // Записываем всё в файл
           book.write(new FileOutputStream(file));
           book.close();
       }
   }



}
