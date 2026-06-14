package cat.kiwicat.kiwicatapi.client.util;

import net.minecraft.util.Identifier;

public class SkinInfo {
    Identifier texture;
    String username;
    boolean SLIM;

    public SkinInfo(Identifier texture, String username, boolean slim){
        this.texture = texture;
        this.username = username;
        this.SLIM = slim;
    }

    public Identifier getTexture(){
        return this.texture;
    }

    public String getUsername(){
        return this.username;
    }

    public boolean isSLIM() {
        return SLIM;
    }
}
