package edu.miu.cs.cs425.sahid.mystudentmgmtapp.model;

import jakarta.persistence.*;

@Entity
public class Transcript {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transcriptId;

    private String degreeTitle;

    @OneToOne(mappedBy = "transcript") // Bi-directional mapping
    private Student student;

    public Transcript() {}

    public Transcript(String degreeTitle) {
        this.degreeTitle = degreeTitle;
    }

    public Long getTranscriptId() {
        return transcriptId;
    }

    public void setTranscriptId(Long transcriptId) {
        this.transcriptId = transcriptId;
    }

    public String getDegreeTitle() {
        return degreeTitle;
    }

    public void setDegreeTitle(String degreeTitle) {
        this.degreeTitle = degreeTitle;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}

