package com.rosterfile.controllers;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.rosterfile.model.Roster;
import com.rosterfile.services.RosterFileService;

import org.apache.poi.xwpf.usermodel.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.stream.Stream;


/**
 * Created by Jimmy Pena on 9/27/2017.
 */
@Controller
public class ExportController {
    @Autowired
    RosterFileService rosterFileService;

    private static final String FILE_PATH_PDF = "SalesRoster.pdf";
    private static final String SALESROSTER_PDF= "SalesRoster/pdf";




    private File getFilePDF() throws FileNotFoundException {
        File file = new File(FILE_PATH_PDF);
        if (!file.exists()){
            throw new FileNotFoundException("file with path: " + FILE_PATH_PDF + " was not found.");
        }
        return file;
    }

    @RequestMapping(value = "/exportToPDF")
    public void exportToPDF( HttpServletResponse response) throws IOException,DocumentException {

        //Creating the file
        com.itextpdf.text.Document document = new com.itextpdf.text.Document(PageSize.A4.rotate());
        PdfWriter.getInstance(document, new FileOutputStream(FILE_PATH_PDF));

        document.open();

        //Adding the tittle
        Paragraph preface = new Paragraph("Swisher International Sales Roster");
        preface.setAlignment(Element.ALIGN_CENTER);
        document.add(preface);

        // add a blank line
        document.add( Chunk.NEWLINE );

        //Defining the table
        PdfPTable table = new PdfPTable(7);
        table.setWidthPercentage(100);
        table.setWidths(new int[]{1, 3, 4, 3, 1, 1, 2});//size ordered by column index

        //adding the headers
        Stream.of("ZRT", "Name","Address","City","State","ZIP", "Mobile")
                .forEach(columnTitle -> {
                    PdfPCell header = new PdfPCell();
                    header.setBorderWidth(1);
                    header.setPhrase(new Phrase(columnTitle));
                    table.addCell(header);
                });

        //adding the records
        for(Roster user : rosterFileService.listAll()){
            table.addCell(user.getZRT());
            table.addCell(user.getFULL_NAME());
            table.addCell(user.getHOMEADDRESS1()+' '+user.getHOMEADDRESS2());
            table.addCell(user.getHOMECITY());
            table.addCell(user.getHOMESTATE());
            table.addCell(user.getHOMEZIPCODE());
            table.addCell(user.getCELL_PHONE());
        }
        document.add(table);
        document.close();

        //-----Downloading the file-----//
        File file = getFilePDF();
        InputStream in = new FileInputStream(file);
        response.setContentType(SALESROSTER_PDF);
        //response.setContentType("application/pdf");
        response.setHeader("content-disposition", "inline;filename=" + file.getName());
        response.setHeader("Content-Length", String.valueOf(file.length()));
        FileCopyUtils.copy(in, response.getOutputStream());

        System.out.println(FILE_PATH_PDF + " is successfully downloaded");
    }
}
