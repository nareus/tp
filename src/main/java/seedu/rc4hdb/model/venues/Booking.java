package seedu.rc4hdb.model.venues;

import java.time.DayOfWeek;
import java.time.LocalTime;

import seedu.rc4hdb.model.resident.Resident;

/**
 * Represents a booking for a venue. Bookings cannot span multiple days.
 */
public abstract class Booking {
    protected static int counter;

    protected Resident resident;
    protected LocalTime startTime;
    protected LocalTime endTime;
    protected DayOfWeek dayOfWeek;

    protected int id;

    /**
     * Constructor for a Booking instance.
     * @param resident The resident trying to book the venue.
     * @param startTime The start time of the booking.
     * @param endTime The end time of the booking.
     */
    public Booking(Resident resident, String startTime, String endTime) {
        this.resident = resident;
        this.startTime = LocalTime.parse(startTime);
        this.endTime = LocalTime.parse(endTime);
        this.id = counter++;
    }

    protected void setDayOfWeek(DayOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    /**
     * Checks if the booking has expired.
     * @return True if the booking has expired.
     */
    public abstract boolean hasExpired();

    /**
     * Checks if the booking period overlaps with another booking period.
     * @param booking The booking to check overlap with.
     * @return True if both bookings overlap.
     */
    public abstract boolean clashesWith(Booking booking);
}
