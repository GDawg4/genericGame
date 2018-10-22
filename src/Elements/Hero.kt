package Elements

data class Hero (val name: String, val tipo: String) {
    override fun toString(): String {
        return "${this.name}: ${this.tipo}"
    }
}