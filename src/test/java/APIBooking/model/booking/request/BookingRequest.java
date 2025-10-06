package APIBooking.model.booking.request;

public class BookingRequest {


    public String firstname;
    public String lastname;
    public Integer totalprice;
    public Boolean depositpaid;
    public BookingDateRequest bookingdaterequest;
    public String additionalneeds;

    public BookingRequest(){

    }

    public BookingRequest(String firstname, String lastname, Integer totalprice, Boolean depositpaid,
    BookingDateRequest bookingdaterequest, String additionalneeds){
        this.firstname = firstname;
        this.lastname=lastname;
        this.totalprice=totalprice;
        this.depositpaid=depositpaid;
        this.bookingdaterequest=bookingdaterequest;
        this.additionalneeds=additionalneeds;
    }




}
