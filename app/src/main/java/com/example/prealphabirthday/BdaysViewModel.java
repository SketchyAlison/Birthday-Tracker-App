package com.example.prealphabirthday;

import android.support.annotation.NonNull;

// Common object that holds data for each object in RecyclerView

public class BdaysViewModel {
    private String bdayName;

    public BdaysViewModel(final String bdayName) { // (?) Why make this final?
        this.bdayName = bdayName;
    }

    @NonNull // (?) What does NonNull do?
    public String getName() {
        return bdayName;
    }

    public void setName(@NonNull final String name) {
        this.bdayName = name;
    }
}
