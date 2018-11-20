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
  public Subject getById(final long id) {
    return subjectDao.getById(id);
  }

  @Override
  public long createSubject(final Subject subject) {
    return subjectDao.createSubject(subject);
  }

  @Override
  public long updateSubject(final Subject subject) {
    return subjectDao.updateSubject(subject);
  }

  @Override
  public long deleteSubjectById(final long id) {
    return subjectDao.deleteSubjectById(id);
  }

}
