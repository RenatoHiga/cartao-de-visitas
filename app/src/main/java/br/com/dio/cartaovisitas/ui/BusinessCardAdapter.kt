package br.com.dio.cartaovisitas.ui

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import br.com.dio.cartaovisitas.data.BusinessCard
import br.com.dio.cartaovisitas.databinding.ItemBusinessCardBinding

class BusinessCardAdapter :
    ListAdapter<BusinessCard, BusinessCardAdapter.ViewHolder>(DiffCallback()) {

    var listenerShare: (View) -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflator = LayoutInflater.from(parent.context)
        val binding = ItemBusinessCardBinding.inflate(inflator, parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(
        private val binding: ItemBusinessCardBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind (item: BusinessCard) {
            binding.tvNome.text = item.nome
            binding.tvTelefone.text = item.telefone
            binding.tvEmail.text = item.email
            binding.tvServices.text = item.servicos
            binding.tvNomeEmpresa.text = item.empresa
            binding.mcvContent.setCardBackgroundColor(Color.parseColor(item.fundoPersonalizado))
            binding.mcvContent.setOnClickListener {
                listenerShare(it)
            }

            binding.tvNome.setTextColor(Color.parseColor(item.corTexto))
            binding.tvTelefone.setTextColor(Color.parseColor(item.corTexto))
            binding.tvEmail.setTextColor(Color.parseColor(item.corTexto))
            binding.tvServices.setTextColor(Color.parseColor(item.corTexto))
            binding.tvNomeEmpresa.setTextColor(Color.parseColor(item.corTexto))
        }
    }

}

class DiffCallback: DiffUtil.ItemCallback<BusinessCard>() {
    override fun areItemsTheSame(oldItem: BusinessCard, newItem: BusinessCard) = oldItem == newItem

    override fun areContentsTheSame(oldItem: BusinessCard, newItem: BusinessCard) =
        oldItem.id == newItem.id
}