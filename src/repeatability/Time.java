package repeatability;

import java.time.LocalDateTime;

public interface Time {
    LocalDateTime getNextTime();
    LocalDateTime getTime();
}
