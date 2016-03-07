package JPA;

import org.junit.*;
import shared.entity.AppDish;
import support.CreatorTestObjects;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Created by cotletkaman on 03.02.16.
 */
public class DaoObjectTest {
    private static EntityManager entityManager;
    private static EntityTransaction transaction;
    private AppDish dish;

    @BeforeClass
    public static void beforeClass(){
        entityManager = Persistence.createEntityManagerFactory("TestPersistJPA").createEntityManager();
    }

    @Before
    public void beforeTest(){
        dish = CreatorTestObjects.getAppDish();
        transaction = entityManager.getTransaction();
    }


    @Test
    public void testCreateObject(){
        transaction.begin();
        entityManager.persist(dish);
        transaction.commit();
        Assert.assertEquals(entityManager.find(AppDish.class , 1L).getDish().getName() , "FooObject");
    }

    @Test
    public void testRemoveObject(){
        transaction.begin();
        AppDish appDish = entityManager.find(AppDish.class , 1L);
        entityManager.remove(appDish);
        transaction.commit();

        Assert.assertNull(entityManager.find(AppDish.class , 1L));
    }

    @AfterClass
    public static void afterClass(){
        entityManager.close();
    }
}
