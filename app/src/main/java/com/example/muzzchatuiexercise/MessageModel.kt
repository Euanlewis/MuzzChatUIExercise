package com.example.muzzchatuiexercise

import android.os.Build
import androidx.annotation.RequiresApi
import java.util.Calendar

class MessageModel {
    var message: String? = null;
    var user: Boolean? = null;
    var time: Long? = null;




    constructor(){};

    //Message constructor
    @RequiresApi(Build.VERSION_CODES.O)
    constructor(message: String?, user: Boolean, time: Long){
        this.message = message;
        this.user = user;
        this.time = time;

    }

}