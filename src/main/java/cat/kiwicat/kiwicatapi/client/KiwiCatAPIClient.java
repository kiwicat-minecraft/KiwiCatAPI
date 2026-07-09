package cat.kiwicat.kiwicatapi.client;

import cat.kiwicat.kiwicatapi.api.SkinInfo;
import net.fabricmc.api.ClientModInitializer;

import java.util.ArrayList;

public class KiwiCatAPIClient implements ClientModInitializer {

    public static ArrayList<SkinInfo> SkinChanges = new ArrayList<>();

    public static boolean blacklist = false;


    @Override
    public void onInitializeClient() {
        //SkinChanges.add(new SkinInfo(Identifier.of(KiwiCatAPI.MOD_ID, "/skins/maid_kiwi.png"), "Kiwicat0_0",true));

    }
}
