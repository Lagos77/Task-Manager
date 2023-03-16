package com.app.todoapp.presentation.note

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.app.todoapp.R
import com.app.todoapp.util.UtilsJava
import com.app.todoapp.util.UtilsSingleton
import com.app.todoapp.util.UtilsStatic

class NoteFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_note, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //This will have some memory allocated
        UtilsSingleton.method()

        //This will have some memory allocated by default


        UtilsStatic.method()
        UtilsStatic.method2()

        //This will have some memory allocated
        val instance = UtilsStatic()
        instance.method3()


        UtilsJava.method3()
    }

}