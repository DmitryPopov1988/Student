package com.test.hibernate.service;

import com.test.hibernate.model.Subject;
import com.test.hibernate.repository.SubjectDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubjectServiceImpl implements SubjectService {

  @Autowired
  private SubjectDao subjectDao;

  @Override
  public List<Subject> getAll() {
    return subjectDao.getAll();
  }

  @Override
  public Subject getById(long id) {
    return null;
  }

  @Override
  public long createSubject() {
    return 0;
  }

  @Override
  public long updateSubject(long id) {
    return 0;
  }

  @Override
  public long deleteSubjectById() {
    return 0;
  }

}
