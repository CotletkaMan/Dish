package DAO;

import org.junit.*;
import support.CreatorTestObjects;
import server.DAOoperations.CRUDinterface;
import shared.entity.AppDish;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.naming.NamingException;
import java.util.HashMap;
import java.util.Map;
import java.io.File;

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
        Map properties = new HashMap();
        properties.put(EJBContainer.MODULES, new File[]{new File("target/classes"), new File("target/test-classes")});
        container = EJBContainer.createEJBContainer(properties);
        context = container.getContext();
    }

    @Before
    public void setUp() throws Exception{
        Object rawObject = context.lookup("java:global/classes/server.DAOoperations.AppDishOperaion.AppDishDaoImpl");
        dishCRUDinterface = (CRUDinterface<AppDish>)rawObject;
    }

    public void testCreateObject(){
        AppDish dish = CreatorTestObjects.getAppDish();
        dishCRUDinterface.create(dish);
    }

    @AfterClass
    public static void tearDownClass() throws NamingException{
        container.close();
    }
}
