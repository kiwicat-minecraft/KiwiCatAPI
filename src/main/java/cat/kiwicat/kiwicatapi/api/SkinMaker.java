package cat.kiwicat.kiwicatapi.api;

import java.nio.file.ProviderNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;

public final class SkinMaker {

    //All providers
    public static List<SkinProvider> providers() {
        List<SkinProvider> services = new ArrayList<>();
        ServiceLoader<SkinProvider> loader = ServiceLoader.load(SkinProvider.class);
        loader.forEach(services::add);
        return services;
    }

//    //Default provider
//    public static SkinProvider provider() {
//        return provider(DEFAULT_PROVIDER);
//    }

    //provider by name
    public static SkinProvider provider(String providerName) {
        ServiceLoader<SkinProvider> loader = ServiceLoader.load(SkinProvider.class);
        Iterator<SkinProvider> it = loader.iterator();
        while (it.hasNext()) {
            SkinProvider provider = it.next();
            if (providerName.equals(provider.getClass().getName())) {
                return provider;
            }
        }
        throw new ProviderNotFoundException("Exchange Rate provider " + providerName + " not found");
    }
}
