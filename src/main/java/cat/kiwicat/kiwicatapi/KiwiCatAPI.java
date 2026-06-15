package cat.kiwicat.kiwicatapi;

import cat.kiwicat.kiwicatapi.client.util.SkinInfo;
import cat.kiwicat.kiwicatapi.util.UwUifier;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

public class KiwiCatAPI implements ModInitializer {

    public static final String MOD_ID = "kiwicatapi";
    public static final String VERSION = "1.1.1";

    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);



    @Override
    public void onInitialize() {
        LOGGER.info(UwUifier.uwuify("Hello from: " + MOD_ID));

    }
}
