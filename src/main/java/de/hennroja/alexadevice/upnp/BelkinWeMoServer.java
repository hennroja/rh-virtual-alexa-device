package de.hennroja.alexadevice.upnp;

import org.fourthline.cling.UpnpService;
import org.fourthline.cling.UpnpServiceImpl;
import org.fourthline.cling.binding.LocalServiceBindingException;
import org.fourthline.cling.binding.annotations.AnnotationLocalServiceBinder;
import org.fourthline.cling.model.DefaultServiceManager;
import org.fourthline.cling.model.ValidationException;
import org.fourthline.cling.model.message.UpnpHeaders;
import org.fourthline.cling.model.message.header.ServiceTypeHeader;
import org.fourthline.cling.model.meta.*;
import org.fourthline.cling.model.profile.HeaderDeviceDetailsProvider;
import org.fourthline.cling.model.types.ServiceType;
import org.fourthline.cling.model.types.UDN;
import de.hennroja.alexadevice.upnp.model.SwitchPower;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class BelkinWeMoServer implements Runnable {


    public void run() {
        try {
            UpnpHeaders aa = new UpnpHeaders();

            //final UpnpService upnpService = new UpnpServiceImpl();
            UpnpService upnpService = new UpnpServiceImpl(new WeMoUpnpServiceConfiguration());
            Runtime.getRuntime().addShutdownHook(new Thread() {
                @Override
                public void run() {
                    upnpService.shutdown();
                }
            });

            // Add the bound local device to the registry
            LocalDevice device = createDevice();
            upnpService.getRegistry().addDevice(
                    device
            );

        } catch (Exception ex) {
            System.err.println("Exception occured: " + ex);
            ex.printStackTrace(System.err);
            System.exit(1);
        }
    }

    LocalDevice createDevice() throws ValidationException,
            LocalServiceBindingException, IOException {

        DeviceIdentity identity =
                new DeviceIdentity(
                        UDN.uniqueSystemIdentifier("Socket-1_0-221517K0101769")
                );

        DummyDeviceType type =
                new DummyDeviceType("Belkin","BinLight", 1);
        DeviceDetails dd1 = new DeviceDetails("friendlyName");
        //DeviceType type1 = new DeviceType("Belkin","BinLight", 1);
        Map<HeaderDeviceDetailsProvider.Key, DeviceDetails> headerDetails = new HashMap<>();
        headerDetails.put(new HeaderDeviceDetailsProvider.Key("User-Agent", "Belkin.*"), dd1);
        //headerDetails.put(new HeaderDeviceDetailsProvider.Key("X-AV-Client-Info", ".*PLAYSTATION 3.*"), dd2);
        DeviceDetails details =
                new DeviceDetails(
                        "Friendly Binary Light",
                        new ManufacturerDetails("Belkin International Inc."),
                        new ModelDetails(
                                "Emulated Socket",
                                "A demo light with on/off switch.",
                                "v1"
                        )
                );

        Icon icon =
                new Icon(
                        "image/png", 48, 48, 8,
                        getClass().getResource("/icon.png")
                );

        LocalService<SwitchPower> switchPowerService =
                new AnnotationLocalServiceBinder().read(SwitchPower.class);


        switchPowerService.setManager(
                new DefaultServiceManager(switchPowerService, SwitchPower.class)
        );

        return new LocalDevice(identity, type, details, icon, switchPowerService);

    /* Several services can be bound to the same device:
    return new LocalDevice(
            identity, type, details, icon,
            new LocalService[] {switchPowerService, myOtherService}
    );
    */

    }

}