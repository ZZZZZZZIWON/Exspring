package com.exam.myapp.bbs;

import java.io.File;
import java.util.List;

public interface BbsService {

	List<BbsVo> selectBbsList();

	int insertBbs(BbsVo vo);

	int deleteBbs(int bbsNo);

	BbsVo selectBbs(int bbsNo);

	int updateBbs(BbsVo vo);

	AttachVo selectAttach(int attNo);

	File getAttachFile(AttachVo vo);

}