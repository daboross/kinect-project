/*
 * Copyright (C) 2013-2014 Dabo Ross <www.daboross.net>
 */
package net.daboross.kinectproject;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import static net.daboross.kinectproject.ProjectLogger.log;
import org.openkinect.freenect.Context;
import org.openkinect.freenect.Device;
import org.openkinect.freenect.Freenect;
import org.openkinect.freenect.LedStatus;

/**
 *
 * @author daboross
 */
public class KinectProject {

    private final Context context;
    private final List<Device> devices;

    public KinectProject() {
        context = Freenect.createContext();
        devices = new ArrayList<>(context.numDevices());
        for (int i = 0; i < context.numDevices(); i++) {
            devices.add(context.openDevice(i));
        }
        if (devices.isEmpty()) {
            throw new KinectProjectException("No devices found");
        }
    }

    public void run() {
        log.log(Level.INFO, "{0} devices found.", devices.size());
        for (int i = 0; i < 10; i++) {
            for (LedStatus status : LedStatus.values()) {
                setAndWait(status, 10);
            }
        }
        close();
    }

    private void setAndWait(LedStatus status, long seconds) {
        for (Device dev : devices) {
            dev.setLed(status);
        }
        try {
            Thread.sleep(TimeUnit.SECONDS.toMillis(seconds));
        } catch (InterruptedException ex) {
            throw new KinectProjectException("Error: " + ex);
        }
    }

    public void close() {
        for (Device dev : devices) {
            dev.close();
        }
        context.shutdown();
    }
}
