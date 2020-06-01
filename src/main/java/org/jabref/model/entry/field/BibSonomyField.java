package org.jabref.model.entry.field;

import java.util.Collections;
import java.util.Set;

public enum BibSonomyField implements Field {

    DESCRIPTION("description"),
    INTERHASH("interhash"),
    INTRAHASH("intrahash"),
    USERNAME("username");

    private final String name;

    BibSonomyField(String name) {
        this.name = name;
    }

    @Override
    public Set<FieldProperty> getProperties() {
        return Collections.emptySet(); //TODO
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public boolean isStandardField() {
        return false;
    }
}
