package com.example.precofipeapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.example.precofipeapp.R
import com.example.precofipeapp.database.dao.UsuarioDAO
import com.example.precofipeapp.database.model.UsuarioModel
import com.example.precofipeapp.util.DialogUtil
import com.example.precofipeapp.util.KeyUtil

class RegistroActivity : ComponentActivity() {
    lateinit var btnSalvar: Button
    lateinit var btnCancelar: Button

    lateinit var editEmailUsuario: EditText
    lateinit var editNomeUsuario: EditText
    lateinit var editSenhaUsuario: EditText
    lateinit var editConfirmaSenhaUsuario: EditText
    lateinit var dao: UsuarioDAO

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.registro_activity)

        btnSalvar = findViewById(R.id.btnSalvar)
        btnSalvar.setOnClickListener {

            if (editNomeUsuario.text.toString().isEmpty()) {
                editNomeUsuario.setError("Campo nome obrigatório")
                editNomeUsuario.setEnabled(true);
            } else if (editEmailUsuario.text.toString().isEmpty()) {
                editEmailUsuario.setError("Campo e-mail obrigatório!")
                editEmailUsuario.setEnabled(true);
            } else if (!editSenhaUsuario.text.toString().equals(editConfirmaSenhaUsuario.text.toString())) {
                editSenhaUsuario.setText("")
                editConfirmaSenhaUsuario.setText("")
                editSenhaUsuario.requestFocus()

                Toast.makeText(this, "Senhas não são iguais", Toast.LENGTH_LONG).show()

            } else {
                dao = UsuarioDAO(this)

                val model = UsuarioModel()
                model.setNomeUsuario(editNomeUsuario.text.toString())
                model.setEmailUsuario(editEmailUsuario.text.toString())
                model.setSenhaUsuario(editSenhaUsuario.text.toString())

                var linhasInseridas = dao.Insert(model)
                if (linhasInseridas > 0) {
                    val it = Intent();
                    it.putExtra(KeyUtil.KEY_REGISTRO_NOME_USUARIO, editNomeUsuario.text.toString())
                    it.putExtra(KeyUtil.KEY_REGISTRO_EMAIL_USUARIO, editEmailUsuario.text.toString())
                    it.putExtra(KeyUtil.KEY_REGISTRO_SENHA_USUARIO, editSenhaUsuario.text.toString())

                    setResult(1, it);
                    finish();
                } else {
                    DialogUtil.show("Erro", "Falha ao cadastrar usuário no banco de dados!", this)
                }
            }
        }

        btnCancelar = findViewById(R.id.btnCancelar)
        btnCancelar.setOnClickListener {
            setResult(9);
            finish();
        }

        editNomeUsuario = findViewById(R.id.editNomeUsuario)
        editEmailUsuario = findViewById(R.id.editEmailUsuario)

        editSenhaUsuario = findViewById(R.id.editSenhaUsuario)
        editConfirmaSenhaUsuario = findViewById(R.id.editConfirmaSenhaUsuario)
    }
}