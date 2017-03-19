package de.hennroja.alexadevice.upnp.model;

import java.util.List;

/**
 * SCPD
 * longkerdandy/evo-gateway
 */
@SuppressWarnings("unused")
public class AllowedValueList {

    private List<String> allowedValues;

    public AllowedValueList(List<String> allowedValues) {
        this.allowedValues = allowedValues;
    }

    public List<String> getAllowedValues() {
        return allowedValues;
    }

    public void setAllowedValues(List<String> allowedValues) {
        this.allowedValues = allowedValues;
    }
}
