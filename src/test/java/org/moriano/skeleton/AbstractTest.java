package org.moriano.skeleton;

import org.moriano.skeleton.mock.GodMock;
import org.moriano.skeleton.model.God;

import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: moriano
 * Date: 16/09/13
 * Time: 3:02 PM
 * To change this template use File | Settings | File Templates.
 */
public class AbstractTest {

    private List<God> godList;

    public AbstractTest() {
        this.godList = Arrays.asList(new God[]{GodMock.LOKI.getGod(), GodMock.ODIN.getGod(), GodMock.THOR.getGod()});
    }
}
