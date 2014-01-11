package net.rainmore.platform.core.models;

import org.joda.time.LocalDateTime;

public interface Signable {
    public LocalDateTime getCreatedTime();
    public LocalDateTime getUpdatedTime();
}
