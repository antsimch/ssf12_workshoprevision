package sg.edu.nus.iss.ssf12_workshoprevision.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

import sg.edu.nus.iss.ssf12_workshoprevision.model.Constants;
import sg.edu.nus.iss.ssf12_workshoprevision.model.Image;

@Service
public class RNGService {

    public List<Image> getImages(int num) {

        List<Image> images = new ArrayList<>();
        List<Integer> numbers = generateRandomNumbers(num);

        for (int number : numbers) {
            Image image = new Image();
            image.setName(Integer.toString(number));
            image.setFilePath(String.format("/images/%d.png", number));
            images.add(image);
        }

        System.out.println(images);
        return images;
    }

    public List<Integer> generateRandomNumbers(int num) {

        Random r = new Random();
        List<Integer> randomNumbers = new ArrayList<>();
        
        while (randomNumbers.size() < num) {         
            int temp = r.nextInt(Constants.MIN_VALUE, Constants.MAX_VALUE);
            
            if (!randomNumbers.contains(temp))
                randomNumbers.add(temp);
        }

        return randomNumbers;
    }
}
