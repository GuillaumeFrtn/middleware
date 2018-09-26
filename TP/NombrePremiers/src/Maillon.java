
public class Maillon extends Thread
{
	int val;
	Tampon tamponPrecedent;
	Tampon tamponSuivant;
	int nbSuivant = 0;
	
	public Maillon(int val, Tampon tampon)
	{
		this.val = val;
		this.tamponPrecedent = tampon;
	}
	
	public void run()
	{
		int valTampon;
		do
		{
			valTampon = tamponPrecedent.cons();
			
			if(!(valTampon%val==0))
			{
				if(nbSuivant==0 && valTampon!=1)
				{
					tamponSuivant = new Tampon();
					Maillon suivant = new Maillon(valTampon, tamponSuivant);
					suivant.start();
					++nbSuivant;
				}
				
				if(nbSuivant>0)
				{
					tamponSuivant.prod(valTampon);
				}
				
			}
		} while (valTampon!=1);
	}
}
