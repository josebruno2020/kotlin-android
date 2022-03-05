package jb.santos.orgs

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import jb.santos.orgs.dao.ProdutosDao
import jb.santos.orgs.ui.activity.FormProductActivity
import jb.santos.orgs.ui.recycler.adapter.ListaProdutosAdapter

class ListProductsActivity: AppCompatActivity(R.layout.activity_main) {

    private val dao = ProdutosDao()
    private val adapter = ListaProdutosAdapter(context = this, produtos = dao.searchAll())


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        recyclerViewConfig()
        submitFab()
    }


    override fun onResume() {
        super.onResume()
        this.adapter.update(dao.searchAll())

    }

    private fun recyclerViewConfig() {
        val recyclerView = this.findViewById<RecyclerView>(R.id.list)

        Log.i("Main", "onResume: ${dao.searchAll()}")
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }

    private fun submitFab() {
        findViewById<FloatingActionButton>(R.id.float_button).setOnClickListener {
            val intent = Intent(this, FormProductActivity::class.java)
            startActivity(intent)
        }
    }
}