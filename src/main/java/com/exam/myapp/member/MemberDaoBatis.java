package com.exam.myapp.member;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDaoBatis implements MemberDao { 
	
	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	
	@Override
	public List<MemberVo> selectMemberList() {
		List<MemberVo> list = null;
		try (SqlSession session = sqlSessionFactory.openSession()) { 

			list = session.selectList("com.exam.member.MemberDao.selectMemberList");
		}
		return list;
	}

	@Override
	public int insertMember(MemberVo vo) {
		int num = 0;
		try (SqlSession session = sqlSessionFactory.openSession()) { 

			num = session.insert("com.exam.member.MemberDao.insertMember", vo);
			session.commit(); 
			
		}
		return num;
	}

	@Override
	public int deleteMember(String memId) {
		int num = 0;
		try (SqlSession session = sqlSessionFactory.openSession()) { 

			num = session.delete("com.exam.member.MemberDao.deleteMember", memId);
		
			session.commit();
			
		}
		return num;
	}

	@Override
	public MemberVo selectMember(String memId) {
		MemberVo vo = null; 
		try (SqlSession session = sqlSessionFactory.openSession()) {
			
			vo = session.selectOne("com.exam.member.MemberDao.selectMember", memId);
		}
		return vo;
	}

	@Override
	public int updateMember(MemberVo vo) {
		int num = 0;
		try (SqlSession session = sqlSessionFactory.openSession()) { // getConnection이랑 비슷한 역할
			
			num = session.update("com.exam.member.MemberDao.updateMember", vo);
			
			session.commit(); 
			
		}
		return num;
	
	}

	@Override
	public MemberVo selectLogin(MemberVo mvo) {
		MemberVo vo = null; 
		try (SqlSession session = sqlSessionFactory.openSession()) { 
			
			vo = session.selectOne("com.exam.member.MemberDao.selectLogin", mvo);
		}
		return vo;
	}
}
