package com.plurasight.sneakerdrops;

import com.plurasight.sneakerdrops.data.BrandRepository;
import com.plurasight.sneakerdrops.models.Brand;
import com.plurasight.sneakerdrops.service.DropService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StartupRunner implements CommandLineRunner {

    private final BrandRepository brandRepository;

    @Autowired
    public StartupRunner(BrandRepository brandRepository){
        this.brandRepository = brandRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        seedData();
        for(Brand b : brandRepository.findAll()){
            System.out.println(b.getId() + " - " + b.getName());
        }


    }

    private void seedData(){
        if(brandRepository.count() == 0){
            brandRepository.save(new Brand("Nike"));
            brandRepository.save(new Brand("Adidas"));
            brandRepository.save(new Brand("New Balance"));

        }
    }
}
