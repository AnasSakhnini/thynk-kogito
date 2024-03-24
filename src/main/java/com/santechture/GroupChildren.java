package com.santechture;

import jakarta.persistence.*;

@Entity(name = "groups_children")
public class GroupChildren {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Integer id;
    @ManyToOne(targetEntity = Group.class)
    @JoinColumn(name = "group_id")
    private Group group;
    @OneToOne(targetEntity = Group.class)
    @JoinColumn(name = "child_id")
    private Group child;

    public GroupChildren() {
    }

    public GroupChildren(Integer id, Group group, Group child) {
        this.id = id;
        this.group = group;
        this.child = child;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Group getChild() {
        return child;
    }

    public void setChild(Group child) {
        this.child = child;
    }
}
