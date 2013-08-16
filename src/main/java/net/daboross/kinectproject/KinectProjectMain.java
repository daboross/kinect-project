/*
 * Copyright (C) 2013 Dabo Ross <www.daboross.net>
 */
package net.daboross.kinectproject;

import java.util.logging.Level;

/**
 *
 * @author daboross
 */
public class KinectProjectMain {

    public static void main(String[] args) {
        try {
            new KinectProject().run();
        } catch (KinectProjectException ex) {
            ProjectLogger.log.log(Level.SEVERE, ex.getMessage());
        }
    }
}
