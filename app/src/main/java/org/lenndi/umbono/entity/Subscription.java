package org.lenndi.umbono.entity;

import java.util.Date;

/**
 * Subscription entity.
 */
public class Subscription {

    private Integer id;
    private Date start;
    private Date end;
    private Float contribution;
    private Borrower borrower;
    private Library library;

    /**
     * Gets id.
     *
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets start.
     *
     * @return the start
     */
    public Date getStart() {
        return start;
    }

    /**
     * Sets start.
     *
     * @param start the start
     */
    public void setStart(Date start) {
        this.start = start;
    }

    /**
     * Gets end.
     *
     * @return the end
     */
    public Date getEnd() {
        return end;
    }

    /**
     * Sets end.
     *
     * @param end the end
     */
    public void setEnd(Date end) {
        this.end = end;
    }

    /**
     * Gets contribution.
     *
     * @return the contribution
     */
    public Float getContribution() {
        return contribution;
    }

    /**
     * Sets contribution.
     *
     * @param contribution the contribution
     */
    public void setContribution(Float contribution) {
        this.contribution = contribution;
    }

    /**
     * Gets borrower.
     *
     * @return the borrower
     */
    public Borrower getBorrower() {
        return borrower;
    }

    /**
     * Sets borrower.
     *
     * @param borrower the borrower
     */
    public void setBorrower(Borrower borrower) {
        this.borrower = borrower;
    }

    /**
     * Gets library.
     *
     * @return the library
     */
    public Library getLibrary() {
        return library;
    }

    /**
     * Sets library.
     *
     * @param library the library
     */
    public void setLibrary(Library library) {
        this.library = library;
    }
}
