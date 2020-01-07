package com.gi.builmanager.service.impl;

import com.gi.builmanager.dominio.GastoComun;
import com.gi.builmanager.repositorio.GastoComunRepository;
import com.gi.builmanager.service.GastoComunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GastoComunServiceImpl implements GastoComunService {
    @Autowired
    private GastoComunRepository gastoComunRepository;
    @Override
    public List<GastoComun> getGastoComun() {
        return gastoComunRepository.findAll();
    }


}
