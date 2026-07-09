package cat.kiwicat.kiwicatapi;

import cat.kiwicat.kiwicatapi.util.UwUifier;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KiwiCatAPI implements ModInitializer {

    public static final String MOD_ID = "kiwicatapi";
    public static final String VERSION = "1.1.3";

    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);



    @Override
    public void onInitialize() {
        LOGGER.info(UwUifier.uwuify("Hello from: " + MOD_ID));

    }
}
