package service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import model.Kisi;
import repository.KisiRepository;

@Service
public class KisiService {

	public static KisiRepository kisiRepository;
	
	//Dependecy Injection
	
	@Autowired
	public KisiService(KisiRepository kisiRepository) {
		this.kisiRepository=kisiRepository;
	}
	
	public List<Kisi> tumkisilerGetir(){
		return kisiRepository.findAll();
	}
	
	//Veritabanina ksii ekleyen servis
	public Kisi kisiEkle(Kisi kisi) {
		return kisiRepository.save(kisi);
	}
	
	//Id ile kisi getiren servis metodu
	
	public Optional<Kisi> idIleKisiGetir(Integer id) {
		return kisiRepository.findById(id);
	}
	
	
	public String idIleKisiSil(Integer id) {
		
		if(kisiRepository.findById(id)==null){
		throw new IllegalStateException(id+" li kisi bulunamamistir");	
		}
		
		kisiRepository.deleteById(id);
		return id+" li kisi silindi";
	}
	
	//PUT
	
	public Kisi idIleKisiGuncelle(Kisi guncelKisi  ) {
		
		Kisi eskiKisi=kisiRepository.findById(guncelKisi.getId()).
				orElseThrow(()-> new IllegalStateException(guncelKisi.getId()+" li kisi bulunamamistir."));
		
	
		return kisiRepository.save(guncelKisi);
	}
	
	//PATCH
	
	public Kisi idIleKismiGuncelle(Integer id, @RequestBody Kisi yeniKisi) {
		Kisi eskiKisi=kisiRepository.findById(id).
				orElseThrow(()-> new IllegalStateException(id+" li kisi bulunamadi"));
		
		
		if (yeniKisi.getAd()!=null) {
			eskiKisi.setAd(yeniKisi.getAd());
		}
		if (yeniKisi.getSoyad()!=null) {
			eskiKisi.setSoyad(yeniKisi.getSoyad());
		}
		if (yeniKisi.getYas()!=0) {
			eskiKisi.setYas(yeniKisi.getYas());
			
		}
		
		return kisiRepository.save(eskiKisi);
		
		
		
	}
	
	
	
	
	
	
}
