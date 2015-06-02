package com.example.rizvan.housecomfort;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.support.v7.widget.CardView;

/**
 * Created by Rizvan on 27.05.2015.
 */
public class VariableDataCardView {

    Integer  deviceCardViewBackgroundColor;
    String   textViewDeviceCardTitle;
    Drawable imageViewDeviceCard;

    Drawable iconButtonPower;
    Drawable iconButtonOne;
    Drawable iconButtonTwo;
    Drawable iconButtonThree;
    Drawable iconButtonFour;
    Drawable iconButtonWindowSize;

    public VariableDataCardView( String textViewDeviceCardTitle, Drawable imageViewDeviceCard,  Integer deviceCardViewBackgroundColor,
                                Drawable iconButtonPower, Drawable iconButtonOne, Drawable iconButtonTwo,
                                Drawable iconButtonThree, Drawable iconButtonFour, Drawable iconButtonWindowSize) {
        this.deviceCardViewBackgroundColor = deviceCardViewBackgroundColor;
        this.textViewDeviceCardTitle = textViewDeviceCardTitle;
        this.imageViewDeviceCard = imageViewDeviceCard;
        this.iconButtonPower = iconButtonPower;
        this.iconButtonOne = iconButtonOne;
        this.iconButtonTwo = iconButtonTwo;
        this.iconButtonThree = iconButtonThree;
        this.iconButtonFour = iconButtonFour;
        this.iconButtonWindowSize = iconButtonWindowSize;
    }

    public Integer getDeviceCardViewBackgroundColor() {
        return deviceCardViewBackgroundColor;
    }

    public void setDeviceCardViewBackgroundColor(Integer deviceCardViewBackgroundColor) {
        this.deviceCardViewBackgroundColor = deviceCardViewBackgroundColor;
    }

    public Drawable getIconButtonPower() {
        return iconButtonPower;
    }

    public void setIconButtonPower(Drawable iconButtonPower) {
        this.iconButtonPower = iconButtonPower;
    }

    public Drawable getIconButtonOne() {
        return iconButtonOne;
    }

    public void setIconButtonOne(Drawable iconButtonOne) {
        this.iconButtonOne = iconButtonOne;
    }

    public Drawable getIconButtonTwo() {
        return iconButtonTwo;
    }

    public void setIconButtonTwo(Drawable iconButtonTwo) {
        this.iconButtonTwo = iconButtonTwo;
    }

    public Drawable getIconButtonThree() {
        return iconButtonThree;
    }

    public void setIconButtonThree(Drawable iconButtonThree) {
        this.iconButtonThree = iconButtonThree;
    }

    public Drawable getIconButtonFour() {
        return iconButtonFour;
    }

    public void setIconButtonFour(Drawable iconButtonFour) {
        this.iconButtonFour = iconButtonFour;
    }

    public Drawable getIconButtonWindowSize() {
        return iconButtonWindowSize;
    }

    public void setIconButtonWindowSize(Drawable iconButtonWindowSize) {
        this.iconButtonWindowSize = iconButtonWindowSize;
    }

    public Integer getDeviceCardView() {
        return deviceCardViewBackgroundColor;
    }

    public void setDeviceCardView(Integer deviceCardView) {
        this.deviceCardViewBackgroundColor = deviceCardViewBackgroundColor;
    }

    public String getTextViewDeviceCardTitle() {
        return textViewDeviceCardTitle;
    }

    public void setTextViewDeviceCardTitle(String textViewDeviceCardTitle) {
        this.textViewDeviceCardTitle = textViewDeviceCardTitle;
    }

    public Drawable getImageViewDeviceCard() {
        return imageViewDeviceCard;
    }

    public void setImageViewDeviceCard(Drawable imageViewDeviceCard) {
        this.imageViewDeviceCard = imageViewDeviceCard;
    }

}


