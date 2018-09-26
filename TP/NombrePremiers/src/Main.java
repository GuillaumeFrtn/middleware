
public class Main 
{
	public static void main(String[] args) 
	{
		int i;
		final int N = 5;
		Tampon tampon = new Tampon();
		Maillon premier = new Maillon(2, tampon);
		premier.start();
		
		for(i=3; i<=N; ++i)
		{
			tampon.prod(i);
		}
		tampon.prod(1);
	}
}
