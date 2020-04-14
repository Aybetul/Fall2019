package com.automation.tests.SelfPractice.NurullahOffice;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class UnderstandinExcelFile {

    @Test
    public void testCase1() throws IOException {
        //location of excel file in computer
        String filePath="Copy of understandingExcel.xlsx";
        // we must load excel file as java file
        FileInputStream byteCodeOfExcelFile= new FileInputStream(filePath);
// load our workbook as a file
        Workbook workbook= WorkbookFactory.create(byteCodeOfExcelFile);

      //  The sheet that we rae working on
     Sheet workSheet= workbook.getSheet("Sheet1");

     //To load the cell we need coulm and row number
        // **--> ass index number
     Cell cell;
     cell=workSheet.getRow(0).getCell(0);
        System.out.println("cell.toString() = " + cell.toString()); // Cell1A

        Cell cell2= workSheet.getRow(0).getCell(1);
        System.out.println("cell2.toString() = " + cell2.toString()); // Cell1B

        Cell cell3= workSheet.getRow(0).getCell(2);
        System.out.println("cell2.toString() = " + cell3.toString()); // null
    }


}
