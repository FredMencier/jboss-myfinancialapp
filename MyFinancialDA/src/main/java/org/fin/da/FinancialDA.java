package org.fin.da;

import org.fin.dto.Currency;
import org.fin.entity.CurrencyEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class FinancialDA {

    private static final Logger LOG = LoggerFactory.getLogger(FinancialDA.class);

    private EntityManager entityManager;

    public FinancialDA(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Currency> findCurrencies() {
        TypedQuery<CurrencyEntity> selectCFromCurrencyEntity = entityManager.createQuery("SELECT c from CurrencyEntity c", CurrencyEntity.class);
        List<CurrencyEntity> resultList = selectCFromCurrencyEntity.getResultList();

        return resultList.stream()
                .map(currencyEntity -> new Currency(currencyEntity.getCode(), currencyEntity.getNum(), currencyEntity.getName(), currencyEntity.getCountry()))
                .collect(Collectors.toList());
    }
}
