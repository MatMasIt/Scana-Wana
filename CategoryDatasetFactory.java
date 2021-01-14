import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.jfree.data.category.DefaultCategoryDataset;

public class CategoryDatasetFactory {
	public CategoryDatasetFactory() {

	}

	public DefaultCategoryDataset loadFile(String path) throws FileNotFoundException {
		//nome_canzone,likes,dislikes,views
		String likes = "Likes";
		String dislikes = "Dislikes";
		String views = "Views";		
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		File f = new File(path);
		Scanner s = new Scanner(f);
		String line="";
		while (s.hasNextLine()) {
			line=s.nextLine();
			String[] celle = line.split(",");
			dataset.addValue(Double.parseDouble(celle[1]), likes, celle[0]);
			dataset.addValue(Double.parseDouble(celle[2]), dislikes, celle[0]);
			dataset.addValue(Double.parseDouble(celle[3]), views, celle[0]);
		}
		s.close();

		return dataset;
	}
}
