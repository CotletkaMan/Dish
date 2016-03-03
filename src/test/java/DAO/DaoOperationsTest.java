package DAO;

import org.junit.*;
import server.DAOoperations.CRUDinterface;
import shared.entity.AppDish;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.naming.NamingException;

/**
 * Created by cotletkaman on 03.02.16.
 */
@Ignore
public class DaoOperationsTest {
    private static EJBContainer container;
    private static Context context;
    private CRUDinterface<AppDish> dishCRUDinterface;

    @BeforeClass
    public static void setUpClass() throws NamingException{
        container = EJBContainer.createEJBContainer();
        context = container.getContext();
    }

    @Before
    public void setUp() throws Exception{
     //   dishCRUDinterface = (CRUDinterface<AppDish>)context.lookup("java:global/classes/server/DAOoperations/AppDishOperaion/AppDishCRUDImpl");
    }

    @Test
    public void testCreateObject(){
       /* AppDish dish = CreatorTestObjects.getAppDish();
        dishCRUDinterface.create(dish);*/
    }

    @AfterClass
    public static void tearDownClass() throws NamingException{
        container.close();
    }
}
