package com.example.vnomobile.adapter.viewholder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vnolib.client.model.Server;
import com.example.vnomobile.R;
import com.example.vnomobile.adapter.ListOfServersAdapter;
import com.example.vnomobile.adapter.OnServerEntryListener;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ListOfServersViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private TextView serverName;
    private TextView serverDescription;

    private TextView serverIp;
    private TextView serverPort;

    private Server server;
    private OnServerEntryListener listener;

    public ListOfServersViewHolder(@NonNull View itemView, OnServerEntryListener listener) {
        super(itemView);
        this.serverName = itemView.findViewById(R.id.server_name);
        this.serverDescription = itemView.findViewById(R.id.server_description);
        this.serverIp = itemView.findViewById(R.id.server_ip);
        this.serverPort = itemView.findViewById(R.id.server_port);
        this.listener = listener;
        itemView.setOnClickListener(this);
    }

    public void bind(Server server) {
        this.server = server;
        serverName.setText(server.getName());
        serverDescription.setText(server.getDescription());
        serverIp.setText(server.getIp());
        serverPort.setText(Integer.toString(server.getPort()));
    }

    @Override
    public void onClick(View v) {
        log.debug("Clicked");
        listener.onServerEntryClick(server);
    }
}
