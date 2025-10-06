package APIBooking.model.booking.updateBooking;
import com.fasterxml.jackson.annotation.JsonProperty;
public class UpdateBooking {

    @JsonProperty("firstname")
    public String firstname;
    @JsonProperty("lastname")
    public String lastname;
}
