package com.ftpdemo.demo.Controller;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.*;
import java.util.Date;

@Controller
public class DemoController {

    String server = "sweetftp.swisher.com";
    int port = 921;
    String user = "ftpadmin";
    String pass = "dsCpLKDV3e";

    @RequestMapping("/")
    public String index(){
        return "demo";
    }

    @RequestMapping("copyFile")
    public String getFile(Model model){
        FTPClient ftpClient = new FTPClient();
        File log = new File("Confirmationlog.txt");
        try {

            ftpClient.connect(server, port);
            ftpClient.login(user, pass);
            ftpClient.enterLocalPassiveMode();
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);

            // APPROACH #1: using retrieveFile(String, OutputStream)
            String remoteFile1 = "/Hempire/Confirmation_Log/confirmation_log.xlsx";
            File downloadFile1 = new File("confirmation_log.xlsx");
            OutputStream outputStream1 = new BufferedOutputStream(new FileOutputStream(downloadFile1));
            boolean success = ftpClient.retrieveFile(remoteFile1, outputStream1);
            outputStream1.close();

            if (success) {
                System.out.println("File #1 has been downloaded successfully.");
            }

        }
        catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                if (ftpClient.isConnected()) {
                    ftpClient.logout();
                    ftpClient.disconnect();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        model.addAttribute("message","File loaded successfully");
        return "demo";
    }
}
