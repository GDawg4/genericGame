package Elements

//clase equipo
class Team{
    //lista de héroes y torres
    var heroes: ArrayList<Hero> = ArrayList()
    var towers: ArrayList<Tower> = ArrayList()
    var ancient: Ancient = Ancient()

    //todos los equipos inician con 6 torres
    init {
        for(i in 1..6){
            val newTower:Tower = Tower()
            towers.add(newTower)
        }
    }

    //para revisar el númer de torres vivs
    fun numberOfTowers():Int{
        //se filtra las torres vivas y se cuenta el tamaño de la lista
        var count = towers.filter {
            it.isAlive
        }
        return count.size
    }
}