package Elements

class Team(var heroes: ArrayList<Hero> = ArrayList(),
           towers: ArrayList<Tower> = ArrayList(),
           var ancient: Ancient = Ancient()) {
    init {
        for (i in 1..6){
            var newTower = Tower()
            towers.add(newTower)
        }
    }
}