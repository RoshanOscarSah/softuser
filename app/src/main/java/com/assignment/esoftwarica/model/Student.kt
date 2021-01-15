package com.assignment.esoftwarica.model

import android.os.Parcel
import android.os.Parcelable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData
import com.assignment.esoftwarica.interfaces.IStudent

data class Student(
    var fullName: String?,
    val studentAge: String?,
    var studentAddress: String?,
    val studentGender: String?
//    val profileImage: String?
) : ViewModel(), Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(fullName)
        parcel.writeString(studentAge)
        parcel.writeString(studentAddress)
        parcel.writeString(studentGender)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Student> {

        var lstStudentData = arrayListOf<Student>();

        fun getStudent(): ArrayList<Student> {
            return lstStudentData;
        }


        fun setStudent(lstStudentData: ArrayList<Student>) {
            Student.lstStudentData = lstStudentData;
        }

        override fun createFromParcel(parcel: Parcel): Student {
            return Student(parcel)
        }

        override fun newArray(size: Int): Array<Student?> {
            return arrayOfNulls(size)
        }
    }
}
