package project.mc.blog.portfolio.service;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.sist.file.domain.FileVO;

import project.mc.blog.portfolio.dao.PortfolioDao;
import project.mc.blog.portfolio.domain.PortfolioVO;
import project.mc.blog.resume.domain.ResumeVO;
import project.mc.blog.user.dao.UserDao;
import project.mc.commons.DTO;
import project.mc.commons.StringUtil;

@Service
public class PortFolioSvcImpl implements PortfolioSvc {
private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired 
	private PortfolioDao pfDao;
	
//	@Autowired
//	private Validator validator;

	/**
	 * 저장
	 * @param mreq
	 * @return int (1:성공,1이 아니면 실패)
	 * @throws IOException 
	 */
	@Override
	public int do_save(MultipartHttpServletRequest mReq) throws DataAccessException, IOException {
		log.debug("======PortfolioDaoImpl: do_save=start================");
		PortfolioVO inVO = new PortfolioVO();
		
		String user_id = mReq.getParameter("user_id").toString();
		inVO.setUser_id(user_id);
		int tmp_no = Integer.parseInt(mReq.getParameter("tmp_no").toString());
		inVO.setTmp_no(tmp_no);
		
		int flag = pfDao.do_save(inVO);
		
		this.do_saveMulti(mReq);
		
		
		
		
		log.debug("======PortfolioDaoImpl: do_save=end================");
		
		return flag;
	}
	
	/**
	 * 파일 멀티 upload;
	 */
	@Override
	public List<DTO> do_saveMulti(
			MultipartHttpServletRequest mReq) 
	   throws IOException, DataAccessException {
		
		String uploadPath = "c:\\file\\";
		String workDiv    = mReq.getParameter("workDiv");
		
		
		File fileDir=new File(uploadPath);
		if(fileDir.isDirectory()==false) {
			fileDir.mkdirs();
		}
		
		Iterator<String> iter =mReq.getFileNames();
		List<DTO> list =new ArrayList<DTO>();
		int fileNo = 1;
		while(iter.hasNext()) {
			FileVO fileVO=new FileVO();
			String uploadFileName = iter.next();
			String orgFileName = "";//원본파일명
			String saveFileName= "";//저장파일명
			String ext         = "";//확장자
			long   fileSize    = 0 ;//파일사이즈
			
			log.debug("1==================");
			log.debug("uploadFileName:"+uploadFileName);
			log.debug("1==================");
			
			MultipartFile mFile=mReq.getFile(uploadFileName);
			orgFileName = mFile.getOriginalFilename();
			ext = orgFileName.substring(orgFileName.lastIndexOf("."));
			fileSize = mFile.getSize();
			
			saveFileName = StringUtil.currDate("yyyy-MM-dd")+"_"+StringUtil.getUUid()+ext;
			
			log.debug("2==================");
			log.debug("saveFileName:"+saveFileName);
			log.debug("2==================");
			
			
			log.debug("3==================");
			log.debug("orgFileName:"+orgFileName);
			log.debug("3==================");	
			
			log.debug("4==================");
			log.debug("fileSize:"+fileSize);
			log.debug("4==================");	
			  
			if(null != orgFileName && !orgFileName.equals(""))
			{
				try {
					fileVO.setFile_size(fileSize+"");
					fileVO.setNo(fileNo);
					fileVO.setOrg_file_nm(orgFileName);
					fileVO.setSave_file_nm(saveFileName);
					//TO-DO:세션에서 기자고 올것
					//fileVO.setReg_id(reg_id);//session
					//fileVO.setMod_id(mod_id);//session
					fileVO.setWork_div(workDiv);
					  
					list.add(fileVO);
					
					mFile.transferTo(new File(uploadPath+saveFileName));
					
					

					
				}catch(IllegalStateException ie) {
					throw ie;
				}
			}
			
			fileNo++;
		}
		
		
		return list;
	}

	

	/**
	 * 삭제
	 * @param dto
	 * @return int (1:성공,1이 아니면 실패)
	 */
	@Override
	public int do_delete(DTO dto) {
		log.debug("======PortfolioDaoImpl: do_delete=================");
		log.debug(dto.toString());
		log.debug("======PortfolioDaoImpl: do_delete=================");
		return pfDao.do_delete(dto);		
	}
	
	/**
	 * 전체 삭제
	 * @param dto
	 * @return int (1:성공,1이 아니면 실패)
	 */
	@Override
	public int do_deleteAll(DTO dto) {
		log.debug("======PortfolioDaoImpl: do_deleteAll=================");
		log.debug(dto.toString());
		log.debug("======PortfolioDaoImpl: do_deleteAll=================");
		return pfDao.do_deleteAll(dto);		
	}
	
	/**
	 * 수정
	 * @param dto
	 * @return int (1:성공,1이 아니면 실패)
	 */
	@Override
	public int do_update(DTO dto) {
		log.debug("======PortfolioDaoImpl: do_update=================");
		log.debug(dto.toString());
		log.debug("======PortfolioDaoImpl: do_update=================");	
		return pfDao.do_update(dto);		
	}
	
	/**
	 * 전체조회
	 * @param dto
	 * @return  List<PortfolioVO>
	 */
	@Override
	public List<?> do_search(DTO dto){
		log.debug("======PortfolioDaoImpl: do_search=================");
		log.debug(dto.toString());
		log.debug("======PortfolioDaoImpl: do_search=================");	
		return pfDao.do_search(dto);
	}
	
	/**
	 * pf_id에 의한 단건조회
	 * @param dto(pf_id=?)
	 * @return PortfolioVO
	 */
	@Override
	public DTO do_searchByPf_id(DTO dto) {
		log.debug("======PortfolioDaoImpl: do_searchByPf_id=================");
		log.debug(dto.toString());
		log.debug("======PortfolioDaoImpl: do_searchByPf_id=================");	
		return pfDao.do_searchByPf_id(dto);
	}
	
	/**
	 * user_no에 의한 list 조회
	 * @param dto(pf_id=?)
	 * @return PortfolioVO
	 */
	@Override
	public List<?> do_searchByUser_id(DTO dto) {
		log.debug("======PortfolioDaoImpl: do_searchByUser_id=================");
		log.debug(dto.toString());
		log.debug("======PortfolioDaoImpl: do_searchByUser_id=================");	
		return pfDao.do_searchByUser_id(dto);
	}
	
	
	
	
	
	
}
