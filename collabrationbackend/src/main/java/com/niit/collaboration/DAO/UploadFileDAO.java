package com.niit.collaboration.DAO;

import com.niit.collaboration.model.UploadFile;

public interface UploadFileDAO {

	void save(UploadFile uploadFile);

	UploadFile getFile(int username);
}
