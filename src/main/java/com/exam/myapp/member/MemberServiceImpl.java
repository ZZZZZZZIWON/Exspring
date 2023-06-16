package com.exam.myapp.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDao memberDao;
	
	@Override
	public List<MemberVo> selectMemberList() {
		return memberDao.selectMemberList();
	}

	@Override
	public int insertMember(MemberVo vo) {
		return memberDao.insertMember(vo);
	}

	@Override
	public int deleteMember(String memId) {
		return memberDao.deleteMember(memId);
	}

	@Override
	public MemberVo selectMember(String memId) {
		return memberDao.selectMember(memId);
		
	}

	@Override
	public int updateMember(MemberVo vo) {
		return memberDao.updateMember(vo);
	}

	@Override
	public MemberVo selectLogin(MemberVo vo) {
		return memberDao.selectLogin(vo);
	}

}
