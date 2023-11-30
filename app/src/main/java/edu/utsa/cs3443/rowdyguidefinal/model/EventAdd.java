/**
 * @author Yash Verma
 */
package edu.utsa.cs3443.rowdyguidefinal.model;


import android.content.res.AssetManager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class EventAdd {

    public static ArrayList<Event> addEvents(AssetManager manager) throws IOException {

        ArrayList<Event> events = new ArrayList<>();

        InputStream inputStream = manager.open("data.csv");
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String line;
            bufferedReader.readLine(); // Skip the header row

        try {
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",");
                String name = data[0].trim();
                String date = data[1].trim();
                String time = data[2].trim();
                String location = data[3].trim();
                String description = data[4].trim();
                String ticketPrice = data[5].trim();
                String eventType = data[6].trim();

                Event event = new Event(name, date, time, location, description, ticketPrice, eventType);
                events.add(event);
            }
        } catch (IOException e){
            e.printStackTrace();
        }finally {
            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();
        }


        return events;
    }

}
