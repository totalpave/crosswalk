// Copyright (c) 2014 Intel Corporation. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

package org.xwalk.core;

import android.content.Context;
import android.content.res.Resources;
import org.chromium.base.BaseChromiumApplication;

/**
 * This class is deprecated.
 *
 * XWalkApplication is to support cross package resource loading.
 * It provides method to allow overriding getResources() behavior.
 */
public class XWalkApplication extends BaseChromiumApplication {
    private static XWalkApplication gApp = null;
    private Resources mRes = null;

    @Override
    public void onCreate(){
        super.onCreate();
        gApp = this;
    }

    /**
     * In embedded mode, returns a Resources instance for the application's package. In shared mode,
     * returns a mised Resources instance that can get resources not only from the application but
     * also from the shared library across package.
     */
    @Override
    public Resources getResources() {
        return mRes == null ? super.getResources() : mRes;
    }

    void addResource(Resources res) {
        if (mRes != null) return;
        mRes = new XWalkMixedResources(super.getResources(), res);
    }

    static XWalkApplication getApplication() {
        return gApp;
    }
}
