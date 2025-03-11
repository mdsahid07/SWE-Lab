package edu.miu.cs.cs425.sahid.mystudentmgmtapp.service.impl;

import edu.miu.cs.cs425.sahid.mystudentmgmtapp.model.Transcript;
import edu.miu.cs.cs425.sahid.mystudentmgmtapp.repository.TranscriptRepository;
import edu.miu.cs.cs425.sahid.mystudentmgmtapp.service.TranscriptService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class TranscriptServiceimpl implements TranscriptService {
    private final TranscriptRepository transcriptRepository;

    public TranscriptServiceimpl(TranscriptRepository transcriptRepository) {
        this.transcriptRepository = transcriptRepository;
    }

    @Override
    public Transcript saveTranscript(Transcript transcript) {
        return transcriptRepository.save(transcript);
    }

    @Override
    public List<Transcript> getAllTranscripts() {
        return List.of();
    }

    @Override
    public Transcript updateTranscript(Transcript transcript) {
        return null;
    }
}
