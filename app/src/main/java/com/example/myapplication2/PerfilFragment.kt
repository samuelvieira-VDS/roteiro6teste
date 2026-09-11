
package com.example.myapplication2
import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.example.myapplication2.OnConfigChangeListener

class PerfilFragment : Fragment(R.layout.fragment_perfil) {

    private var listener: OnConfigChangeListener? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        // Conecta a Activity à Interface
        if (context is OnConfigChangeListener) {
            listener = context
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val editNome = view.findViewById<EditText>(R.id.editNomeJogador)
        val btnSalvar = view.findViewById<Button>(R.id.btnSalvarPerfil)

        btnSalvar.setOnClickListener {
            val novoNome = editNome.text.toString()
            // Envia o dado para a MainActivity
            listener?.onConfigUpdated("Nome do Jogador", novoNome)
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null // Evita memory leaks
    }
}