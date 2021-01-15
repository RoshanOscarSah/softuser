package com.assignment.esoftwarica.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.assignment.esoftwarica.R
import com.assignment.esoftwarica.interfaces.IStudent
import com.assignment.esoftwarica.model.Student

class StudentListAdapter(val context: Context, val lstStudent: ArrayList<Student>) :
    RecyclerView.Adapter<StudentListAdapter.StudentViewHolder>() {

    class StudentViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val imgProfile: ImageView
        val tvFullname: TextView
        val tvAddress: TextView
        val tvGender: TextView
        val tvAge: TextView
        val btnDelete: Button

        init {
            imgProfile = view.findViewById(R.id.imgProfile);
            tvFullname = view.findViewById(R.id.tvFullname);
            tvAddress = view.findViewById(R.id.tvAddress);
            tvGender = view.findViewById(R.id.tvGender);
            tvAge = view.findViewById(R.id.tvAge);
            btnDelete = view.findViewById(R.id.btnDelete);
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val view =
            LayoutInflater.from(this.context).inflate(R.layout.adapter_layout, parent, false);
        return StudentViewHolder(view);
    }

    override fun getItemCount(): Int {
        return lstStudent.size;
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        var genderImg: Int = 0;
        val student: Student = lstStudent[position];
        holder.tvFullname.text = student.fullName.toString();
        holder.tvAge.text = student.studentAge.toString();
        holder.tvAddress.text = student.studentAddress.toString();
        holder.tvGender.text = student.studentGender.toString();

        when (student.studentGender) {
            "Male" -> {
                genderImg = R.drawable.man
            }
            "Female" -> {
                genderImg = R.drawable.woman;
            }
            "Other" -> {
                genderImg = R.drawable.other;
            }
            //        Glide.with(context).load(student.profileImage).into(holder.imgProfile);
        }

        holder.imgProfile.setImageResource(genderImg);
//        Glide.with(context).load(student.profileImage).into(holder.imgProfile);

        holder.imgProfile.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {

                Toast.makeText(context, "Hello I'm ${student.fullName}", Toast.LENGTH_SHORT).show();
            }
        });

        holder.btnDelete.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {

             lstStudent.removeAt(position);
                notifyDataSetChanged();
            }
        })


    }
}