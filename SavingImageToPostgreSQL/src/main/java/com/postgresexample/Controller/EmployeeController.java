package com.postgresexample.Controller;

import com.postgresexample.Model.Employee;
import com.postgresexample.Repository.EmployeesRepository;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

/**
 * Created by jpena on 3/19/2018.
 */

@Controller
@RequestMapping("")
public class EmployeeController {
    @Autowired
    EmployeesRepository employeesRepository;


    @RequestMapping("/")
    public String listCustomers(Model model, HttpServletRequest request){

        model.addAttribute("employees", employeesRepository.findAll());

        return "employees";
    }

    @GetMapping("/new")
    public String newEmployee(Model model, HttpServletRequest request){
        model.addAttribute("employee",new Employee());
        return "new_employee";
    }

    @PostMapping("/save")
    public String saveEmployee(Model model, @ModelAttribute Employee employee, HttpServletRequest request,
                               @RequestParam("picture") MultipartFile file){

        // only do the upload if user selected file to upload
        if (!file.isEmpty()) {
            try {
                //convert file input stream to byte array, so that we can store it into db.
                byte[] bytes = org.apache.commons.io.IOUtils.toByteArray(file.getInputStream());
                employee.setPhotoContentLength(Long.valueOf(file.getSize()).intValue());
                employee.setPhotoContentType(file.getContentType());
                employee.setPhotoBlob(bytes);
            } catch (Exception e) {
                System.out.println("You failed to upload => " + e.getMessage());
            }
        }

        employeesRepository.save(employee);
        model.addAttribute("employees", employeesRepository.findAll());
        return "employees";
    }

    @GetMapping("/edit/{id}")
    public String editCustomer(@PathVariable("id") Integer id, Model model, HttpServletRequest request,
                               HttpServletResponse response) throws UnsupportedEncodingException {

        Employee employee= employeesRepository.findOne(id);
        model.addAttribute("employee",employee);

        return "new_employee";
    }

    // This method allows you to load image from an url like the following
    // http://hostname/workers/photo/1
    // to display as an image in the html file, we can use
    // <img src="http://hostname/workers/photo/1" />
    @RequestMapping("/photo/{idNo}")
    public void download(@PathVariable("idNo") Integer idNo, HttpServletRequest request, HttpServletResponse response) {
        try {

            Employee employee= employeesRepository.findOne(idNo);
            response.setHeader("Content-Disposition", "inline;filename=\"" + employee.getName() + "\"");

            if(employee.getPhotoBlob() == null) {
                // if this worker doesn't have any photo, redirect to a default image.
                response.sendRedirect(request.getContextPath() + "/images/user.png");
            } else {
                // else display the photo by writing the byte array to the response.
                OutputStream out = response.getOutputStream();
                response.setContentType(employee.getPhotoContentType());
                response.setContentLength(employee.getPhotoContentLength());
                IOUtils.copy(new ByteArrayInputStream(employee.getPhotoBlob()), out);

                out.flush();
                out.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
