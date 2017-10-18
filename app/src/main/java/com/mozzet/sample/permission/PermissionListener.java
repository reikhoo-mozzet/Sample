package com.mozzet.sample.permission;

import java.util.Map;

public interface PermissionListener {
    void onAllPermissionGranted();

    void onPermissionDenied(Map<String, Integer> permissionMap);
}