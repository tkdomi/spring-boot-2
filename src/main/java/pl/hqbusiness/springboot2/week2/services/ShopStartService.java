package pl.hqbusiness.springboot2.week2.services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("Start")
public class ShopStartService implements ShopService { }
