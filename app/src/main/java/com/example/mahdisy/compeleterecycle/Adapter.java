package com.example.mahdisy.compeleterecycle;

import android.content.Context;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ItemViewHolder> {

    private Context context;
    private List<DataModel> list;
    private InterFaceForViewEvents viewEvents;

    Adapter(Context context, List<DataModel> list, InterFaceForViewEvents viewEvents) {

        this.context = context;
        this.list = list;
        this.viewEvents = viewEvents;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.card, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ItemViewHolder holder, int position) {
        holder.BindItems(list.get(position));
        viewEvents.OnAction(list, list.get(holder.getAdapterPosition()), holder.view);
        if (getItemCount()-1==holder.getAdapterPosition()) {            viewEvents.OnLoadMore();        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void AddItem(DataModel dataModel){
        list.add(dataModel);
        notifyItemInserted(getItemCount()+1);
    }
    public interface InterFaceForViewEvents {
        void OnAction(List<DataModel> list, DataModel data, View v);
        void OnLoadMore();
    }


    class ItemViewHolder extends RecyclerView.ViewHolder {
        private TextView subject;
        private TextView describe;
        private View view;

        ItemViewHolder(View itemView) {
            super(itemView);
            subject = itemView.findViewById(R.id.itemView_subject);
            describe = itemView.findViewById(R.id.itemView_describe);
            view = itemView;
        }

        void BindItems(DataModel data) {
            subject.setText(data.subject);
            describe.setText(data.describe);
        }
    }


}
