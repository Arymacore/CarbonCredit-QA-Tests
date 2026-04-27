package com.service;

import java.util.HashSet;
import java.util.Set;

public class TransactionService {

    private Set<String> credits = new HashSet<>();

    public boolean verify(String creditId) {

        if (creditId == null || creditId.isEmpty()) {
            throw new IllegalArgumentException("Credit ID cannot be null");
        }

        if (creditId.contains("REVOKED")) {
            return false;
        }

        if (credits.contains(creditId)) {
            throw new RuntimeException("DuplicateCreditException");
        }

        if (credits.size() >= 50) {
            throw new RuntimeException("Queue limit reached");
        }

        credits.add(creditId);
        return true;
    }
}