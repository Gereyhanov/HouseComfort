package com.example.rizvan.housecomfort;

import android.graphics.Typeface;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.daimajia.androidanimations.library.specials.in.DropOutAnimator;

import java.util.List;



/**
 * Created by Rizvan on 27.05.2015.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private List<VariableDataCardView> mDataSet;
    public static RecyclerListButtonElements recyclerListButtonElements = new RecyclerListButtonElements();


    public static TextView textViewDeviceCardTitle;
    public static CardView deviceCardView;
    public static ImageView imageViewDeviceCard;
    public static ImageView imageViewBottomLine;

    public static class ViewHolder extends RecyclerView.ViewHolder {


        public ViewHolder(View view) {
            super(view);

            textViewDeviceCardTitle = (TextView) view.findViewById(R.id.textViewDeviceCardTitle);
            deviceCardView = (CardView) view.findViewById(R.id.cardview);
            imageViewDeviceCard = (ImageView) view.findViewById(R.id.imageViewDeviceCard);
            imageViewBottomLine = (ImageView) view.findViewById(R.id.imageViewBottomLine);

            textViewDeviceCardTitle.setTypeface(OpenSans.getInstance(view.getContext()).getTypeFace());

            recyclerListButtonElements.buttonPower = (Button) view.findViewById(R.id.buttonDevicePower);
            recyclerListButtonElements.buttonOne = (Button) view.findViewById(R.id.buttonDeviceOne);
            recyclerListButtonElements.buttonTwo = (Button) view.findViewById(R.id.buttonDeviceTwo);
            recyclerListButtonElements.buttonThree = (Button) view.findViewById(R.id.buttonDeviceThree);
            recyclerListButtonElements.buttonFour = (Button) view.findViewById(R.id.buttonDeviceFour);
            recyclerListButtonElements.buttonSizeWindow = (Button) view.findViewById(R.id.buttonDeviceSize);
        }
    }

    public RecyclerAdapter(List<VariableDataCardView> dataSet) {
        mDataSet = dataSet;
    }

    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                         int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_device_card_view, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);

       // buttonPower.setOnClickListener();
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, final int position) {

        textViewDeviceCardTitle.setText(mDataSet.get(position).textViewDeviceCardTitle);
        imageViewDeviceCard.setImageDrawable(mDataSet.get(position).getImageViewDeviceCard());
        imageViewBottomLine.setBackgroundColor(mDataSet.get(position).getDeviceCardViewBackgroundColor());

        recyclerListButtonElements.buttonPower.setOnClickListener(mClickListener);
        recyclerListButtonElements.buttonPower.setBackground(mDataSet.get(position).getIconButtonPower());
        recyclerListButtonElements.buttonPower.setTag(position);

        recyclerListButtonElements.buttonOne.setOnClickListener(mClickListener);
        recyclerListButtonElements.buttonOne.setBackground(mDataSet.get(position).getIconButtonOne());
        recyclerListButtonElements.buttonOne.setTag(position);

        recyclerListButtonElements.buttonTwo.setOnClickListener(mClickListener);
        recyclerListButtonElements.buttonTwo.setBackground(mDataSet.get(position).getIconButtonTwo());
        recyclerListButtonElements.buttonTwo.setTag(position);

        recyclerListButtonElements.buttonThree.setOnClickListener(mClickListener);
        recyclerListButtonElements.buttonThree.setBackground(mDataSet.get(position).getIconButtonThree());
        recyclerListButtonElements.buttonThree.setTag(position);

        recyclerListButtonElements.buttonFour.setOnClickListener(mClickListener);
        recyclerListButtonElements.buttonFour.setBackground(mDataSet.get(position).getIconButtonFour());
        recyclerListButtonElements.buttonFour.setTag(position);

        recyclerListButtonElements.buttonSizeWindow.setOnClickListener(mClickListener);
        recyclerListButtonElements.buttonSizeWindow.setBackground(mDataSet.get(position).getIconButtonWindowSize());
        recyclerListButtonElements.buttonSizeWindow.setTag(position);
    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }

    public View.OnClickListener mClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.buttonDevicePower:
                    Log.i("buttonDevicePower " + v.getId(), v.getTag().toString());
                    YoYo.with(Techniques.Tada)
                            .duration(700)
                            .playOn(v.findViewById(R.id.buttonDevicePower));
                    break;
                case R.id.buttonDeviceOne:
                    Log.i("buttonDeviceOne " + v.getId(), v.getTag().toString());
                    YoYo.with(Techniques.Tada)
                            .duration(700)
                            .playOn(v.findViewById(R.id.buttonDeviceOne));
                    break;
                case R.id.buttonDeviceTwo:
                    Log.i("buttonDeviceTwo " + v.getId(), v.getTag().toString());
                    YoYo.with(Techniques.Tada)
                            .duration(700)
                            .playOn(v.findViewById(R.id.buttonDeviceTwo));
                    break;
                case R.id.buttonDeviceThree:
                    Log.i("buttonDeviceThree " + v.getId(), v.getTag().toString());
                    YoYo.with(Techniques.Tada)
                            .duration(700)
                            .playOn(v.findViewById(R.id.buttonDeviceThree));
                    break;
                case R.id.buttonDeviceFour:
                    Log.i("buttonDeviceFour " + v.getId(), v.getTag().toString());
                    YoYo.with(Techniques.Tada)
                            .duration(700)
                            .playOn(v.findViewById(R.id.buttonDeviceFour));
                    break;
                case R.id.buttonDeviceSize:
                    Log.i("buttonDeviceSize " + v.getId(), "" + v.getTag());
                    YoYo.with(Techniques.RubberBand)
                            .duration(500)
                            .playOn(v.findViewById(R.id.buttonDeviceSize));
                    break;
            }
        }
    };

    public static class RecyclerListButtonElements {
        Button buttonPower;
        Button buttonOne;
        Button buttonTwo;
        Button buttonThree;
        Button buttonFour;
        Button buttonSizeWindow;
    }
}