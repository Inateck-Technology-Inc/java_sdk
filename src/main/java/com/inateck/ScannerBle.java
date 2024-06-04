package com.inateck;

import com.inateck.ScannerJNA.CLibrary;
import com.inateck.ScannerJNA.EventCallback;

public class ScannerBle {

    int registerEventCallback(EventCallback callback) {
        int status = CLibrary.INSTANCE.inateck_scanner_ble_init(callback);
        return status;
    }
    
    int destroy() {
        int status = CLibrary.INSTANCE.inateck_scanner_ble_destroy();
        return status;
    }

    int startScan() {
        int status = CLibrary.INSTANCE.inateck_scanner_ble_start_scan();
        return status;
    }

    int stopScan() {
        int status = CLibrary.INSTANCE.inateck_scanner_ble_stop_scan();
        return status;
    }

    String getDevices() {
        String devices = CLibrary.INSTANCE.inateck_scanner_ble_get_devices();
        return devices;
    }

    String connect(String mac, EventCallback callback) {
        String result = CLibrary.INSTANCE.inateck_scanner_ble_connect(mac, callback);
        return result;
    }

    int auth(String mac) {
        int status = CLibrary.INSTANCE.inateck_scanner_ble_auth(mac);
        return status;
    }

    int disconnect(String mac) {
        int status = CLibrary.INSTANCE.inateck_scanner_ble_disconnect(mac);
        return status;
    }

    String getBattery(String mac) {
        String battery = CLibrary.INSTANCE.inateck_scanner_ble_get_battery(mac);
        return battery;
    }

    String getHardwareVersion(String mac) {
        String version = CLibrary.INSTANCE.inateck_scanner_ble_get_hardware_version(mac);
        return version;
    }

    String getSoftwareVersion(String mac) {
        String version = CLibrary.INSTANCE.inateck_scanner_ble_get_software_version(mac);
        return version;
    }

    String getSettingInfo(String mac) {
        String info = CLibrary.INSTANCE.inateck_scanner_ble_get_setting_info(mac);
        return info;
    }

    String setSettingInfo(String mac, String cmd) {
        String result = CLibrary.INSTANCE.inateck_scanner_ble_set_setting_info(mac, cmd);
        return result;
    }

    int setName(String mac, String name) {
        int status = CLibrary.INSTANCE.inateck_scanner_ble_set_name(mac, name);
        return status;
    }

    int setTime(String mac, long time) {
        int status = CLibrary.INSTANCE.inateck_scanner_ble_set_time(mac, time);
        return status;
    }

    int inventoryClearCache(String mac) {
        int status = CLibrary.INSTANCE.inateck_scanner_ble_inventory_clear_cache(mac);
        return status;
    }

    int inventoryUploadCache(String mac) {
        int status = CLibrary.INSTANCE.inateck_scanner_ble_inventory_upload_cache(mac);
        return status;
    }

    int inventoryUploadCacheNumber(String mac) {
        int status = CLibrary.INSTANCE.inateck_scanner_ble_inventory_upload_cache_number(mac);
        return status;
    }

    int reset(String mac) {
        int status = CLibrary.INSTANCE.inateck_scanner_ble_reset(mac);
        return status;
    }

    int restart(String mac) {
        int status = CLibrary.INSTANCE.inateck_scanner_ble_restart(mac);
        return status;
    }

    int closeAllCode(String mac) {
        int status = CLibrary.INSTANCE.inateck_scanner_ble_close_all_code(mac);
        return status;
    }

    int openAllCode(String mac) {
        int status = CLibrary.INSTANCE.inateck_scanner_ble_open_all_code(mac);
        return status;
    }

    int resetAllCode(String mac) {
        int status = CLibrary.INSTANCE.inateck_scanner_ble_reset_all_code(mac);
        return status;
    }

    String getSdkVersion() {
        String version = CLibrary.INSTANCE.inateck_scanner_ble_sdk_version();
        return version;
    }

}
