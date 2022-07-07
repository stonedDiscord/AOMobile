package com.example.vnomobile.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vnolib.client.model.Server;
import com.example.vnomobile.ClientHandler;
import com.example.vnomobile.R;
import com.example.vnomobile.adapter.viewholder.ListOfServersViewHolder;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ListOfServersAdapter extends RecyclerView.Adapter<ListOfServersViewHolder> {

    private OnServerEntryListener listener;

    public ListOfServersAdapter(OnServerEntryListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public ListOfServersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_server, parent, false);
        return new ListOfServersViewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull ListOfServersViewHolder holder, int position) {
        Server server = ClientHandler.getClient().getServers().get(position);
        holder.bind(server);
    }

    @Override
    public int getItemCount() {
        return ClientHandler.getClient().getServers().size();
    }

}
