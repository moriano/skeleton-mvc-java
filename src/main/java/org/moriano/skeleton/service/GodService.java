package org.moriano.skeleton.service;

import org.moriano.skeleton.dao.GodDAO;
import org.moriano.skeleton.model.God;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: moriano
 * Date: 16/09/13
 * Time: 9:38 AM
 * To change this template use File | Settings | File Templates.
 */
public class GodService {

    private GodDAO godDAO;

    public void setGodDAO(GodDAO godDAO) {
        this.godDAO = godDAO;
    }

    public List<God> getAll() {
        return this.godDAO.getAll();
    }

    public God getById(int id) {
        return this.godDAO.getById(id);
    }

    public void save(String name, int age) {
        this.godDAO.save(age, name);
    }

    public List<God> search(int age) throws IllegalArgumentException {
        if(age < 0) {
            throw new IllegalArgumentException("Age cannot be negative, provided age was " + age);
        }
        return this.godDAO.getByAge(age);
    }

    public List<God> search(String name) {
        return this.godDAO.getByName(name);
    }
}
