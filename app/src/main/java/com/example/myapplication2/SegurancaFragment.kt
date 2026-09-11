package com.example.myapplication2

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.ToggleButton
import androidx.fragment.app.Fragment

class SegurancaFragment : Fragment(R.layout.fragment_seguranca) {

    private var listener: OnConfigChangeListener? = null


    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnConfigChangeListener) {
            listener = context
        }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val toggle2FA = view.findViewById<ToggleButton>(R.id.toggle2FA)


        toggle2FA.setOnCheckedChangeListener { _, isChecked ->
            val status = if (isChecked) "Ativada" else "Desativada"


            listener?.onConfigUpdated("Autenticação 2FA", status)
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }
}