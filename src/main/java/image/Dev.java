package image;

import java.io.IOException;
import java.nio.file.Path;
//import image.filter.Pixelate;

public class Dev
	{
	public static void pixelate() throws IOException
		{
		final var image = new Image("../all-in-one/tests/plage.jpg");

		//final var pixelate = image.filter(new Pixelate(Pixelate.Mode.LINE, 30, 0.07));

		//Image.write(pixelate, "JPEG", Path.of("../all-in-one/tests/plage-pixelate2aaaaaaaa.jpeg"));
		}

	public static void main(String[] args)
		{
		try
			{
			pixelate();
			}
		catch (final Throwable ex)
			{
			ex.printStackTrace();
			}
		}
	}
