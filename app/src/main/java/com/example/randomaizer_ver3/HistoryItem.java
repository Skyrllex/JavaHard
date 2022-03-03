package com.example.randomaizer_ver3;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.design.widget.TextInputEditText;
import android.widget.TextView;

public class HistoryItem implements Parcelable {
    //yeah, 2-input system doesn't look good with StringFragment
    //it is problem to fix in lab7
    private String mAsk;
    private String mResult;
    public HistoryItem(String textasking, String result){
        mAsk=textasking;

        mResult = result;
    }

    public static final Parcelable.Creator<HistoryItem> CREATOR = new Parcelable.Creator<HistoryItem>() {
        @Override
        public HistoryItem createFromParcel(Parcel in) {
            return new HistoryItem(in);
        }

        @Override
        public HistoryItem[] newArray(int size) {
            return new HistoryItem[size];
        }
    };

    public HistoryItem(Parcel in) {
        String[] data =new String[2];
        in.readStringArray(data);
        mAsk = data[0];
        mResult = data[1];
    }

    public String getTextRepresentation(){
        String textRepresentation;
            textRepresentation = String.format("1s", mResult, mAsk);
        return textRepresentation;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeStringArray(new String[]{mAsk, mResult});
    }
}
