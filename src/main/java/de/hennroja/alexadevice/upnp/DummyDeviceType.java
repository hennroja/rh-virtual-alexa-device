package de.hennroja.alexadevice.upnp;

import org.fourthline.cling.model.types.DeviceType;

class DummyDeviceType extends DeviceType {
    DummyDeviceType(String namespace, String type, int version) {
        super(namespace, type, version);
    }


    @Override
    public String getNamespace() {
        return super.getNamespace();
    }

    @Override
    public String toString() {
        return "urn:Belkin:device:**";
    }
}
