import Elements.Hero
import Elements.Match
import Elements.Team
import voicePacks.NarratorDeutsch

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


fun main(args: Array<String>) {
    val match = Match(NarratorDeutsch())
    match.availableHeroesDire = createHeroes()
    match.availableHeroesRadiant = createHeroes()

    println(match.narrate(1))
    println(match.narrate(2))

    for (i in 1..10){
        println(match.narrate(20))
        println(match.availableHeroes())
        println(match.narrate(24))
        val chosenHero = readLine()!!
        println(match.selectHero(chosenHero.toInt()))
        match.teamSelecting = !match.teamSelecting
    }
    println(match.radiant.heroes)
    println(match.dire.heroes)
}