package de.rappet.ispmap;

import org.springframework.web.bind.annotation.*;

@RestController
public class ApiController {

    private final PtrRepository ptrRepository;

    ApiController(PtrRepository ptrRepository) {
        this.ptrRepository = ptrRepository;
    }

    @GetMapping(value = "/api/ptrs")
    Iterable<Ptr> all() {
        return ptrRepository.findAll();
    }

    @GetMapping(value = "/api/ptrs/{ip}")
    public Ptr getPtr(@PathVariable("ip") String ip) {
        return ptrRepository.findByIp(ip);
    }

    @PostMapping(value = "/api/ptrs")
    public Ptr postPtr(@RequestBody Ptr ptr) {
        return ptrRepository.save(ptr);
    }

}
