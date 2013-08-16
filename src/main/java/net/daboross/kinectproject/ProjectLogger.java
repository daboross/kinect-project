/*
 * Copyright (C) 2013 Dabo Ross <www.daboross.net>
 */
package net.daboross.kinectproject;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author daboross
 */
public class ProjectLogger {

    public static final Logger log = Logger.getLogger("net.daboross.kinectproject");

    static {
        log.setLevel(Level.ALL);
        log.addHandler(new ConsoleHandler());
    }
}
