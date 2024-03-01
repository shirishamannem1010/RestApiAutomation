package payloads;
import com.fasterxml.jackson.annotation.JsonProperty;
import payloads.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Booking {

    private String firstname;
    private String lastname;
    @JsonProperty("totalprice")
    private int totalPrice;
    @JsonProperty("depositpaid")
    private boolean depositPaid;
    @JsonProperty("bookingdates")
    private BookingDates bookingDates;
    @JsonProperty("additionalneeds")
    private String additionalNeeds;
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
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	public boolean isDepositPaid() {
		return depositPaid;
	}
	public void setDepositPaid(boolean depositPaid) {
		this.depositPaid = depositPaid;
	}
	public BookingDates getBookingDates() {
		return bookingDates;
	}
	public void setBookingDates(BookingDates bookingDates) {
		this.bookingDates = bookingDates;
	}
	public String getAdditionalNeeds() {
		return additionalNeeds;
	}
	public void setAdditionalNeeds(String additionalNeeds) {
		this.additionalNeeds = additionalNeeds;
	}
	/**
	 * @param firstname
	 * @param lastname
	 * @param totalPrice
	 * @param depositPaid
	 * @param bookingDates
	 * @param additionalNeeds
	 */
	public Booking(String firstname, String lastname, int totalPrice, boolean depositPaid, BookingDates bookingDates,
			String additionalNeeds) {
		
		this.firstname = firstname;
		this.lastname = lastname;
		this.totalPrice = totalPrice;
		this.depositPaid = depositPaid;
		this.bookingDates = bookingDates;
		this.additionalNeeds = additionalNeeds;
	}
	public Booking() {
		
	}

}

