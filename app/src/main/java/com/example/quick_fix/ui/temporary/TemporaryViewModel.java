package com.example.quick_fix.ui.temporary;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class TemporaryViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public TemporaryViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is temporary fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}