/*
 * Copyright (C) 2011 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/*
 * This file is auto-generated. DO NOT MODIFY!
 * The source Renderscript file: /home/terry/workspace/Compute/src/com/xuzhi/renderScriptCompute/mono.rs
 */
package com.bitmap.szlizb.render;

import android.renderscript.*;
import android.content.res.Resources;

/**
 * @hide
 */
public class ScriptC_mono extends ScriptC {
    // Constructor
    public  ScriptC_mono(RenderScript rs, Resources resources, int id) {
        super(rs, resources, id);
        __U8_4 = Element.U8_4(rs);
    }

    private Element __U8_4;
    private final static int mExportVarIdx_gIn = 0;
    private Allocation mExportVar_gIn;
    public void set_gIn(Allocation v) {
        mExportVar_gIn = v;
        setVar(mExportVarIdx_gIn, v);
    }

    public Allocation get_gIn() {
        return mExportVar_gIn;
    }

    private final static int mExportVarIdx_gOut = 1;
    private Allocation mExportVar_gOut;
    public void set_gOut(Allocation v) {
        mExportVar_gOut = v;
        setVar(mExportVarIdx_gOut, v);
    }

    public Allocation get_gOut() {
        return mExportVar_gOut;
    }

    private final static int mExportVarIdx_gScript = 2;
    private Script mExportVar_gScript;
    public void set_gScript(Script v) {
        mExportVar_gScript = v;
        setVar(mExportVarIdx_gScript, v);
    }

    public Script get_gScript() {
        return mExportVar_gScript;
    }

    private final static int mExportForEachIdx_root = 0;
    public void forEach_root(Allocation ain, Allocation aout) {
        // check ain
        if (!ain.getType().getElement().isCompatible(__U8_4)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        // check aout
        if (!aout.getType().getElement().isCompatible(__U8_4)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        // Verify dimensions
        Type tIn = ain.getType();
        Type tOut = aout.getType();
        if ((tIn.getCount() != tOut.getCount()) ||
            (tIn.getX() != tOut.getX()) ||
            (tIn.getY() != tOut.getY()) ||
            (tIn.getZ() != tOut.getZ()) ||
            (tIn.hasFaces() != tOut.hasFaces()) ||
            (tIn.hasMipmaps() != tOut.hasMipmaps())) {
            throw new RSRuntimeException("Dimension mismatch between input and output parameters!");
        }
        forEach(mExportForEachIdx_root, ain, aout, null);
    }

    private final static int mExportFuncIdx_filter = 0;
    public void invoke_filter() {
        invoke(mExportFuncIdx_filter);
    }

}

