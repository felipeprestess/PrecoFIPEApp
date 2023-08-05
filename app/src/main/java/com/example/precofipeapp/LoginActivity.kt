package com.example.precofipeapp

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.preference.PreferenceManager
import android.widget.Button
import android.widget.EditText
import android.widget.Switch
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.example.precofipeapp.database.dao.UsuarioDAO
import com.example.precofipeapp.util.DialogUtil
import com.example.precofipeapp.util.KeyUtil

class LoginActivity : ComponentActivity() {
    lateinit var editEmail: EditText
    lateinit var editSenha: EditText
    lateinit var btnEntrar: Button
    lateinit var btnRegistrar: Button
    lateinit var switchLembrarSenha: Switch
    lateinit var dao: UsuarioDAO

    val REQUEST_REGISTRO = 10


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity)

        switchLembrarSenha = findViewById(R.id.switchLembrarSenha)
        editEmail = findViewById(R.id.editEmail)
        editSenha = findViewById(R.id.editSenha)

        btnRegistrar = findViewById(R.id.btnRegistrar)
        btnRegistrar.setOnClickListener {
            val it = Intent(this, RegistroActivity::class.java)
            startActivityForResult(it, REQUEST_REGISTRO)
        }

        btnEntrar = findViewById(R.id.btnEntrar);
        btnEntrar.setOnClickListener {
            var conteudoEmail = editEmail.text.toString()
            var conteudoSenha = editSenha.text.toString()

            if (conteudoEmail.isEmpty()) {
                editEmail.setError("Campo Email obrigatório!")
            } else if (conteudoSenha.isEmpty()) {
                editSenha.setError("Campo Senha obrigatório!")
            } else {

                dao = UsuarioDAO(this)
                val usuarioFounded: Boolean = dao.Select(conteudoEmail, conteudoSenha)
                if (usuarioFounded) {
                    if (switchLembrarSenha.isChecked()){
                        var preferencesTmp = PreferenceManager.getDefaultSharedPreferences(this)
                        var edito = preferencesTmp.edit()
                        edito.putString(KeyUtil.KEY_USUARIO, conteudoEmail).putString(KeyUtil.KEY_SENHA, conteudoSenha).apply()
                    }

                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                } else {
                    DialogUtil.show("Erro", "Usuário inválido", this)
                }
            }
        }

        var pref: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)
        editEmail.setText(pref.getString(KeyUtil.KEY_USUARIO,""))
        editSenha.setText(pref.getString(KeyUtil.KEY_SENHA, ""))

        if (!editEmail.text.toString().isEmpty()) {
            switchLembrarSenha.setChecked(true)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_REGISTRO) {

            //botao salvar
            if (resultCode == 1) {

                val resultadoEmailUsuario = data?.getStringExtra(KeyUtil.KEY_REGISTRO_EMAIL_USUARIO)
                val resultadoSenhaUsuario = data?.getStringExtra(KeyUtil.KEY_REGISTRO_SENHA_USUARIO)
                editEmail.setText(resultadoEmailUsuario)
                editSenha.setText(resultadoSenhaUsuario)

            } else if (resultCode == 9) {
                Toast.makeText(this, "Cancelou o registro de usuário", Toast.LENGTH_LONG).show()
            }

        }
    }
}



