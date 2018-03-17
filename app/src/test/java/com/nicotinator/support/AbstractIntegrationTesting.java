package com.nicotinator.support;


import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AbstractIntegrationTesting extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    private EntityManager entityManager;

    @After
    public void tearDown() {
        entityManager.flush();
    }

    protected EntityManager getEntityManager() {
        return this.entityManager;
    }
}
