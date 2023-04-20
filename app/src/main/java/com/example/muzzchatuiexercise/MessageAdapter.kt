package com.example.muzzchatuiexercise

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MessageAdapter(val context: Context, val messageList: ArrayList<MessageModel>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    // Two classes that initialise the view holders for each of the 2 users.
    class User1ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val user1Message = itemView.findViewById<TextView>(R.id.user1Message);

        fun bind(message: MessageModel){
            user1Message.text = message.message;
        }
    }

    class User2ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val user2Message = itemView.findViewById<TextView>(R.id.user2Message);

        fun bind(message: MessageModel){
            user2Message.text = message.message;
        }
    }

    // Variables used to control which is the active user.
    val itemUser1 = 1;
    val itemUser2 = 2;

    //Method that returns a value that is used to control the view holder of the active user.
    override fun getItemViewType(position: Int): Int {
        if(messageList.get(position).user == true){
            return itemUser1;
        }else {
            return itemUser2;
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        // Uses "viewType" returned from getItemViewType to determine the user layout
        if(viewType == 1){

            val view: View = LayoutInflater.from(context).inflate(R.layout.user1_message, parent, false);
            return User1ViewHolder(view);

        }else{

            val view: View = LayoutInflater.from(context).inflate(R.layout.user2_message, parent, false);
            return User2ViewHolder(view);

        }

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        if (holder.javaClass == User1ViewHolder::class.java) {

            if(messageList.get(position).user == true) {
                holder as User1ViewHolder;
                holder.user1Message.text = messageList.get(position).message;
                holder.bind(messageList.get(position));

            }

        } else {
            if(messageList.get(position).user == false) {
                holder as User2ViewHolder;
                holder.user2Message.text = messageList.get(position).message;
                holder.bind(messageList.get(position));

            }

        }
    }

    override fun getItemCount() = messageList.size;



}
