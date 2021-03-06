package jb.santos.orgs.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import jb.santos.orgs.R
import jb.santos.orgs.dao.ProdutosDao
import jb.santos.orgs.model.Produto
import java.math.BigDecimal

class FormProductActivity : AppCompatActivity(R.layout.activity_form_product) {

    private val dao = ProdutosDao()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        clickButton()
    }

    private fun clickButton() {
        val button = findViewById<Button>(R.id.form_button)
        button.setOnClickListener {
            submitForm()
        }
    }

    private fun submitForm() {
        val nome = findViewById<EditText>(R.id.form_nome).text.toString()
        val descricao = findViewById<EditText>(R.id.form_descricao).text.toString()
        val valor = findViewById<EditText>(R.id.form_valor).text.toString()

        val valorBigDecimal = if (valor.isBlank()) {
            BigDecimal.ZERO
        } else {
            BigDecimal(valor)
        }
        val product = Produto(
            nome = nome,
            descricao = descricao,
            valor = valorBigDecimal
        )

        this.dao.add(product)

        Toast.makeText(this, R.string.save_product, Toast.LENGTH_SHORT).show()
        finish()
    }

}