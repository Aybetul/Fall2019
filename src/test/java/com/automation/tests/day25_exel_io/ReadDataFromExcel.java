package com.automation.tests.day25_exel_io;

import com.automation.utulities.ExcelUtil;
import org.apache.poi.ss.usermodel.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;

public class ReadDataFromExcel {

    @Test
    public void readExcelFileTest()throws  Exception {

        File file = new File("VytrackTestUsers.xlsx");
        Workbook workbook = WorkbookFactory.create(file);
//get QA1 short
        Sheet workSheet = workbook.getSheet("QA1-short");
//get first row
        Row firstRow = workSheet.getRow(0);
//get firts cell
        Cell firstCell = firstRow.getCell(0);
//get string value
        String value = firstCell.getStringCellValue();
//get second cell and String value
        String secondCellValue = firstRow.getCell(1).getStringCellValue();

        System.out.println(value);
        System.out.println(secondCellValue);

        Assert.assertEquals(value, "execute");
        Assert.assertEquals(secondCellValue, "username");
        System.out.println("============================");
        int lastCell = firstRow.getLastCellNum();

        for (int i = 0; i < lastCell; i++) {
            System.out.print(firstRow.getCell(i) + " | ");
        }

        int numberOfRows = workSheet.getPhysicalNumberOfRows();
        int indexOfLastRow = workSheet.getLastRowNum();
        System.out.println("\nindexOfLastRow = " + indexOfLastRow);
        System.out.println("numberOfRows = " + numberOfRows);

        System.out.println("=================================");

        for (int i = 0; i < workSheet.getPhysicalNumberOfRows(); i++) {
            for (int j = 0; j < workSheet.getRow(i).getLastCellNum(); j++) {
                String cellValue = workSheet.getRow(i).getCell(j).getStringCellValue();
                System.out.print(cellValue + " | ");

            }
            System.out.println();
        }
    }

    @Test
public void excelUtilityTest(){
            String path="VytrackTestUsers.xlsx";
            String spreadSheet="QA1-short";
            ExcelUtil excelUtils= new ExcelUtil(path, spreadSheet);
            excelUtils.getDataList().forEach(System.out::println);
        }


@Test
public void getColumnNames(){
    String path="VytrackTestUsers.xlsx";
    String spreadSheet="QA1-short";
    ExcelUtil excelUtils=new ExcelUtil(path, spreadSheet);
    System.out.println(excelUtils.getColumnsNames());

}
    public void excelUtilityArray(){
        String path="VytrackTestUsers.xlsx";
        String spreadSheet="QA1-short";
        ExcelUtil excelUtils= new ExcelUtil(path, spreadSheet);
       // excelUtils.getDataArray().forEach(System.out::println);
    }











}
