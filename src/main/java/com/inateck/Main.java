package com.inateck;

public class Main {
    public static void main(String[] args) {
        ScannerBle scanner = new ScannerBle();
        int status = scanner.registerEventCallback((result) -> {
            System.out.println(result);
        });
        if (status != 0) {
            System.out.println("init failed: " + status);
            System.exit(1);
        }
        System.out.println("init success");
        System.out.println("you can input command: > scan, > stop, > devices, > connect, > disconnect, > version, > battery, > software, > settingInfo, > closeVolume, > openVolume, > destroy");
        while (true) {
            String inputStr = System.console().readLine();
            String[] cmd = inputStr.split(" ");
            String start = cmd[0];
            if (!start.equals(">")) {
                System.out.println("Invalid command, example: > scan");
                continue;
            }
            String method = cmd[1];
            if (method == null) {
                System.out.println("Invalid command, example: > scan");
                continue;
            }
            if (method.equals("scan")) {
                status = scanner.startScan();
                System.out.println("status: " + status);
            } else if (method.equals("stop")) {
                status = scanner.stopScan();
                System.out.println("status: " + status);
            } else if (method.equals("devices")) {
                String devices = scanner.getDevices();
                System.out.println("devices: " + devices);
            } else if (method.equals("connect")) {
                String mac = cmd[2];
                if (mac == null) {
                    System.out.println("Invalid command, example: > connect fb556f1d-f919-2d4d-c98c-fcbe246af2e4");
                    continue;
                }
                String device = scanner.connect(mac, (result) -> {
                    System.out.println(result);
                });
                scanner.auth(mac);
                System.out.println("device: " + device);
            } else if (method.equals("disconnect")) {
                String mac = cmd[2];
                if (mac == null) {
                    System.out.println("Invalid command, example: > disconnect fb556f1d-f919-2d4d-c98c-fcbe246af2e4");
                    continue;
                }
                int device = scanner.disconnect(mac);
                System.out.println("device: " + device);
            } else if (method.equals("version")) {
                String mac = cmd[2];
                if (mac == null) {
                    System.out.println("Invalid command, example: > version fb556f1d-f919-2d4d-c98c-fcbe246af2e4");
                    continue;
                }
                String version = scanner.getHardwareVersion(mac);
                System.out.println("version: " + version);
            } else if (method.equals("battery")) {
                String mac = cmd[2];
                if (mac == null) {
                    System.out.println("Invalid command, example:" + " > battery fb556f1d-f919-2d4d-c98c-fcbe246af2e4");
                }
                String battery = scanner.getBattery(mac);
                System.out.println("battery: " + battery);
            } else if (method.equals("software")) {
                String mac = cmd[2];
                if (mac == null) {
                    System.out.println("Invalid command, example: > software fb556f1d-f919-2d4d-c98c-fcbe246af2e4");
                    continue;
                }
                String software = scanner.getSoftwareVersion(mac);
                System.out.println("software: " + software);
            } else if (method.equals("settingInfo")) {
                String mac = cmd[2];
                if (mac == null) {
                    System.out.println("Invalid command, example: > settingInfo fb556f1d-f919-2d4d-c98c-fcbe246af2e4");
                    continue;
                }
                String settingInfo = scanner.getSettingInfo(mac);
                System.out.println("settingInfo: " + settingInfo);
            } else if (method.equals("closeVolume")) {
                String mac = cmd[2];
                if (mac == null) {
                    System.out.println("Invalid command, example: > closeVolume fb556f1d-f919-2d4d-c98c-fcbe246af2e4");
                    continue;
                }
                String closeVolume = "[{\"area\":\"3\",\"value\":\"0\",\"name\":\"volume\"}]";
                String info = scanner.setSettingInfo(mac, closeVolume);
                System.out.println("settingInfo: " + info);
            } else if (method.equals("openVolume")) {
                String mac = cmd[2];
                if (mac == null) {
                    System.out.println("Invalid command, example: > closeVolume fb556f1d-f919-2d4d-c98c-fcbe246af2e4");
                    continue;
                }
                String closeVolume = "[{\"area\":\"3\",\"value\":\"4\",\"name\":\"volume\"}]";
                String info = scanner.setSettingInfo(mac, closeVolume);
                System.out.println("settingInfo: " + info);
            } else if (method.equals("destroy")) {
                scanner.destroy();
            } else {
                System.out.println("Invalid command, example: > scan");
            }
        }
    }
}
