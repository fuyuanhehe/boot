/*
package excel;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class test {

    public static void main(String[] args) {




    }

    public static void Excel2003Operate(String filePath) throws Exception {
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(new FileInputStream(new File(filePath)));
        HSSFSheet sheet = hssfWorkbook.getSheetAt(0);
        for (int i = 0; i < 10000; i++) {
            HSSFRow hssfRow = sheet.createRow(i);
            for (int j = 0; j < 10; j++) {
                HSSFCellUtil.createCell(hssfRow, j, String.valueOf(Math.random()));
            }
        }
        FileOutputStream out = new FileOutputStream("workbook.xlsx");
        hssfWorkbook.write(out);
        out.close();
    }

}
*/
