package edu.miu.cs.cs425.sahid.mystudentmgmtapp.service;

import edu.miu.cs.cs425.sahid.mystudentmgmtapp.model.Classroom;
import edu.miu.cs.cs425.sahid.mystudentmgmtapp.model.Transcript;

import java.util.List;

public interface TranscriptService {
    Transcript saveTranscript(Transcript transcript);
    List<Transcript> getAllTranscripts();
    Transcript updateTranscript(Transcript transcript);
}
