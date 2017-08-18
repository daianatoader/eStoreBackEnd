package com.nttdata.estore.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@CrossOrigin
public class UpdateController {
    public static String photoPath = null;

    @Value("${frontend.resources.folder}")
    private String resourcesLocation;

    @Value("${app.images}")
    private String appImages;

    @PostMapping("/update")
    @ResponseBody
    public String uploadPhoto(@RequestParam("photo") MultipartFile file) {
        final Path rootLocation = Paths.get(resourcesLocation + appImages);
        if (file.isEmpty()) {
            return "error";
        }
        try {
            Files.copy(file.getInputStream(), rootLocation.resolve(file.getOriginalFilename()));
        } catch (IOException e) {
            return "error";
        }
        photoPath = appImages + file.getOriginalFilename();
        return file.getOriginalFilename();
    }
}
