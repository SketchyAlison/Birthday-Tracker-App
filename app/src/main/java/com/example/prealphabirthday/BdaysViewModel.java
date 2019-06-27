package com.example.prealphabirthday;

import android.support.annotation.NonNull;

import java.util.Date;

// Common object that holds data for each object in RecyclerView

public class BdaysViewModel {
    private String bdayName;
    private Date bday;

    public BdaysViewModel(final String bdayName, Date bday) { // (?) Why make this final?
        this.bdayName = bdayName;
        this.bday = bday;
    }

    @NonNull // (?) What does NonNull do?
    public String getName() {
        return bdayName;
    }

    public void setName(@NonNull final String name) {
        this.bdayName = name;
    }

    public Date getDate() { return bday; }

    public void setDate(@NonNull final Date date) { this.bday = date; }
}
