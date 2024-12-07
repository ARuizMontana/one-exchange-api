package com.aruizmontana.data.datasource.remote;

import com.aruizmontana.domain.model.PairModel;

public interface IPairRemoteDataSource {
    PairModel pair(String base, String target, Double amount);
}
