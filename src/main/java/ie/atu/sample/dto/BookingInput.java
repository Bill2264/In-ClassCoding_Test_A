package ie.atu.sample.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BookingInput {
    private long id;
    @NotNull
    private String organiserName;
    @NotNull
    @Positive
    private int attendeeCount;
    @NotNull
    private long roomId;
}
