package com.inateck;

public class RustJNI {
    static {
        System.loadLibrary("java_scanner");
    }

    public static void main(String[] args) {
       // init();
        RustJNI jni = new RustJNI();
        System.out.println("scan: " + jni.scan());
        System.out.println("connect: " + jni.connect("F7:7C:4A:1F:FB:3E","com.inateck.scanner","693be162686a","SrwG8UsCC6Fp7OSCDfckFHtfnNF8MRg9CmIvDgHXoFNFRsm3uiQviNtkyOfc//+m2ZpZ32uK3Z5g83optZwpZUFlnmX9DdyvYaaOqzIUJvruixZ3AfKmA/jYKxhbAhjvMLgoW+tHyPnARkJRAMMRULnayq4BLFXm47WGxVVQFXg="));
        System.out.println("getBarcodeProperties: " + jni.getBarcodeProperties("F7:7C:4A:1F:FB:3E"));

    }

     native String scan();
     native String connect(String device,String appId,String developerId,String appKey);
     native String getBasicProperties(String device,String key);
     native String getPropertiesInfo(String device,String key);
     native String editPropertiesInfo(String device,String key,String data);
     native String getBarcodeProperties(String device);
}
