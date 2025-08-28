package za.ac.cput.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Gig;

import java.util.List;
import java.util.Optional;

@Repository
public interface GigRepository extends JpaRepository<Gig, Long> {

    Gig save(Gig gig);

    Optional<Gig> findById(Long gigId);

    void deleteById(Long gigId);

    List<Gig> findAll();
}
