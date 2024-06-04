package rafoshi.com.rafaelioshi_rm93102_modelo_recyclerview.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import rafoshi.com.rafaelioshi_rm93102_modelo_recyclerview.R
import rafoshi.com.rafaelioshi_rm93102_modelo_recyclerview.model.ItemModel

class ItemsAdapter : RecyclerView.Adapter<ItemsAdapter.ItemViewHolder>() {
    private val items = mutableListOf<ItemModel>()

    fun addItem(newItem: ItemModel) {
        items.add(newItem)
        notifyDataSetChanged()
    }

    fun removeAll(){
        items.clear()
        notifyDataSetChanged()
    }

    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val praia = view.findViewById<TextView>(R.id.txtViewPraia)
        val cidade = view.findViewById<TextView>(R.id.txtViewCidade)
        val estado = view.findViewById<TextView>(R.id.txtViewEstado)
        val button = view.findViewById<ImageButton>(R.id.imageBtnDelete)

        fun bind(item: ItemModel) {
            praia.text = item.praia;
            cidade.text = item.cidade;
            estado.text = item.estado;

            button.setOnClickListener{
                item.onRemove(item)
            }
        }
    }

    fun removeItem(item: ItemModel) {
        items.remove(item)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ItemViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size;
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }
}