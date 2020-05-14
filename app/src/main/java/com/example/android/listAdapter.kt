package com.example.android

import android.app.Activity
import android.content.Context
import android.media.MediaPlayer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*


class listAdapter (private val _ctx: Context, private var activity: Activity, private var items: ArrayList<Word>): BaseAdapter() {

    private var mp: MediaPlayer? = null
    private var mc: MediaController? = null

    private class ViewHolder(row: View?) {
        var engTxt: TextView? = null
        var frTxt: TextView? = null
        var img: ImageView? = null
        var audio: ImageView? = null
        var video: ImageView? = null

        init {
            this.engTxt= row?.findViewById(R.id.eng_text)
            this.frTxt= row?.findViewById(R.id.fr_text)
            this.img= row?.findViewById(R.id.image)
            this.audio= row?.findViewById(R.id.play_audio)
            this.video= row?.findViewById(R.id.play_audio)
        }
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view: View?
        val viewHolder: ViewHolder
        if (convertView == null) {
            val inflater = activity?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            view = inflater.inflate(R.layout.list_item, null)
            viewHolder = ViewHolder(view)
            view?.tag = viewHolder
        } else {
            view = convertView
            viewHolder = view.tag as ViewHolder
        }

        var userDto = items[position]
        viewHolder.engTxt?.text = userDto.engTxt
        viewHolder.frTxt?.text = userDto.frTxt
        viewHolder.img?.setBackgroundResource(userDto.img)

        return view as View
    }

    override fun getItem(i: Int): Word {
        return items[i]
    }

    override fun getItemId(i: Int): Long {
        return i.toLong()
    }

    override fun getCount(): Int {
        return items.size
    }

}