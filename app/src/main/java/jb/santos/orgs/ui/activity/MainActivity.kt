package jb.santos.orgs.ui.activity

import android.app.Activity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import jb.santos.orgs.R
import jb.santos.orgs.ui.recycler.adapter.ListaProdutosAdapter

class MainActivity: Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val nome = this.findViewById<TextView>(R.id.nome)
//        nome.text = "Cesta de fruta"
//
//        val descricao = this.findViewById<TextView>(R.id.descricao)
//        descricao.text = "Laranja, manga e maça"
//
//        val valor = this.findViewById<TextView>(R.id.numero)
//        valor.text = "1998"


        val recyclerView = this.findViewById<RecyclerView>(R.id.list)
        recyclerView.adapter = ListaProdutosAdapter()
    }
}