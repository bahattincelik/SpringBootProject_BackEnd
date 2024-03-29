package controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import model.Kisi;
import service.KisiService;

@RestController
public class KisiController {
	
	
	public KisiService kisiService;
	
	@Autowired
	public KisiController(KisiService kisiService) {
		this.kisiService=kisiService;
	}
	
	@GetMapping(path="/kisiler")
	public List<Kisi> kisileriGetir() {
		
		return kisiService.tumkisilerGetir();
	}
	
	@PostMapping(path = "/kisiler/ekle")
	public Kisi yeniKisiEkle(@RequestBody Kisi kisi) {
		return kisiService.kisiEkle(kisi);
	}
	
	@GetMapping(path="/kisiler/{id}")
	public Optional<Kisi> idIleKisiListele(@PathVariable ("id") Integer id) {
		
		return kisiService.idIleKisiGetir(id);
	}
	
	@DeleteMapping(path = "/kisiler/sil/{id}")
	public String idIleKisiSil(@PathVariable Integer id) {
		return kisiService.idIleKisiSil(id);
	}
	
	@PutMapping(path = "/kisiler/guncelle")
	public Kisi idIleGuncelle(@RequestBody Kisi yeniKisi) {
		
		return kisiService.idIleKisiGuncelle(yeniKisi);
	}
	
	
	@PatchMapping(path = "/kisiler/yenile/{id}")
	public Kisi idIleKismiGuncelle(@PathVariable Integer id, @Validated @RequestBody Kisi yeniKisi) {
		
		return kisiService.idIleKismiGuncelle(id,yeniKisi);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
