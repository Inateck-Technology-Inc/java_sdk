package com.inateck;

import com.sun.jna.Library;
import com.sun.jna.Native;

import static java.lang.Thread.sleep;
import com.sun.jna.Callback;


public class ScannerJNA {
    public interface CallbackInterface extends Callback {
    }
    public interface ScannerLibrary extends Library {
        ScannerLibrary INSTANCE = (ScannerLibrary) Native.loadLibrary("E:\\project\\java_sdk\\src\\main\\java\\lib\\scanner_windows_64bit", ScannerLibrary.class);

        String scan();
        String connect(String device,String appId,String developerId,String appKey,Callback callback);
        String disconnect(String device);
        String get_basic_properties(String device,String key);
        String get_properties_info_by_key(String device,String key);
        String edit_properties_info_by_key(String device,String key,String data);
        String get_all_barcode_properties(String device);

        interface Callback extends CallbackInterface{
            void call(String result);
        }
    }

    public static void main(String[] args) {
        ScannerLibrary scanner = ScannerLibrary.INSTANCE;
        System.out.println(scanner.scan());
        System.out.println("connect: "+scanner.connect("7B:AA:8C:98:10:71","com.inateck.scanner","","",new ScannerCallback()) );
        System.out.println("get_basic_properties: "+scanner.get_basic_properties("7B:AA:8C:98:10:71","firmware_version"));
        System.out.println("get_properties_info_by_key: "+scanner.get_properties_info_by_key("7B:AA:8C:98:10:71","Codabar"));
        System.out.println("get_all_barcode_properties: "+scanner.get_all_barcode_properties("7B:AA:8C:98:10:71"));
        System.out.println("edit_properties_info_by_key: "+scanner.edit_properties_info_by_key("7B:AA:8C:98:10:71","Codabar","1"));
    }
}
 class ScannerCallback implements ScannerJNA.ScannerLibrary.Callback{
    @Override
    public void call(String result) {
        System.out.println("Callback Result: " + result);
    }
}

