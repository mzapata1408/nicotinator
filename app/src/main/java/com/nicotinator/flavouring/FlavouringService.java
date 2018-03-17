package com.nicotinator.flavouring;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nicotinator.common.text.Like;
import com.nicotinator.common.validation.InvalidArgumentProvided;
import com.nicotinator.common.validation.Validate;
import com.nicotinator.common.validation.ValidateString;

@Service
public class FlavouringService {

    private static final InvalidArgumentProvided INVALID_TERM_MESSAGE = new InvalidArgumentProvided("term");

    @Autowired
    private FlavouringRepository flavouringRepository;

    public List<String> getFlavouringNameByAutocomplete(String term) {
        Validate.notNull(term, INVALID_TERM_MESSAGE);
        ValidateString.notEmpty(term, INVALID_TERM_MESSAGE);

        List<Flavouring> flavourings = flavouringRepository.findByNameLike(Like.contains(term));

        return getNames(flavourings);
    }

    private List<String> getNames(List<Flavouring> flavourings) {

        List<String> names = new ArrayList<>();

        for (Flavouring flavouring : flavourings) {
            names.add(flavouring.getName());
        }

        return names;
    }
}
