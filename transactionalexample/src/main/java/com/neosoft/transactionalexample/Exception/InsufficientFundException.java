package com.neosoft.transactionalexample.Exception;

public class InsufficientFundException extends RuntimeException
{
    public InsufficientFundException(String msg)
    {
        super(msg);
    }
}
