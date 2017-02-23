package com.demo.service.evaluation.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.demo.base.BaseDao;
import com.demo.base.BaseServiceImpl;
import com.demo.base.DaoException;
import com.demo.base.PageList;
import com.demo.dao.evaluation.EvaluationCriteriaDao;
import com.demo.entity.evaluation.EvaluationCriteria;
import com.demo.entity.evaluation.EvaluationCriteriaExample;
import com.demo.service.evaluation.EvaluationService;

@Service("evaluationService")
public class EvaluationServiceImpl extends BaseServiceImpl<EvaluationCriteria, EvaluationCriteriaExample> implements EvaluationService {

	@Resource
	EvaluationCriteriaDao dao;
	
	@Override
	public BaseDao<EvaluationCriteria, EvaluationCriteriaExample> getDao() throws DaoException {
		return dao;
	}

}
