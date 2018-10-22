package Elements

//clase héroe
data class Hero (val name: String, val tipo: String) {
    //regresa info de manera ordenada
    override fun toString(): String {
        return "${this.name}: ${this.tipo}"
    }
}