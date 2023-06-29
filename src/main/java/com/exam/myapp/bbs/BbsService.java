package com.exam.myapp.bbs;

import java.util.List;

public interface BbsService {

	List<BbsVo> selectBbsList();

	int insertBbs(BbsVo vo);

	int deleteBbs(int bbsNo);

	BbsVo selectBbs(int bbsNo);

	int updateBbs(BbsVo vo);

}