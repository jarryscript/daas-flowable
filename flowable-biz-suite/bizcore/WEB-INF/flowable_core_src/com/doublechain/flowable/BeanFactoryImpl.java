
package com.doublechain.flowable;
import java.util.Map;

import com.doublechain.flowable.platform.Platform;
import com.doublechain.flowable.user.User;
import com.doublechain.flowable.role.Role;
import com.doublechain.flowable.leaverecord.LeaveRecord;
import com.doublechain.flowable.leaverecordtype.LeaveRecordType;
import com.doublechain.flowable.holydaysetting.HolydaySetting;
import com.doublechain.flowable.province.Province;
import com.doublechain.flowable.city.City;
import com.doublechain.flowable.district.District;
import com.doublechain.flowable.userdomain.UserDomain;
import com.doublechain.flowable.userwhitelist.UserWhiteList;
import com.doublechain.flowable.secuser.SecUser;
import com.doublechain.flowable.userapp.UserApp;
import com.doublechain.flowable.quicklink.QuickLink;
import com.doublechain.flowable.listaccess.ListAccess;
import com.doublechain.flowable.objectaccess.ObjectAccess;
import com.doublechain.flowable.loginhistory.LoginHistory;
import com.doublechain.flowable.genericform.GenericForm;
import com.doublechain.flowable.formmessage.FormMessage;
import com.doublechain.flowable.formfieldmessage.FormFieldMessage;
import com.doublechain.flowable.formfield.FormField;
import com.doublechain.flowable.formaction.FormAction;
import com.doublechain.flowable.candidatecontainer.CandidateContainer;
import com.doublechain.flowable.candidateelement.CandidateElement;
import com.doublechain.flowable.wechatworkappidentify.WechatWorkappIdentify;
import com.doublechain.flowable.wechatminiappidentify.WechatMiniappIdentify;

public class BeanFactoryImpl{


	public Platform createPlatform(Map<String,Object> options){
		return new Platform();
	}


	public User createUser(Map<String,Object> options){
		return new User();
	}


	public Role createRole(Map<String,Object> options){
		return new Role();
	}


	public LeaveRecord createLeaveRecord(Map<String,Object> options){
		return new LeaveRecord();
	}


	public LeaveRecordType createLeaveRecordType(Map<String,Object> options){
		return new LeaveRecordType();
	}


	public HolydaySetting createHolydaySetting(Map<String,Object> options){
		return new HolydaySetting();
	}


	public Province createProvince(Map<String,Object> options){
		return new Province();
	}


	public City createCity(Map<String,Object> options){
		return new City();
	}


	public District createDistrict(Map<String,Object> options){
		return new District();
	}


	public UserDomain createUserDomain(Map<String,Object> options){
		return new UserDomain();
	}


	public UserWhiteList createUserWhiteList(Map<String,Object> options){
		return new UserWhiteList();
	}


	public SecUser createSecUser(Map<String,Object> options){
		return new SecUser();
	}


	public UserApp createUserApp(Map<String,Object> options){
		return new UserApp();
	}


	public QuickLink createQuickLink(Map<String,Object> options){
		return new QuickLink();
	}


	public ListAccess createListAccess(Map<String,Object> options){
		return new ListAccess();
	}


	public ObjectAccess createObjectAccess(Map<String,Object> options){
		return new ObjectAccess();
	}


	public LoginHistory createLoginHistory(Map<String,Object> options){
		return new LoginHistory();
	}


	public GenericForm createGenericForm(Map<String,Object> options){
		return new GenericForm();
	}


	public FormMessage createFormMessage(Map<String,Object> options){
		return new FormMessage();
	}


	public FormFieldMessage createFormFieldMessage(Map<String,Object> options){
		return new FormFieldMessage();
	}


	public FormField createFormField(Map<String,Object> options){
		return new FormField();
	}


	public FormAction createFormAction(Map<String,Object> options){
		return new FormAction();
	}


	public CandidateContainer createCandidateContainer(Map<String,Object> options){
		return new CandidateContainer();
	}


	public CandidateElement createCandidateElement(Map<String,Object> options){
		return new CandidateElement();
	}


	public WechatWorkappIdentify createWechatWorkappIdentify(Map<String,Object> options){
		return new WechatWorkappIdentify();
	}


	public WechatMiniappIdentify createWechatMiniappIdentify(Map<String,Object> options){
		return new WechatMiniappIdentify();
	}





}








