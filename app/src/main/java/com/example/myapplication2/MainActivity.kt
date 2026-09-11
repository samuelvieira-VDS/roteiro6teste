package com.example.myapplication2

import OnConfigChangeListener
import PerfilFragment
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(), OnConfigChangeListener {

    private lateinit var tvStatus: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvStatus = findViewById(R.id.tvStatus)

        // Inicializa com o Menu Principal
        if (savedInstanceState == null) {
            replaceFragment(MenuPrincipalFragment(), false)
        }

        // Configuração dos Botões
        findViewById<Button>(R.id.btnMenu).setOnClickListener {
            // Limpa o back stack e volta para o menu
            supportFragmentManager.popBackStack(null, androidx.fragment.app.FragmentManager.POP_BACK_STACK_INCLUSIVE)
            replaceFragment(MenuPrincipalFragment(), false)
        }

        findViewById<Button>(R.id.btnPerfil).setOnClickListener {
            replaceFragment(PerfilFragment(), true)
        }

        findViewById<Button>(R.id.btnAudio).setOnClickListener {
            replaceFragment(AudioFragment(), true)
        }

        findViewById<Button>(R.id.btnSeguranca).setOnClickListener {
            replaceFragment(SegurancaFragment(), true)
        }
    }

    // Método para substituir fragments. Note o uso da Back Stack.
    private fun replaceFragment(fragment: Fragment, addToBackStack: Boolean) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragmentContainer, fragment)

        if (addToBackStack) {
            transaction.addToBackStack(null)
        }

        transaction.commit()
    }

    override fun onConfigUpdated(configName: String, newValue: String) {
        tvStatus.text = "Status atualizado: $configName -> $newValue"
    }
}