package com.program.moudle_base.utils;

import com.program.moudle_base.model.ImageItem;

import java.util.List;

public class ImagePickerConfig {
    private ImagePickerConfig(){

    }
    private static ImagePickerConfig sPickerConfig;

    public static ImagePickerConfig getInstance(){
        if (sPickerConfig==null){
            sPickerConfig = new ImagePickerConfig();
        }
        return sPickerConfig;
    }

    private int maxSelectCount = 1;
    private OnImageSelectFinishedListener mImageSelectedFinishListener;

    public int getMaxSelectCount() {
        return maxSelectCount;
    }

    public void setMaxSelectCount(int maxSelectCount) {
        this.maxSelectCount = maxSelectCount;
    }

    public OnImageSelectFinishedListener getOnImageSelectFinishedListener(){
        return mImageSelectedFinishListener;
    }

    public void setOnImageSelectFinishedListener(OnImageSelectFinishedListener listener){
        this.mImageSelectedFinishListener = listener;
    }

    public interface OnImageSelectFinishedListener{
        void onSelectedFinished(List<ImageItem> result);
    }
}
