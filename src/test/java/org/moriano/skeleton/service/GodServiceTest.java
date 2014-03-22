package org.moriano.skeleton.service;

import org.junit.Before;
import org.moriano.skeleton.dao.GodDAO;
import org.moriano.skeleton.mock.GodMock;
import org.moriano.skeleton.model.God;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kubek2k.springockito.annotations.ReplaceWithMock;
import org.kubek2k.springockito.annotations.SpringockitoContextLoader;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 * User: moriano
 * Date: 16/09/13
 * Time: 2:56 PM
 * To change this template use File | Settings | File Templates.
 */

@ContextConfiguration(loader = SpringockitoContextLoader.class, locations = "classpath:test-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class GodServiceTest {

    @Autowired
    @InjectMocks
    private GodService godService;

    @ReplaceWithMock
    @Autowired
    private GodDAO godDAO;



    @Test
    public void getAll() {
        List<God> allGods = GodMock.allGods();
        when(this.godDAO.getAll()).thenReturn(allGods);
        List<God> myGods = this.godService.getAll();

        assertEquals(myGods, allGods);
    }

    @Test
    public void getById() {
        God thor = GodMock.THOR.getGod();
        when(this.godDAO.getById(thor.getId())).thenReturn(thor);

        God found = this.godDAO.getById(thor.getId());

        assertEquals(thor, found);
    }

    @Test
    public void searchByAge(){
        God odin = GodMock.ODIN.getGod();
        when(this.godDAO.getByAge(odin.getAge())).thenReturn(Arrays.asList(new God[]{odin}));
        List<God> found = this.godDAO.getByAge(odin.getAge());

        assertEquals(found.get(0), odin);


    }

    @Test(expected = IllegalArgumentException.class)
    public void searchByAge_InvalidAge(){
        God loki = GodMock.LOKI.getGod();
        when(this.godDAO.getByAge(loki.getAge())).thenThrow(new IllegalArgumentException("Norrrrl"));
        List<God> found = this.godDAO.getByAge(loki.getAge());

        assertEquals(found.get(0), loki);


    }




}
