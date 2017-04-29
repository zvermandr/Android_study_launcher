package com.yandex.mandrik.launcher.listappsactivity.appsrecycler.recycler;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import com.yandex.mandrik.launcher.listappsactivity.appsrecycler.recycler.adapter.ApplicationListAdapter;
import com.yandex.mandrik.launcher.listappsactivity.appdata.ApplicationListManager;

import java.io.Serializable;


/**
 * This recycler contains items of applications
 * Created by Nick Mandrik on 21.03.2017.
 * @author Nick Mandrik
 */

public class ApplicationsRecycler extends RecyclerView implements Serializable{

    private ApplicationListAdapter appAdapter;
    private ApplicationListManager applicationListManager;

    public ApplicationsRecycler(Context context) {
        super(context);
    }

    public void construct(ApplicationListManager manager) {
        this.applicationListManager = manager;
        appAdapter = new ApplicationListAdapter(applicationListManager, null);
        this.setAdapter(appAdapter);
    }

    public ApplicationListManager getApplicationListManager() {
        return applicationListManager;
    }

    @Override
    public ApplicationListAdapter getAdapter() {
        return appAdapter;
    }
}