package com.example.cardviewmenu.mainfragments.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {
    private MutableLiveData<String> hoText;

    public HomeViewModel() {
        hoText = new MutableLiveData<>();
        hoText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return hoText;
    }
}
