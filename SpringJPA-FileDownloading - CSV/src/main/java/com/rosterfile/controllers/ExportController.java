package com.rosterfile.controllers;

import com.rosterfile.model.Roster;
import com.rosterfile.services.RosterFileService;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.*;


/**
 * Created by Jimmy Pena on 9/27/2017.
 */
@Controller
public class ExportController {
    @Autowired
    RosterFileService rosterFileService;

    private static final String FILE_PATH = "SalesRoster.csv";
    private static final String SALESROSTER_CSV = "SalesRoster/csv";

    private File getFile() throws FileNotFoundException {
        File file = new File(FILE_PATH);
        if (!file.exists()){
            throw new FileNotFoundException("file with path: " + FILE_PATH + " was not found.");
        }
        return file;
    }


    /*
    * Send the rosterList object to the model, when the model received it the ExcelView class
    * catchs it and creat the Excel file.
    * Look a the line 30 on ExcelView class */
    @RequestMapping(value = "/exportToCSV")
    public void exportToCSV( HttpServletResponse response) throws IOException {

        Iterable<Roster> roster=rosterFileService.listAll();

        //Creating the CSV File
        //Delimiters which has to be in the CSV file
        char COMMA_DELIMITER = ',';
        String LINE_SEPARATOR = "\n";

        FileWriter fileWriter=null;

        try {
            fileWriter=new FileWriter(FILE_PATH);

            List<String> lines= new ArrayList<String>();
            for (Roster item:roster){
                fileWriter.append(item.getZRT());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(item.getFULL_NAME());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(item.getHOMEADDRESS1());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(item.getHOMEADDRESS2());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(item.getHOMECITY());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(item.getHOMESTATE());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(item.getHOMEZIPCODE());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(LINE_SEPARATOR);
            }

            System.out.println("Write to CSV file Succeeded!!!");
        }
        catch(Exception ee)
        {
            ee.printStackTrace();
        }
        finally
        {
            try
            {
                fileWriter.close();
            }
            catch(IOException ie)
            {
                System.out.println("Error occured while closing the fileWriter");
                ie.printStackTrace();
            }
        }

        //-----Downloading the file-----//
        File file = getFile();
        InputStream in = new FileInputStream(file);
        response.setContentType(SALESROSTER_CSV);
        response.setHeader("Content-Disposition", "attachment; filename=" + file.getName());
        response.setHeader("Content-Length", String.valueOf(file.length()));
        FileCopyUtils.copy(in, response.getOutputStream());

        System.out.println(FILE_PATH + " is successfully downloaded");
    }
}
