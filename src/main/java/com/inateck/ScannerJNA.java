package com.inateck;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Callback;


public class ScannerJNA {

    static {
        System.setProperty("jna.library.path", "/Users/inateck/Desktop/scanner/2024-3-15-scanner/scanner_sdk/java_sdk/src/main/java/lib/");
    }

    public interface EventCallback extends Callback {
        void call(String result);
    }
 
    public interface CLibrary extends Library {

        CLibrary INSTANCE = (CLibrary) Native.loadLibrary("/Users/inateck/Desktop/scanner/2024-3-15-scanner/scanner_sdk/java_sdk/src/main/java/lib/libscanner_ble_x86_64-apple-darwin.dylib", CLibrary.class);

        int inateck_scanner_ble_init(EventCallback callback);

        int inateck_scanner_ble_destroy();

        int inateck_scanner_ble_start_scan();

        int inateck_scanner_ble_stop_scan();

        String inateck_scanner_ble_get_devices();

        String inateck_scanner_ble_connect(String mac, EventCallback callback);

        int inateck_scanner_ble_auth(String mac);

        int inateck_scanner_ble_disconnect(String mac);

        String inateck_scanner_ble_get_battery(String mac);

        String inateck_scanner_ble_get_hardware_version(String mac);

        String inateck_scanner_ble_get_software_version(String mac);

        String inateck_scanner_ble_get_setting_info(String mac);

        String inateck_scanner_ble_set_setting_info(String mac, String cmd);

        int inateck_scanner_ble_set_name(String mac, String name);

        int inateck_scanner_ble_set_time(String mac, long time);

        int inateck_scanner_ble_inventory_clear_cache(String mac);

        int inateck_scanner_ble_inventory_upload_cache(String mac);

        int inateck_scanner_ble_inventory_upload_cache_number(String mac);

        int inateck_scanner_ble_reset(String mac);

        int inateck_scanner_ble_restart(String mac);

        int inateck_scanner_ble_close_all_code(String mac);

        int inateck_scanner_ble_open_all_code(String mac);

        int inateck_scanner_ble_reset_all_code(String mac);

        String inateck_scanner_ble_sdk_version();
    }
}


