package project.mc.blog.resume.service;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import project.mc.blog.resume.dao.ResumeDao;
import project.mc.blog.resume.domain.ResumeVO;
import project.mc.commons.DTO;

/**
 * 
 * @author 홍준석
 * 작성일 : 2017년 9월 27일
 */
@Service
public class ResumeSvcImpl implements ResumeSvc {
		
	@Autowired
	ResumeDao resumeDao;
	
	private Logger log = LoggerFactory.getLogger(ResumeSvcImpl.class);

	@Override
	public List<DTO> do_saveMulti(MultipartHttpServletRequest mReq) throws IOException, DataAccessException {
		
		String uploadPath = "/MyCareer/src/main/webapp/resources/resume";
		
		File fileDir = new File(uploadPath);
		if(fileDir.isDirectory()==false) {
			fileDir.mkdirs();
		}
		
		Iterator<String> iter = mReq.getFileNames();
		List<DTO> list = new ArrayList<DTO>();
		//int fileNo = 1;
		while(iter.hasNext()) {
			ResumeVO resumeVO  = new ResumeVO();
			String uploadFileName = iter.next();
			String org_file_name = "";		//원본파일명
			String save_file_name = "";		//저장파일명
			String ext = "";				//파일의 확장자
			long file_size = 0; 			//파일 크키(사이즈)
			
			log.debug("ResumeSvcImpl 입니다.");
			log.debug("uploadFileName의 값은 : " + uploadFileName);
			log.debug("ResumeSvcImpl 입니다.");
			
			MultipartFile mFile = mReq.getFile(uploadFileName);
			org_file_name = mFile.getOriginalFilename();
			ext = org_file_name.substring(org_file_name.lastIndexOf("."));
			file_size = mFile.getSize();
			
			save_file_name = this.currDate("yyyy-MM-dd") + "_" +  org_file_name;
			
			if(org_file_name != null && !org_file_name.equals("")) {
					try {
						resumeVO.setFile_size(file_size+"");
						resumeVO.setOrg_file_name(org_file_name);
						resumeVO.setSave_file_name(save_file_name);
						resumeVO.setFile_ext(ext);
						//TO-DO: 세션에서 가져올 것
						//resumeVO.setReg_id(reg_id);
						//resumeVO.setReg_dt(reg_dt);
						//나중에 지우자
						resumeVO.setReg_id("joon");
						//나중에 지우자
						list.add(resumeVO);						
						resumeDao.do_save(resumeVO);
						mFile.transferTo(new File(uploadPath+save_file_name));
					}catch(IllegalStateException ie) {
						throw ie;
				}//end try/catch
			}//end if	
			//fileNo++;
		}//end while
		
		return list;
	}
	
	public String currDate(String type) {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat(type);
		return sdf.format(date);
	}
	
	public String getUUid() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}

	@Override
	public int do_save(DTO dto) throws DataAccessException {
		log.debug("ResumeSvcImpl do_save입니다");
		log.debug("DTO의 값은 : " + dto.toString());
		log.debug("ResumeSvcImpl do_save입니다");
		return resumeDao.do_save(dto);
	}
	
}
