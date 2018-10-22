package Elements

class Team{
    var heroes: ArrayList<Hero> = ArrayList()
    var towers: ArrayList<Tower> = ArrayList()
    var ancient: Ancient = Ancient()

    init {
        for(i in 1..6){
            val newTower:Tower = Tower()
            towers.add(newTower)
        }
    }

    fun numberOfTowers():Int{
        var count = towers.filter {
            it.isAlive
        }
        return count.size
    }
}