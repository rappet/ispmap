package de.rappet.ispmap;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Ptr {
    @Id
    private String ip;
    private String ptr;
    private LocalDateTime timestamp;

    protected Ptr() {
        this.timestamp = LocalDateTime.now();
    }

    protected Ptr(String ip, String ptr, LocalDateTime time) {
        this.ip = ip;
        this.ptr = ptr;
        this.timestamp = time;
    }

    @Override
    public String toString() {
        return String.format(
                "PTR[ip=%s, ptr=%s, time=%s]",
                ip, ptr, timestamp
        );
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getPtr() {
        return ptr;
    }

    public void setPtr(String ptr) {
        this.ptr = ptr;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime time) {
        this.timestamp = time;
    }
}
