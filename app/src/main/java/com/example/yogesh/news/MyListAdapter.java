package com.example.yogesh.news;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Yogesh on 7/27/2018.
 */

 public class MyListAdapter extends SimpleAdapter{
    private Context mContext;
    public LayoutInflater inflater = null;

    public MyListAdapter(Context context, List data, int resource, String[] from, int[] to) {
        super(context, data, resource, from, to);
        this.mContext=context;
        inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View vi = convertView;
        if (convertView == null) {
            vi = inflater.inflate(R.layout.newslist, null);
        }

        HashMap<String, Object> data = (HashMap<String, Object>) getItem(position);

        DownloadTask ob= new DownloadTask((ImageView) vi.findViewById(R.id.im1),
                (String) data.get("k4"));
        ob.execute();

        TextView t= (TextView)vi.findViewById(R.id.t1);
        t.setText((String)data.get("k1"));
        t= (TextView)vi.findViewById(R.id.t2);
        t.setText((String)data.get("k2"));
        t= (TextView)vi.findViewById(R.id.t3);
        t.setText((String)data.get("k3"));
        return vi;
    }
}

