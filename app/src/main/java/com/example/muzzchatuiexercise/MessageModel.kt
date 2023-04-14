package com.example.muzzchatuiexercise

import java.time.LocalTime

class MessageModel {
    var message: String? = null;
    var user: String? = null;


    constructor(){};

    constructor(message: String?, user: String?, time: LocalTime){
        this.message = message;
        this.user = user;
    }
}