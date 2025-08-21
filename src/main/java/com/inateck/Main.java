package com.inateck;

// latest lib version:
// https://github.com/Inateck-Technology-Inc/scanner_lib

public class Main {

    static void connect(ScannerBle scanner, String deviceID) {
        scanner.connect(deviceID);
        scanner.checkCommunication(deviceID);
        scanner.auth(deviceID);
        scanner.setCodeCallback(deviceID, (result) -> {
            System.out.println("code: " + result);
        });
    }

    static void getHardwareVersion(ScannerBle scanner, String deviceID) {
        String hardwareVersion = scanner.getHardwareVersion(deviceID);
        System.out.println("hardwareVersion: " + hardwareVersion);
    }

    static void getSoftwareVersion(ScannerBle scanner, String deviceID) {
        String softwareVersion = scanner.getSoftwareVersion(deviceID);
        System.out.println("softwareVersion: " + softwareVersion);
    }

    static void getSettingInfo(ScannerBle scanner, String deviceID) {
        String settingInfo = scanner.getSettingInfo(deviceID, InateckDeviceType.ST75);
        System.out.println("settingInfo: " + settingInfo);
    }

    static void quietMode(ScannerBle scanner, String deviceID) {
        String closeVolume = "[{\"flag\":1001,\"value\":0}]";
        String info = scanner.setSettingInfo(deviceID, closeVolume, InateckDeviceType.ST75);
        scanner.beeOrShake(deviceID);
        System.out.println("quiet Mode： " + info);
    }

    static void loudMode(ScannerBle scanner, String deviceID) {
        String openVolume = "[{\"flag\":1001,\"value\":4}]";
        String info = scanner.setSettingInfo(deviceID, openVolume, InateckDeviceType.ST75);
        scanner.beeOrShake(deviceID);
        System.out.println("loud Mode： " + info);
    }

    static void sleep(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        ScannerBle scanner = new ScannerBle();
        scanner.setDebug(1);
        scanner.init();
        scanner.waitAvailable();
        
        scanner.setDiscoverCallback((result) -> {
            System.out.println("discover: " + result);
        });
        scanner.startScan();
        // sleep 10s
        sleep(10000);
        scanner.stopScan();

        String deviceID = "BluetoothLE#BluetoothLEf4:4e:fc:89:ee:4a-aa:2b:00:03:95:83";

        connect(scanner, deviceID);

        sleep(10000);

        scanner.beeOrShake(deviceID);

        sleep(5000);

        getHardwareVersion(scanner, deviceID);

        getSoftwareVersion(scanner, deviceID);

        getSettingInfo(scanner, deviceID);

        quietMode(scanner, deviceID);

        sleep(5000);

        loudMode(scanner, deviceID);

        sleep(5000);
    }
}
