package com.hr.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class StagesOfWorkWithCandidate {
    @Id
    private Long id;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "stagesOfWorkWithCandidate_selectionStages",
            joinColumns = @JoinColumn(name = "stagesOfWorkWithCandidate_id"),
            inverseJoinColumns = @JoinColumn(name = "selectionStages_id"))
    private Set<SelectionStages> selectionStagesSet = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "stagesOfWorkWithCandidates_candidates",
            joinColumns = @JoinColumn(name = "stagesOfWorkWithCandidate_id"),
            inverseJoinColumns = @JoinColumn(name = "candidate_id"))
    private Set<Candidate> candidateSet = new HashSet<>();

    @Column(length = 10)
    private String typeOfInteraction;
    @Column(length = 25)
    private String whatIsDone;
    @Column(length = 25)
    private String result;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<SelectionStages> getSelectionStagesSet() {
        return selectionStagesSet;
    }

    public void setSelectionStagesSet(Set<SelectionStages> selectionStagesSet) {
        this.selectionStagesSet = selectionStagesSet;
    }

    public Set<Candidate> getCandidateSet() {
        return candidateSet;
    }

    public void setCandidateSet(Set<Candidate> candidateSet) {
        this.candidateSet = candidateSet;
    }

    public String getTypeOfInteraction() {
        return typeOfInteraction;
    }

    public void setTypeOfInteraction(String typeOfInteraction) {
        this.typeOfInteraction = typeOfInteraction;
    }

    public String getWhatIsDone() {
        return whatIsDone;
    }

    public void setWhatIsDone(String whatIsDone) {
        this.whatIsDone = whatIsDone;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}