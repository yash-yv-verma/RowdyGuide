package edu.utsa.cs3443.rowdyguidefinal;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import edu.utsa.cs3443.rowdyguidefinal.model.Event;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private final RecyclerViewInterface recyclerViewInterface;
    Context context;
    ArrayList<Event> events;

    public RecyclerViewAdapter(Context context, ArrayList<Event> events, RecyclerViewInterface recyclerViewInterface) {
        this.context = context;
        this.events = events;
        this.recyclerViewInterface = recyclerViewInterface;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_view_row, parent, false);


        return new MyViewHolder(view, recyclerViewInterface);
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

        public MyViewHolder(@NonNull View itemView, RecyclerViewInterface recyclerViewInterface) {
            super(itemView);

            imgView1 = itemView.findViewById(R.id.imageView);
            tvDate = itemView.findViewById(R.id.textViewDate);
            tvEventName = itemView.findViewById(R.id.textViewEventName);
            tvEventLocation = itemView.findViewById(R.id.textViewEventLocation);
            tvEventName.setMaxLines(1);
            tvEventName.setEllipsize(TextUtils.TruncateAt.END);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (recyclerViewInterface != null){
                        int pos = getAdapterPosition();
                        if(pos != RecyclerView.NO_POSITION){
                            recyclerViewInterface.onItemClick(pos);
                        }
                    }
                }
            });



        }

    }

}
