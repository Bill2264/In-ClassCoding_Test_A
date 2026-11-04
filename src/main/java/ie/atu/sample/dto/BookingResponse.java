package ie.atu.sample.dto;

import ch.qos.logback.core.status.Status;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BookingResponse {
    private long id;
    private String organiserName;
    private int attendeeCount;
    private long roomId;
    private String roomName;
    private String status;
}
