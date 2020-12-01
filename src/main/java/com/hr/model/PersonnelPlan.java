package com.hr.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "personal_plan")
public class PersonnelPlan {
    @Id
    private Long id;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "personal_plans_branches",
            joinColumns = @JoinColumn(name = "personal_plan_id"),
            inverseJoinColumns = @JoinColumn(name = "branch_id"))
    private Set<Branch> branchSet = new HashSet<>();

    private short maxQuantity;
    private short quantity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Branch> getBranchSet() {
        return branchSet;
    }

    public void setBranchSet(Set<Branch> branchSet) {
        this.branchSet = branchSet;
    }

    public short getMaxQuantity() {
        return maxQuantity;
    }

    public void setMaxQuantity(short maxQuantity) {
        this.maxQuantity = maxQuantity;
    }

    public short getQuantity() {
        return quantity;
    }

    public void setQuantity(short quantity) {
        this.quantity = quantity;
    }
}
