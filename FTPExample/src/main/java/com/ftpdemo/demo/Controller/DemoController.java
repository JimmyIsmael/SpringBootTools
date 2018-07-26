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

    String server = "yourftpserver.com";
    int port = 21;
    String user = "user";
    String pass = "password";

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
            String remoteFile1 = "yourFile/Path/test.txt";
            File downloadFile1 = new File("location/toDownload/test.txt");
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
