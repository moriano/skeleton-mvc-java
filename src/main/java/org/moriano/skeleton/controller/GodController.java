package org.moriano.skeleton.controller;

import org.moriano.skeleton.model.God;
import org.moriano.skeleton.service.GodService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/god")
public class GodController {

    @Autowired
    private GodService godService;

    private static final ObjectMapper jsonMapper = new ObjectMapper();

    @RequestMapping(value = "/list", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public String list() throws Exception {
        List<God> allGods = this.godService.getAll();
        String json = jsonMapper.writeValueAsString(allGods);
        return json;
    }

    /**
     * Sample of using the GET request using the parameter as part of the url
     *
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public String get(@PathVariable int id) throws Exception {

        God god = this.godService.getById(id);
        String json = jsonMapper.writeValueAsString(god);

        return json;
    }

    @RequestMapping(value = "/get", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public String getByName(String name) throws Exception {
        List<God> gods = this.godService.search(name);
        String json = jsonMapper.writeValueAsString(gods);
        return json;
    }

    @RequestMapping(value = "/save/", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public String save(int age, String name) throws Exception {
        this.godService.save(name, age);
        String json = jsonMapper.writeValueAsString("Fine");
        return json;
    }
}