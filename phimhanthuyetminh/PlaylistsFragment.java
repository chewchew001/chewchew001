///*
// * Copyright (C) 2016 SMedic
// *
// * Licensed under the Apache License, Version 2.0 (the "License");
// * you may not use this file except in compliance with the License.
// * You may obtain a copy of the License at
// *
// *      http://www.apache.org/licenses/LICENSE-2.0
// *
// * Unless required by applicable law or agreed to in writing, software
// * distributed under the License is distributed on an "AS IS" BASIS,
// * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// * See the License for the specific language governing permissions and
// * limitations under the License.
// */
//package com.hc88.nhacdotest.fragments;
//
//import android.app.SearchManager;
//import android.content.Context;
//import android.content.Intent;
//import android.os.AsyncTask;
//import android.os.Bundle;
//import android.support.v7.widget.DefaultItemAnimator;
//import android.support.v7.widget.GridLayoutManager;
//import android.support.v7.widget.RecyclerView;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ProgressBar;
//
//import com.hc88.nhacdotest.MainActivity;
//import com.hc88.nhacdotest.R;
//import com.hc88.nhacdotest.adapters.VideoCustomAdater;
//import com.hc88.nhacdotest.interfaces.ItemEventsListener;
//import com.hc88.nhacdotest.interfaces.OnItemSelected;
//import com.hc88.nhacdotest.model.Video;
//import com.hc88.nhacdotest.model.YouTubeVideo;
//import com.hc88.nhacdotest.utils.Config;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class PlaylistsFragment extends BaseFragment implements
//        ItemEventsListener<Video> {
//    GridLayoutManager recyclerLayoutManager;
//    GridLayoutManager recyclerLayoutManager2;
//    RecyclerView recyclerView;
//    RecyclerView recyclerViewMV;
//    List<Video> listVideoDto;
//    List<Video> listVideoDtoMV;
//    private ProgressBar processBar;
//    //private AdView mAdView;
//
//    private Context context;
//    public static OnItemSelected itemSelected;
//
//    public PlaylistsFragment() {
//        // Required empty public constructor
//    }
//
//    public static PlaylistsFragment newInstance() {
//        return new PlaylistsFragment();
//    }
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//    }
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        View v = inflater.inflate(R.layout.home_layout, container, false);
//        //mAdView = (AdView) v.findViewById(R.id.adView);
////        AdRequest adRequest = new AdRequest.Builder()
////                //.addTestDevice(Constants.TEST_DEVICE_ID)
////                .build();
//        //mAdView.loadAd(adRequest);
//
//        /* Setup the ListView */
//        processBar =(ProgressBar) v.findViewById(R.id.progressBar);
//        recyclerViewMV = (RecyclerView) v.findViewById(R.id.myRecyclerViewMV);
//        recyclerView = (RecyclerView) v.findViewById(R.id.myRecyclerView);
//
//
//        recyclerLayoutManager = new GridLayoutManager(getContext(), 2, GridLayoutManager.VERTICAL, false);
//        recyclerViewMV.setLayoutManager(recyclerLayoutManager);
//        recyclerViewMV.setItemAnimator(new DefaultItemAnimator());
//
//        recyclerLayoutManager2 = new GridLayoutManager(getContext(), 2, GridLayoutManager.VERTICAL, false);
//        recyclerView.setLayoutManager(recyclerLayoutManager2);
//        recyclerView.setItemAnimator(new DefaultItemAnimator());
//        new getData().execute();
//        return v;
//    }
//
//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        if (context instanceof MainActivity) {
//            this.context = context;
//            itemSelected = (MainActivity) context;
//        }
//    }
//
//    @Override
//    public void onDetach() {
//        super.onDetach();
//        this.context = null;
//        this.itemSelected = null;
//    }
//
//    @Override
//    public void onResume() {
//        super.onResume();
//        updateList();
//    }
//
//
//
//    @Override
//    public void onShareClicked(String itemId) {
//        share(Config.SHARE_PLAYLIST_URL + itemId);
//    }
//
//    @Override
//    public void onFavoriteClicked(YouTubeVideo video, boolean isChecked) {
//        //do nothing
//    }
//
//    @Override
//    public void onItemClick(Video video) {
//        //results are in onVideosReceived callback method
//        Intent suggestionIntent = new Intent(Intent.ACTION_SEARCH);
//        suggestionIntent.putExtra(SearchManager.QUERY, video.getKeySearch());
//        itemSelected.handleIntentTest(suggestionIntent);
//    }
//
//    @Override
//    public void updateList() {
//    }
//
//    //////// parse json /////////////////
//    private class getData extends AsyncTask<String, Void, Void> {
//        @Override
//        protected void onPreExecute() {
//            super.onPreExecute();
//            processBar.setVisibility(View.VISIBLE);
//        }
//        @Override
//        protected Void doInBackground(String... arg0) {
//            Video vd = new Video();
//            vd = new Video();
//            listVideoDto  = new ArrayList<>();
//            vd = new Video();
//            listVideoDtoMV = new ArrayList<Video>();
//            vd.setTitle("Nhạc Đỏ Tuyển Chọn");
//            vd.setBigThumbUrl("https://raw.githubusercontent.com/hc88media/hc88_nhacremixnhacdj/master/anh/nhacdotuyenchon.jpg");
//            vd.setKeySearch("nhạc đỏ tuyển chọn");
//            listVideoDto.add(vd);
//
//            vd = new Video();
//            vd.setTitle("Nhạc Đỏ NSUT Trọng Thủy");
//            vd.setBigThumbUrl("https://raw.githubusercontent.com/hc88media/hc88_nhacremixnhacdj/master/anh/nhacdotrongthuy.jpg");
//            vd.setKeySearch("Nhạc Đỏ NSUT Trọng Thủy");
//            listVideoDto.add(vd);
//
//            vd = new Video();
//            vd.setTitle("Nhạc Đỏ Thu Hiền");
//            vd.setBigThumbUrl("https://raw.githubusercontent.com/hc88media/hc88_nhacremixnhacdj/master/anh/nhacdothuhien.jpg");
//            vd.setKeySearch("nhạc đỏ thu hiền");
//            listVideoDto.add(vd);
//
//            vd = new Video();
//            vd.setTitle("Nhạc Đỏ Anh Thơ");
//            vd.setBigThumbUrl("https://raw.githubusercontent.com/hc88media/hc88_nhacremixnhacdj/master/anh/nhacdoanhtho.jpg");
//            vd.setKeySearch("Nhạc Đỏ Anh Thơ");
//            listVideoDto.add(vd);
//
//            vd = new Video();
//            vd.setTitle("Nhạc Đỏ Trọng Tấn");
//            vd.setBigThumbUrl("https://raw.githubusercontent.com/hc88media/hc88_nhacremixnhacdj/master/anh/nhacdotrongtan.jpg");
//            vd.setKeySearch("Nhạc Đỏ Trọng Tấn");
//            listVideoDto.add(vd);
//
//            vd = new Video();
//            vd.setTitle("Nhạc Đỏ Trung Đức");
//            vd.setBigThumbUrl("https://raw.githubusercontent.com/hc88media/hc88_nhacremixnhacdj/master/anh/nhacdotrungduc.jpg");
//            vd.setKeySearch("Nhạc Đỏ Trung Đức");
//            listVideoDto.add(vd);
//
//            vd = new Video();
//            vd.setTitle("Nhạc Cách mạng");
//            vd.setBigThumbUrl("https://raw.githubusercontent.com/hc88media/hc88_nhacremixnhacdj/master/anh/nhacdocachmang.jpg");
//            vd.setKeySearch("Nhạc Cách mạng");
//            listVideoDto.add(vd);
//
//            vd = new Video();
//            vd.setTitle("Nhạc Tiền  Chiến");
//            vd.setBigThumbUrl("https://raw.githubusercontent.com/hc88media/hc88_nhacremixnhacdj/master/anh/nhacdotienchien.jpg");
//            vd.setKeySearch("Nhạc Tiền  Chiến");
//            listVideoDto.add(vd);
//
//            vd = new Video();
//            vd.setTitle("Nhạc Người Lính");
//            vd.setBigThumbUrl("https://raw.githubusercontent.com/hc88media/hc88_nhacremixnhacdj/master/anh/nhacdonguoilinh.jpg");
//            vd.setKeySearch("Nhạc Người Lính cách mạng");
//            listVideoDto.add(vd);
//
//            vd = new Video();
//            vd.setTitle("Nhạc Năm 75");
//            vd.setBigThumbUrl("https://raw.githubusercontent.com/hc88media/hc88_nhacremixnhacdj/master/anh/nhacdo75.jpg");
//            vd.setKeySearch("Nhạc Năm thập niên 75");
//            listVideoDto.add(vd);
//
//            vd = new Video();
//            vd.setTitle("Liên Khúc Nhạc Đỏ remix");
//            vd.setKeySearch("Liên Khúc  Nhạc Đỏ remix");
//            vd.setBigThumbUrl("https://raw.githubusercontent.com/hc88media/hc88_nhacremixnhacdj/master/anh/nhacdoremix.jpg");
//            listVideoDto.add(vd);
//
//            vd = new Video();
//            vd.setTitle("Liên Khúc  Nhạc Cách mạng remix");
//            vd.setKeySearch("Liên Khúc  Nhạc Cách mạng remix");
//            vd.setBigThumbUrl("https://raw.githubusercontent.com/hc88media/hc88_nhacremixnhacdj/master/anh/nhacdocachmangremix.jpg");
//            listVideoDto.add(vd);
//
////            vd = new Video();
////            vd.setTitle("MV Dân ca quê hương");
////            vd.setKeySearch("MV Dân ca quê hương");
////            vd.setBigThumbUrl("https://raw.githubusercontent.com/hc88media/hc88_nhacremixnhacdj/master/anh/dancaquehuong.jpg");
////            listVideoDto.add(vd);
//
//
//
//            //----------------------------
//            listVideoDtoMV  = new ArrayList<>();
//            vd = new Video();
//            listVideoDtoMV = new ArrayList<Video>();
//            vd.setTitle("MV Nhạc Đỏ Tuyển Chọn");
//            vd.setBigThumbUrl("https://raw.githubusercontent.com/hc88media/hc88_nhacremixnhacdj/master/anh/nhacdotuyenchon.jpg");
//            vd.setKeySearch("mv nhạc đỏ tuyển chọn");
//            listVideoDtoMV.add(vd);
//
//            vd = new Video();
//            vd.setTitle("MV Nhạc Đỏ NSUT Trọng Thủy");
//            vd.setBigThumbUrl("https://raw.githubusercontent.com/hc88media/hc88_nhacremixnhacdj/master/anh/nhacdotrongthuy.jpg");
//            vd.setKeySearch("MV Nhạc Đỏ NSUT Trọng Thủy");
//            listVideoDto.add(vd);
//
//
//            vd = new Video();
//            vd.setTitle("MV Nhạc Đỏ Thu Hiền");
//            vd.setBigThumbUrl("https://raw.githubusercontent.com/hc88media/hc88_nhacremixnhacdj/master/anh/nhacdothuhien.jpg");
//            vd.setKeySearch("MV nhạc đỏ thu hiền");
//            listVideoDtoMV.add(vd);
//
//            vd = new Video();
//            vd.setTitle("MV Nhạc Đỏ Anh Thơ");
//            vd.setBigThumbUrl("https://raw.githubusercontent.com/hc88media/hc88_nhacremixnhacdj/master/anh/nhacdoanhtho.jpg");
//            vd.setKeySearch("MV Nhạc Đỏ Anh Thơ");
//            listVideoDtoMV.add(vd);
//
//            vd = new Video();
//            vd.setTitle("MV Nhạc Đỏ Trọng Tấn");
//            vd.setBigThumbUrl("https://raw.githubusercontent.com/hc88media/hc88_nhacremixnhacdj/master/anh/nhacdotrongtan.jpg");
//            vd.setKeySearch("MV Nhạc Đỏ Trọng Tấn");
//            listVideoDtoMV.add(vd);
//
//            vd = new Video();
//            vd.setTitle("MV Nhạc Đỏ Trung Đức");
//            vd.setBigThumbUrl("https://raw.githubusercontent.com/hc88media/hc88_nhacremixnhacdj/master/anh/nhacdotrungduc.jpg");
//            vd.setKeySearch("MV Nhạc Đỏ Trung Đức");
//            listVideoDtoMV.add(vd);
//
//            vd = new Video();
//            vd.setTitle("MV Nhạc Cách mạng");
//            vd.setBigThumbUrl("https://raw.githubusercontent.com/hc88media/hc88_nhacremixnhacdj/master/anh/nhacdocachmang.jpg");
//            vd.setKeySearch("MV Nhạc Cách mạng");
//            listVideoDtoMV.add(vd);
//
//            vd = new Video();
//            vd.setTitle("MV Nhạc Tiền  Chiến");
//            vd.setBigThumbUrl("https://raw.githubusercontent.com/hc88media/hc88_nhacremixnhacdj/master/anh/nhacdotienchien.jpg");
//            vd.setKeySearch("MV Nhạc Tiền  Chiến");
//            listVideoDtoMV.add(vd);
//
//            vd = new Video();
//            vd.setTitle("Nhạc Người Lính");
//            vd.setBigThumbUrl("https://raw.githubusercontent.com/hc88media/hc88_nhacremixnhacdj/master/anh/nhacdonguoilinh.jpg");
//            vd.setKeySearch("Nhạc Người Lính");
//            listVideoDtoMV.add(vd);
//
//            vd = new Video();
//            vd.setTitle("Nhạc Năm 75");
//            vd.setBigThumbUrl("https://raw.githubusercontent.com/hc88media/hc88_nhacremixnhacdj/master/anh/nhacdo75.jpg");
//            vd.setKeySearch("Nhạc Năm 75");
//            listVideoDtoMV.add(vd);
//
//            vd = new Video();
//            vd.setTitle("Nhạc Đỏ remix");
//            vd.setKeySearch("Nhạc Đỏ remix");
//            vd.setBigThumbUrl("https://raw.githubusercontent.com/hc88media/hc88_nhacremixnhacdj/master/anh/nhacdoremix.jpg");
//            listVideoDtoMV.add(vd);
//
//            vd = new Video();
//            vd.setTitle("Nhạc Cách mạng remix");
//            vd.setKeySearch("Nhạc Cách mạng remix");
//            vd.setBigThumbUrl("https://raw.githubusercontent.com/hc88media/hc88_nhacremixnhacdj/master/anh/nhacdocachmangremix.jpg");
//            listVideoDtoMV.add(vd);
//
////            vd = new Video();
////            vd.setTitle("MV Dân ca quê hương");
////            vd.setKeySearch("MV Dân ca quê hương");
////            vd.setBigThumbUrl("https://raw.githubusercontent.com/hc88media/hc88_nhacremixnhacdj/master/anh/dancaquehuong.jpg");
////            listVideoDtoMV.add(vd);
//
//            return null;
//        }
//        @Override
//        protected void onPostExecute(Void result) {
//            super.onPostExecute(result);
//            VideoCustomAdater adapterMV = new VideoCustomAdater(getContext(), listVideoDtoMV);
//            VideoCustomAdater adapter = new VideoCustomAdater(getContext(), listVideoDto);
//            adapterMV.setOnItemEventsListener(PlaylistsFragment.this);
//            adapter.setOnItemEventsListener(PlaylistsFragment.this);
//            GridLayoutManager gridLayoutManager = ((GridLayoutManager) recyclerView.getLayoutManager());
////            int firstVisiblePosition = 0;
////            if(gridLayoutManager != null) {
////                firstVisiblePosition = gridLayoutManager.findFirstVisibleItemPosition();
////            }
//            adapterMV.notifyDataSetChanged();
//            adapter.notifyDataSetChanged();
//            recyclerViewMV.setAdapter(adapterMV);
//            recyclerViewMV.setNestedScrollingEnabled(false);
//            recyclerView.setAdapter(adapter);
//            recyclerView.setNestedScrollingEnabled(false);
//            processBar.setVisibility(View.GONE);
//            //recyclerView.scrollToPosition(firstVisiblePosition);
//        }
//    }
//}
/*
 * Copyright (C) 2016 SMedic
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
package com.hc88.nhacdotest.fragments;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.hc88.nhacdotest.MainActivity;
import com.hc88.nhacdotest.R;
import com.hc88.nhacdotest.adapters.VideoCustomAdater;
import com.hc88.nhacdotest.interfaces.ItemEventsListener;
import com.hc88.nhacdotest.interfaces.OnItemSelected;
import com.hc88.nhacdotest.model.Video;
import com.hc88.nhacdotest.model.YouTubeVideo;
import com.hc88.nhacdotest.utils.Config;

import java.util.ArrayList;
import java.util.List;

public class PlaylistsFragment extends BaseFragment implements
        ItemEventsListener<Video> {
    GridLayoutManager recyclerLayoutManager;
    //GridLayoutManager recyclerLayoutManager2;
    // RecyclerView recyclerView;
    RecyclerView recyclerViewMV;
    //List<Video> listVideoDto;
    List<Video> listVideoDtoMV;
    private ProgressBar processBar;
   // private AdView mAdView;

    private Context context;
    public static OnItemSelected itemSelected;

    public PlaylistsFragment() {
        // Required empty public constructor
    }

    public static PlaylistsFragment newInstance() {
        return new PlaylistsFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.home_layout, container, false);
//        mAdView = (AdView) v.findViewById(R.id.adView);
//        AdRequest adRequest = new AdRequest.Builder()
//                //.addTestDevice(Constants.TEST_DEVICE_ID)
//                .build();
//        mAdView.loadAd(adRequest);

        /* Setup the ListView */
        processBar =(ProgressBar) v.findViewById(R.id.progressBar);
        recyclerViewMV = (RecyclerView) v.findViewById(R.id.myRecyclerViewMV);
        // recyclerView = (RecyclerView) v.findViewById(R.id.myRecyclerView);


        recyclerLayoutManager = new GridLayoutManager(getContext(), 2, GridLayoutManager.VERTICAL, false);
        recyclerViewMV.setLayoutManager(recyclerLayoutManager);
        recyclerViewMV.setItemAnimator(new DefaultItemAnimator());

        //recyclerLayoutManager2 = new GridLayoutManager(getContext(), 2, GridLayoutManager.VERTICAL, false);
        //recyclerView.setLayoutManager(recyclerLayoutManager2);
        // recyclerView.setItemAnimator(new DefaultItemAnimator());
        new getData().execute();
        return v;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof MainActivity) {
            this.context = context;
            itemSelected = (MainActivity) context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        this.context = null;
        this.itemSelected = null;
    }

    @Override
    public void onResume() {
        super.onResume();
        updateList();
    }



    @Override
    public void onShareClicked(String itemId) {
        share(Config.SHARE_PLAYLIST_URL + itemId);
    }

    @Override
    public void onFavoriteClicked(YouTubeVideo video, boolean isChecked) {
        //do nothing
    }

    @Override
    public void onItemClick(Video video) {
        //results are in onVideosReceived callback method
        Intent suggestionIntent = new Intent(Intent.ACTION_SEARCH);
        suggestionIntent.putExtra(SearchManager.QUERY, video.getKeySearch());
        itemSelected.handleIntentTest(suggestionIntent);
    }

    @Override
    public void updateList() {
    }

    //////// parse json /////////////////
    private class getData extends AsyncTask<String, Void, Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            processBar.setVisibility(View.VISIBLE);
        }
        @Override
        protected Void doInBackground(String... arg0) {
            Video vd = new Video();
            //vd = new Video();
//            listVideoDto  = new ArrayList<>();
            listVideoDtoMV = new ArrayList<Video>();
//            vd.setTitle("Nhạc Đỏ Tuyển Chọn");
//            vd.setBigThumbUrl("https://raw.githubusercontent.com/hc88media/hc88_nhacremixnhacdj/master/anh/nhacdotuyenchon.jpg");
//            vd.setKeySearch("nhạc đỏ tuyển chọn");
//            listVideoDto.add(vd);
//
//            vd = new Video();
//            vd.setTitle("Nhạc Đỏ NSUT Trọng Thủy");
//            vd.setBigThumbUrl("https://raw.githubusercontent.com/hc88media/hc88_nhacremixnhacdj/master/anh/nhacdotrongthuy.jpg");
//            vd.setKeySearch("Nhạc Đỏ NSUT Trọng Thủy");
//            listVideoDto.add(vd);
//
//            vd = new Video();
//            vd.setTitle("Nhạc Đỏ Thu Hiền");
//            vd.setBigThumbUrl("https://raw.githubusercontent.com/hc88media/hc88_nhacremixnhacdj/master/anh/nhacdothuhien.jpg");
//            vd.setKeySearch("nhạc đỏ thu hiền");
//            listVideoDto.add(vd);
//
//            vd = new Video();
//            vd.setTitle("Nhạc Đỏ Anh Thơ");
//            vd.setBigThumbUrl("https://raw.githubusercontent.com/hc88media/hc88_nhacremixnhacdj/master/anh/nhacdoanhtho.jpg");
//            vd.setKeySearch("Nhạc Đỏ Anh Thơ");
//            listVideoDto.add(vd);
//
//            vd = new Video();
//            vd.setTitle("Nhạc Đỏ Trọng Tấn");
//            vd.setBigThumbUrl("https://raw.githubusercontent.com/hc88media/hc88_nhacremixnhacdj/master/anh/nhacdotrongtan.jpg");
//            vd.setKeySearch("Nhạc Đỏ Trọng Tấn");
//            listVideoDto.add(vd);
//
//            vd = new Video();
//            vd.setTitle("Nhạc Đỏ Trung Đức");
//            vd.setBigThumbUrl("https://raw.githubusercontent.com/hc88media/hc88_nhacremixnhacdj/master/anh/nhacdotrungduc.jpg");
//            vd.setKeySearch("Nhạc Đỏ Trung Đức");
//            listVideoDto.add(vd);
//
//            vd = new Video();
//            vd.setTitle("Nhạc Cách mạng");
//            vd.setBigThumbUrl("https://raw.githubusercontent.com/hc88media/hc88_nhacremixnhacdj/master/anh/nhacdocachmang.jpg");
//            vd.setKeySearch("Nhạc Cách mạng");
//            listVideoDto.add(vd);
//
//            vd = new Video();
//            vd.setTitle("Nhạc Tiền  Chiến");
//            vd.setBigThumbUrl("https://raw.githubusercontent.com/hc88media/hc88_nhacremixnhacdj/master/anh/nhacdotienchien.jpg");
//            vd.setKeySearch("Nhạc Tiền  Chiến");
//            listVideoDto.add(vd);
//
//            vd = new Video();
//            vd.setTitle("Nhạc Người Lính");
//            vd.setBigThumbUrl("https://raw.githubusercontent.com/hc88media/hc88_nhacremixnhacdj/master/anh/nhacdonguoilinh.jpg");
//            vd.setKeySearch("Nhạc Người Lính cách mạng");
//            listVideoDto.add(vd);
//
//            vd = new Video();
//            vd.setTitle("Nhạc Năm 75");
//            vd.setBigThumbUrl("https://raw.githubusercontent.com/hc88media/hc88_nhacremixnhacdj/master/anh/nhacdo75.jpg");
//            vd.setKeySearch("Nhạc Năm thập niên 75");
//            listVideoDto.add(vd);
//
//            vd = new Video();
//            vd.setTitle("Liên Khúc Nhạc Đỏ remix");
//            vd.setKeySearch("Liên Khúc  Nhạc Đỏ remix");
//            vd.setBigThumbUrl("https://raw.githubusercontent.com/hc88media/hc88_nhacremixnhacdj/master/anh/nhacdoremix.jpg");
//            listVideoDto.add(vd);
//
//            vd = new Video();
//            vd.setTitle("Liên Khúc  Nhạc Cách mạng remix");
//            vd.setKeySearch("Liên Khúc  Nhạc Cách mạng remix");
//            vd.setBigThumbUrl("https://raw.githubusercontent.com/hc88media/hc88_nhacremixnhacdj/master/anh/nhacdocachmangremix.jpg");
//            listVideoDto.add(vd);
//
//            vd = new Video();
//            vd.setTitle("MV Dân ca quê hương");
//            vd.setKeySearch("MV Dân ca quê hương");
//            vd.setBigThumbUrl("https://raw.githubusercontent.com/hc88media/hc88_nhacremixnhacdj/master/anh/nhacdodanca.jpg");
//            listVideoDto.add(vd);



            //----------------------------
            vd = new Video();
            vd.setTitle("Hàn Quốc Phim Hay");
            vd.setBigThumbUrl("https://raw.githubusercontent.com/hc88media/hc88_nhacremixnhacdj/master/anh/hanquocphimhay.jpg");
            vd.setKeySearch("phim hay hàn quốc thuyết minh");
            listVideoDtoMV.add(vd);

            vd = new Video();
            vd.setTitle("Hàn Quốc Phim Mới");
            vd.setBigThumbUrl("https://raw.githubusercontent.com/hc88media/hc88_nhacremixnhacdj/master/anh/hanquoctinhcam.jpg");
            vd.setKeySearch("phim mới hàn quốc thuyết minh");
            listVideoDtoMV.add(vd);

            vd = new Video();
            vd.setTitle("Hàn Quốc Cổ trang");
            vd.setBigThumbUrl("https://raw.githubusercontent.com/hc88media/hc88_nhacremixnhacdj/master/anh/hanquoccotrang.jpg");
            vd.setKeySearch("phim hàn quốc cổ trang thuyết minh");
            listVideoDtoMV.add(vd);

            vd = new Video();
            vd.setTitle("Hàn Quốc Phim Lẻ");
            vd.setBigThumbUrl("https://raw.githubusercontent.com/hc88media/hc88_nhacremixnhacdj/master/anh/hanquocphimle.jpg");
            vd.setKeySearch("phim lẻ hàn quốc thuyết minh");
            listVideoDtoMV.add(vd);


            vd = new Video();
            vd.setTitle("Hàn Quốc Phim Hài");
            vd.setBigThumbUrl("https://raw.githubusercontent.com/hc88media/hc88_nhacremixnhacdj/master/anh/hanquocphimhai.jpg");
            vd.setKeySearch("phim hài hàn quốc thuyết minh");
            listVideoDtoMV.add(vd);

            vd = new Video();
            vd.setTitle("Hàn Quốc Hành Động");
            vd.setBigThumbUrl("https://raw.githubusercontent.com/hc88media/hc88_nhacremixnhacdj/master/anh/hanquochanhdong.jpg");
            vd.setKeySearch("phim hành động hàn quốc thuyết minh");
            listVideoDtoMV.add(vd);

            vd = new Video();
            vd.setTitle("Hàn Quốc Tình Cảm");
            vd.setBigThumbUrl("https://raw.githubusercontent.com/hc88media/hc88_nhacremixnhacdj/master/anh/hanquoctinhcam.jpg");
            vd.setKeySearch("phim tình cảm hàn quốc thuyết minh");
            listVideoDtoMV.add(vd);

            vd = new Video();
            vd.setTitle("Hàn Quốc Học Đường");
            vd.setBigThumbUrl("https://raw.githubusercontent.com/hc88media/hc88_nhacremixnhacdj/master/anh/hanquochocduong.jpg");
            vd.setKeySearch("phim học đường hàn quốc thuyết minh");
            listVideoDtoMV.add(vd);

            return null;
        }
        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            VideoCustomAdater adapterMV = new VideoCustomAdater(getContext(), listVideoDtoMV);
            //VideoCustomAdater adapter = new VideoCustomAdater(getContext(), listVideoDto);
            adapterMV.setOnItemEventsListener(PlaylistsFragment.this);
            //adapter.setOnItemEventsListener(PlaylistsFragment.this);
            //GridLayoutManager gridLayoutManager = ((GridLayoutManager) recyclerView.getLayoutManager());
//            int firstVisiblePosition = 0;
//            if(gridLayoutManager != null) {
//                firstVisiblePosition = gridLayoutManager.findFirstVisibleItemPosition();
//            }
            adapterMV.notifyDataSetChanged();
            //adapter.notifyDataSetChanged();
            recyclerViewMV.setAdapter(adapterMV);
            recyclerViewMV.setNestedScrollingEnabled(false);
            //recyclerView.setAdapter(adapter);
            //recyclerView.setNestedScrollingEnabled(false);
            processBar.setVisibility(View.GONE);
            //recyclerView.scrollToPosition(firstVisiblePosition);
        }
    }
}