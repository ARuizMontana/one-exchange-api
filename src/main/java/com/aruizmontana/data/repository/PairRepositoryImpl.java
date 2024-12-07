package com.aruizmontana.data.repository;

import com.aruizmontana.data.datasource.remote.IPairRemoteDataSource;
import com.aruizmontana.domain.model.PairModel;

public class PairRepositoryImpl implements  IPairRepository {
    IPairRemoteDataSource remoteDataSource;
    public PairRepositoryImpl(IPairRemoteDataSource remoteDataSource) {
        this.remoteDataSource = remoteDataSource;
    }

    @Override
    public PairModel pair(String base, String target, Double amount) {
        return remoteDataSource.pair(base, target, amount);
    }
}
