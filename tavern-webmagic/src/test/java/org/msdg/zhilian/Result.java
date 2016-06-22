package org.msdg.zhilian;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.Pipeline;
import us.codecraft.webmagic.result.ResultHandler;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

/**
 * Created by mw4157 on 16/6/22.
 */
public class Result implements ResultHandler {
    @Override
    public void process(Spider spider){
        System.out.println(SetPipeline.positionSet.size());

        SXSSFWorkbook workbook = new SXSSFWorkbook(100);
        // 创建工作簿
        Sheet sheet = workbook.createSheet();
        Row header = sheet.createRow(0);
        header.createCell(0).setCellValue("Position");
        header.createCell(1).setCellValue("Company");
        header.createCell(2).setCellValue("Salary");
        header.createCell(3).setCellValue("Place");
        header.createCell(4).setCellValue("Detail");

        int index = 1;
        Iterator<Position> it = SetPipeline.positionSet.iterator();
        while(it.hasNext()) {
            Position position = it.next();
            Row row = sheet.createRow(index++);
            row.createCell(0).setCellValue(position.getPosition());
            row.createCell(1).setCellValue(position.getCompany());
            row.createCell(2).setCellValue(position.getSalary());
            row.createCell(3).setCellValue(position.getPlace());
            row.createCell(4).setCellValue(position.getDetail());
        }

        try {
            FileOutputStream fileOutputStream = new FileOutputStream("/Users/mw4157/Desktop/positions.xlsx");
            workbook.write(fileOutputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                workbook.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
