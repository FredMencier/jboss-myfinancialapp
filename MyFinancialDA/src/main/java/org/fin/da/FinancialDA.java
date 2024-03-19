package org.fin.da;

import org.fin.dto.Currency;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;


public class FinancialDA {

    private static final Logger LOG = LoggerFactory.getLogger(FinancialDA.class);
    private final static FinancialDA me = new FinancialDA();

    public static FinancialDA getInstance() {
        return me;
    }

    private FinancialDA() {
    }

    public List<Currency> findCurrencies() {
        List<Currency> res = new ArrayList<>();
        res.add(new Currency("CHF", "756", "Swiss franc", "Switzerland"));
        res.add(new Currency("EUR", "978", "Euro", "France"));
        res.add(new Currency("USD", "840)", "United States dollar", "United States"));
        res.add(new Currency("BRL", "986", "Brazilian real", "Brazil"));
        res.add(new Currency("JPY", "392", "Japanese yen", "Japan"));
        return res;
    }
}
