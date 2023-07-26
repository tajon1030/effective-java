package org.example.chapter2.Item17;

import java.util.ArrayList;
import java.util.List;

public class StablePerson {

    private final String name;
    private final List<CanModify> canModifies;

    public StablePerson(final String name, final List<CanModify> canModifies) {
        this.name = name;
        this.canModifies = new ArrayList<>(canModifies);
    }

    public String name() {
        return name;
    }

    public List<CanModify> canModifies() {
        return new ArrayList<>(canModifies);
    }
}
