package com.nicotinator.home;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nicotinator.flavouring.FlavouringService;

@RequestMapping("/home")
@RestController
public class HomeController {

    @Autowired
    private FlavouringService flavouringService;

    @GetMapping("greetings")
    public List<String> getFlavourNameAutocomplete(String term) {
        return flavouringService.getFlavouringNameByAutocomplete(term);
    }
}
