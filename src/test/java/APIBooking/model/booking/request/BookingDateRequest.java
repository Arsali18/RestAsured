package APIBooking.model.booking.request;

public class BookingDateRequest {

     public String checkin;
     public String checkout;

    public BookingDateRequest(){

    }

    public BookingDateRequest(String checkin, String checkout){
    this.checkin=checkin;
    this.checkout=checkout;
    }
}
