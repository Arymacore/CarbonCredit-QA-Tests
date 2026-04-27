package com.integration;

import com.service.TransactionService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TransactionServiceTest {

    TransactionService service = new TransactionService();

    @Test
    void TC_INT_001_validCredit() {
        assertTrue(service.verify("CC-VALID-001"));
    }

    @Test
    void TC_INT_002_revokedCredit() {
        assertFalse(service.verify("CC-REVOKED-001"));
    }

    @Test
    void TC_INT_003_duplicateCredit() {
        service.verify("CC-123");
        assertThrows(RuntimeException.class, () -> service.verify("CC-123"));
    }

    @Test
    void TC_INT_004_nullCredit() {
        assertThrows(IllegalArgumentException.class, () -> service.verify(null));
    }

    @Test
    void TC_INT_005_concurrentIsolation() {
        assertTrue(service.verify("CC-A"));
        assertTrue(service.verify("CC-B"));
    }

    @Test
    void TC_INT_006_timeoutHandling() {
        long start = System.currentTimeMillis();
        service.verify("CC-TIME");
        assertTrue(System.currentTimeMillis() - start < 5000);
    }

    @Test
    void TC_INT_007_queueLimit() {
        for (int i = 0; i < 50; i++) {
            service.verify("CC-" + i);
        }
        assertThrows(RuntimeException.class, () -> service.verify("CC-OVERFLOW"));
    }
}