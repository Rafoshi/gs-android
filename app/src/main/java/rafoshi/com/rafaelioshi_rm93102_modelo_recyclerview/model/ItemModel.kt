package rafoshi.com.rafaelioshi_rm93102_modelo_recyclerview.model

data class ItemModel(val praia: String,val cidade: String,val estado: String, val onRemove: (ItemModel) -> Unit)