package com.exam.myapp.bbs;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AttachDao {

//	List<BbsVo> selectBbsList();

	int insertAttach(AttachVo vo);

	AttachVo selectAttach(int attNo);

//	int deleteBbs(int bbsNo);
//
//	BbsVo selectBbs(int memId);
//
//	int updateBbs(BbsVo vo);
}