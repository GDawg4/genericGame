import Elements.Hero
import Elements.Match
import voicePacks.NarratorDeutsch

fun main(args: Array<String>) {
    val match = Match(NarratorDeutsch())

    println(match.narrator.narrate(2))
}