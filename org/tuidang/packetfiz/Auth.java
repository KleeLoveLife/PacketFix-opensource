import java.lang.invoke.*;
import dev.jnic.Loader;

public final class Auth {
   private native static String a(String var0);

   public static native Object b(Lookup var0, String var1, MethodType var2, int var3, String var4, String var5, String var6);
   static {
        Loader.init();
        $jnicLoader();
    }
}
