package com.dennitlava.dennitlava;

import org.springframework.http.MediaType;
import org.springframework.lang.NonNull;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.Arrays;

public class TestUtils {

    public static File getTestFile() {
        return new File("testFile.jpg");
    }

    public static MultipartFile getMultipartTestFile() {

        File _file = TestUtils.getTestFile();
        return new MultipartFile() {
            @Override
            @NonNull
            public String getName() {
                return Arrays.stream(_file.getAbsolutePath().split("/")).reduce((s, s2) -> s2).get();
            }

            @Override
            public String getOriginalFilename() {
                return Arrays.stream(_file.getAbsolutePath().split("/")).reduce((s, s2) -> s2).get();
            }

            @Override
            public String getContentType() {
                return MediaType.IMAGE_JPEG_VALUE;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public long getSize() {
                return _file.length();
            }

            @Override
            @NonNull
            public byte[] getBytes() throws IOException {
                return Files.readAllBytes(_file.toPath());
            }

            @Override
            @NonNull
            public InputStream getInputStream() throws IOException {
                return Files.newInputStream(_file.toPath());
            }

            @Override
            public void transferTo(@NonNull File dest) throws IOException, IllegalStateException {
                FileCopyUtils.copy(getInputStream(), Files.newOutputStream(dest.toPath()));
            }

        };
    }
}
