package com.dennitlava.dennitlava.services;

import com.dennitlava.dennitlava.utils.ImageManipulator;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Service
@RequiredArgsConstructor
public class ImageService {
    private final ImageManipulator imageManipulator;

    public File compressImage(@NonNull MultipartFile file, double quality, double scale) {
        return imageManipulator.compress(file, quality, scale);
    }
}
