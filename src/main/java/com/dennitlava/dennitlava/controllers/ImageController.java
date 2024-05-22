package com.dennitlava.dennitlava.controllers;

import com.dennitlava.dennitlava.dtos.ManipulatorRequestDto;
import com.dennitlava.dennitlava.services.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@RequiredArgsConstructor
@RequestMapping("api/v1")
public class ImageController {
    private final ImageService imageService;

    @PostMapping("image")
    public File compressImage(@RequestParam double quality, @RequestParam double scale, MultipartFile file) {
        return imageService.compressImage(file, quality,scale);
    }
}
