package com.nttdata.estore.controllers;

import com.nttdata.estore.entities.Brand;
import com.nttdata.estore.services.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;

import static com.nttdata.estore.controllers.UpdateController.photoPath;

@RestController
@CrossOrigin
public class BrandController {

    @Autowired
    private BrandService brandService;

    @Value("${frontend.resources.folder}")
    private String resourcesLocation;

    @GetMapping(path = "/brands")
    public @ResponseBody
    Iterable<Brand> getAllBrands() {
        return brandService.getAllBrands();
    }

    @GetMapping("/brands/{id}")
    public ResponseEntity getBrand(@PathVariable("id") int id) {
        Brand brand = brandService.getBrand(id);
        if (brand == null) {
            return new ResponseEntity("No Customer found for ID " + id, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(brand, HttpStatus.OK);
    }

    @PostMapping("/brands")
    public ResponseEntity add(@RequestBody Brand brand) {
        brandService.saveOrUpdateBrand(brand);
        return new ResponseEntity(brand, HttpStatus.OK);
    }

    @PutMapping("/brands/{id}")
    public ResponseEntity update(@PathVariable("id") int id, @RequestBody Brand brand) {
        Brand oldBrand = brandService.getBrand(id);
        if (oldBrand.getPhotoPath() != null) {
            deleteFileFromDisk(oldBrand.getPhotoPath());
        }
        brand.setPhotoPath(photoPath);
        if (null == oldBrand) {
            return new ResponseEntity("No Brand found", HttpStatus.NOT_FOUND);
        }
        oldBrand = brand;
        brandService.saveOrUpdateBrand(oldBrand);
        return new ResponseEntity(oldBrand, HttpStatus.OK);
    }

    @DeleteMapping("/brands/{id}")
    public ResponseEntity delete(@PathVariable("id") int id) {
        if (null == getBrand(id)) {
            return new ResponseEntity("No Brand found", HttpStatus.NOT_FOUND);
        }
        deleteFileFromDisk(brandService.getBrand(id).getPhotoPath());
        brandService.deleteBrand(id);
        return new ResponseEntity(id, HttpStatus.OK);
    }

    private void deleteFileFromDisk(String filePath) {
        File file = new File(resourcesLocation + filePath);
        if (file.exists())
            file.delete();
    }

}
