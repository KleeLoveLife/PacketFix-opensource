org.spongepowered.asm.*
mport dev.jnic.Loader;
public final class Auth {
   private native static String a(String var0);
   static {
        Loader.init();
        $jnicLoader();
    }
}
