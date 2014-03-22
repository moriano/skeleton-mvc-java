package org.moriano.skeleton.mock;

import org.moriano.skeleton.model.God;

import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: moriano
 * Date: 16/09/13
 * Time: 11:32 AM
 * To change this template use File | Settings | File Templates.
 */
public enum GodMock  {

    ODIN(new God(1, "Odin", 50)),
    THOR(new God(2, "Thor", 25)),
    LOKI(new God(3, "Loki", 28));

    private God god;

    private GodMock(God god) {
        this.god = god;
    }

    public God getGod() {
        return this.god;
    }

    public static List<God> allGods() {
        return Arrays.asList(new God[]{ODIN.getGod(), THOR.getGod(), LOKI.getGod()});
    }


}
