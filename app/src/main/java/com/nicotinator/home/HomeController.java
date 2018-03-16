package com.nicotinator.home;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nicotinator.common.autocomplete.Autocomplete;
import com.nicotinator.flavour.FlavourService;

@RequestMapping("/home")
@RestController
public class HomeController {

    private FlavourService flavourService;

    @GetMapping("greetings")
    public Autocomplete<String> getFlavourNameAutocomplete(String term) {
        return flavourService.getFlavourNameAutocomplete(term);
    }
}
