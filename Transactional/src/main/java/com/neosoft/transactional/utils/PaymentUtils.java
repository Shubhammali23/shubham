package com.neosoft.transactional.utils;

import com.neosoft.transactional.Exception.InsufficientAmountEx;

import java.util.HashMap;
import java.util.Map;

public class PaymentUtils {
    private static Map<String, Double> paymentMap = new HashMap<>();

    {
        paymentMap.put("acc1", 12000.00);
        paymentMap.put("acc2", 10000.00);
        paymentMap.put("acc3", 8000.00);
        paymentMap.put("acc4", 6000.00);

    }

    public static boolean validateCreditLimit(String accNo, double paidAmount) {
        if (paidAmount > paymentMap.get(accNo)) {
            throw new InsufficientAmountEx("Insufficient fund...");
        } else {
            return true;
        }
    }

}

