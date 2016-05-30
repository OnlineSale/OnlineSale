package com.shop.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shop.dao.StandardMapper;
import com.shop.model.Standard;
import com.shop.service.StandardService;

/**创建商品2级目录
 * @author chuankun
 *@2016年5月11日 下午11:00:45
 * email:yichuankun@qq.com
 */
@Service
public class StandardServiceImpImp implements StandardService{
	
	@Resource
	private StandardMapper standardMapper;

	public List findBySpecificationId(Integer specificationId) {
		// TODO Auto-generated method stub
		return standardMapper.selectBySpecificationId(specificationId);
	}

	public void addStandard(Standard record) {
		// TODO Auto-generated method stub
		standardMapper.insert(record);
	}

	public void updateStandard(Standard record) {
		// TODO Auto-generated method stub
		standardMapper.updateByPrimaryKey(record);
	}

	public void deleteStandard(Integer standardId) {
		// TODO Auto-generated method stub
		standardMapper.deleteByPrimaryKey(standardId);
	}

}
