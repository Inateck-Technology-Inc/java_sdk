package com.inateck;

// if __name__ == '__main__':
//     inateck = InateckScannerBle()
//     status = inateck.registerEvent(scan_callback)
//     if status != 0:
//         print("init failed: %d" % (status))
//         exit(1)
//     print("init success")
//     print("you can input command: > scan, > stop, > devices, > connect, > disconnect, > version, > battery, > software, > settingInfo, > closeVolume, > openVolume, > destroy")
//     while True:
//         input_str = input("")
//         cmd = input_str.split(' ')
//         start = cmd[0]
//         if start != '>':
//             print("Invalid command, example: > scan")
//             continue
//         method = cmd[1]
//         if method == None:
//             print("Invalid command, example: > scan")
//             continue
//         if method == 'scan':
//             status = inateck.startScan()
//             print("status: %d" % (status))
//         elif method == 'stop':
//             status = inateck.stopScan()
//             print("status: %d" % (status))
//         elif method == 'devices':
//             devices = inateck.getDevices()
//             print("devices: %s" % (devices))
//         elif method == 'connect':
//             mac = cmd[2]
//             if mac == None:
//                 print("Invalid command, example: > connect fb556f1d-f919-2d4d-c98c-fcbe246af2e4")
//                 continue
//             device = inateck.connect(mac)
//             inateck.auth(mac)
//             print("device: %s" % (device))
//         elif method == 'disconnect':
//             mac = cmd[2]
//             if mac == None:
//                 print("Invalid command, example: > disconnect fb556f1d-f919-2d4d-c98c-fcbe246af2e4")
//                 continue
//             device = inateck.disconnect(mac)
//             print("device: %d" % (device))
//         elif method == 'version':
//             mac = cmd[2]
//             if mac == None:
//                 print("Invalid command, example: > version fb556f1d-f919-2d4d-c98c-fcbe246af2e4")
//                 continue
//             version = inateck.getHardwareVersion(mac)
//             print("version: %s" % (version))
//         elif method == 'battery':
//             mac = cmd[2]
//             if mac == None:
//                 print("Invalid command, example: > battery fb556f1d-f919-2d4d-c98c-fcbe246af2e4")
//                 continue
//             battery = inateck.getBattery(mac)
//             print("battery: %s" % (battery))
//         elif method == 'software':
//             mac = cmd[2]
//             if mac == None:
//                 print("Invalid command, example: > software fb556f1d-f919-2d4d-c98c-fcbe246af2e4")
//                 continue
//             software = inateck.getSoftwareVersion(mac)
//             print("software: %s" % (software))
//         elif method == 'settingInfo':
//             mac = cmd[2]
//             if mac == None:
//                 print("Invalid command, example: > settingInfo fb556f1d-f919-2d4d-c98c-fcbe246af2e4")
//                 continue
//             settingInfo = inateck.getSettingInfo(mac)
//             print("settingInfo: %s" % (settingInfo))
//         elif method == 'closeVolume':
//             mac = cmd[2]
//             if mac == None:
//                 print("Invalid command, example: > closeVolume fb556f1d-f919-2d4d-c98c-fcbe246af2e4")
//                 continue
//             closeVolume = '[{"area":"3","value":"0","name":"volume"}]'
//             status = inateck.setSettingInfo(mac, closeVolume)
//             print("settingInfo: %s" % (status))
//         elif method == 'openVolume':
//             mac = cmd[2]
//             if mac == None:
//                 print("Invalid command, example: > closeVolume fb556f1d-f919-2d4d-c98c-fcbe246af2e4")
//                 continue
//             closeVolume = '[{"area":"3","value":"4","name":"volume"}]'
//             status = inateck.setSettingInfo(mac, closeVolume)
//             print("settingInfo: %s" % (status))
//         elif method == 'destroy':
//             inateck.destroy()
//         else:
//             print("Invalid command, example: > scan")

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
