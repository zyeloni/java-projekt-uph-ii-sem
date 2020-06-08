package me.kacperlukasik.exceptions;

public class NoFillException extends Exception
{
    public NoFillException()
    {
    }

    public NoFillException(String message)
    {
        super(message);
    }

    public NoFillException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public NoFillException(Throwable cause)
    {
        super(cause);
    }

    public NoFillException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace)
    {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
