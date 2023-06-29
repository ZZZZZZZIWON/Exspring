package com.exam.myapp.bbs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.myapp.member.MemberDao;
import com.exam.myapp.member.MemberService;

@Service
public class BbsServiceImpl implements BbsService {

	@Autowired
	private BbsDao bbsDao;
	
	@Override
	public List<BbsVo> selectBbsList() {
		return bbsDao.selectBbsList();
	}

	@Override
	public int insertBbs(BbsVo vo) {
		return bbsDao.insertBbs(vo);
	}

	@Override
	public int deleteBbs(int bbsNo) {
		return bbsDao.deleteBbs(bbsNo);
	}

	@Override
	public BbsVo selectBbs(int memId) {
		return bbsDao.selectBbs(memId);
		
	}

	@Override
	public int updateBbs(BbsVo vo) {
		return bbsDao.updateBbs(vo);
	}


}
