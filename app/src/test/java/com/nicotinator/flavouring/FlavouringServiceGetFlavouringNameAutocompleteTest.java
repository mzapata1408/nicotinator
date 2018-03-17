package com.nicotinator.flavouring;

import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.nicotinator.common.text.Like;
import com.nicotinator.common.validation.InvalidArgumentProvided;

@RunWith(MockitoJUnitRunner.class)
public class FlavouringServiceGetFlavouringNameAutocompleteTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();
    @Mock
    private FlavouringRepository flavouringRepository;
    @InjectMocks
    private FlavouringService service = new FlavouringService();

    @Test
    public void shouldPassTermWithAddedLikeCriteriaToRepository() {

        String term = "coco";
        String expected = "%coco%";

        service.getFlavouringNameByAutocomplete(term);

        Mockito.verify(flavouringRepository).findByNameLike(expected);
    }

    @Test
    public void shouldReturnListOfNamesFromFlavours() {

        Flavouring cocoaFlavouring = new Flavouring("Cocoa");
        Flavouring coconutFlavouring = new Flavouring("Coconut");
        String term = "Coco";
        when(flavouringRepository.findByNameLike(Like.contains(term))).thenReturn(Arrays.asList(cocoaFlavouring, coconutFlavouring));

        List<String> flavours = service.getFlavouringNameByAutocomplete(term);

        assertThat(flavours, hasSize(2));
        assertThat(flavours, hasItems(cocoaFlavouring.getName(), coconutFlavouring.getName()));
    }

    @Test
    public void shouldThrowErrorWhenTermIsNull() {

        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage(InvalidArgumentProvided.of("term").get());

        String nullTerm = null;

        service.getFlavouringNameByAutocomplete(nullTerm);
    }

    @Test
    public void shouldThrowErrorWhenTermIsBlankString() {

        thrown.expectMessage(InvalidArgumentProvided.of("term").get());
        thrown.expect(IllegalArgumentException.class);

        String blankTerm = " ";

        service.getFlavouringNameByAutocomplete(blankTerm);
    }
}