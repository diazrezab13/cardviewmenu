package com.example.cardviewmenu.mainfragments.profile;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ProfileViewModel extends ViewModel {
    private MutableLiveData<String> pText;

    public ProfileViewModel() {
        pText = new MutableLiveData<>();
        pText.setValue("This is profile fragment");
    }

    public LiveData<String> getText() {
        return pText;
    }
}
