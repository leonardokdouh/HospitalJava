package com.solvd.hospital.Generics;

import com.solvd.hospital.enums.PaymentMethods;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GenericPayment<T> {
    final private T amount;
    private static final Logger LOG = LogManager.getLogger(GenericPayment.class);

    public GenericPayment(T amount) {
        this.amount = amount;
    }


    public void payCash() {
        LOG.debug("You paid " + amount + " using " + PaymentMethods.CASH.data);

    }

    public void payCredit() {
        LOG.debug("You paid " + amount + " using " + PaymentMethods.CREDIT.data);

    }

    public void payDebit() {
        LOG.debug("You paid " + amount + " using " + PaymentMethods.DEBIT.data);

    }
}
