package com.shop.service.imp;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shop.dao.SpecificationMapper;
import com.shop.model.Specification;
import com.shop.service.SpecificationService;

/**创建第一季规格
 * @author chuankun
 *@2016年5月7日 下午2:37:36
 * email:yichuankun@qq.com
 */
@Service
public class SpecificationServiceImp implements SpecificationService{

	@Resource
	private SpecificationMapper specificationMapper;
	
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
	}

}
