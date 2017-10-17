package project.mc.blog.portfolio.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;


import project.mc.blog.portfolio.dao.PortfolioDao;
import project.mc.blog.portfolio.domain.PortfolioVO;
import project.mc.blog.resume.dao.ResumeDao;
import project.mc.blog.resume.domain.ResumeVO;
import project.mc.commons.DTO;
import project.mc.commons.StringUtil;

@Service
public class PortFolioSvcImpl implements PortfolioSvc {
private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired 
	private PortfolioDao pfDao;
	@Autowired
	private ResumeDao rsDao;
	
//	@Autowired
//	private Validator validator;

	/**
	 * 저장
	 * @param mreq
	 * @return int (1:성공,1이 아니면 실패)
	 * @throws IOException 
	 */
	@Override
	public DTO do_save(MultipartHttpServletRequest mReq) throws DataAccessException, IOException {
		log.debug("======PortfolioSvcImpl: do_save=start================");
		PortfolioVO inVO = new PortfolioVO();
		
		String user_id = mReq.getParameter("user_id").toString();
		inVO.setUser_id(user_id);
		int tmp_no = Integer.parseInt(mReq.getParameter("tmp_no").toString());
		inVO.setTmp_no(tmp_no);
		
		PortfolioVO outVO = (PortfolioVO) pfDao.do_save(inVO);
		
		if(outVO.getFlag() == 1) {
			mReq.setAttribute("table_id", outVO.getPf_id());
		}
		
		this.do_upsertImages(mReq);
		
		log.debug("======PortfolioSvcImpl: do_save=end================");
		return outVO;
	}
	
	/**
	 * 파일 멀티 upload;
	 */
	@Override
	public List<DTO> do_upsertImages(MultipartHttpServletRequest mReq) throws IOException, DataAccessException {
		String root_path = mReq.getSession().getServletContext().getRealPath("/");  
		String attach_path = "resources\\uploadimages\\";
		String uploadPath = root_path+attach_path;
		String workDiv    = mReq.getParameter("workDiv");
		if(workDiv != null && workDiv.equals("do_save")) {
			log.debug("pf_multisave ongoing");
		}
		
		File fileDir=new File(uploadPath);
		if(fileDir.isDirectory()==false) {
			fileDir.mkdirs();
		}
		
		Iterator<String> iter =mReq.getFileNames();
		List<DTO> list =new ArrayList<DTO>();
		while(iter.hasNext()) {
			ResumeVO resumeVO=new ResumeVO();
			String uploadFileName = iter.next();
			String orgFileName = "";//원본파일명
			String saveFileName= "";//저장파일명
			String ext         = "";//확장자
			long   fileSize    = 0 ;//파일사이즈
			int fileNo = 0;
			
			
			//log.debug("uploadFileName:"+uploadFileName);
			
			String fileNoStr = uploadFileName.substring(uploadFileName.length()-2, uploadFileName.length());
			fileNo = Integer.parseInt(fileNoStr);
			MultipartFile mFile=mReq.getFile(uploadFileName);
			orgFileName = mFile.getOriginalFilename();
			if(orgFileName == null || orgFileName.equals("")) {
				String tmp_img = "tmp_img1_"+fileNoStr;
				String img_src = mReq.getParameter(tmp_img);
				log.debug("tmp_img: "+img_src);
				if(img_src == null || img_src.equals("")) {
					resumeVO.setTable_div(Integer.parseInt(mReq.getParameter("table_div").toString()));
					resumeVO.setTable_id(Integer.parseInt(mReq.getAttribute("table_id").toString()));
					resumeVO.setSeq(fileNo);
					List<ResumeVO> outList = (List<ResumeVO>) rsDao.do_search_img(resumeVO);
					
					if(outList.size() == 1) {
						ResumeVO outVO = outList.get(0);
						String fileStr = outVO.getFile_path()+outVO.getSave_file_name()+outVO.getFile_ext();
						log.debug("fileStr: "+fileStr);
						File deleteFile = new File(fileStr);
						if( deleteFile.exists() ){
				            if(deleteFile.delete()){
				            	log.debug("파일삭제 성공");
				            	int delFlag = rsDao.do_delete_img(resumeVO);
								log.debug("delFlag/fileNo: "+delFlag+"/"+fileNo);
				            }else{
				            	log.debug("파일삭제 실패");
				            }
				        }else{
				        	log.debug("파일이 존재하지 않습니다.");
				        }
					} else {
						log.debug("삭제 불필요");
					}
				}
				continue;
			}
				
			
			saveFileName = StringUtil.currDate("yyyy-MM-dd")+"_"+StringUtil.getUUid();
			ext = orgFileName.substring(orgFileName.lastIndexOf("."));
			fileSize = mFile.getSize();
			
			
			log.debug("pfsvcimpl debug==================");
			log.debug("uploadFileName:"+uploadFileName);
			log.debug("saveFileName:"+saveFileName);
			log.debug("orgFileName:"+orgFileName);
			log.debug("fileSize:"+fileSize);
			log.debug("fileNO: "+ fileNo);
			log.debug("pfsvcimpl debug==================");
			
			if(null != orgFileName && !orgFileName.equals(""))
			{
				try {
					resumeVO.setTable_div(Integer.parseInt(mReq.getParameter("table_div").toString()));
					resumeVO.setTable_id(Integer.parseInt(mReq.getAttribute("table_id").toString()));
					resumeVO.setSeq(fileNo);
					resumeVO.setFile_path(uploadPath);
					resumeVO.setFile_size(fileSize+"");
					resumeVO.setOrg_file_name(orgFileName);
					resumeVO.setSave_file_name(saveFileName);
					resumeVO.setFile_ext(ext);
					resumeVO.setReg_id(mReq.getParameter("user_id").toString());
					//파일 DB 저장
					int flag = rsDao.do_upsert(resumeVO);
					log.debug("seq/flag: "+fileNo+"/"+flag);
					resumeVO.setFlag(flag);
					
					list.add(resumeVO);
					
					//이미지 서버에 업로드
					mFile.transferTo(new File(uploadPath+saveFileName+ext));
					
				}catch(IllegalStateException ie) {
					log.debug("IllegalStateException");
					throw ie;
				}catch(Exception e) {
					e.getCause();
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
		log.debug("======PortfolioSvcImpl: do_delete=================");
		log.debug(dto.toString());
		PortfolioVO pfVO = (PortfolioVO)dto;
		ResumeVO rsVO = new ResumeVO();
		int flag = pfDao.do_delete(dto);
		log.debug("pfFlag:" + flag);
		
		rsVO.setTable_div(31);
		rsVO.setTable_id(pfVO.getPf_id());
		int rsFlag = 0;
		int delFlag = 0;
		
		List<ResumeVO> list = (List<ResumeVO>) rsDao.do_search_img(rsVO);
		for(ResumeVO outVO : list) {
			String fileStr = outVO.getFile_path()+outVO.getSave_file_name()+outVO.getFile_ext();
			log.debug("fileStr: "+fileStr);
			File deleteFile = new File(fileStr);
			if( deleteFile.exists() ){
	            if(deleteFile.delete()){
	            	log.debug("파일삭제 성공");
	            	delFlag++;
	            }else{
	            	log.debug("파일삭제 실패");
	            }
	        }else{
	        	log.debug("파일이 존재하지 않습니다.");
	        }

		}
		if(delFlag == list.size())
			rsFlag = rsDao.do_delete_img(rsVO);
		else {
			log.debug("이미지 삭제 실패!");
		}
		
		if(rsFlag != delFlag)
			flag = 0;
		
		log.debug("delFlag: "+ delFlag);
		log.debug("rsFlag:" + rsFlag);
		log.debug("======PortfolioSvcImpl: do_delete=================");
		return flag;
	}
	
	/**
	 * 전체 삭제
	 * @param dto
	 * @return int (1:성공,1이 아니면 실패)
	 */
	@Override
	public int do_deleteAll(DTO dto) {
		log.debug("======PortfolioSvcImpl: do_deleteAll=================");
		log.debug(dto.toString());
		log.debug("======PortfolioSvcImpl: do_deleteAll=================");
		return pfDao.do_deleteAll(dto);		
	}
	
	/**
	 * 수정
	 * @param dto
	 * @return int (1:성공,1이 아니면 실패)
	 */
	@Override
	public int do_update(MultipartHttpServletRequest mReq) throws DataAccessException, IOException {
		log.debug("======PortfolioSvcImpl: do_update=================");
		PortfolioVO inVO = new PortfolioVO();
		
		int pf_id = Integer.parseInt(mReq.getParameter("pf_id").toString());
		inVO.setPf_id(pf_id);
		mReq.setAttribute("table_id", pf_id);
		String user_id = mReq.getParameter("user_id").toString();
		inVO.setUser_id(user_id);
		int tmp_no = Integer.parseInt(mReq.getParameter("tmp_no").toString());
		inVO.setTmp_no(tmp_no);
		
		int flag = pfDao.do_update(inVO);
		
		this.do_upsertImages(mReq);
		
		log.debug("======PortfolioSvcImpl: do_update=================");	
		return flag;		
	}
	
	
	/**
	 * 전체조회
	 * @param dto
	 * @return  List<PortfolioVO>
	 */
	@Override
	public List<?> do_search(DTO dto){
		log.debug("======PortfolioSvcImpl: do_search=================");
		log.debug(dto.toString());
		log.debug("======PortfolioSvcImpl: do_search=================");	
		return pfDao.do_search(dto);
	}
	
	/**
	 * pf_id에 의한 단건조회
	 * @param dto(pf_id=?)
	 * @return PortfolioVO
	 */
	@SuppressWarnings("unchecked")
	@Override
	public DTO do_searchByPf_id(DTO dto) {
		log.debug("======PortfolioSvcImpl: do_searchByPf_id=================");
		log.debug(dto.toString());
		PortfolioVO inVO = (PortfolioVO)dto;
		int pf_id = inVO.getPf_id();
		
		//포트폴리오 가져오는 부분
		PortfolioVO pfVO = null;
		pfVO = (PortfolioVO) pfDao.do_searchByPf_id(dto);
		
		//이미지 리스트 가져오는 부분
		ResumeVO inRsVO = new ResumeVO();
		inRsVO.setTable_div(31);
		inRsVO.setTable_id(pf_id);
		
		List<ResumeVO> imgList = null;
		imgList = (List<ResumeVO>) rsDao.do_search_img(inRsVO);
		log.debug("imgList: "+imgList.toString());
		
		pfVO.setImgList(imgList);
		
		log.debug("======PortfolioSvcImpl: do_searchByPf_id=================");	
		return pfVO;
	}
	
	/**
	 * user_no에 의한 list 조회
	 * @param dto(pf_id=?)
	 * @return PortfolioVO
	 */
	@Override
	public List<?> do_searchByUser_id(DTO dto) {
		log.debug("======PortfolioSvcImpl: do_searchByUser_id=================");
		log.debug(dto.toString());
		log.debug("======PortfolioSvcImpl: do_searchByUser_id=================");	
		return pfDao.do_searchByUser_id(dto);
	}
	
	
	
	
	
	
}
