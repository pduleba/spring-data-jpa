package com.pduleba.spring.data.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pduleba.jpa.model.OwnerModel;
import com.pduleba.spring.data.dao.OwnerDao;

@Service
public class OwnerServiceImpl implements OwnerService {

	@Autowired
	private OwnerDao ownerDao;

	@Override
	public void create(OwnerModel owner) {
		ownerDao.saveAndFlush(owner);
	}
	
	@Override
	public void createAll(List<OwnerModel> owners) {
		ownerDao.save(owners);
	}

	@Override
	public OwnerModel getById(long ownerId) {
		return ownerDao.getById(ownerId);
	}

	@Override
	public void update(OwnerModel owner) {
		ownerDao.saveAndFlush(owner);
	}

	@Override
	public void delete(OwnerModel owner) {
		ownerDao.delete(owner);
	}

	@Override
	public long count() {
		return ownerDao.count();
	}

	// ------------------------------------------------
	//					Query methods
	// ------------------------------------------------

	@Override
	public List<OwnerModel> getByFirstName(String firstName) {
		return ownerDao.getByFirstName(firstName);
	}
	
	@Override
	public List<OwnerModel> findByFirstNameLastNameAndAgeNameBased(String first, String lastLike, Integer ageNot) {
		return ownerDao.findByFirstNameLastNameAndAgeNameBased(first, lastLike, ageNot);
	}
	
	@Override
	public List<OwnerModel> findByFirstNameLastNameAndAgeOrderBased(String first, String lastLike, Integer ageNot) {
		return ownerDao.findByFirstNameLastNameAndAgeOrderBased(first, lastLike, ageNot);
	}
	
	@Override
	public List<OwnerModel> findByFirstNameLastNameAndAgeNativeSQL(String first, String lastLike, Integer ageNot) {
		return ownerDao.findByFirstNameLastNameAndAgeNativeSQL(first, lastLike, ageNot);
	}
	
	@Override
	public int updateLastNameByFirstName(String lastName, String firstName) {
		return ownerDao.updateLastNameByFirstName(lastName, firstName);
	}

	@Override
	public int updateLastNameByFirstNameNativeSQL(String lastName, String firstName) {
		return ownerDao.updateLastNameByFirstNameNativeSQL(lastName, firstName);
	}
}
