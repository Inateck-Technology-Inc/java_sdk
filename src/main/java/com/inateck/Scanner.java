package com.inateck;

public class Scanner {
    static {
        System.loadLibrary("java_scanner");
    }

    public static void main(String[] args) {
       // init();
        Scanner jni = new Scanner();
        System.out.println("scan: " + jni.scan());
        System.out.println("connect: "+jni.connect("7B:AA:8C:98:10:71","com.inateck.scanner","","") );
        System.out.println("getBasicProperties: " + jni.getBasicProperties("7B:AA:8C:98:10:71","battery"));
        System.out.println("getBarcodeProperties: " + jni.getBarcodeProperties("7B:AA:8C:98:10:71"));

    }

     native String scan();
     native String connect(String device,String appId,String developerId,String appKey);
     native String disconnect(String device);
     native String getBasicProperties(String device,String key);
     native String getPropertiesInfo(String device,String key);
     native String editPropertiesInfo(String device,String key,String data);
     native String getBarcodeProperties(String device);
}