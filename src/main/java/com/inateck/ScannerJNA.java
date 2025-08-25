package com.inateck;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Callback;


public class ScannerJNA {

    @FunctionalInterface
    public interface EventCallback extends Callback {
        void call(String result);
    }
 
    public interface CLibrary extends Library {

        // latest lib version:
        // https://github.com/Inateck-Technology-Inc/scanner_lib

        CLibrary INSTANCE = (CLibrary) Native.loadLibrary(System.getProperty("user.dir") + "\\src\\main\\java\\com\\inateck\\lib\\inateck_scanner_ble.dll", CLibrary.class);

        String inateck_scanner_ble_init();

        String inateck_scanner_ble_set_discover_callback(EventCallback callback);

        String inateck_scanner_ble_wait_available();

        String inateck_scanner_ble_start_discover();

        String inateck_scanner_ble_stop_discover();

        String inateck_scanner_ble_get_devices();

        String inateck_scanner_ble_connect(String deviceID);

        String inateck_scanner_ble_check_communication(String deviceID);

        String inateck_scanner_ble_auth(String deviceID);

        String inateck_scanner_ble_set_code_callback(String deviceID, EventCallback callback);

        String inateck_scanner_ble_set_disconnect_callback(String deviceID, EventCallback callback);

        String inateck_scanner_ble_disconnect(String deviceID);

        String inateck_scanner_ble_get_battery(String deviceID);

        String inateck_scanner_ble_get_hardware_version(String deviceID);

        String inateck_scanner_ble_bee_or_shake(String deviceID);

        String inateck_scanner_set_bee(String deviceID, int voiceTime, int silentTime, int count);

        String inateck_scanner_set_led(String deviceID, int color, int lightTime, int darkTime, int count);

        String inateck_scanner_ble_get_software_version(String deviceID);

        String inateck_scanner_ble_get_mac(String deviceID);

        String inateck_scanner_ble_get_setting_info(String deviceID, int deviceType);

        String inateck_scanner_ble_set_setting_info(String deviceID, String cmd, int deviceType);

        String inateck_scanner_ble_set_name(String deviceID, String name);

        String inateck_scanner_ble_set_time(String deviceID,
                                         int hour,
                                         int minute,
                                         int second,
                                         int year,
                                         int month,
                                         int day);

        String inateck_scanner_ble_inventory_clear_cache(String deviceID);

        String inateck_scanner_ble_inventory_upload_cache(String deviceID);

        String inateck_scanner_ble_inventory_upload_cache_number(String deviceID);

        String inateck_scanner_ble_reset(String deviceID);

        String inateck_scanner_ble_restart(String deviceID);

        String inateck_scanner_ble_close_all_code(String deviceID);

        String inateck_scanner_ble_open_all_code(String deviceID);

        String inateck_scanner_ble_reset_all_code(String deviceID);

        String inateck_scanner_ble_get_prefix(String deviceID);

        String inateck_scanner_ble_set_prefix(String deviceID, byte[] prefix, int prefixLen);

        String inateck_scanner_ble_get_suffix(String deviceID);

        String inateck_scanner_ble_set_suffix(String deviceID, byte[] suffix, int suffixLen);

        String inateck_scanner_ble_sdk_version();

        int inateck_scanner_ble_set_debug(int is_debug);

        int inateck_scanner_ble_send_hid_text(String text);

        String inateck_scanner_ble_set_hid_output(String deviceID, int outputType);
    }
}


