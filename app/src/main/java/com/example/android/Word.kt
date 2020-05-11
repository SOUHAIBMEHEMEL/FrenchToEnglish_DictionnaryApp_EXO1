package com.example.android

class Word  {
    var engTxt: String = ""
    var frTxt: String = ""
    var img: Int =-1
    var audio: Int =-1
    var video: Int =-1

    constructor() {}

    constructor(engTxt: String, frTxt: String, img: Int , audio: Int , video: Int) {
        this.engTxt=engTxt
        this.frTxt= frTxt
        this.img= img
        this.audio= audio
        this.video= video

    }

}