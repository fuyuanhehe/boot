/*
package excel;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

public class cc {

    //第一次写入



    public static void createExcel(Map<String, Object> map, OutputStream os) throws Exception {



        int n = 0;

        int m = 0;

        //创建工作薄

        WritableWorkbook workbook = Workbook.createWorkbook(os);



        //创建新的一页

        WritableSheet sheet = workbook.createSheet("First Sheet",0);





        //创建要显示的内容,创建一个单元格，第一个参数为列坐标，第二个参数为行坐标，第三个参数为内容



        for (String key : map.keySet()) {

            Label dk = new Label(n,0,key);

            sheet.addCell(dk);

            n++;



        }



        for (Object value : map.values()) {

            Label dk = new Label(m,1,value.toString());

            sheet.addCell(dk);

            m++;

        }





        //把创建的内容写入到输出流中，并关闭输出流

        workbook.write();

        workbook.close();

        os.close();

    }



//向excel中追加数据.@excelPath:excel所在路径,list:数据集合.(第2,3,4,5,6.....次写入

    public static void addExcel(String excelPath,List<Object> list ) throws IOException{



        FileInputStream fs = new FileInputStream(excelPath);//获取excel



        POIFSFileSystem ps = new POIFSFileSystem(fs);//获取excel信息



        HSSFWorkbook wb = new HSSFWorkbook(ps);



        HSSFSheet sheet = wb.getSheetAt(0);//获取工作表



        HSSFRow row = sheet.getRow(0);//获取第一行(即:字段列头,便于赋值)



        System.out.println(sheet.getLastRowNum()+"空"+row.getLastCellNum());//分别得到最后一行行号,和一条记录的最后一个单元格



        FileOutputStream out = new FileOutputStream(excelPath);//向excel中添加数据



        row = sheet.createRow(sheet.getLastRowNum()+1);//在现有行号后追加数据



        for (int i = 0; i < list.size(); i++) {



            String str = String.valueOf(list.get(i));

            row.createCell(i).setCellValue(str);//设置单元格的数据

        }

        out.flush();

        wb.write(out);

        wb.close();



    }

}
*/
