package voicePacks

class NarratorSpanish:Narrator{

    override fun narrate(action: Int):String?{
        when(action){
            1 -> return "BIENVENIDOS AL JUEGO\n"
            2 -> return "EMPECEMOS\n"
            21 -> return "LE TOCA A RADIANT\n"
            22 -> return "LE TOCA A DIRE\n"
            23 -> return "FUE ELEGIDO\n"
            24 -> "INGRESE EL NÚMERO DE SU SELECCIÓN\n"
            25 -> "BUENO, EMPECEMOS\n"
            3 -> return "UNA KILL PARA\n"
            4 -> return "MULTI-KILL PARA\n"
            41 -> return "NO VÁLIDO"
            5 -> return "PENTA-KILL\n"
            6 -> return "TORRE MUERTA\n"
            61 -> return "TODAS LAS TORRES ESTÁN MUERTAS"
            7 -> return "GANA RADIANT\n"
            8 -> return "GANA DIRE\n"
        }
        return ""
    }

}