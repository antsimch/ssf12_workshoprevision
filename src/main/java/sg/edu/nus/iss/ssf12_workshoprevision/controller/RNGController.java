package sg.edu.nus.iss.ssf12_workshoprevision.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import sg.edu.nus.iss.ssf12_workshoprevision.model.Constants;
import sg.edu.nus.iss.ssf12_workshoprevision.model.Image;
import sg.edu.nus.iss.ssf12_workshoprevision.service.RNGService;

@Controller
public class RNGController {

    private RNGService service;

    public RNGController (RNGService service) {
        this.service = service;
    }

    @GetMapping(path = "/home")
    public String getLandingPage() {
        return "home";
    }


    @GetMapping(path = "/generate")
    public String getRandomNumber(@RequestParam int number, Model model) {

        if (number < Constants.MIN_VALUE || number >= Constants.MAX_VALUE) {
            String errorMsg = String.format("Number cannot be smaller than %d" + 
                                            "or greater than %d", Constants.MIN_VALUE
                                            , Constants.MAX_VALUE - 1);
            model.addAttribute("error", errorMsg);
            return "home";
        }

        List<Image> images = service.getImages(number);
        model.addAttribute("images", images);

        return "generate";
    }

}
