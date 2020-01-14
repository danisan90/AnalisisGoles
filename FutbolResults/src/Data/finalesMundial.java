package Data;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class finalesMundial {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chromedriver.driver", "C:\\Users\\fsaru\\Documents\\chromedriver.exe");
		WebDriver driver =  new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://es.wikipedia.org/wiki/Anexo:Finales_de_la_Copa_Mundial_de_F%C3%BAtbol");
		
		List<WebElement> resultColList = driver.findElements(By.cssSelector("tr")); 
		//esta seria la lista de todos los resultados de los mundiales
		//yo quiero los valores, asiq ue los voy a tomar
		List<String> newResults = new ArrayList<String>();
		for(int i=0; i<resultColList.size();i++) {
			if(resultColList.get(i).getText().contains("pen.")) {
				String paisG = resultColList.get(i).findElement(By.cssSelector("td:nth-child(2)")).getText();
				String resultado = resultColList.get(i).findElement(By.cssSelector("th")).getText();
				String paisP = resultColList.get(i).findElement(By.cssSelector("td:nth-child(4)")).getText();

				//System.out.println(resultado);
				
				newResults.add(paisG);
				newResults.add(resultado);
				newResults.add(paisP);
		}}
		
			
		System.out.println(newResults);
		
		
		
		File file = new File("C:\\Users\\fsaru\\Documents\\udemy\\futbolProyect\\datosFutbolMundiales.xls");
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sh = wb.createSheet("First Sheet");
		
		sh.createRow(0).createCell(0).setCellValue("Campeon");
		sh.getRow(0).createCell(1).setCellValue("Subcampeon");
		sh.getRow(0).createCell(2).setCellValue("Resultado");

		sh.createRow(1).createCell(0).setCellValue(newResults.get(0));
		sh.getRow(1).createCell(1).setCellValue(newResults.get(2));
		sh.getRow(1).createCell(2).setCellValue(newResults.get(1));

		sh.createRow(2).createCell(0).setCellValue(newResults.get(3));
		sh.getRow(2).createCell(1).setCellValue(newResults.get(5));
		sh.getRow(2).createCell(2).setCellValue(newResults.get(4));
		try {
			FileOutputStream fos = new FileOutputStream(file);
			wb.write(fos);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		

		
		

	}

}
