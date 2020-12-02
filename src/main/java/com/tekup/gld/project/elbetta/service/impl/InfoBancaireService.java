package com.tekup.gld.project.elbetta.service.impl;

import java.lang.ProcessHandle.Info;

import com.tekup.gld.project.elbetta.model.InfoBancaire;

public interface InfoBancaireService {
	InfoBancaire getInfoById(Long id);
	InfoBancaire addInfo();
	InfoBancaire deleteInfo(Long id);
	InfoBancaire modifInfo(InfoBancaire newInfo);

}
