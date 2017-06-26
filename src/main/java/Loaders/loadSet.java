package Loaders;
import entity.*;
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
        XSSFSheet sheet = wb.getSheet("AUTOSPACE");
        for (int i = 0; i < sheet.getLastRowNum()+1;) {
            XSSFRow row = sheet.getRow(i);

            try{
                String brand = row.getCell(0).getStringCellValue();
                String group = row.getCell(1).getStringCellValue();
                String art = (String)row.getCell(2).getStringCellValue();
                int code = Integer.parseInt(row.getCell(3).getRawValue());
                String e = (String)row.getCell(4).getStringCellValue();
                int count = Integer.parseInt(row.getCell(5).getRawValue());
                double sbs = Double.parseDouble(row.getCell(6).getRawValue());
                double cost = Double.parseDouble(row.getCell(7).getRawValue());
                list.add(new Product(brand,group, art, code, e, count, sbs, cost));
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
        Row title = sheet.createRow(0);
        Cell brand1 = title.createCell(0);
        brand1.setCellValue("Brand");
        Cell group1 = title.createCell(1);
        group1.setCellValue("Group");
        Cell art1 = title.createCell(2);
        art1.setCellValue("Art");
        Cell code1 = title.createCell(3);
        code1.setCellValue("1C_CODE");
        Cell e1 = title.createCell(4);
        e1.setCellValue("ED");
        Cell count1 = title.createCell(5);
        count1.setCellValue("Count_AC");
        Cell sbs1 = title.createCell(6);
        sbs1.setCellValue("SBS");
        Cell cost1 = title.createCell(7);
        cost1.setCellValue("RU_001");
        Cell rus1 = title.createCell(8);
        rus1.setCellValue("Best_Price_VST67");
        Cell deliveryTime1 = title.createCell(9);
        deliveryTime1.setCellValue("Delivery_time");
        Cell rusCount1 = title.createCell(10);
        rusCount1.setCellValue("Count_From_VST67");
        // Нумерация начинается с нуля
        for (int i = 1; i < list.size(); i++) {
            Row row = sheet.createRow(i);
            // Создаем ячейку
            Cell brand = row.createCell(0);
            brand.setCellValue(list.get(i).getBrand());
            Cell group = row.createCell(1);
            group.setCellValue(list.get(i).getGroup());
            Cell art = row.createCell(2);
            art.setCellValue(list.get(i).getArt());
            Cell code = row.createCell(3);
            code.setCellValue(list.get(i).getCode());
            Cell e = row.createCell(4);
            e.setCellValue(list.get(i).getE());
            Cell count = row.createCell(5);
            count.setCellValue(list.get(i).getCount());
            Cell sbs = row.createCell(6);
            sbs.setCellValue(list.get(i).getSbs());
            Cell cost = row.createCell(7);
            cost.setCellValue(list.get(i).getCost());
            Cell rus = row.createCell(8);
            rus.setCellValue(list.get(i).getCostFrom());
            Cell deliveryTime = row.createCell(9);
            deliveryTime.setCellValue(list.get(i).getTime());
            Cell rusCount = row.createCell(10);
            rusCount.setCellValue(list.get(i).getrCount());

            // Меняем размер столбца
            sheet.autoSizeColumn(1);

            // Записываем всё в файл
            book.write(new FileOutputStream(file));
            book.close();
        }
    }



}
