package com.learn.springboot.sblessons.springdata.image;

import com.learn.springboot.sblessons.springdata.file.Image;
import com.learn.springboot.sblessons.springdata.file.ImageRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.*;

@SpringBootTest
public class ImageTest {

    @Autowired
    ImageRepository imageRepository;

    @Test
    public void testFileSave() throws IOException {
        Image image = new Image();
        image.setId((long) 2);

        File file =new File("c:/temp/PH02053J.JPG");
        image.setName(file.getName());

        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] bytes = new byte[(int)file.length()];
        fileInputStream.read(bytes);
        fileInputStream.close();
        image.setData(bytes);
        imageRepository.save(image);
        
    }

    @Test
    public void testReadImage() throws FileNotFoundException {
        File file = new File("c:/temp/test1.jpg");
        try (FileOutputStream fos = new FileOutputStream(file)) {
            Image image = imageRepository.findById(1L).get();
            fos.write(image.getData());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
