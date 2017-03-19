package de.hennroja.alexadevice.upnp;

import org.fourthline.cling.binding.xml.DescriptorBindingException;
import org.fourthline.cling.binding.xml.RecoveringUDA10DeviceDescriptorBinderImpl;
import org.fourthline.cling.model.ValidationException;
import org.fourthline.cling.model.meta.Device;

/**
 * copied from longkerdandy/evo-gateway repo
 */
public class WeMoRecoveringUDA10DeviceDescriptorBinderImpl extends RecoveringUDA10DeviceDescriptorBinderImpl {

    @Override
    public <D extends Device> D describe(D undescribedDevice, String descriptorXml) throws DescriptorBindingException, ValidationException {
        descriptorXml = descriptorXml.replaceAll("urn:Belkin:device-1-0", "urn:schemas-de.hennroja.alexadevice.upnp-org:device-1-0");
        descriptorXml = descriptorXml.replaceAll("<mimetype>jpg</mimetype>", "<mimetype>image/jpeg</mimetype>");

        return super.describe(undescribedDevice, descriptorXml);
    }
}
