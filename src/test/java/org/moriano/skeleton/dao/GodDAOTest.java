package org.moriano.skeleton.dao;

import org.moriano.skeleton.mock.GodMock;
import org.moriano.skeleton.model.God;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 * User: moriano
 * Date: 16/09/13
 * Time: 10:28 AM
 * To change this template use File | Settings | File Templates.
 */
@ContextConfiguration(locations = "classpath:test-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class GodDAOTest {

    @Autowired
    private GodDAO godDAO;

    @Test
    public void getAll() {
        List<God> gods = this.godDAO.getAll();
        assertNotNull(gods);
        assertTrue(gods.size() > 0);
    }

    @Test
    public void getById() {
        God god = this.godDAO.getById(GodMock.LOKI.getGod().getId());
        assertEquals(god, GodMock.LOKI.getGod());
    }

    @Test
    public void getByAge() {
        List<God> gods = this.godDAO.getByAge(GodMock.ODIN.getGod().getAge());
        assertNotNull(gods);
        assertTrue(gods.size() == 1);
        assertEquals(gods.get(0), GodMock.ODIN.getGod());
    }

    @Test
    public void getNames() {
        List<String> gods = this.godDAO.getNames(GodMock.THOR.getGod().getId());
        assertNotNull(gods);
        assertTrue(gods.size() == 1);
        assertEquals(gods.get(0), GodMock.THOR.getGod().getName());
    }

    @DirtiesContext
    @Test
    public void delete() {
        List<God> allGods = this.godDAO.getAll();
        this.godDAO.delete(GodMock.LOKI.getGod().getId());
        List<God> remainingGods = this.godDAO.getAll();

        assertTrue(allGods.size() > remainingGods.size());
        assertFalse(remainingGods.contains(GodMock.LOKI.getGod()));
    }

    @Test
    public void save() {
        List<God> oldGodsNames = this.godDAO.getAll();
        for(God god : oldGodsNames) {
            assertFalse(god.getName().equals("Zeus"));
        }

        this.godDAO.save(65, "Zeus");
        List<God> newGods = this.godDAO.getAll();
        boolean found = false;

        for(God god : newGods) {
            if(god.getName().equals("Zeus")) {
                found = true;
                break;
            }
        }

        assertTrue(found);


    }




}
