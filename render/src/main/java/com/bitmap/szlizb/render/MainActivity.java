package com.bitmap.szlizb.render;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.renderscript.Allocation;
import android.renderscript.RenderScript;
import android.widget.ImageView;

public class MainActivity extends Activity {
    private Bitmap mBitmapIn, mBitmapOut;
    private RenderScript mRS;

    private Allocation mInAllocation, mOutAllocation;
    private ScriptC_mono mScript;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mBitmapIn = loadBitmap(R.drawable.data);
        mBitmapOut = Bitmap.createBitmap(mBitmapIn.getWidth(), mBitmapIn.getHeight(),
                mBitmapIn.getConfig());

        ImageView in = (ImageView) findViewById(R.id.displayin);
        in.setImageBitmap(mBitmapIn);

        ImageView out = (ImageView) findViewById(R.id.displayout);
        out.setImageBitmap(mBitmapOut);

        createScript();

    }

    private void createScript() {
        mRS = RenderScript.create(this);
        //从一个bitmap 创建一个allocation
        mInAllocation = Allocation.createFromBitmap(mRS, mBitmapIn,
                Allocation.MipmapControl.MIPMAP_NONE, Allocation.USAGE_SCRIPT);

        mOutAllocation= Allocation.createTyped(mRS, mInAllocation.getType());

        mScript=new ScriptC_mono(mRS, getResources(), R.raw.mono);
        mScript.set_gIn(mInAllocation);

        mScript.set_gOut(mOutAllocation);

        mScript.set_gScript(mScript);

        mScript.invoke_filter();

        mOutAllocation.copyTo(mBitmapOut);


    }

    private Bitmap loadBitmap(int resource) {
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        return BitmapFactory.decodeResource(getResources(), resource, options);
    }

}