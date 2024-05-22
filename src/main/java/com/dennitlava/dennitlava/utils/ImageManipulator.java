package com.dennitlava.dennitlava.utils;

import lombok.RequiredArgsConstructor;
import net.coobird.thumbnailator.Thumbnails;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.UUID;

/**
 * <h1> The actual Image Manipulator Class</h1>
 */
@Component
@RequiredArgsConstructor
public class ImageManipulator {

    /**
     * @param image   file to be compressed
     * @param quality quality to be compressed to
     * @param scale   the new image scale
     * @return the compressed file
     */
    public File compress(File image, double quality, double scale) {
        try {
            File output = Files.createTempFile("image","").toFile();
            Thumbnails.of(image)
                    .scale(scale)
                    .outputQuality(quality)
                    .toFile(output);
            return output;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public File compress(MultipartFile image, double quality, double scale) {
        try {
            File output = Files.createTempFile(UUID.randomUUID().toString(), "." + Arrays.stream(image.getOriginalFilename().split("\\.")).reduce((s, s2) -> s2).orElse("")).toFile();
            Thumbnails.of(image.getInputStream())
                    .scale(scale)
                    .outputQuality(quality)
                    .toFile(output);
            return output;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
