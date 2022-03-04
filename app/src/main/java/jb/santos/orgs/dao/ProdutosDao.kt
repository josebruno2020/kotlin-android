package jb.santos.orgs.dao

import jb.santos.orgs.model.Produto

class ProdutosDao {

    fun add(produto: Produto) {
        Companion.products.add(produto)
    }

    fun searchAll(): List<Produto> {
        return Companion.products.toList()
    }

    companion object {
        private val products =  mutableListOf<Produto>()
    }
}