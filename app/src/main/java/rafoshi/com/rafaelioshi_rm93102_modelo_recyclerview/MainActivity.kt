package rafoshi.com.rafaelioshi_rm93102_modelo_recyclerview

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.RecyclerView
import rafoshi.com.rafaelioshi_rm93102_modelo_recyclerview.adapter.ItemsAdapter
import rafoshi.com.rafaelioshi_rm93102_modelo_recyclerview.model.ItemModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.setTitle("CETESB - Praias")

        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewId)
        val itemsAdapter = ItemsAdapter()
        recyclerView.adapter = itemsAdapter

        val incluirButton = findViewById<Button>(R.id.btnIncluir)
        val deleteButton = findViewById<Button>(R.id.btnDeletar)
        val txtPraia = findViewById<EditText>(R.id.editTxtPraia)
        val txtCidade = findViewById<EditText>(R.id.editTxtCidade)
        val txtEstado = findViewById<EditText>(R.id.editTxtEstado)


        deleteButton.setOnClickListener{
            itemsAdapter.removeAll()
        }

        incluirButton.setOnClickListener{
            if(txtPraia.text.isEmpty()){
                txtPraia.error = "Preencha um valor"
                return@setOnClickListener
            }
            if(txtCidade.text.isEmpty()) {
                txtCidade.error = "Preencha um valor"
                return@setOnClickListener
            }
            if(txtEstado.text.isEmpty()) {
                txtEstado.error = "Preencha um valor"
                return@setOnClickListener
            }

            val item = ItemModel(
                praia = txtPraia.text.toString(),
                cidade = txtCidade.text.toString(),
                estado = txtEstado.text.toString(),
                onRemove = {
                    itemsAdapter.removeItem(it)
                }
            )

            itemsAdapter.addItem(item)
            txtPraia.text.clear()
            txtCidade.text.clear()
            txtEstado.text.clear()
        }
    }
}