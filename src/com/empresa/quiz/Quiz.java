package com.empresa.quiz;

public class Quiz {
	public Quiz(String Pregunta, String RespuestaCorrecta) {
		strPregunta = Pregunta;
		strRespuestaCorrecta = RespuestaCorrecta;
	}
	public String strPregunta;
	public String strRespuestaCorrecta;
	public String strRespuesta;
	
	public Boolean ComprobarRespuesta() {
		if(strRespuesta == strRespuestaCorrecta){
			return (true);
		}
		else {
			return (false);
		}
	}
}
