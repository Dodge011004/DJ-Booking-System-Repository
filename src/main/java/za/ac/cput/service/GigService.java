package za.ac.cput.service;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Gig;
import za.ac.cput.repository.GigRepository;

import java.util.List;
import java.util.Optional;

@Service
public class GigService {

    private final GigRepository repository;

    public GigService(GigRepository repository) {
        this.repository = repository;
    }

    public Gig create(Gig gig) {
        return repository.save(gig);
    }

    public Optional<Gig> read(Long id) {
        return repository.findById(id);
    }

    public List<Gig> getAll() {
        return repository.findAll();
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
