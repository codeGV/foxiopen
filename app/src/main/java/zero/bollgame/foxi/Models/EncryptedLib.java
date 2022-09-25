package zero.bollgame.foxi.Models;

public class EncryptedLib {
    static {
        System.loadLibrary("Ulib");
        System.loadLibrary("lib_tech");
    }

    public static native String Decrpted(String str);

    public static native String FiveKey();

    public static native String FourKey();

    public static native String Threekey();

    public static native String baseUrlFromJNI();

    public static native String moveNameUrl();
}
