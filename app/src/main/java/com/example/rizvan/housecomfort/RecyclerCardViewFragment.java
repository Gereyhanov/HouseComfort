package com.example.rizvan.housecomfort;

import android.app.Fragment;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rizvan on 26.05.2015.
 */
public class RecyclerCardViewFragment extends Fragment {

    private static final String TAG = RecyclerCardViewFragment.class.getSimpleName();

    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerAdapter mRecyclerAdapter;

    List<VariableDataCardView> myDataSet;


    public static RecyclerCardViewFragment newInstance() {
        RecyclerCardViewFragment fragment = new RecyclerCardViewFragment();
        fragment.setRetainInstance(true);
        return fragment;
    }

    public RecyclerCardViewFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.device_recycler_view, container, false);

/*
        Palette.PaletteAsyncListener listener = new Palette.PaletteAsyncListener() {
            public void onGenerated(Palette palette) {
                // access palette colors here
            }
        };
*/
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mRecyclerView = (RecyclerView) getView().findViewById(R.id.recycler_view_device);
        //mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getActivity().getApplicationContext(), new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Log.i("addOnItemTouchListener", "" + position);
            }
        }));

        initializeData();

        mRecyclerAdapter = new RecyclerAdapter(myDataSet);
        mRecyclerView.setAdapter(mRecyclerAdapter);

    }

    public void removeAt(int position, List<VariableDataCardView> mDataSet, View view) {
        myDataSet.remove(position);
        mRecyclerAdapter.notifyItemRemoved(position);
        mRecyclerAdapter.notifyItemRangeChanged(position, mDataSet.size());
    }

    public void addAt(String nameTitle, Drawable imageViewDeviceCard, Integer deviceCardViewBackgroundColor) {
        //myDataSet.add(new VariableDataCardView(nameTitle, imageViewDeviceCard, deviceCardViewBackgroundColor));
        mRecyclerAdapter.notifyDataSetChanged();
    }
    private void initializeData(){
        myDataSet = new ArrayList<>();
        myDataSet.add(new VariableDataCardView(getString(R.string.tv_1), getDraw(R.drawable.ic_tv), getColor(R.color.md_amber_900),
                getIcon(R.drawable.user_ic_power), getIcon(R.drawable.user_ic_arrow_up), getIcon(R.drawable.user_ic_arrow_down),
                getIcon(R.drawable.user_ic_volume_down), getIcon(R.drawable.user_ic_volume_up), getIcon(R.drawable.user_ic_arrow_orange)));

        myDataSet.add(new VariableDataCardView(getString(R.string.conditioner_1), getDraw(R.drawable.ic_condi), MainActivity.generatePaletteColor(R.drawable.ic_condi),
                getIcon(R.drawable.user_ic_power), getIcon(R.drawable.user_ic_valves), getIcon(R.drawable.user_ic_timer),
                getIcon(R.drawable.user_ic_fan), getIcon(R.drawable.user_ic_ok), getIcon(R.drawable.user_ic_arrow_blue)));

        myDataSet.add(new VariableDataCardView(getString(R.string.audio_system), getDraw(R.drawable.ic_audio), MainActivity.generatePaletteColor(R.drawable.ic_audio),
                getIcon(R.drawable.user_ic_power), getIcon(R.drawable.user_ic_play), getIcon(R.drawable.user_ic_next_music),
                getIcon(R.drawable.user_ic_volume_down), getIcon(R.drawable.user_ic_volume_up), getIcon(R.drawable.user_ic_arrow_green)));

        myDataSet.add(new VariableDataCardView(getString(R.string.tv_2), getDraw(R.drawable.ic_tv), getColor(R.color.md_amber_900),
                getIcon(R.drawable.user_ic_power), getIcon(R.drawable.user_ic_arrow_up), getIcon(R.drawable.user_ic_arrow_down),
                getIcon(R.drawable.user_ic_volume_down), getIcon(R.drawable.user_ic_volume_up), getIcon(R.drawable.user_ic_arrow_orange)));

        myDataSet.add(new VariableDataCardView(getString(R.string.tv_3), getDraw(R.drawable.ic_tv), getColor(R.color.md_amber_900),
                getIcon(R.drawable.user_ic_power), getIcon(R.drawable.user_ic_arrow_up), getIcon(R.drawable.user_ic_arrow_down),
                getIcon(R.drawable.user_ic_volume_down), getIcon(R.drawable.user_ic_volume_up), getIcon(R.drawable.user_ic_arrow_orange)));

        myDataSet.add(new VariableDataCardView(getString(R.string.conditioner_2), getDraw(R.drawable.ic_condi), MainActivity.generatePaletteColor(R.drawable.ic_condi),
                getIcon(R.drawable.user_ic_power), getIcon(R.drawable.user_ic_valves), getIcon(R.drawable.user_ic_timer),
                getIcon(R.drawable.user_ic_fan), getIcon(R.drawable.user_ic_ok), getIcon(R.drawable.user_ic_arrow_blue)));

    }

    public Drawable getIcon (Integer drawable) {

        Drawable draw = getResources().getDrawable(drawable);

        return draw;
    }
    public Drawable getDraw (Integer drawable) {

        Drawable draw = getResources().getDrawable(drawable);

        return draw;
    }
    public Integer getColor (Integer colors) {

        Integer color = getResources().getColor(colors);

        return color;
    }
}





