package edu.utsa.cs3443.rowdyguidefinal;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.IOError;
import java.util.ArrayList;

import edu.utsa.cs3443.rowdyguidefinal.model.Event;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
    Context context;
    ArrayList<Event> events;

    public RecyclerViewAdapter(Context context, ArrayList<Event> events) {
        this.context = context;
        this.events = events;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_view_row, parent, false);


        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        String[] dateTex = (events.get(position).getEventDate()).split("-");
        String dat = dateTex[0].trim();
        String mon = dateTex[1].trim();


        holder.imgView1.setImageResource(R.drawable.baseline_blur_circular_24);
        holder.tvEventName.setText(events.get(position).getEventName());
        holder.tvEventLocation.setText(events.get(position).getEventLocation());
        holder.tvDate.setText(" " + dat + "\n" + mon);

    }

    @Override
    public int getItemCount() {
        return events.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView imgView1;
        TextView tvDate, tvEventName, tvEventLocation;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imgView1 = itemView.findViewById(R.id.imageView);

            tvDate = itemView.findViewById(R.id.textViewDate);

            tvEventName = itemView.findViewById(R.id.textViewEventName);
            tvEventName.setMaxLines(1);
            tvEventName.setEllipsize(TextUtils.TruncateAt.END);

            tvEventLocation = itemView.findViewById(R.id.textViewEventLocation);



        }

    }

}
