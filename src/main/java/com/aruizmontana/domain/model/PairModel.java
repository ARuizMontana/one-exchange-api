package com.aruizmontana.domain.model;

public class PairModel {
    private String baseCode;
    private String targetCode;
    private Double conversationRate;
    private Double conversationResult;

    public PairModel() { }

    public String getBaseCode() {
        return baseCode;
    }

    public void setBaseCode(String baseCode) {
        this.baseCode = baseCode;
    }

    public String getTargetCode() {
        return targetCode;
    }

    public void setTargetCode(String targetCode) {
        this.targetCode = targetCode;
    }

    public Double getConversationRate() {
        return conversationRate;
    }

    public void setConversationRate(Double conversationRate) {
        this.conversationRate = conversationRate;
    }

    public Double getConversationResult() {
        return conversationResult;
    }

    public void setConversationResult(Double conversationResult) {
        this.conversationResult = conversationResult;
    }
}
