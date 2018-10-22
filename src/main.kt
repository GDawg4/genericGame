import Elements.Hero
import Elements.Match
import Elements.Team
import voicePacks.NarratorDeutsch
import voicePacks.NarratorSpanish

//función para crear los héroes
fun createHeroes():ArrayList<Hero>{
    //se crea una lista vacía, se crean todas las instancias de héroe y se agregan a la lista
    var availableHero: ArrayList<Hero> = ArrayList()
    var strength = "Strength"
    var agility = "Agility"
    var intelligence = "Intelligence"

    availableHero.add(Hero("Tiny", strength))
    availableHero.add(Hero("Kunkka", strength))
    availableHero.add(Hero("Pangolier", agility))
    availableHero.add(Hero("Slark", agility))
    availableHero.add(Hero("Storm Spirit", intelligence))
    availableHero.add(Hero("Invoker", intelligence))
    availableHero.add(Hero("Night Stalker", strength))
    availableHero.add(Hero("Doom", strength))
    availableHero.add(Hero("Terrorblade", agility))
    availableHero.add(Hero("Ember spirit", agility))
    availableHero.add(Hero("Necrophos", intelligence))
    availableHero.add(Hero("Witch Doctor", intelligence))
    availableHero.add(Hero("Lycan", strength))
    availableHero.add(Hero("Sand King", agility))
    availableHero.add(Hero("Ursa", agility))
    availableHero.add(Hero("Bloodseeker", agility))
    availableHero.add(Hero("Enchantress", agility))
    availableHero.add(Hero("Chen", agility))
    availableHero.add(Hero("Abbadon", strength))
    availableHero.add(Hero("Dazzle", intelligence))
    return availableHero
}

//función que contiene los dos tipos de menú
fun menu(typeOfMenu:Int):String{
    when(typeOfMenu){
        1 ->{
            return """
        1. Ocurrieron muertes
        2. Matan torres
    """.trimIndent()
        }
        2 ->{
            return """
        1. Ocurrieron muertes
        2. Matan torres
        3. Matan Ancient
    """.trimIndent()
        }
    }
    return ""
}


fun main(args: Array<String>) {
    //se crea la partida, con el cometarista incluído
    val match = Match(NarratorSpanish())

    //se crean los héroes que pueden ser elegidos
    match.loadHeroes(createHeroes())

    println(match.welcome())
    println(match.begin())
    //para seleccionar los equipos
    for (i in 1..10){
        //se imprime qué equipo elige actualmente
        println(match.teamIsUp())
        //se imprie lista de héroes disponibles
        println(match.availableHeroes())
        //se incita a elegir
        println(match.choose())
        val chosenHero = readLine()!!
        //se selecciona elhéroe arpopiado
        println(match.selectHero(chosenHero.toInt()))
    }
    println(match.matchStart())

    do {
        var gameIsOn = true
        //se revisa si un Ancient puede ser eliminado y se imprime acorde
        println(menu(if (match.canGameBeEnded()){
            2
        }else {
            1
        }))
        //se pregunta sobre el evento ocurrido
        println("Qué ocurrió?")
        var event = readLine()!!
        when(event){
            //muerte de héroes
            "1" ->{
                //se pregunta qué equipo mató
                println("Mató Radiant?")
                var killer = readLine()!!.toLowerCase()

                println("Cuántas muertes? (1-5) ")
                var numberOfKills = readLine()!!.toInt()

                //se imprime el mensaje acorde
                when(killer){
                    "si" -> {
                        when {
                            (numberOfKills == 1)-> println(match.oneKill(true))
                            ((5 >= numberOfKills) and (numberOfKills > 1)) -> println(match.moreKills(true))
                            else -> println(match.wrongInput())
                        }
                    }
                    "no" -> {
                        when {
                            (numberOfKills == 1) -> println(match.oneKill(false))
                            ((5 >= numberOfKills) and (numberOfKills > 1)) -> println(match.moreKills(false))
                            else -> println(match.wrongInput())
                        }
                    }
                    else ->{
                        println(match.wrongInput())
                    }
                }
            }

            //destrucción de torres
            "2" ->{
                //se pregunta quién mató
                println("Mató Radiant?")
                var towerKiller = readLine()!!.toLowerCase()
                //se imprime acorde
                when(towerKiller){
                    "si" -> {
                        match.killTower(true)
                    }
                    "no" ->{
                        match.killTower(false)
                    }
                }
            }

            //para fin de juego
            "3" ->{
                // si el juego puede ser terminado
                if (match.canGameBeEnded()){
                    //se revisa si solo un equipo puede ganar
                    //en ese caso, gana automáticamente ese equipo
                    when {
                        (match.isRadiantKillable() and !match.isDireKillable()) -> println(match.direWins())
                        (!match.isRadiantKillable() and match.isDireKillable()) -> println(match.radiantWins())
                        //de lo contrario, se pregunta quién ganó
                        else -> {
                            println("Mató Radiant?")
                            var winner = readLine()!!.toLowerCase()
                            when(winner){
                                "si" -> match.radiantWins()
                                "no" -> match.direWins()
                            }
                        }
                    }
                    //en cualquier caso, se termina el juego
                    gameIsOn = false
                }else{
                    println(match.wrongInput())
                }
            }
            //mensaje de ingreso incorrecto
            else -> {
                println(match.wrongInput())
            }
        }
    }while (gameIsOn)
}