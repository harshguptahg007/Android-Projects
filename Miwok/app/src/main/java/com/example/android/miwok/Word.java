package com.example.android.miwok;

/**
 * Created by Harsh Gupta on 28-10-2017.
 */

public class Word {

    private int  mImageResourceId=NO_IMAGE_PROVIDED;

    private String mDefaultTranslation;

    private String mMiwokTranslation;

    private static final int NO_IMAGE_PROVIDED=-1;

    private int mAudioResourceId;

    public Word(String defaultTranslation, String miwokTranslation,int audioresourceId)
    {
        mDefaultTranslation=defaultTranslation;
        mMiwokTranslation=miwokTranslation;
        mAudioResourceId=audioresourceId;
    }

    public Word(String defaultTranslation, String miwokTranslation,int imageResourceId,int audioResourceId)
    {
        mDefaultTranslation=defaultTranslation;
        mMiwokTranslation=miwokTranslation;
        mImageResourceId=imageResourceId;
        mAudioResourceId=audioResourceId;
    }

    public String getDefaultTranslation()
    {
        return mDefaultTranslation;
    }

    public String getMiwokTranslation(){
        return mMiwokTranslation;
    }

    public int getImageResourceId(){
        return mImageResourceId;
    }

    //Returns whether the word has an image or not
    public boolean hasImage(){
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

    //Returns the audio resource id of the audio file
    public int getAudioResourceId(){
        return mAudioResourceId;
    }
}
