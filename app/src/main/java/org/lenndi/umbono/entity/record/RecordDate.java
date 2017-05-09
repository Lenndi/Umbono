package org.lenndi.umbono.entity.record;

/**
 * Record date entity.
 */
public class RecordDate {

    private String publicationDate;
    private String manufactureDate;

    /**
     * Gets publication date.
     *
     * @return the publication date
     */
    public String getPublicationDate() {
        return publicationDate;
    }

    /**
     * Sets publication date.
     *
     * @param publicationDate the publication date
     */
    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }

    /**
     * Gets manufacture date.
     *
     * @return the manufacture date
     */
    public String getManufactureDate() {
        return manufactureDate;
    }

    /**
     * Sets manufacture date.
     *
     * @param manufactureDate the manufacture date
     */
    public void setManufactureDate(String manufactureDate) {
        this.manufactureDate = manufactureDate;
    }
}
