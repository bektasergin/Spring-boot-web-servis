package tr.edu.medipol.yova.springbootwebservicedemo;

import java.util.*;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ogrenci")
public class OgrenciWebServisi {
	
	public record Ogrenci(String name, String numara) {}
	
	private static List<Ogrenci> OGRENCILER = new ArrayList<>();
	static {
		OGRENCILER.add(new Ogrenci("Ali", "1"));
		OGRENCILER.add(new Ogrenci("Esma", "2"));
	}
	
	@GetMapping("/")
	public List<Ogrenci> listele(){
		return OGRENCILER;
	}
	
	@PostMapping("/")
	public void ekle(Ogrenci yeniOgrenci) {
		OGRENCILER.add(yeniOgrenci);
	}
	
	@DeleteMapping("/")
	public boolean sil(@RequestParam String numara) {
		for(Ogrenci ogrenci: OGRENCILER) {
			//Ogrenciyi sil
			if (ogrenci.numara.equals(numara)) {
				OGRENCILER.remove(ogrenci);
				return true;
			}
		}
		//Ogrenci bulunamadı
		return false;
	}
	

}
