package com.example.cardviewmenu.mainfragments.notification;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class NotificationViewModel extends ViewModel {
    private MutableLiveData<String> nText;

    public NotificationViewModel() {
        nText = new MutableLiveData<>();
        nText.setValue("This is notification fragment");
    }

    public LiveData<String> getText() {
        return nText;
    }
}
