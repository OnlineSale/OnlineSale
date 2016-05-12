package com.shop.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shop.dao.SpecificationMapper;
import com.shop.dao.StandardMapper;
import com.shop.model.Specification;
import com.shop.model.Standard;
import com.shop.service.SpecificationService;
import com.shop.service.StandardService;

/**创建第1级规格
 * @author chuankun
 *@2016年5月7日 下午2:37:36
 * email:yichuankun@qq.com
 */
@Service
public class SpecificationServiceImp implements SpecificationService{

	@Resource
	private SpecificationMapper specificationMapper;
	@Resource
	private StandardService standardService;
	
	public void addSpecification(Specification record) {
		// TODO Auto-generated method stub
	specificationMapper.insert(record);	
	}

	public void updateSpecification(Specification record) {
		// TODO Auto-generated method stub
		specificationMapper.updateByPrimaryKey(record);
	}

	public void deleteSpecification(Integer id) {
		// TODO Auto-generated method stub
		specificationMapper.deleteByPrimaryKey(id);
		List<Standard> list = standardService.findBySpecificationId(id);
		for(Standard re:list){
			standardService.deleteStandard(re.getStandardid());
		}
		
	}

}
