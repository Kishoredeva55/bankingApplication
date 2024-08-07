package org.example;

import java.io.*;
import java.util.Objects;
import java.util.Scanner;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

public class CustomerDetails {
    public String name;

    public double balance;

    public int row;

    public void getDetails(String accNum, String pin) throws IOException {
        FileInputStream fis = new FileInputStream("/home/bharath-deva/kishore/project/simple-banking-application/data/bankDetails.xlsx");
        Workbook wb = WorkbookFactory.create(fis);
        Sheet S = wb.getSheet("Sheet1");
        for (int i = 0; i < S.getPhysicalNumberOfRows(); i++) {
            Row R = S.getRow(i);
            Cell C = R.getCell(1);
            String data = C.getStringCellValue();

            if (data.equals(accNum)) {
                name = R.getCell(0).getStringCellValue();
                balance = R.getCell(3).getNumericCellValue();
                row = i;

            }
        }

        
    }
    public void putDetails(String name ,String accNum ,String pin ) throws IOException {
            FileInputStream fis = new FileInputStream("/home/bharath-deva/kishore/project/simple-banking-application/data/bankDetails.xlsx");
            Workbook wb = WorkbookFactory.create(fis);
            Sheet S = wb.getSheet("Sheet1");
            Row R = S.createRow(S.getPhysicalNumberOfRows());
            Cell c = R.createCell(0);
            c.setCellValue(name);
            R.createCell(1).setCellValue(accNum);
            R.createCell(2).setCellValue(pin);
            R.createCell(3).setCellValue("0");
            FileOutputStream fos = new FileOutputStream("/home/bharath-deva/kishore/project/simple-banking-application/data/bankDetails.xlsx");
            wb.write(fos);

    }
    public void updatebalance(double balance) throws IOException {

        FileInputStream fis = new FileInputStream("/home/bharath-deva/kishore/project/simple-banking-application/data/bankDetails.xlsx");
        Workbook wb = WorkbookFactory.create(fis);
        Sheet S = wb.getSheet("Sheet1");
        Row R = S.getRow(row);
        Cell c = R.getCell(3);
        c.setCellValue(balance);FileOutputStream fos = new FileOutputStream("/home/bharath-deva/kishore/project/simple-banking-application/data/bankDetails.xlsx");
        wb.write(fos);



    }

    public void create() {

        File f = new File("/home/bharath-deva/kishore/project/simple-banking-application/data/bankDetails.xlsx");
        if (f.exists()) {

        } else {
            try (
                    OutputStream fileOut = new FileOutputStream("/home/bharath-deva/kishore/project/simple-banking-application/data/bankDetails.xlsx");
                    Workbook wb = new HSSFWorkbook();
            ) {
                Sheet S = wb.createSheet("Sheet1");
                wb.write(fileOut);
                System.out.println("file created");

            } catch (FileNotFoundException e) {
                System.out.println("file not opened");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
