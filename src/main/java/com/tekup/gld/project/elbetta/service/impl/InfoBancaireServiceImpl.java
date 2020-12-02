package com.tekup.gld.project.elbetta.service.impl;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tekup.gld.project.elbetta.model.InfoBancaire;
import com.tekup.gld.project.elbetta.model.User;
import com.tekup.gld.project.elbetta.repository.InfoBancaireRepository;
import com.tekup.gld.project.elbetta.repository.UserRepository;
@Service
public class InfoBancaireServiceImpl implements InfoBancaireService {
	
	private InfoBancaireRepository repoInfo;
	
	@Autowired
	public InfoBancaireServiceImpl(InfoBancaireRepository repoInfo) {
		super();
		this.repoInfo = repoInfo;
	
	}


	public InfoBancaireRepository getRepoInfo() {
		return repoInfo;
	}

	public void setRepoInfo(InfoBancaireRepository repoInfo) {
		this.repoInfo = repoInfo;
	}

	@Override
	public InfoBancaire addInfo() {
		return (InfoBancaire) repoInfo.findAll();
	}

	@Override
	public InfoBancaire modifInfo(InfoBancaire newInfo) {
		// TODO Auto-generated method stub
		return repoInfo.save(newInfo);
		
	}

	@Override
	public InfoBancaire getInfoById(Long id) {
			Optional<InfoBancaire>opt=repoInfo.findById(id);
			InfoBancaire infobancaire;
			if(opt.isPresent())
				infobancaire=opt.get();
			else 
				throw new NoSuchElementException("Info with this id is not found");
			return infobancaire;
	}

	@Override
	public InfoBancaire deleteInfo(Long id) {
		InfoBancaire entity = this.getInfoById(id);
		repoInfo.deleteById(id);
		return entity;
	}
	}


