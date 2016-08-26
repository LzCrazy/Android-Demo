package com.bitmap.szlizb.musicsample.entity;

/**
 * Created by szlizb on 2016/6/22.
 */

import java.util.ArrayList;
import java.util.List;

import static android.R.id.list;

/**
 * 描述一首歌
 */
public class Song {
    //大图片
    private String pic_big;
    //小图片
    private String pic_small;
    //歌词链接
    private String lrclink;
    //歌曲的ID
    private String song_id;
    //歌曲的标题
    private String song_title;
    //作者
    private String author;
    //专辑的标题
    private String alum_title;
    //作者名
    private String artist_name;
    //音乐的路径
    private List<SongUrl>urls=new ArrayList<>();
    //音乐信息
    private SongInfo songInfo;
    //歌词
    private List<LrcLine>lrc;

}

