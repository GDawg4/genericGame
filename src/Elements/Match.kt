package Elements

import voicePacks.Narrator
//clase partida
class Match <T>(
        //se crea un narrador variable
        private val narrator: T,
        //dos equipos
        private val radiant: Team = Team(),
        private val dire:Team = Team(),
        //para selección de equipos
        private var teamSelecting: Boolean = true,
        //lista de héroes disponibles
        private var availableHeroes:ArrayList<Hero> = ArrayList()
        ) where T: Narrator {

    //se cargan los héroes al pasarle una lista con los héroes disponibles
    fun loadHeroes(heroes: ArrayList<Hero>) {
        this.availableHeroes = heroes
    }

    //función que "traduce" eventos a narraciones
    fun narrate(event: Int): String? {
        if (event == 20) {
            when (teamSelecting) {
                true -> return this.narrator.narrate(21)
                false -> return this.narrator.narrate(22)
            }
        }
        return this.narrator.narrate(event)
    }

    //imprime todos los héroes disponibles de manera ordenada
    fun availableHeroes(): String? {
        var finalString = ""
        var counter = 1
        availableHeroes.forEach {
            finalString += "$counter. $it \n"
            counter++
        }
        return finalString
    }

    //para seleccionar héroes
    fun selectHero(place: Int): String? {
        //se "traduce" la posición del héroe
        var correctedPlace = place - 1
        //se revisa qué equipo está seleccionando
        if (teamSelecting) {
            //se agrega ese héroe a la lista del equipo
            radiant.heroes.add(availableHeroes[correctedPlace])
            //se retira de la lista de héroes disponibles
            availableHeroes.removeAt(correctedPlace)
            this.teamSelecting = !this.teamSelecting
            return "${radiant.heroes.last().name} ${this.narrate(23)}"
        } else {
            dire.heroes.add(availableHeroes[correctedPlace])
            availableHeroes.removeAt(correctedPlace)
            this.teamSelecting = !this.teamSelecting
            return "${dire.heroes.last().name} ${this.narrate(23)}"
        }
    }

    //para revisar si se puede matar a Radiant
    fun isRadiantKillable(): Boolean {
        if (this.radiant.numberOfTowers() == 0) {
            return true
        }
        return false
    }

    //para revisar si se puede matar a Dire
    fun isDireKillable(): Boolean {
        if (this.dire.numberOfTowers() == 0) {
            return true
        }
        return false
    }

    //para matar torre de Radiant
    fun killRadiantTower(): Boolean {
        //se revisa si queda alguna torre viva
        //si si, se mata y se regresa true
        radiant.towers.forEach {
            if (it.isAlive) {
                it.isAlive = false
                return true
            }
        }
        return false
    }

    //para matar torre de Radiant
    fun killDireTower(): Boolean {
        //se revisa si queda alguna torre viva
        //si si, se mata y se regresa true
        dire.towers.forEach {
            if (it.isAlive) {
                it.isAlive = false
                return true
            }
        }
        return false
    }

    //en caso se pueda matar uno de los dos, el juego se puede terminar
    fun canGameBeEnded(): Boolean {
        if (isRadiantKillable() or isDireKillable()) {
            return true
        }
        return false
    }

    //funciones de eventos varios
    fun welcome(): String? {
        return this.narrate(1)
    }

    fun begin(): String? {
        return this.narrate(2)
    }

    fun teamIsUp(): String? {
        return this.narrate(20)
    }

    fun choose(): String? {
        return this.narrate(24)
    }

    fun matchStart(): String? {
        return this.narrate(25)
    }

    fun oneKill(isRadiant: Boolean): String? {
        if (isRadiant) {
            return "${this.narrate(3)} RADIANT"
        }
        return "${this.narrate(3)} DIRE"
    }

    fun moreKills(isRadiant: Boolean): String? {
        if (isRadiant) {
            return "${this.narrate(4)} RADIANT"
        }
        return "${this.narrate(4)} DIRE"
    }

    fun wrongInput(): String? {
        return this.narrate(41)
    }

    fun killTower(isRadiant: Boolean): String? {
        if (isRadiant) {
            if (this.killDireTower()) {
                return this.narrate(6)
            } else {
                return this.narrate(61)
            }
        }
        else if(!isRadiant){
            if (this.killRadiantTower()) {
                return this.narrate(6)
            } else {
                return this.narrate(61)
            }
        }
        return ""
    }

    fun radiantWins():String?{
        this.dire.ancient.isDead = true
        return this.narrate(7)
    }

    fun direWins():String?{
        this.radiant.ancient.isDead = true
        return this.narrate(8)
    }
}