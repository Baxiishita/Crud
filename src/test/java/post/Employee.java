package post;

public class Employee {
  private  String firstname;
  private String lastname;
   private Integer totalprice;
    private Boolean depositpaid;
    private String additionalneeds;
    private Bookingdatesclass bookingdates;


    public Bookingdatesclass getBookingdates() {
        return bookingdates;
    }

    public void setBookingdates(Bookingdatesclass bookingdates) {
        this.bookingdates = bookingdates;
    }





    public Boolean getDepositpaid() {
        return depositpaid;
    }

    public void setDepositpaid(Boolean depositpaid) {
        this.depositpaid = depositpaid;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(Integer totalprice) {
        this.totalprice = totalprice;
    }



    public String getAdditionalneeds() {
        return additionalneeds;
    }

    public void setAdditionalneeds(String additionalneeds) {
        this.additionalneeds = additionalneeds;
    }
}









