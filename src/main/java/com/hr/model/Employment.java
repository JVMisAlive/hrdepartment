package com.hr.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "employment")
public class Employment {
    @Id
    private Long id;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "employments_candidates",
            joinColumns = @JoinColumn(name = "employment_id"),
            inverseJoinColumns = @JoinColumn(name = "candidate_id"))
    private Set<Candidate> candidateSet = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "employments_personnel_plans",
            joinColumns = @JoinColumn(name = "employment_id"),
            inverseJoinColumns = @JoinColumn(name = "personnel_plan_id"))
    private Set<PersonnelPlan> personnelPlanSet = new HashSet<>();

    private LocalDate date;

    private String comment;
    private short quantity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Candidate> getCandidateSet() {
        return candidateSet;
    }

    public void setCandidateSet(Set<Candidate> candidateSet) {
        this.candidateSet = candidateSet;
    }

    public Set<PersonnelPlan> getPersonnelPlanSet() {
        return personnelPlanSet;
    }

    public void setPersonnelPlanSet(Set<PersonnelPlan> personnelPlanSet) {
        this.personnelPlanSet = personnelPlanSet;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public short getQuantity() {
        return quantity;
    }

    public void setQuantity(short quantity) {
        this.quantity = quantity;
    }
}
