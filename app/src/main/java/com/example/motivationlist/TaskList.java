package com.example.motivationlist;

import android.os.Parcel
import android.os.Parcelable

/* Created by Tatjana Kukic and Mert Sevindik on 09.11.2019 */

class TaskList(val name: String?, val tasks: ArrayList<String> = ArrayList<String>()) : Parcelable {

        constructor(source: Parcel) : this (source.readString(),
        source.createStringArrayList() as ArrayList<String>
    )

            override fun describeContents(): Int = 0

            // Called when parcel needs to be created
            override fun writeToParcel(dest: Parcel, flags: Int) {
            dest.writeString(name)
            dest.writeStringList(tasks)
            }

            companion object CREATOR: Parcelable.Creator<TaskList> {
        override fun createFromParcel(source: Parcel): TaskList = TaskList(source)
        override fun newArray(size: Int): Array<TaskList?> = arrayOfNulls(size)
        }
        }