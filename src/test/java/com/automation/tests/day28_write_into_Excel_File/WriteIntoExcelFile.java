package com.automation.tests.day28_write_into_Excel_File;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;

public class WriteIntoExcelFile {



    @Test
  public  void writeIntoFileTest() throws IOException {
        String path="VytrackTestUsers.xlsx";
        FileInputStream inputStream=new FileInputStream(path);
        Workbook workbook= WorkbookFactory.create(inputStream);
        Sheet sheet=workbook.getSheet("QA3-short");
        Row row=sheet.getRow(1);
        Cell cell= row.getCell(5);
        //before we change the value
        System.out.println(cell.getStringCellValue());
        //set value
       cell.setCellValue("PASSED");
        //after we change the value
        System.out.println(cell.getStringCellValue());

      Row firstRow=  sheet.getRow(0);
      Cell newCell=firstRow.createCell(firstRow.getLastCellNum());
      newCell.setCellValue("Date of execution");
      Cell newCell2=row.createCell(6);
      newCell2.setCellValue(LocalDateTime.now().toString());

        //don't forget close file other wise will crash
        FileOutputStream outputStream=new FileOutputStream("VytrackTestUsers.xlsx");
        workbook.write(outputStream); //writes changes
        workbook.close();

    }




}
