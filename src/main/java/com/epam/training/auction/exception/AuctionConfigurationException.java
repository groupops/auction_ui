package com.epam.training.auction.exception;

public final class AuctionConfigurationException extends RuntimeException{

    private static final long serialVersionUID = 6723757295356233295L;

    public AuctionConfigurationException(String msg){
        super(msg);
    }
    
    public AuctionConfigurationException(String msg, Throwable e){
        super(msg, e);
    }
}
