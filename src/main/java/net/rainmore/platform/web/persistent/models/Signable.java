package net.rainmore.platform.web.persistent.models;

import org.joda.time.LocalDateTime;

public interface Signable {
    public LocalDateTime getCreatedTime();
    public LocalDateTime getUpdatedTime();
}
