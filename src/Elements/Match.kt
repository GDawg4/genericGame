package Elements

import voicePacks.Narrator

class Match <T>(
        private val narrator: T,
        private val radiant: Team = Team(),
        private val dire:Team = Team(),
        private var teamSelecting: Boolean = true,
        private var availableHeroes:ArrayList<Hero> = ArrayList()
        ) where T: Narrator{

    fun loadHeroes(heroes:ArrayList<Hero>){
        this.availableHeroes = heroes
    }

    fun narrate(event: Int):String? {
        if (event == 20){
            when(teamSelecting){
                true -> return this.narrator.narrate(21)
                false -> return this.narrator.narrate(22)
            }
        }
        return this.narrator.narrate(event)
    }

    fun availableHeroes():String?{
        var finalString = ""
        var counter = 1
        availableHeroes.forEach {
            finalString += "$counter. $it \n"
            counter++
        }
        return finalString
    }

    fun selectHero(place:Int):String?{
        var correctedPlace = place - 1
        if(teamSelecting){
            radiant.heroes.add(availableHeroes[correctedPlace])
            availableHeroes.removeAt(correctedPlace)
            this.teamSelecting = !this.teamSelecting
            return "${radiant.heroes.last().name} ${this.narrate(23)}"
        }
        else{
            dire.heroes.add(availableHeroes[correctedPlace])
            availableHeroes.removeAt(correctedPlace)
            this.teamSelecting = !this.teamSelecting
            return "${dire.heroes.last().name} ${this.narrate(23)}"
        }
    }

    fun isRadiantKillable():Boolean{
        if(this.radiant.numberOfTowers() == 0){
            return true
        }
        return false
    }

    fun isDireKillable():Boolean{
        if(this.dire.numberOfTowers() == 0){
            return true
        }
        return false
    }

    fun killRadiantTower():Boolean{
        radiant.towers.forEach {
            println("ded")
            if (it.isAlive){
                it.isAlive = false
                println("ded")
                return true
            }
        }
        return false
    }

    fun killDireTower():Boolean{
        dire.towers.forEach {
            println("ded")
            if (it.isAlive){
                it.isAlive = false
                println("ded")
                return true
            }
        }
        return false
    }

    fun canGameBeEnded():Boolean{
        if(isRadiantKillable() or isDireKillable()){
            return true
        }
        return false
    }
}