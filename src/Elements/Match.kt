package Elements

import voicePacks.Narrator

class Match <T>(
        val narrator: T,
        val radiant: Team = Team(),
        val dire:Team = Team()) where T: Narrator{

    fun narrate(event: Int):String? {
        return this.narrator.narrate(event)
    }

    fun heroesOptions():String{
        return """
            1. TINY
            2. KUNKKA
            3. PANGOLIER
            4. SLARK
            5. STORM SPIRIT
            6. INVOKER
            7. NIGHT STALKER
            8. DOOM
            9. TERRORBLADE
            10.EMBER SPIRIT
            11.NECROPHOS
            12.WITCH DOCTOR
            13.LYCAN
            14.SAND KING
            15.URSA
            16.BLOODSEEKER
            17.ENCHANTRESS
            18.CHEN
            19.ABADDON
            20.DAZZLE
        """.trimIndent()
    }
    fun heroesSelection():String?{
        return null
    }
}