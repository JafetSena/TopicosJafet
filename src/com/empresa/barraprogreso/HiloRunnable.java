package com.empresa.barraprogreso;

public class HiloRunnable implements Runnable 
{
	Thread hilo;
	String strNombreHilo;
	HiloRunnable(String strNombre)
	{
		hilo = new Thread(this, strNombre);
		hilo.start();
	}
	public void run() 
	{
		try 
		{
			for(int i=0;i<10;i++) 
			{
				Thread.sleep(1000);
			}
		}
		catch(InterruptedException x) 
		{
			System.out.println(x.getMessage());
		}
	}
}
