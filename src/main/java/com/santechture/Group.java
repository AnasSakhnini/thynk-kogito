package com.santechture;

import java.util.List;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import jakarta.persistence.*;

@Entity(name = "groups")
public class Group extends PanacheEntity {
    //    @Id
    //    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    //    @Column(name = "id", nullable = false)
    //    private Integer id;
    @Column(name = "type")
    private String type;
    @Column(name = "name")
    private String name;
    @OneToMany(targetEntity = GroupChildren.class, mappedBy = "group")
    private List<GroupChildren> children;
    @OneToMany(targetEntity = GroupRange.class, mappedBy = "group")
    private List<GroupRange> ranges;

    public List<GroupChildren> getChildren() {
        return children;
    }

    public void setChildren(List<GroupChildren> children) {
        this.children = children;
    }

    public Group() {
    }

    public Group(String type, String name) {
        this.type = type;
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<GroupRange> getRanges() {
        return ranges;
    }

    public void setRanges(List<GroupRange> ranges) {
        this.ranges = ranges;
    }



}
