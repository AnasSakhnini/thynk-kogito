package com.santechture;

import jakarta.persistence.*;

import java.util.List;

@Entity(name = "groups_ranges")
public class GroupRange {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "from")
    private String codeFrom;
    @Column(name = "to")
    private String codeTo;
    @ManyToOne(targetEntity = Group.class)
    @JoinColumn(name = "group_id")
    private Group group;

    public boolean containsCode(String sCode) {
        if (sCode.equalsIgnoreCase(codeFrom)) {
            return true;
        }
        if (codeTo != null && !codeTo.isEmpty()) {
            return sCode.compareToIgnoreCase(codeFrom) >= 0 && sCode.compareToIgnoreCase(codeTo) <= 0;
        }
        return false;
    }
    public boolean containsAnyCode(List<String> array) {
        for (String sCode: array){
            if(containsCode(sCode)) return true;
        }
        return false;
    }

    public GroupRange(Integer id, String codeFrom, String codeTo, Group group) {
        this.id = id;
        this.codeFrom = codeFrom;
        this.codeTo = codeTo;
        this.group = group;
    }

    public GroupRange() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodeFrom() {
        return codeFrom;
    }

    public void setCodeFrom(String codeFrom) {
        this.codeFrom = codeFrom;
    }

    public String getCodeTo() {
        return codeTo;
    }

    public void setCodeTo(String codeTo) {
        this.codeTo = codeTo;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}
