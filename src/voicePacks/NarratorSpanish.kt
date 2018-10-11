package voicePacks

class NarratorSpanish:Narrator{

    override fun narrate(action: Int):String?{
        when(action){
            1 -> return "BIENVENIDOS AL JUEGO"
            2 -> return "EMPEZEMOS"
            3 -> return "UNA KILL"
            4 -> return "MULTI-KILL"
            5 -> return "PENTA-KILL"
            6 -> return "TORRE MUERTA"
            7 -> return "GANA EL EQUIPO 1"
            8 -> return "GANA EL EQUIPO 2"
        }
        return ""
    }

}