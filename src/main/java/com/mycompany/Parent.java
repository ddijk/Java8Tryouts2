package com.mycompany;

import java.util.List;

/**
 * Created by dickdijk on 21/11/16.
 */
public class Parent {

    String name;

    List<Child> children;

    public Parent(String name, List<Child> children) {
        this.name = name;
        this.children = children;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Child> getChildren() {
        return children;
    }

    public void setChildren(List<Child> children) {
        this.children = children;
    }
}

class  Child {
    String name;

    public Child(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
