package com.example.muzzchatuiexercise

import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.Calendar

class MainActivity : AppCompatActivity() {

    //Variables for objects
    private lateinit var messageRecyclerView: RecyclerView;
    private lateinit var messageBox: EditText;
    private lateinit var sendButton: ImageView;
    private lateinit var messageAdapter: MessageAdapter;
    private lateinit var messageList: ArrayList<MessageModel>;

    //Boolean Variable for active user.
    public var isUser: Boolean = true;


    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Initialising objects
        messageRecyclerView = findViewById(R.id.recyclerView);
        messageBox = findViewById(R.id.textBox);
        sendButton = findViewById(R.id.sendButton);
        messageList = ArrayList();
        messageAdapter = MessageAdapter(this, messageList);

        messageRecyclerView.layoutManager = LinearLayoutManager(this);
        messageRecyclerView.adapter = messageAdapter;


        //Method for the send button to add the message to the message list
        sendButton.setOnClickListener{


            val message = messageBox.text.toString();
            val time = System.currentTimeMillis();


            val messageObject = MessageModel(message, isUser, time);
            messageList.add(messageObject)


            messageBox.text.clear();


        }


        //Initialise the button to alternate between users
        val u1Button = findViewById<Button>(R.id.user1);
        val u2Button = findViewById<Button>(R.id.user2);

        if(isUser){
            u1Button.setTextColor(Color.RED);
            u2Button.setTextColor(Color.WHITE);
        }else{
            u1Button.setTextColor(Color.WHITE);
            u2Button.setTextColor(Color.RED);
        }

        //Method to change users
        u1Button.setOnClickListener{
            isUser = true;
            u1Button.setTextColor(Color.RED);
            u2Button.setTextColor(Color.WHITE);
        }
        u2Button.setOnClickListener{
            isUser = false;
            u1Button.setTextColor(Color.WHITE);
            u2Button.setTextColor(Color.RED);

        }


    }



}