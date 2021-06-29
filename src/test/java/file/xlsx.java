/*
package file;

import com.boot.boot.model.DemoData;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

@Slf4j
public class xlsx {

    */
/**
     * 导出excel
     *
     * @param fileName 要导出的文件名（包含路径）
     * @param data
     * @return
     *//*

    public boolean exportToExcel(String fileName, List<String[]> data) {

        log.info("导出excel开始，fileName: " + fileName + ", data个数：" + data.size());
        if (!fileName.endsWith(".xlsx")) {
            log.error("fileName有误，需要以xlsx结尾");
            return false;
        }
        // 声明一个工作薄
        Workbook workBook = null;

        ByteArrayOutputStream ops = null;
        ByteArrayInputStream in = null;
        File file = new File(fileName);
        try {
            if (file.exists()) {
                file.delete();
            }
            file = new File(fileName);
            //重新复制模版文件
            FileUtils.copyFile(new File(DemoData.class.getResource("/src/main/webapp/upload/AA.xlsx").getFile()), file);


            // 声明一个工作薄
            workBook = new XSSFWorkbook(new FileInputStream(file));
            // 生成一个表格
            Sheet sheet = workBook.getSheetAt(0);
            if (sheet == null) {
                sheet = workBook.createSheet("AutoPolicy");
            }
            //最新Excel列索引,从0开始
            int lastRowIndex = sheet.getLastRowNum();
            lastRowIndex++;
            // 设置表格默认列宽度
            sheet.setDefaultColumnWidth(300);
            // 产生表格表头列标题行
            Row row;
            NumberFormat decimalFormat = new DecimalFormat("###,###.00");
            DecimalFormat zeroFormat = new DecimalFormat("0.00");
            // 遍历集合数据,产生数据行,前两行为标题行与表头行
            for (String[] dataRow : data) {
                row = sheet.createRow(lastRowIndex);
                lastRowIndex++;
                for (int j = 0; j < dataRow.length; j++) {
                    Cell contentCell = row.createCell(j);
                    String dataObject = dataRow[j];
                    contentCell.setCellType(CellType.STRING);
                    contentCell.setCellValue(dataObject);
                }
            }
            ops = new ByteArrayOutputStream();
            workBook.write(ops);
            byte[] b = ops.toByteArray();
            in = new ByteArrayInputStream(b);

            //    fileStreamUpload.uploadFile(in, fileName);

            ops.flush();

        } catch (Exception e) {
            log.error("导出excel失败，失败原因：" + e.getMessage());
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(workBook);
            IOUtils.closeQuietly(ops);
            IOUtils.closeQuietly(in);
        }
        return result;
    }

}
*/
