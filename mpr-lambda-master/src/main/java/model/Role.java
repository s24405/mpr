package model;

import java.util.List;

public class Role {

    private String name;
    List<Permission> permissions;

    public String getName() {
        return name;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }
}
