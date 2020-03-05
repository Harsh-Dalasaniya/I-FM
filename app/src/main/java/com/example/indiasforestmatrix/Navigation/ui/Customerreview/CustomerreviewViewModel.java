package com.example.indiasforestmatrix.Navigation.ui.Customerreview;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CustomerreviewViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public CustomerreviewViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is slideshow fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}