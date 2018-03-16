package com.nicotinator.flavour;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.nicotinator.common.autocomplete.Autocomplete;

@RunWith(MockitoJUnitRunner.class)
public class FlavourServiceGetFlavourNameAutocompleteShould {

    @Mock
    private FlavourRepository flavourRepository;
    @InjectMocks
    private FlavourService service = new FlavourService();

    @Test
    public void callRepositoryPassingTheTerm() {

        String term = "rasp";

        Autocomplete<String> result = service.getFlavourNameAutocomplete(term);

        Mockito.verify(flavourRepository).findByAutocomplete(term);
    }
}