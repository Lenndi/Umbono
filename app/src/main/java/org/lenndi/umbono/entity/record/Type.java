package org.lenndi.umbono.entity.record;

import java.util.ArrayList;
import java.util.List;

/**
 * Type entity.
 */
public class Type {

    private List<String> types;

    /**
     * Instantiates a new Type.
     */
    public Type() {
        this.types = new ArrayList<>();
    }

    /**
     * Gets types.
     *
     * @return the types
     */
    public List<String> getTypes() {
        return types;
    }

    /**
     * Sets types.
     *
     * @param types the types
     */
    public void setTypes(List<String> types) {
        this.types = types;
    }

    /**
     * Add type.
     *
     * @param type the type
     */
    public void addType(String type) {
        this.types.add(type);
    }
}
