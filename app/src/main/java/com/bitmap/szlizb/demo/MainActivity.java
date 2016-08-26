package com.bitmap.szlizb.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
 /*   private ImageView imageView;
    private ImageView imageView1;*/

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
     /*  imageView = (ImageView) findViewById(R.id.iv_image);
        imageView1=(ImageView)findViewById(R.id.iv_image1);
        imageView.setImageResource(R.mipmap.ic_launcher);
        imageView1.setImageResource(R.mipmap.ic_launcher);*/
       /* //图片缓存
        getDrawingCache(imageView,imageView1);*/


       /* //图片圆角处理
        getRoundedBitmap();*/

      /*  //图片灰画处理
        getGrayBitmap();*/

/*
        //提取图像Alpna位图
        getAlphaBitmap();*/



    }






/*
    public Bitmap getAlphaBitmap() {
        BitmapDrawable bitmapDrawable=(BitmapDrawable)getResources().getDrawable(R.mipmap.ic_launcher);
        Bitmap bitmap=bitmapDrawable.getBitmap();
        //BitmapDrawable的getIntrinsicwidth()   Bitmap的getWidth()
//        Bitmap bitmap1=Bitmap.createBitmap(bitmapDrawable.getIntrinsicWidth(),bitmapDrawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Bitmap AlphaBitmap=Bitmap.createBitmap(bitmap.getWidth(),bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas=new Canvas(AlphaBitmap);
        Paint paint=new Paint();
        paint.setColor(Color.RED);
        //从位图中提取包含alpha的位图
        Bitmap alphaBitmap=bitmap.extractAlpha();
        //在画布上（AlphaBitmap)绘制alpha位图
        canvas.drawBitmap(alphaBitmap,0,0,paint);
        return AlphaBitmap;
    }*/




/*
    //图片灰画处理
    public Bitmap getGrayBitmap() {
        Bitmap bitmap= BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher);
        Bitmap mGrayBitmap=Bitmap.createBitmap(bitmap.getWidth(),bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas=new Canvas(mGrayBitmap);
        Paint paint=new Paint();
        //创建颜色变化矩形
        ColorMatrix colorMatrix=new ColorMatrix() ;
        //设置灰度印象范围
        colorMatrix.setSaturation(0);
        //创建颜色过滤矩陈
        ColorMatrixColorFilter colorMatrixColorFilter=new ColorMatrixColorFilter(colorMatrix);

        //设置画笔的颜色过滤矩陈
        paint.setColorFilter(colorMatrixColorFilter);
        //使用处理后的画笔绘制图像
        canvas.drawBitmap(bitmap,0,0,paint);
        return mGrayBitmap;
    }*/



/*

    //图片圆角处理
    public Bitmap getRoundedBitmap() {
        Bitmap mBitmap= BitmapFactory.decodeResource(getResources(),R.id.frame);
        //创建新的位图
        Bitmap bgBitmap=Bitmap.createBitmap(mBitmap.getWidth(),mBitmap.getHeight(), Bitmap.Config.ARGB_8888);
        //把创建的位图当做画板
        Canvas mCanvas=new Canvas(bgBitmap);

        Paint mPaint=new Paint();
        //矩形
        Rect mRect=new Rect(0,0,mBitmap.getWidth(),mBitmap.getHeight());
        RectF mRectF=new RectF(mRect);
        //设置圆角半径
        float roundPx=15;
        mPaint.setAntiAlias(true);
        //先绘制圆角矩形
        mCanvas.drawRoundRect(mRectF, roundPx, roundPx, mPaint);
        //设置图像的叠加模式
        mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        //绘制图像
        mCanvas.drawBitmap(mBitmap,mRect,mRect,mPaint);
        return bgBitmap;

    }
*/



 /*
    //view转化为bitmap
    public void getDrawingCache(final ImageView sourceImageView, final ImageView destImageView){

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //开启bitmap缓存
                sourceImageView.setDrawingCacheEnabled(true);
                //获取bitmap缓存
                Bitmap bitmap=sourceImageView.getDrawingCache();
                //显示 bitmap
                destImageView.setImageBitmap(bitmap);

               *//* Bitmap bitmap1=sourceImageView.getDrawingCache();
                Drawable drawable=(Drawable)new BitmapDrawable(bitmap);
                destImageView.setImageDrawable(drawable);*//*

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //不在显示bitmap缓存
                        //destImageView.setImageBitmap(null);
                        destImageView.setImageResource(R.mipmap.h1);

                        //不显示bitmap
                        sourceImageView.setBackground(null);
                        //关闭bitmap缓存
                        sourceImageView.setDrawingCacheEnabled(false);
                        //释放bitmap缓存资源
                        sourceImageView.destroyDrawingCache();
                    }
                },1000);

            }
        },1000);
    }*/
}
