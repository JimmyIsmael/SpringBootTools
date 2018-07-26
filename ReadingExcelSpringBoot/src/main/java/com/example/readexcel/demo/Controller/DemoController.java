package com.example.readexcel.demo.Controller;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;
import java.io.IOException;

@Controller
public class DemoController {

    @RequestMapping("/")
    public String index(){
        return "demo";
    }

    @RequestMapping("/readExcel")
    public String readExcel(Model model){

        final String SAMPLE_XLSX_FILE_PATH = "vendors.xlsx";

        try {
            // Creating a Workbook from an Excel file (.xls or .xlsx)
            Workbook workbook = WorkbookFactory.create(new File(SAMPLE_XLSX_FILE_PATH));

            // Getting the Sheet at index zero
            Sheet sheet = workbook.getSheetAt(0);

            //Starting at 1 to avoid column header, start from 0 if wanted
            for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {

                Cell id = sheet.getRow(i).getCell(0); // Get the Cell at the Index / Column you want.
                System.out.println(id);

                Cell name = sheet.getRow(i).getCell(1);
                System.out.println(name);

                Cell address1 = sheet.getRow(i).getCell(2);
                System.out.println(address1);

                Cell address2 = sheet.getRow(i).getCell(3);
                System.out.println(address2);

                Cell city = sheet.getRow(i).getCell(4);
                System.out.println(city);

                Cell email = sheet.getRow(i).getCell(5);
                System.out.println(email);
            }
            //Closing the workbook
            workbook.close();
        }
        catch (IOException e){
            System.out.println("Error: " + e.getMessage());
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }

        model.addAttribute("message","File loaded successfully");

        return "demo";
    }
}
