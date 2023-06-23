package com.exam.myapp.member;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//@Repository
public class MemberDaoBatis implements MemberDao {

	@Autowired
	private SqlSession session;

	@Override
	public List<MemberVo> selectMemberList() {
		return session.selectList("com.exam.myapp.member.MemberDao.selectMemberList");
	}

	@Override
	public int insertMember(MemberVo vo) {
		return session.insert("com.exam.myapp.member.MemberDao.insertMember", vo);
	}

	@Override
	public int deleteMember(String memId) {
		return session.delete("com.exam.myapp.member.MemberDao.deleteMember", memId);

	}

	@Override
	public MemberVo selectMember(String memId) {
		return session.selectOne("com.exam.myapp.member.MemberDao.selectMember", memId);
	}

	@Override
	public int updateMember(MemberVo vo) {
		return session.update("com.exam.myapp.member.MemberDao.updateMember", vo);

	}

	@Override
	public MemberVo selectLogin(MemberVo mvo) {
		return session.selectOne("com.exam.myapp.member.MemberDao.selectLogin", mvo);
	}
}
