package com.bitmap.szlizb.musicsample.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bitmap.szlizb.musicsample.R;
import com.bitmap.szlizb.musicsample.entity.Song;

import java.util.List;

/**
 * Created by szlizb on 2016/6/23.
 */

public class MusicAdapter extends BaseAdapter{
    //上下文
    private Context context;
    //歌曲列表
    private List<Song> songlist;
    //xml
    private LayoutInflater inflater;

    public MusicAdapter(Context context, List<Song>songlist, ListView listView){
        this.context=context;
        this.songlist=songlist;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return songlist.size();
    }

    @Override
    public Object getItem(int position) {
        return songlist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        Song song=new Song();
        if(convertView == null){
            convertView = inflater.inflate(R.layout.item_lv_music, null);
            holder = new ViewHolder();
            holder.tvName = (TextView) convertView.findViewById(R.id.tvName);
            holder.tvSinger = (TextView) convertView.findViewById(R.id.tvSinger);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
//        Song  song=getItem(position);


        return convertView;
    }
    class ViewHolder{
        TextView tvName;
        TextView tvSinger;
        ImageView ivAlbum;
    }
}
