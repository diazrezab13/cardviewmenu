package com.example.cardviewmenu.mainfragments.history;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HistoryViewModel extends ViewModel {
    private MutableLiveData<String> hiText;

    public HistoryViewModel() {
        hiText = new MutableLiveData<>();
        hiText.setValue("This is history fragment");
    }

    public LiveData<String> getText() {
        return hiText;
    }

}
