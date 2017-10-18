package com.mozzet.sample.permission;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Flowable;

public class PermissionModule {

    private Map<String, Integer> mPermissionMap;
    private Activity mActivity;
    private PermissionListener mPermissionListener;
    private final int PERMISSION_REQUEST_CODE = 1004;

    public static final int PERMISSION_DENIED = PackageManager.PERMISSION_DENIED;
    public static final int PERMISSION_GRANTED = PackageManager.PERMISSION_GRANTED;
    public static final int PERMISSION_NEVER_ASK_AGAIN = -2;


    public static PermissionModule getInstance() {
        return PermissionModule.LazyHolder.INSTANCE;
    }

    private static class LazyHolder {
        public static final PermissionModule INSTANCE = new PermissionModule();
    }

    private PermissionModule() {
        mPermissionMap = new HashMap<>();
    }

    public PermissionModule setRequestPermissions(String... permissions) {
        mPermissionMap.clear();
        for (String permission : permissions) {
            mPermissionMap.put(permission, ContextCompat.checkSelfPermission(mActivity, permission));
        }
        return this;
    }

    public PermissionModule setActivity(Activity activity) {
        mActivity = activity;
        return this;
    }

    public void requestPermissions(PermissionListener listener) {
        if (!mPermissionMap.containsValue(PermissionModule.PERMISSION_DENIED)
                && !mPermissionMap.containsValue(PermissionModule.PERMISSION_NEVER_ASK_AGAIN)) {
            listener.onAllPermissionGranted();
            return;
        }
        Flowable.fromArray(mPermissionMap.keySet().toArray(new String[mPermissionMap.size()]))
                .filter(PermissionModule.this::isNeverAskedPermission)
                .forEach(PermissionModule.this::setNeverAskedPermission)
                .dispose();
        if (!mPermissionMap.containsValue(PermissionModule.PERMISSION_DENIED)) {
            listener.onPermissionDenied(mPermissionMap);
            return;
        }
        mPermissionListener = listener;
        ActivityCompat.requestPermissions(mActivity
                , mPermissionMap.keySet().toArray(new String[mPermissionMap.size()])
                , PERMISSION_REQUEST_CODE);
    }


    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        if (requestCode != PERMISSION_REQUEST_CODE
                || permissions.length <= 0 || grantResults.length <= 0) return;

        for (int i = 0; i < permissions.length; i++) {
            String permission = permissions[i];
            if (!isNeverAskedPermission(permission)) {
                mPermissionMap.put(permission, grantResults[i]);
                continue;
            }
            mPermissionMap.put(permission, PERMISSION_NEVER_ASK_AGAIN);
        }
        if (!mPermissionMap.containsValue(PermissionModule.PERMISSION_DENIED)
                && !mPermissionMap.containsValue(PermissionModule.PERMISSION_NEVER_ASK_AGAIN)) {
            mPermissionListener.onAllPermissionGranted();
        } else {
            mPermissionListener.onPermissionDenied(mPermissionMap);
        }
    }

    public static boolean hasPermission(Activity activity, String permission) {
        if (ContextCompat.checkSelfPermission(activity, permission)
                == PermissionModule.PERMISSION_DENIED) return false;
        return true;
    }

    public static boolean hasPermissions(Activity activity, String... permissions) {
        for (String permission : permissions) {
            if (ContextCompat.checkSelfPermission(activity, permission)
                    == PermissionModule.PERMISSION_DENIED) return false;
        }
        return true;
    }

    private boolean isNeverAskedPermission(String permission) {
        if (mPermissionMap.get(permission) == PermissionModule.PERMISSION_DENIED
                && ActivityCompat.shouldShowRequestPermissionRationale(mActivity, permission)) {
            return true;
        }
        return false;
    }

    private void setNeverAskedPermission(String permission) {
        mPermissionMap.put(permission, PermissionModule.PERMISSION_NEVER_ASK_AGAIN);
    }

}
