package com.josecuentas.androiddesign_chat.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.josecuentas.androiddesign_chat.R;
import com.josecuentas.androiddesign_chat.model.RowChat;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by PibeDx on 14/08/2017.
 */

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ChatViewHolder> {

    private List<RowChat> rowChatList;

    public ChatAdapter() {
        this.rowChatList = new ArrayList<>();
    }

    public void setRowChatList(List<RowChat> rowChatList) {
        this.rowChatList = rowChatList;
    }

    public void addRowChatList(RowChat rowChat) {
        this.rowChatList.add(rowChat);
        notifyItemInserted(this.rowChatList.size() - 1);
    }

    @Override
    public ChatViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_chat, parent, false);
        return new ChatViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ChatViewHolder holder, int position) {
        RowChat rowChat = rowChatList.get(position);
        holder.tviMessage.setText(rowChat.message);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss a");
        String format = simpleDateFormat.format(rowChat.timeStamp);
        holder.tviTimeStamp.setText(format);
    }

    @Override
    public int getItemCount() {
        return rowChatList.size();
    }

    public class ChatViewHolder extends RecyclerView.ViewHolder{
        TextView tviMessage;
        TextView tviTimeStamp;
        public ChatViewHolder(View itemView) {
            super(itemView);
            tviMessage = (TextView) itemView.findViewById(R.id.tviMessage);
            tviTimeStamp = (TextView) itemView.findViewById(R.id.tviTimeStamp);
        }
    }
}
