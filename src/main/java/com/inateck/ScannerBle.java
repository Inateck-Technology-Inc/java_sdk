package com.inateck;

import com.inateck.ScannerJNA.CLibrary;
import com.inateck.ScannerJNA.EventCallback;

enum InateckDeviceType {
    None(0),
    Pro8(1),
    ST45(2),
    ST23(3),
    ST91(4),
    ST42(5),
    ST54(6),
    ST55(7),
    ST73(8),
    ST75(9),
    ST43(10),
    P7(11),
    ST21(12),
    ST60(13),
    ST70(14),
    P6(15),
    ST35(16),
    Pro8AI(17),
    ST45AI(18),
    ST23AI(19),
    ST91AI(20),
    ST42AI(21),
    ST54AI(22),
    ST55AI(23),
    ST73AI(24),
    ST75AI(25),
    ST43AI(26),
    P7AI(27),
    ST21AI(28),
    ST60AI(29),
    ST70AI(30),
    P6AI(31),
    ST35AI(32),
    ST46(33),
    ST46AI(34),
    ST72(35),
    ST72AI(36),
    ST75S(37),
    ST75SAI(38),
    ST36(39),
    ST36AI(40),
    ST61(41),
    ST61AI(42),
    ST47(43),
    ST47AI(44),
    PBS002(45),
    PRO8SE(46),
    PRO8SEAI(47),
    ST49(48),
    ST49AI(49),
    B560B(50),
    PBS005AI(51);

    private final int value;

    InateckDeviceType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

public class ScannerBle {

    String init() {
        String result = CLibrary.INSTANCE.inateck_scanner_ble_init();
        return result;
    }

    String setDiscoverCallback(EventCallback callback) {
        String result = CLibrary.INSTANCE.inateck_scanner_ble_set_discover_callback(callback);
        return result;
    }
    
    String waitAvailable() {
        String result = CLibrary.INSTANCE.inateck_scanner_ble_wait_available();
        return result;
    }

    String startScan() {
        String result = CLibrary.INSTANCE.inateck_scanner_ble_start_discover();
        return result;
    }

    String stopScan() {
        String status = CLibrary.INSTANCE.inateck_scanner_ble_stop_discover();
        return status;
    }

    String getDevices() {
        String devices = CLibrary.INSTANCE.inateck_scanner_ble_get_devices();
        return devices;
    }

    String connect(String devicdID) {
        String status = CLibrary.INSTANCE.inateck_scanner_ble_connect(devicdID);
        return status;
    }

    String checkCommunication(String devicdID) {
        String status = CLibrary.INSTANCE.inateck_scanner_ble_check_communication(devicdID);
        return status;
    }

    String auth(String devicdID) {
        String status = CLibrary.INSTANCE.inateck_scanner_ble_auth(devicdID);
        return status;
    }

    String setCodeCallback(String devicdID, EventCallback callback) {
        String status = CLibrary.INSTANCE.inateck_scanner_ble_set_code_callback(devicdID, callback);
        return status;
    }

    String setDisconnectCallback(String devicdID, EventCallback callback) {
        String status = CLibrary.INSTANCE.inateck_scanner_ble_set_disconnect_callback(devicdID, callback);
        return status;
    }

    String disconnect(String devicdID) {
        String status = CLibrary.INSTANCE.inateck_scanner_ble_disconnect(devicdID);
        return status;
    }

    String getBattery(String devicdID) {
        String status = CLibrary.INSTANCE.inateck_scanner_ble_get_battery(devicdID);
        return status;
    }

    String getHardwareVersion(String devicdID) {
        String status = CLibrary.INSTANCE.inateck_scanner_ble_get_hardware_version(devicdID);
        return status;
    }

    String beeOrShake(String devicdID) {
        String status = CLibrary.INSTANCE.inateck_scanner_ble_bee_or_shake(devicdID);
        return status;
    }

    String setBee(String devicdID, int voiceTime, int silentTime, int count) {
        String status = CLibrary.INSTANCE.inateck_scanner_set_bee(devicdID, voiceTime, silentTime, count);
        return status;
    }

    String setLed(String devicdID, int color, int lightTime, int darkTime, int count) {
        String status = CLibrary.INSTANCE.inateck_scanner_set_led(devicdID, color, lightTime, darkTime, count);
        return status;
    }

    String getSoftwareVersion(String devicdID) {
        String status = CLibrary.INSTANCE.inateck_scanner_ble_get_software_version(devicdID);
        return status;
    }

    String getMac(String devicdID) {
        String status = CLibrary.INSTANCE.inateck_scanner_ble_get_mac(devicdID);
        return status;
    }

    String getSettingInfo(String devicdID, InateckDeviceType deviceType) {
        String status = CLibrary.INSTANCE.inateck_scanner_ble_get_setting_info(devicdID, deviceType.getValue());
        return status;
    }

    String setSettingInfo(String devicdID, String cmd, InateckDeviceType deviceType) {
        String status = CLibrary.INSTANCE.inateck_scanner_ble_set_setting_info(devicdID, cmd, deviceType.getValue());
        return status;
    }

    String setName(String devicdID, String name) {
        String status = CLibrary.INSTANCE.inateck_scanner_ble_set_name(devicdID, name);
        return status;
    }

    String setTime(String devicdID, long name) {
        String status = CLibrary.INSTANCE.inateck_scanner_ble_set_time(devicdID, name);
        return status;
    }

    String inventoryClearCache(String devicdID) {
        String status = CLibrary.INSTANCE.inateck_scanner_ble_inventory_clear_cache(devicdID);
        return status;
    }

    String inventoryUploadCache(String devicdID) {
        String status = CLibrary.INSTANCE.inateck_scanner_ble_inventory_upload_cache(devicdID);
        return status;
    }

    String inventoryUploadCacheNumber(String devicdID) {
        String status = CLibrary.INSTANCE.inateck_scanner_ble_inventory_upload_cache_number(devicdID);
        return status;
    }

    String reset(String devicdID) {
        String status = CLibrary.INSTANCE.inateck_scanner_ble_reset(devicdID);
        return status;
    }

    String restart(String devicdID) {
        String status = CLibrary.INSTANCE.inateck_scanner_ble_restart(devicdID);
        return status;
    }

    String closeAllCode(String devicdID) {
        String status = CLibrary.INSTANCE.inateck_scanner_ble_close_all_code(devicdID);
        return status;
    }

    String openAllCode(String devicdID) {
        String status = CLibrary.INSTANCE.inateck_scanner_ble_open_all_code(devicdID);
        return status;
    }

    String resetAllCode(String devicdID) {
        String status = CLibrary.INSTANCE.inateck_scanner_ble_reset_all_code(devicdID);
        return status;
    }

    String getPrefix(String devicdID) {
        String status = CLibrary.INSTANCE.inateck_scanner_ble_get_prefix(devicdID);
        return status;
    }

    String setPrefix(String devicdID, byte[] prefix, int prefixLen) {
        String status = CLibrary.INSTANCE.inateck_scanner_ble_set_prefix(devicdID, prefix, prefixLen);
        return status;
    }

    String getSuffix(String devicdID) {
        String status = CLibrary.INSTANCE.inateck_scanner_ble_get_suffix(devicdID);
        return status;
    }

    String setSuffix(String devicdID, byte[] suffix, int suffixLen) {
        String status = CLibrary.INSTANCE.inateck_scanner_ble_set_suffix(devicdID, suffix, suffixLen);
        return status;
    }

    String sdkVersion() {
        String status = CLibrary.INSTANCE.inateck_scanner_ble_sdk_version();
        return status;
    }

    int setDebug(int is_debug) {
        int status = CLibrary.INSTANCE.inateck_scanner_ble_set_debug(is_debug);
        return status;
    }

    int sendHidText(String text) {
        int status = CLibrary.INSTANCE.inateck_scanner_ble_send_hid_text(text);
        return status;
    }

    String setHidOutput(String devicdID, int outputType) {
        String status = CLibrary.INSTANCE.inateck_scanner_ble_set_hid_output(devicdID, outputType);
        return status;
    }   
}
