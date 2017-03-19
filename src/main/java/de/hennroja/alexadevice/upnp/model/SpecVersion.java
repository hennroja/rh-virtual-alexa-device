package de.hennroja.alexadevice.upnp.model;

/**
 * SCPD
 * longkerdandy/evo-gateway
 */
@SuppressWarnings("unused")
public class SpecVersion {

    private int major;
    private int minor;

    public SpecVersion(int major, int minor) {
        this.major = major;
        this.minor = minor;
    }

    public int getMajor() {
        return major;
    }

    public void setMajor(int major) {
        this.major = major;
    }

    public int getMinor() {
        return minor;
    }

    public void setMinor(int minor) {
        this.minor = minor;
    }
}
