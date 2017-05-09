package org.lenndi.umbono.entity;

import java.util.Date;
import java.util.List;

/**
 * Borrower entity.
 */
public class Borrower {

    private Integer id;
    private String name;
    private String comment;
    private Date birthday;
    private Integer quota;
    private Boolean emailOptin;
    private Address address;
    private List<Subscription> subscriptions;
    private Integer libraryId;
    private String libraryName;
    private Integer nbLoans;
    private Boolean tooMuchLoans;
    private Boolean lateness;
    private Date subscriptionStart;
    private Date subscriptionEnd;

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
     * Gets birthday.
     *
     * @return the birthday
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * Sets birthday.
     *
     * @param birthday the birthday
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * Gets address.
     *
     * @return the address
     */
    public Address getAddress() {
        return address;
    }

    /**
     * Sets address.
     *
     * @param address the address
     */
    public void setAddress(Address address) {
        this.address = address;
    }

    /**
     * Gets subscriptions.
     *
     * @return the subscriptions
     */
    public List<Subscription> getSubscriptions() {
        return subscriptions;
    }

    /**
     * Sets subscriptions.
     *
     * @param subscriptions the subscriptions
     */
    public void setSubscriptions(List<Subscription> subscriptions) {
        this.subscriptions = subscriptions;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets comment.
     *
     * @return the comment
     */
    public String getComment() {
        return comment;
    }

    /**
     * Sets comment.
     *
     * @param comment the comment
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * Gets quota.
     *
     * @return the quota
     */
    public Integer getQuota() {
        return quota;
    }

    /**
     * Sets quota.
     *
     * @param quota the quota
     */
    public void setQuota(Integer quota) {
        this.quota = quota;
    }

    /**
     * Gets email optin.
     *
     * @return the email optin
     */
    public Boolean getEmailOptin() {
        return emailOptin;
    }

    /**
     * Sets email optin.
     *
     * @param emailOptin the email optin
     */
    public void setEmailOptin(Boolean emailOptin) {
        this.emailOptin = emailOptin;
    }

    /**
     * Gets nb loans.
     *
     * @return the nb loans
     */
    public Integer getNbLoans() {
        return nbLoans;
    }

    /**
     * Sets nb loans.
     *
     * @param nbLoans the nb loans
     */
    public void setNbLoans(Integer nbLoans) {
        this.nbLoans = nbLoans;
    }

    /**
     * Is too much loans boolean.
     *
     * @return the boolean
     */
    public Boolean isTooMuchLoans() {
        return tooMuchLoans;
    }

    /**
     * Sets too much loans.
     *
     * @param tooMuchLoans the too much loans
     */
    public void setTooMuchLoans(Boolean tooMuchLoans) {
        this.tooMuchLoans = tooMuchLoans;
    }

    /**
     * Gets lateness.
     *
     * @return the lateness
     */
    public Boolean getLateness() {
        return lateness;
    }

    /**
     * Sets lateness.
     *
     * @param lateness the lateness
     */
    public void setLateness(Boolean lateness) {
        this.lateness = lateness;
    }

    /**
     * Gets subscription start.
     *
     * @return the subscription start
     */
    public Date getSubscriptionStart() {
        return subscriptionStart;
    }

    /**
     * Sets subscription start.
     *
     * @param subscriptionStart the subscription start
     */
    public void setSubscriptionStart(Date subscriptionStart) {
        this.subscriptionStart = subscriptionStart;
    }

    /**
     * Gets subscription end.
     *
     * @return the subscription end
     */
    public Date getSubscriptionEnd() {
        return subscriptionEnd;
    }

    /**
     * Sets subscription end.
     *
     * @param subscriptionEnd the subscription end
     */
    public void setSubscriptionEnd(Date subscriptionEnd) {
        this.subscriptionEnd = subscriptionEnd;
    }

    /**
     * Gets library id.
     *
     * @return the library id
     */
    public Integer getLibraryId() {
        return libraryId;
    }

    /**
     * Sets library id.
     *
     * @param libraryId the library id
     */
    public void setLibraryId(Integer libraryId) {
        this.libraryId = libraryId;
    }

    /**
     * Gets library name.
     *
     * @return the library name
     */
    public String getLibraryName() {
        return libraryName;
    }

    /**
     * Sets library name.
     *
     * @param libraryName the library name
     */
    public void setLibraryName(String libraryName) {
        this.libraryName = libraryName;
    }
}
