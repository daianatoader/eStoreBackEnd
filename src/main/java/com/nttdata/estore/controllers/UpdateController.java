package com.nttdata.estore.controllers;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@CrossOrigin
public class UpdateController {
    public static String photoPath = null;

    @PostMapping("/update")
    @ResponseBody
    public String uploadPhoto(@RequestParam("photo") MultipartFile file) {
        // TODO change the path
        final Path rootLocation = Paths.get("D:/Practica/angular-tour-of-heroes/src/app/images");
        if (file.isEmpty()) {
            return "error";
        }
        try {
            Files.copy(file.getInputStream(), rootLocation.resolve(file.getOriginalFilename()));
        } catch (IOException e) {
            return "error";
        }
        photoPath = "app/images/" + file.getOriginalFilename();
        return file.getOriginalFilename();
    }
}
