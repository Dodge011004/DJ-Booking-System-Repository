package za.ac.cput.controller;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Gig;
import za.ac.cput.service.GigService;

import java.util.List;

@RestController
@RequestMapping("/api/gigs")
public class GigController {

    private final GigService service;

    public GigController(GigService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Gig> create(@RequestBody Gig gig) {
        return ResponseEntity.ok(service.create(gig));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Gig> read(@PathVariable Long id) {
        return service.read(id).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<Gig> getAll() {
        return service.getAll();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}




