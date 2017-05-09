package org.lenndi.umbono.entity;

import org.lenndi.umbono.entity.record.Record;
import org.lenndi.umbono.enumeration.Condition;
import org.lenndi.umbono.enumeration.ItemType;

import java.util.List;

/**
 * Item entity.
 */
public class Item {

    private Integer id;
    private ItemType type;
    private ShelfMark shelfmark;
    private Integer internalId;
    private Float purchasePrice;
    private Boolean loanable;
    private Boolean borrowed;
    private List<Loan> loans;
    private Condition condition;
    private String currency;
    private Library library;
    private Library externalLibrary;
    private String recordId;
    private Record record;

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
     * Gets borrowed.
     *
     * @return the borrowed
     */
    public Boolean getBorrowed() {
        return borrowed;
    }

    /**
     * Sets borrowed.
     *
     * @param borrowed the borrowed
     */
    public void setBorrowed(Boolean borrowed) {
        this.borrowed = borrowed;
    }

    /**
     * Gets type.
     *
     * @return the type
     */
    public ItemType getType() {
        return type;
    }

    /**
     * Sets type.
     *
     * @param type the type
     */
    public void setType(ItemType type) {
        this.type = type;
    }

    /**
     * Gets shelfmark.
     *
     * @return the shelfmark
     */
    public ShelfMark getShelfmark() {
        return shelfmark;
    }

    /**
     * Sets shelfmark.
     *
     * @param shelfmark the shelfmark
     */
    public void setShelfmark(ShelfMark shelfmark) {
        this.shelfmark = shelfmark;
    }

    /**
     * Gets internal id.
     *
     * @return the internal id
     */
    public Integer getInternalId() {
        return internalId;
    }

    /**
     * Sets internal id.
     *
     * @param internalId the internal id
     */
    public void setInternalId(Integer internalId) {
        this.internalId = internalId;
    }

    /**
     * Gets purchase price.
     *
     * @return the purchase price
     */
    public Float getPurchasePrice() {
        return purchasePrice;
    }

    /**
     * Sets purchase price.
     *
     * @param purchasePrice the purchase price
     */
    public void setPurchasePrice(Float purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    /**
     * Gets loanable.
     *
     * @return the loanable
     */
    public Boolean getLoanable() {
        return loanable;
    }

    /**
     * Sets loanable.
     *
     * @param loanable the loanable
     */
    public void setLoanable(Boolean loanable) {
        this.loanable = loanable;
    }

    /**
     * Gets loans.
     *
     * @return the loans
     */
    public List<Loan> getLoans() {
        return loans;
    }

    /**
     * Sets loans.
     *
     * @param loans the loans
     */
    public void setLoans(List<Loan> loans) {
        this.loans = loans;
    }

    /**
     * Gets condition.
     *
     * @return the condition
     */
    public Condition getCondition() {
        return condition;
    }

    /**
     * Sets condition.
     *
     * @param condition the condition
     */
    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    /**
     * Gets currency.
     *
     * @return the currency
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * Sets currency.
     *
     * @param currency the currency
     */
    public void setCurrency(String currency) {
        this.currency = currency;
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

    /**
     * Gets external library.
     *
     * @return the external library
     */
    public Library getExternalLibrary() {
        return externalLibrary;
    }

    /**
     * Sets external library.
     *
     * @param externalLibrary the external library
     */
    public void setExternalLibrary(Library externalLibrary) {
        this.externalLibrary = externalLibrary;
    }

    /**
     * Gets record id.
     *
     * @return the record id
     */
    public String getRecordId() {
        return recordId;
    }

    /**
     * Sets record id.
     *
     * @param recordId the record id
     */
    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    public Record getRecord() {
        return record;
    }

    public void setRecord(Record record) {
        this.record = record;
    }
}
