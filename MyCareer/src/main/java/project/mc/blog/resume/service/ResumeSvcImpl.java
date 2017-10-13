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
		String root_path = mReq.getSession().getServletContext().getRealPath("/");
		
		String attach_path = "resources\\resume\\";
		String uploadPath = root_path + attach_path;
		log.debug("씨발!!!"+uploadPath);
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
			ext = org_file_name.substring(org_file_name.lastIndexOf(".")+1);
			file_size = mFile.getSize();
			
			save_file_name = this.currDate("yyyy-MM-dd") + "_" +  getUUid() + "." +ext;
			
			if(org_file_name != null && !org_file_name.equals("")) {
					try {
//TO-DO 나중에 지울것
//						private int file_id; //파일id
//						private int table_div; //소속 테이블
//						private int table_id; //소속 id
//						private int seq; //파일 순서
//						private String file_path; //파일 저장 경로**
//						private	String file_size; //파일 사이즈**
//						private String org_file_name; //원본파일명**
//						private String save_file_name; //저장 파일명**
//						private String file_ext; //파일 확장자**
//						private String reg_id; //작성자 id**
//						private String reg_dt; //작성일자 (기본값은 SYSDATE)
					
						resumeVO.setFile_path(uploadPath);
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

	@Override
	public List<?> do_search(DTO dto) {
		log.debug("ResumeSvcImpl do_search입니다");
		log.debug("DTO의 값은 : " + dto.toString());
		log.debug("ResumeSvcImpl do_search입니다");
		return resumeDao.do_search(dto);
	}

	@Override
	public DTO do_searchOne(DTO dto) {
		log.debug("ResumeSvcImpl do_searchOne입니다");
		log.debug("DTO의 값은 : " + dto.toString());
		log.debug("ResumeSvcImpl do_searchOne입니다");
		return resumeDao.do_searchOne(dto);
	}

	@Override
	public int do_update(DTO dto) {
		log.debug("ResumeSvcImpl do_update입니다");
		log.debug("DTO의 값은 : " + dto.toString());
		log.debug("ResumeSvcImpl do_update입니다");
		return resumeDao.do_update(dto);
	}

	@Override
	public int do_delete(DTO dto) {
		log.debug("ResumeSvcImpl do_delete입니다");
		log.debug("DTO의 값은 : " + dto.toString());
		log.debug("ResumeSvcImpl do_delete입니다");
		return resumeDao.do_delete(dto);
	}

	@Override
	public int do_checkDelete(List<String> list) {
		log.debug("ResumeSvcImpl do_checkdelete입니다");
		log.debug("DTO의 값은 : " + list.toString());
		log.debug("ResumeSvcImpl do_checkdelete입니다");
		int flag = 0;
		for(String file_id : list) {
			ResumeVO resumeVO = new ResumeVO();
			resumeVO.setFile_id(Integer.parseInt(file_id));
			int one = resumeDao.do_delete(resumeVO);
			flag += one;
		}
		return flag;
	}
	
}
