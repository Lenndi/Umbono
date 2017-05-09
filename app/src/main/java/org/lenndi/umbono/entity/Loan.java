package org.lenndi.umbono.entity;

import java.util.Date;

/**
 * Loan entity.
 */
public class Loan {

    private Integer id;
    private Date start;
    private Date end;
    private Borrower borrower;
    private Boolean returned;
    private Item item;

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
     * Gets returned.
     *
     * @return the returned
     */
    public Boolean getReturned() {
        return returned;
    }

    /**
     * Sets returned.
     *
     * @param returned the returned
     */
    public void setReturned(Boolean returned) {
        this.returned = returned;
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
     * Gets item.
     *
     * @return the item
     */
    public Item getItem() {
        return item;
    }

    /**
     * Sets item.
     *
     * @param item the item
     */
    public void setItem(Item item) {
        this.item = item;
    }
}
