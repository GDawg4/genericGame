package voicePacks

class NarratorDeutsch:Narrator {

    override fun narrate(action: Int):String?{
        when(action){
            1 -> return "GUTEN MORGEN"
            2 -> return "FANGEN WIR AN"
            3 -> return "EIN TOD"
            4 -> return "MULTI-TOD"
            5 -> return "PENTA-TOD"
            6 -> return "ZERTRUMTE TURM"
            7 -> return "TEAM 1 GEWIINT"
            8 -> return "TEAM 2 GEWINNT"
        }
        return ""
    }
}