package edu.clark.sqa.tests;

import edu.clark.sqa.RegulatoryAPI;
import edu.clark.sqa.TransactionService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class TransactionServiceTest {

    @Test
    public void testCreditVerification_ValidCredit() {
        RegulatoryAPI mockApi = Mockito.mock(RegulatoryAPI.class);
        Mockito.when(mockApi.checkCreditStatus("CREDIT-9981")).thenReturn("VERIFIED");
        TransactionService service = new TransactionService(mockApi);
        boolean isApproved = service.processPurchase("CREDIT-9981", 500);
        assertTrue(isApproved, "Transaction should be approved for verified credits.");
    }

    @Test
    public void testCreditVerification_InvalidCredit() {
        RegulatoryAPI mockApi = Mockito.mock(RegulatoryAPI.class);
        Mockito.when(mockApi.checkCreditStatus("CREDIT-0000")).thenReturn("REVOKED");

        TransactionService service = new TransactionService(mockApi);
        boolean isApproved = service.processPurchase("CREDIT-0000", 500);

        assertFalse(isApproved, "Transaction should fail for revoked credits.");
    }
}