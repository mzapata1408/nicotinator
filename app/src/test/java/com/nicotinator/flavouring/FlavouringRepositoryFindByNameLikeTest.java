package com.nicotinator.flavouring;

import static org.hamcrest.Matchers.hasItem;
import static org.junit.Assert.assertThat;

import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.nicotinator.support.AbstractIntegrationTesting;

public class FlavouringRepositoryFindByNameLikeTest extends AbstractIntegrationTesting {

    @Autowired
    private FlavouringRepository repository;

    private Flavouring coconutFlavouring;

    @Before
    public void setUp() {
        repository.deleteAll();
        getEntityManager().flush();

        coconutFlavouring = new Flavouring("Coconut123456789");
        repository.save(coconutFlavouring);
    }

    @Test
    public void shouldFindFlavoursByLikeQuery() {

        List<Flavouring> flavourings = repository.findByNameLike("%oconut123456789");

        assertThat(flavourings, hasItem(coconutFlavouring));
    }

    @Test
    public void shouldFindIgnoringCase() {

        List<Flavouring> flavourings = repository.findByNameLike("cOcOnut123456789");

        assertThat(flavourings, hasItem(coconutFlavouring));
    }
}