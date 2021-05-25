/*   Created by IntelliJ IDEA.
 *   Author: Devvrat Sharma (devrats)
 *   Date: 5/24/2021
 *   Time: 9:04 PM
 *   File: Hand.java
 */

package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

@Controller
public class Hand {
    @RequestMapping("/home")
    public String home(){
        return "home";
    }

    @RequestMapping("/submit")
    public String map(@RequestParam("file")MultipartFile file){
        System.out.println(file.getContentType());
        System.out.println(file.getSize());
        System.out.println(file.getName());
        String path = "D:\\" + file.getOriginalFilename();
        try {
            byte[] file1 = file.getBytes();
            FileOutputStream fileOutputStream = new FileOutputStream(path);
            fileOutputStream.write(file1);
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "success";
    }
}