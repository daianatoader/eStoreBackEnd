package com.nttdata.estore.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@CrossOrigin
public class UpdateController {

    @PostMapping("/update")
    public ResponseEntity<?> uploadPhoto(@RequestParam("photo") MultipartFile file) {
        final Path rootLocation = Paths.get("D:/Practica/angular-tour-of-heroes/src/app/images");
        if (file.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        String returnPath = null;
        try {
            Files.copy(file.getInputStream(), rootLocation.resolve(file.getOriginalFilename()));


        } catch (IOException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        //TODO return picture name
        return new ResponseEntity<String>("abc", HttpStatus.OK);
    }
}
