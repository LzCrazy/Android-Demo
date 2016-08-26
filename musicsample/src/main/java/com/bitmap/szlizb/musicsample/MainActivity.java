package com.bitmap.szlizb.musicsample;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.bitmap.szlizb.musicsample.adapter.MusicAdapter;
import com.bitmap.szlizb.musicsample.fragment.HotFragment;
import com.bitmap.szlizb.musicsample.fragment.NewFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity {
    //Viewpager
    private ViewPager viewPager;
    //Fragment
    private Fragment HotFragment, NewFragment;
    //Fragment集合
    private List<Fragment> fragments;
    //Adapter
    private MusicAdapter musicAdapter;
    //PagerAdapter
    private MusicPagerAdapter pagerAdapter;
    //group
    private RadioGroup radioGroup;
    //radiobutton
    private RadioButton rbNew;
    private RadioButton rbHot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化控件
        setView();
        //设置适配器
        setAdapter();
        //设置监听
        setListener();

    }
    private void setListener(){
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId==R.id.newMusic){
                    viewPager.setCurrentItem(0);
                }else{
                    viewPager.setCurrentItem(1);
                }
            }
        });

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if(position == 0){
                    rbNew.setChecked(true);
                }else{
                    rbHot.setChecked(true);
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void setAdapter() {
        fragments = new ArrayList<>();
        fragments.add(new HotFragment());
        fragments.add(new NewFragment());
        //创建fragment的Adapter
       pagerAdapter=new MusicPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);
    }

    //为viewpager编写适配器
    class MusicPagerAdapter extends FragmentPagerAdapter{

        public MusicPagerAdapter(FragmentManager fm) {
            super(fm);
        }
        public Fragment getItem(int position) {
            return fragments.get(position);
        }
        public int getCount() {
            return fragments.size();
        }

    }

    private void setView() {
        viewPager = (ViewPager) findViewById(R.id.vp_music);
        rbHot=(RadioButton)findViewById(R.id.HotMusic);
        rbNew=(RadioButton)findViewById(R.id.newMusic);
        radioGroup=(RadioGroup)findViewById(R.id.rgMusic);
    }
}
