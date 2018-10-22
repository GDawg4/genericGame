package Elements

import voicePacks.Narrator

class Match <T>(
        val narrator: T,
        val radiant: Team = Team(),
        val dire:Team = Team(),
        var teamSelecting: Boolean = true,
        var availableHeroesRadiant:ArrayList<Hero> = ArrayList(),
        var availableHeroesDire: ArrayList<Hero> = ArrayList()) where T: Narrator{

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
        if (teamSelecting){
            availableHeroesRadiant.forEach {
                finalString += "$counter. $it \n"
                counter ++
            }
            return  finalString
        }
        else{
            availableHeroesDire.forEach {
                finalString += "$counter. $it \n"
                counter ++
            }
            return finalString
        }
    }

    fun selectHero(place:Int):String?{
        var correctedPlace = place - 1
        if(teamSelecting){
            radiant.heroes.add(availableHeroesRadiant[correctedPlace])
            availableHeroesRadiant.removeAt(correctedPlace)
            return "${radiant.heroes.first().name} ${this.narrate(23)}"
        }
        else{
            dire.heroes.add(availableHeroesDire[correctedPlace])
            availableHeroesDire.removeAt(correctedPlace)
            return "${radiant.heroes.first().name} ${this.narrate(23)}"
        }
    }
}