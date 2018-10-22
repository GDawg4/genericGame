package voicePacks

class NarratorDeutsch:Narrator {

    //verschiedene Aktionen, verschiedene Strings
    override fun narrate(action: Int):String?{
        when(action){
            1 -> return "GUTEN MORGEN\n"
            2 -> return "FANGEN WIR AN\n"
            21 -> return "RADIANT IST DRAN\n"
            22 -> return "DIRE IST DRAN\n"
            23 -> return "WAR GEWÄHLT\n"
            24 -> return "SCHREIB DER ZAHL DEINER WAHL\n"
            25 -> return "ALSO BEGINN MAL\n"
            3 -> return "EIN TOD FÜR\n"
            4 -> return "MULTI-TOD FÜR\n"
            41 -> return "WIE BITTE??"
            5 -> return "PENTA-TOD\n"
            6 -> return "ZERTRÜMTE TURM\n"
            61 -> return "ALLE TURME SIND SCHÖN TOT"
            7 -> return "RADIANT GEWINNT\n"
            8 -> return "DIRE GEWINNT\n"
        }
        return ""
    }
}