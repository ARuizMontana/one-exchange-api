package com.aruizmontana.data.repository;

import com.aruizmontana.domain.model.PairModel;

public interface IPairRepository {
    PairModel pair(String base, String target, Double amount);
}
