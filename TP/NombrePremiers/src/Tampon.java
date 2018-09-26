
public class Tampon 
{
	private int val;
	private boolean estVide;
	
	public Tampon()
	{
		this.estVide = true;
	}
	
	public synchronized void prod(int val)
	{
		if (!estVide)
		{
			try
			{
				wait();
			}
			catch (InterruptedException e) {}
		}
		
		this.val = val; estVide = false; notify();
	}
	
	public synchronized int cons()
	{
		if (estVide)
		{
			try
			{
				wait();
			}
			catch (InterruptedException e) {}
		}
		
		int resul = this.val; estVide = true; notify();
		return resul;
	}
}
