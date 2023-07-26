package org.example.chapter2.Item17;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RealStablePerson {

    private final String name;
    private final List<StableCanModify> canModifies;

    public RealStablePerson(final String name, final List<StableCanModify> canModifies) {
        this.name = name;
        this.canModifies = canModifies.stream()
                .map(StableCanModify::new)
                .collect(Collectors.toList());
    }

    public String name() {
        return name;
    }

    public List<StableCanModify> canModifies() {
        return canModifies.stream()
                .map(StableCanModify::new)
                .collect(Collectors.toList());
    }}
