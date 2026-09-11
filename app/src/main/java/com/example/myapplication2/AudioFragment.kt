package com.example.myapplication2

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Switch
import androidx.fragment.app.Fragment


class AudioFragment : Fragment(R.layout.fragment_audio) {

    private var listener: OnConfigChangeListener? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnConfigChangeListener) {
            listener = context
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val switchMusica = view.findViewById<Switch>(R.id.switchMusica)

        // Listener do Switch nativo do Android
        switchMusica.setOnCheckedChangeListener { _, isChecked ->
            val status = if (isChecked) "Ligada" else "Desligada"
            // Envia a atualização em tempo real para a Activity
            listener?.onConfigUpdated("Música", status)
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }
}