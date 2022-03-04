package jb.santos.orgs

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import jb.santos.orgs.model.Produto
import jb.santos.orgs.ui.recycler.adapter.ListaProdutosAdapter
import java.math.BigDecimal

class MainActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val recyclerView = this.findViewById<RecyclerView>(R.id.list)
        recyclerView.adapter = ListaProdutosAdapter(context = this, produtos = listOf(
            Produto(
                nome = "PRODUTO 1",
                descricao = "DESSCRICAO",
                valor = BigDecimal("15.5")
            ),
            Produto(
                nome = "PRODUTO 2",
                descricao = "DESSCRICAO 2",
                valor = BigDecimal("20.5")
            )
        ))

        recyclerView.layoutManager = LinearLayoutManager(this)
    }
}