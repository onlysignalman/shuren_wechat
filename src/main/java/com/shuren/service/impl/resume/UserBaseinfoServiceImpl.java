package com.shuren.service.impl.resume;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shuren.constants.wechat.WeChatConfigProperties;
import com.shuren.utils.wechat.StingUtils;
import com.shuren.utils.wechat.UrlRequestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shuren.bean.resume.BaseReturns;
import com.shuren.bean.resume.ErrorInfos;
import com.shuren.bean.resume.ListReturns;
import com.shuren.bean.resume.ModelReturns;
import com.shuren.mapper.resume.JobExperienceMapper;
import com.shuren.mapper.resume.LanguageCapacityMapper;
import com.shuren.mapper.resume.UserBaseinfoMapper;
import com.shuren.mapper.resume.UserExtendinfoMapper;
import com.shuren.pojo.resume.JobExperience;
import com.shuren.pojo.resume.LanguageCapacity;
import com.shuren.pojo.resume.UserBaseinfo;
import com.shuren.pojo.resume.UserExtendinfo;
import com.shuren.service.resume.MsgService;
import com.shuren.service.resume.UserBaseinfoService;
import com.shuren.utils.wechat.SecurityUtils;
import org.springframework.util.StringUtils;

/**
 * Created by 董帮辉 on 2017-5-18.
 */
@Service("userBaseinfoService")
public class UserBaseinfoServiceImpl implements UserBaseinfoService {

	private static final ObjectMapper MAPPER = new ObjectMapper();

	@Autowired
	private UserBaseinfoMapper userBaseinfoMapper;
	
	@Autowired
	private UserExtendinfoMapper userExtendinfoMapper;
	
	@Autowired
	private JobExperienceMapper jobExperienceMapper;
	
	@Autowired
	private LanguageCapacityMapper languageCapacityMapper;

	@Autowired
	private WeChatConfigProperties weChatConfigProperties;

	@Autowired
	private MsgService msgService;
	
	@Override
	public BaseReturns register(UserBaseinfo userBaseinfo, String msg, String code) throws IOException {
		// TODO Auto-generated method stub
		BaseReturns returns = new BaseReturns();
		//1.短信校验
		/*ModelReturns<Map<String, Object>> msg = msgService.getLastMsg(userBaseinfo.getMobile());
		if(msg.getModel().get("msg") == null){
			returns.setError(ErrorInfos.YANZHENGMACUOWU.getError());
			returns.setStatus(ErrorInfos.YANZHENGMACUOWU.getStatus());
			return returns;
		}*/
		//2.判断是否已经注册
		Map<String, Object> params = new HashMap<>();
		params.put("mobile", userBaseinfo.getMobile());
		if(userBaseinfoMapper.queryCount(params) != null &&
				userBaseinfoMapper.queryCount(params) > 0){
			returns.setError(ErrorInfos.GAISHOUJIHAOYIZHUCHE.getError());
			returns.setStatus(ErrorInfos.GAISHOUJIHAOYIZHUCHE.getStatus());
			return returns;
		}
		//判断code是否为空
		String openId = null;
		if(!StringUtils.isEmpty(code)){
			//调用微信接口查询用户
			String pageAccessTokenUrl = weChatConfigProperties.getPageAccessTokenUrl();
			String result = UrlRequestUtils.sendGet(pageAccessTokenUrl.replace("APPID", weChatConfigProperties.getAppId()).
					replace("SECRET", weChatConfigProperties.getAppSecret()).replace("CODE", code));
			if(StringUtils.isEmpty(result)){
				Map<String, String> map = MAPPER.readValue(result, Map.class);
				if (StringUtils.isEmpty(map.get("access_token"))){
					openId = map.get("openid");
				}
			}

		}
		userBaseinfo.setPassword(SecurityUtils.MD5(userBaseinfo.getPassword()));
		userBaseinfo.setOpenId(openId);
		userBaseinfoMapper.register(userBaseinfo);
		return returns;
	}

	@Override
	public ModelReturns<UserBaseinfo> login(UserBaseinfo userBaseinfo) {
		// TODO Auto-generated method stub
		ModelReturns<UserBaseinfo> returns = new ModelReturns<UserBaseinfo>();
		userBaseinfo.setPassword(SecurityUtils.MD5(userBaseinfo.getPassword()));
		Map<String, Object> params = new HashMap<>();
		params.put("mobile", userBaseinfo.getMobile());
		params.put("password", userBaseinfo.getPassword());
		//登录失败
		if(userBaseinfoMapper.queryCount(params) == null ||
				userBaseinfoMapper.queryCount(params) <= 0){
			returns.setError(ErrorInfos.SHOUJIHAOHUOMIMACUOWU.getError());
			returns.setStatus(ErrorInfos.SHOUJIHAOHUOMIMACUOWU.getStatus());
			return returns;
		}
		//登录成功
		userBaseinfo = userBaseinfoMapper.login(userBaseinfo);
		//计算分数
		int score = 0;
		score = calcScore(userBaseinfo.getUserId());
		userBaseinfo.setScore(score);
		returns.setModel(userBaseinfo);
		return returns;
	}

	private int calcScore(Integer userId) {
		// TODO Auto-generated method stub
		int score = 0;
		Map<String, String> map = new HashMap<>();
		map.put("userId", userId.toString());
		//1.用户扩展信息计算 TOTAL：80
		UserExtendinfo userExtendinfo = userExtendinfoMapper.getOne(map);
		//2.用户语言能力信息 TOTAL：10
		List<JobExperience> jobs = jobExperienceMapper.getJobs(map);
		//3.用户工作经历信息 TOTAL：10
		List<LanguageCapacity> languages = languageCapacityMapper.getLanguages(map);
		if(userExtendinfo != null){
			score += userExtendinfo.getLogo() == null? 0 : 2;
			score += userExtendinfo.getRealName() == null? 0 : 2;
			score += userExtendinfo.getSex() == null? 0 : 2;
			score += userExtendinfo.getBirthday() == null? 0 : 2;
			score += userExtendinfo.getTall() == null? 0 : 2;
			
			score += userExtendinfo.getWeight() == null? 0 : 2;
			score += userExtendinfo.getNation() == null? 0 : 2;
			score += userExtendinfo.getPolitics() == null? 0 : 2;
			score += userExtendinfo.getMarry() == null? 0 : 2;
			score += userExtendinfo.getContactPhone() == null? 0 : 2;
			
			score += userExtendinfo.getContactEmail() == null? 0 : 2;
			score += userExtendinfo.getIdCard() == null? 0 : 2;
			score += userExtendinfo.getResidence() == null? 0 : 2;
			score += userExtendinfo.getLocation() == null? 0 : 2;
			score += userExtendinfo.getNowStatus() == null? 0 : 2;
			
			score += userExtendinfo.getWishType() == null? 0 : 2;
			score += userExtendinfo.getWishBusiness() == null? 0 : 2;
			score += userExtendinfo.getWishJob() == null? 0 : 2;
			score += userExtendinfo.getWishLocation() == null? 0 : 2;
			score += userExtendinfo.getWishSalary() == null? 0 : 2;

			score += userExtendinfo.getCollegeName() == null? 0 : 2;
			score += userExtendinfo.getSpecialities() == null? 0 : 2;
			score += userExtendinfo.getGraduationTime() == null? 0 : 2;
			score += userExtendinfo.getCollegeType() == null? 0 : 2;
			score += userExtendinfo.getDiplomas() == null? 0 : 2;
			
			score += userExtendinfo.getDegree() == null? 0 : 2;
			score += userExtendinfo.getClassDuty() == null? 0 : 2;
			score += userExtendinfo.getStudentDuty() == null? 0 : 2;
			score += userExtendinfo.getScholarship() == null? 0 : 2;
			score += userExtendinfo.getScholarshipRange() == null? 0 : 2;
			
			score += userExtendinfo.getAwards() == null? 0 : 2;
			score += userExtendinfo.getAwardsRange() == null? 0 : 2;
			score += userExtendinfo.getAwardsDes() == null? 0 : 2;
			score += userExtendinfo.getInternProject() == null? 0 : 2;
			score += userExtendinfo.getInternTime() == null? 0 : 2;
			
			score += userExtendinfo.getInternDuty() == null? 0 : 2;
			score += userExtendinfo.getInternDesc() == null? 0 : 2;
			score += userExtendinfo.getHobby() == null? 0 : 2;
			score += userExtendinfo.getHonor() == null? 0 : 2;
			score += userExtendinfo.getAssessment() == null? 0 : 2;
		}
		if(jobs != null && jobs.size() > 0){
			if(jobs.size() > 1){
				score += 10;
			}else{
				JobExperience job = jobs.get(0);
				if(job != null){
					score += job.getCompanyName() == null? 0 : 1;
					score += job.getCompanyType() == null? 0 : 1;
					score += job.getCompanyScale() == null? 0 : 1;
					score += job.getBusinessType() == null? 0 : 1;
					score += job.getJobName() == null? 0 : 1;
					
					score += job.getJobTime() == null? 0 : 1;
					score += job.getSalary() == null? 0 : 2;
					score += job.getJobContent() == null? 0 : 2;
				}
			}
		}
		if(languages != null && languages.size() > 0){
			if(languages.size() > 1){
				score += 10;
			}else{
				LanguageCapacity language = languages.get(0);
				if(language != null){
					score += language.getLanguage() == null? 0 : 4;
					score += language.getReadAndWrite() == null? 0 : 3;
					score += language.getListenAndSpeak() == null? 0 : 3;
				}
			}
		}
		map.put("score", String.valueOf(score));
		userBaseinfoMapper.update(map);
		return score;
	}

	@Override
	public ListReturns<Map<String, Object>> queryList(Map<String, Object> params) {
		// TODO Auto-generated method stub
		ListReturns<Map<String, Object>> returns = new ListReturns<>();
		Long count = userBaseinfoMapper.queryCount(params);
		List<Map<String, Object>> list = userBaseinfoMapper.queryList(params);
		returns.setCount(count);
		returns.setList(list);
		return returns;
	}

	@Override
	public BaseReturns forget(UserBaseinfo userBaseinfo, String validate) {
		// TODO Auto-generated method stub
		BaseReturns returns = new BaseReturns();
		//1.从日志库查该手机号最后一条短信验证码信息
		/*ModelReturns<Map<String, Object>> msg = msgService.getLastMsg(userBaseinfo.getMobile());
		if(msg.getModel().get("msg") == null){
			returns.setError(ErrorInfos.YANZHENGMACUOWU.getError());
			returns.setStatus(ErrorInfos.YANZHENGMACUOWU.getStatus());
			return returns;
		}
		//2.判断日志库最后一条验证码是否正确
		if(!validate.equals(msg.getModel().get("msg"))){
			returns.setError(ErrorInfos.YANZHENGMACUOWU.getError());
			returns.setStatus(ErrorInfos.YANZHENGMACUOWU.getStatus());
			return returns;
		}
		//3.判断验证码是否已经超时失效
		if(System.currentTimeMillis() > (Long.valueOf(msg.getModel().get("createTimeStamp").toString()) + 1000*60*60)){
			returns.setError(ErrorInfos.YANZHENGMACUOWU.getError());
			returns.setStatus(ErrorInfos.YANZHENGMACUOWU.getStatus());
			return returns;
		}*/
		userBaseinfo.setPassword(SecurityUtils.MD5(userBaseinfo.getPassword()));
		userBaseinfoMapper.forget(userBaseinfo);
		return returns;
	}

	@Override
	public ModelReturns<String> getScore(Integer userId) {
		// TODO Auto-generated method stub
		ModelReturns<String> returns = new ModelReturns<>();
		int calcScore = calcScore(userId);
		returns.setModel(String.valueOf(calcScore));
		return returns;
	}
}
