package edu.clark.sqa;

public class TransactionService {
    private final RegulatoryAPI regulatoryAPI;


    public TransactionService(RegulatoryAPI regulatoryAPI) {
        this.regulatoryAPI = regulatoryAPI;
    }

    public boolean processPurchase(String creditId, int amount) {

        String status = regulatoryAPI.checkCreditStatus(creditId);

        if ("VERIFIED".equals(status) && amount > 0) {

            return true;
        }
        return false;
    }
}
