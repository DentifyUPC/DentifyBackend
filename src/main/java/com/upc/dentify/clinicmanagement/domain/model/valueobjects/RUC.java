package com.upc.dentify.clinicmanagement.domain.model.valueobjects;

public record RUC(String value) {

    public RUC {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("RUC cannot be null or blank");
        }
        if (!value.matches("\\d{11}")) {
            throw new IllegalArgumentException("RUC must have exactly 11 digits");
        }

        String prefix = value.substring(0, 2);
        if (!(prefix.equals("10") || prefix.equals("15") || prefix.equals("20"))) {
            throw new IllegalArgumentException("RUC must start with 10, 15, or 20");
        }

        if (!isValidCheckDigit(value)) {
            throw new IllegalArgumentException("Invalid RUC: check digit does not match");
        }
    }

    private static boolean isValidCheckDigit(String ruc) {
        // Algoritmo SUNAT (módulo 11)
        int[] factors = {5, 4, 3, 2, 7, 6, 5, 4, 3, 2};
        int sum = 0;

        for (int i = 0; i < factors.length; i++) {
            sum += Character.getNumericValue(ruc.charAt(i)) * factors[i];
        }

        int remainder = sum % 11;
        int checkDigit = 11 - remainder;

        if (checkDigit == 10) checkDigit = 0;
        else if (checkDigit == 11) checkDigit = 1;

        int lastDigit = Character.getNumericValue(ruc.charAt(10));

        return checkDigit == lastDigit;
    }

    @Override
    public String toString() {
        return value;
    }
}
