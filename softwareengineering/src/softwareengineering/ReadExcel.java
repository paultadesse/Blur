/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softwareengineering;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbookType;

/**
 *
 * @author paulos
 */
public class ReadExcel {
    public static void main(String[] args) throws Exception{
        
//        sheet1.getRow(0).createCell(2).setCellValue("pa");
//        sheet1.getRow(1).createCell(2).setCellValue("f");
//        sheet1.getRow(2).createCell(2).setCellValue("medium");
//        String[] ar = {"dddp","sss","fghfg","sad","oasdiols","dddp","sss","fghfg","sad","oasdiols"};
//        try {
            for (int i = 0; i < 10; i++) {
                copyToExcel("de", i);
        }
//            System.out.println("Total in Item copied to Excel File: "+ ar.length);
//        } catch (Exception e) {
//        }

      
        
    }
    public static void copyToExcel(String name, int index) throws Exception{
        File src = new File("C:\\TestD\\testing.xlsx");
        FileInputStream fis = new FileInputStream(src);
        XSSFWorkbook wb = new XSSFWorkbook(fis);  
        XSSFSheet sheet1 = wb.getSheetAt(0);
        sheet1.getRow(index).createCell(0).setCellValue(name);
        FileOutputStream fout = new FileOutputStream(src);
        wb.write(fout);
        wb.close();
    
    }
    
    
}
