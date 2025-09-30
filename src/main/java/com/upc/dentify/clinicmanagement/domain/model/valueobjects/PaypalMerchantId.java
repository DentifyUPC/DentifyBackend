package com.upc.dentify.clinicmanagement.domain.model.valueobjects;

public record PaypalMerchantId(String paypalMerchantId) {

    public PaypalMerchantId {
        if (paypalMerchantId == null || paypalMerchantId.isBlank()) {
            throw new IllegalArgumentException("PayPal Merchant ID cannot be null or blank");
        }
        if (!paypalMerchantId.matches("^X[a-zA-Z0-9]{12}$")) {
            throw new IllegalArgumentException(
                    "Invalid PayPal Merchant ID format. It must start with 'X' and contain 13 alphanumeric characters."
            );
        }
    }

}
