package de.rappet.ispmap;

import org.springframework.data.repository.CrudRepository;

import java.net.Inet4Address;

public interface PtrRepository extends CrudRepository<Ptr, Inet4Address> {
    Ptr findByIp(String ip);
}
