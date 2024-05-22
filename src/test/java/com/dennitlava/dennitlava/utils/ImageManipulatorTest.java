package com.dennitlava.dennitlava.utils;

import com.dennitlava.dennitlava.TestUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.lang.NonNull;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ImageManipulatorTest {
    ImageManipulator imageManipulator = new ImageManipulator();

    @Test
    void compress() {
        File file = TestUtils.getTestFile();
        File file2 = imageManipulator.compress(file, 0.3, 0.8);
        Assertions.assertTrue(file.length() > 0, "supplied file is empty");
        Assertions.assertTrue(file2.length() > 0, "returned file is empty");
        Assertions.assertTrue(file.length() > file2.length(), "File Not Compressed Properly");
    }

    @Test
    void testCompress() {
        MultipartFile file = TestUtils.getMultipartTestFile();
        File file2 = imageManipulator.compress(file, 0.3, 0.8);
        Assertions.assertTrue(file.getSize() > 0, "supplied file is empty");
        Assertions.assertTrue(file2.length() > 0, "returned file is empty");
        Assertions.assertTrue(file.getSize() > file2.length(), "File Not Compressed Properly");
    }
}