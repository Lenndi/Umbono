package org.lenndi.umbono.service;

import org.lenndi.umbono.entity.Borrower;

public class SessionService {
    private static final SessionService ourInstance = new SessionService();

    public static SessionService getInstance() {
        return ourInstance;
    }

    private Borrower connectedBorrower;

    private SessionService() {
    }

    public Borrower getConnectedBorrower() {
        return connectedBorrower;
    }

    public void login(Borrower connectedBorrower) {
        this.connectedBorrower = connectedBorrower;
    }

    public void logout() {
        this.connectedBorrower = null;
    }
}
