package com.exam.myapp.bbs;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
@Transactional
public class BbsServiceImpl implements BbsService {

	@Autowired
	private BbsDao bbsDao;

	@Autowired
	private AttachDao attachDao;
	
	// 게시판 첨부파일 저장 위치
	private String uploadPath = "C:/Temp/upload";

	// uploadPath directory가 없으면 생성
	public BbsServiceImpl() {
		new File(uploadPath).mkdirs();
	}
	
	@Override
	public List<BbsVo> selectBbsList() {
		return bbsDao.selectBbsList();
	}

//	@Transactional
	@Override
	public int insertBbs(BbsVo vo) {
		int num = bbsDao.insertBbs(vo);

		
		List<MultipartFile> bbsFileList = vo.getBbsFile();
		
		for (MultipartFile f : bbsFileList) {
			if(f.getSize()<=0) continue; 
			System.out.println("파일명: " + f.getOriginalFilename());
			System.out.println("파일크기: " + f.getSize());

			
			// 중복될 확률이 극도로 낮은 랜덤 문자열 생성
			String fname = UUID.randomUUID().toString();

			File savefile = new File(uploadPath, fname);
			
			try {
				f.transferTo(savefile);
				
				AttachVo attVo = new AttachVo();
				attVo.setAttOrgName(f.getOriginalFilename());
				attVo.setAttNewName(fname);
				attVo.setAttBbsNo(vo.getBbsNo());
				attachDao.insertAttach(attVo);
				
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
				
				throw new RuntimeException(e); // 첨부파일 저장 중 오류 발생시 트랜잭션이 롤백되도록 설정 
			}
		}
		return num;
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

	@Override
	public AttachVo selectAttach(int attNo) {
		return attachDao.selectAttach(attNo);
	}

	@Override
	public File getAttachFile(AttachVo vo) {
		return new File(uploadPath, vo.getAttNewName());
	}
	
}



