/**
 * @author Yash Verma
 */

package edu.utsa.cs3443.rowdyguidefinal.controller;


import android.content.res.AssetManager;

import android.view.View;

import java.io.IOException;
import java.util.ArrayList;

import edu.utsa.cs3443.rowdyguidefinal.EventTabActivity;
import edu.utsa.cs3443.rowdyguidefinal.model.Event;
import edu.utsa.cs3443.rowdyguidefinal.model.EventAdd;

public class EventTabController implements View.OnClickListener{
    EventTabActivity eventTabActivity;
    AssetManager assetManager;

    static ArrayList<Event> events;

    public EventTabController(EventTabActivity eventTabActivity){
        this.eventTabActivity = eventTabActivity;
        assetManager = eventTabActivity.getAssets();

        {
            try {
                events = EventAdd.addEvents(assetManager);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }

    public EventTabActivity getEventTabActivity() {
        return eventTabActivity;
    }

    public void setEventTabActivity(EventTabActivity eventTabActivity) {
        this.eventTabActivity = eventTabActivity;
    }

    public AssetManager getAssetManager() {
        return assetManager;
    }

    public void setAssetManager(AssetManager assetManager) {
        this.assetManager = assetManager;
    }

    public static ArrayList<Event> getEvents() {
        return events;
    }

    public void setEvents(ArrayList<Event> events) {
        this.events = events;
    }

    public void onClick(View v){

    }

}
