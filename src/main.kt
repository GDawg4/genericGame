import Elements.Hero
import Elements.Match
import Elements.Team
import voicePacks.NarratorDeutsch
import voicePacks.NarratorSpanish

fun createHeroes():ArrayList<Hero>{
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
    val match = Match(NarratorSpanish())
    /*
    match.loadHeroes(createHeroes())

    println(match.narrate(1))
    println(match.narrate(2))

    for (i in 1..10){
        println(match.narrate(20))
        println(match.availableHeroes())
        println(match.narrate(24))
        val chosenHero = readLine()!!
        println(match.selectHero(chosenHero.toInt()))
    }
    println(match.narrate(25))
    */

    do {
        var gameIsOn = true
        println(menu(if (match.canGameBeEnded()){
            2
        }else {
            1
        }))
        println("Qué ocurrió?")
        var event = readLine()!!
        when(event){
            "1" ->{
                println("Mató Radiant?")
                var killer = readLine()!!.toLowerCase()

                println("Cuántas muertes? (1-5) ")
                var numberOfKills = readLine()!!.toInt()

                if(killer == "si"){
                    if (numberOfKills == 1){
                        println("${match.narrate(3)} RADIANT")
                    }
                    else if ((5 >= numberOfKills) and (numberOfKills > 1)){
                        println("${match.narrate(4)} RADIANT")
                    }
                    else{
                        println(match.narrate(41))
                    }
                }else if (killer == "no"){
                    if (numberOfKills == 1){
                        println("${match.narrate(3)} DIRE")
                    }
                    else if ((5 >= numberOfKills) and (numberOfKills > 1)){
                        println("${match.narrate(4)} DIRE")
                    }
                    else{
                        println(match.narrate(41))
                    }
                }else{
                    println(match.narrate(41))
                }
            }
            "2" ->{
                println("Mató Radiant?")
                var towerKiller = readLine()!!.toLowerCase()
                when(towerKiller){
                    "si" -> {
                        if (match.killDireTower()){
                            println(match.narrate(6))
                        }else{
                            println(match.narrate(61))
                        }
                    }
                    "no" ->{
                        if (match.killRadiantTower()){
                            println(match.narrate(6))
                        }else{
                            println(match.narrate(61))
                        }
                    }
                }
            }
            "3" ->{
                if (match.canGameBeEnded()){
                    when {
                        (match.isRadiantKillable() and !match.isDireKillable()) -> println(match.narrate(8))
                        (!match.isRadiantKillable() and match.isDireKillable()) -> println(match.narrate(7))
                        else -> {
                            println("Mató Radiant?")
                            var winner = readLine()!!.toLowerCase()
                            when(winner){
                                "si" -> println(7)
                                "no" -> println(8)
                            }
                        }
                    }
                    gameIsOn = false
                }else{
                    println(match.narrate(41))
                }
            }
            else -> {
                println(match.narrate(41))
            }
        }
    }while (gameIsOn)

}