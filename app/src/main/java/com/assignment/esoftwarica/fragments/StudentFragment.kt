package com.assignment.esoftwarica.fragments

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.assignment.esoftwarica.R
import com.assignment.esoftwarica.adapter.StudentListAdapter
import com.assignment.esoftwarica.model.Student
import java.lang.Exception


class StudentFragment : Fragment() {

    private lateinit var etFullname: EditText;
    private lateinit var etAddress: EditText;
    private lateinit var etAge: EditText;
    private lateinit var rdoGender: RadioGroup;
    private lateinit var rdoMale: RadioButton;
    private lateinit var rdoFemale: RadioButton;
    private lateinit var rdoOther: RadioButton;
    private lateinit var btnSave: Button;


    companion object {
        private var lstStudent: ArrayList<Student> = arrayListOf<Student>();
    }


    var gender: String = "";


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {


        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_student, container, false);
        etFullname = view.findViewById(R.id.etFullname);
        etAddress = view.findViewById(R.id.etAddress);
        etAge = view.findViewById(R.id.etAge);
        rdoGender = view.findViewById(R.id.rdoGroup);
        rdoMale = view.findViewById(R.id.rdoMale);
        rdoFemale = view.findViewById(R.id.rdoFemale);
        rdoOther = view.findViewById(R.id.rdoOther);
        btnSave = view.findViewById(R.id.btnSave);


        btnSave.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {

                val fullname = etFullname.text.toString();
                val address = etAddress.text.toString();
                val age = etAge.text.toString();


                if (TextUtils.isEmpty(etFullname.text.toString())) {
                    etFullname.setError("Enter Fullname");
                    etFullname.requestFocus();
                } else if (TextUtils.isEmpty(etAge.text.toString())) {
                    etAge.setError("Enter Age");
                    etAge.requestFocus();
                } else if (TextUtils.isEmpty(etAddress.text.toString())) {
                    etAddress.setError("Enter Address");
                    etAddress.requestFocus();
                } else if (!rdoMale.isChecked && !rdoFemale.isChecked && !rdoOther.isChecked) {
                    Toast.makeText(context, "Please Select Gender", Toast.LENGTH_SHORT).show();
                } else {

//                    Student.getStudent();
                    lstStudent.add(Student(fullname, age, address, gender));
                    Student.setStudent(lstStudent);


                    resetFields();
                    Toast.makeText(
                        context,
                        "Student Added Successfully",
                        Toast.LENGTH_SHORT
                    ).show();
                }
            }
        })

        rdoGender.setOnCheckedChangeListener(object : RadioGroup.OnCheckedChangeListener {
            override fun onCheckedChanged(group: RadioGroup?, checkedId: Int) {
                when (checkedId) {
                    R.id.rdoMale -> {
                        gender = "Male";
                    }
                    R.id.rdoFemale -> {
                        gender = "Female";
                    }
                    R.id.rdoOther -> {
                        gender = "Other";
                    }
                }
            }

        })
        return view;
    }

    fun resetFields() {

        etFullname.setText("");
        etAge.setText("");
        etAddress.setText("");
        rdoMale.isChecked = false;
        rdoFemale.isChecked = false;
        rdoOther.isChecked = false;

    }


}