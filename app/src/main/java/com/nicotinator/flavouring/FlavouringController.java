package com.nicotinator.flavouring;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/flavourings")
@RestController
public class FlavouringController {

    @Autowired
    private FlavouringService flavouringService;

    @GetMapping("autocomplete")
    public List<String> getFlavourNameAutocomplete(String term) {
        return flavouringService.getFlavouringNameByAutocomplete(term);
    }
}
