/*
 * Copyright (C) 2013 Dabo Ross <www.daboross.net>
 */
package net.daboross.kinectproject;

/**
 *
 * @author daboross
 */
public class KinectProjectException extends RuntimeException {

    public KinectProjectException() {
        super();
    }

    public KinectProjectException(String message) {
        super(message);
    }

    public KinectProjectException(Throwable cause) {
        super(cause);
    }

    public KinectProjectException(String message, Throwable cause) {
        super(message, cause);
    }
}
